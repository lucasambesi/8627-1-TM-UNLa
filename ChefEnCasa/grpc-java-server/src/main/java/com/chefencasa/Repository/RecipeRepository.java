package com.chefencasa.Repository;

import com.chefencasa.Model.Category;
import com.chefencasa.Model.Recipe;
import com.chefencasa.Model.RecipeImage;
import com.chefencasa.Model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class RecipeRepository {
    private static RecipeRepository repository;

    public static RecipeRepository getInstance() {
        if(repository == null) {
            repository = new RecipeRepository();
        }
        return repository;
    }

    public Recipe saveOrUpdateRecipe(Recipe recipe) throws Exception{

        EntityManager em = JPAUtil.getEMF().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        Recipe entity = null;
        try {
            transaction.begin();
            entity = em.merge(recipe);
            transaction.commit();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw new Exception("ATENCION: Error de persistencia en método saveOrUpdateRecipe");
        }
        finally {
            em.close();
        }

        return entity;
    }

    public void saveOrUpdateImage(RecipeImage image) throws Exception {
        EntityManager em = JPAUtil.getEMF().createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(image);
            transaction.commit();
        } catch (Exception e){
            String msg = "Error de persistencia - Método saveOrUpdateImage: " + e.getMessage();
            System.out.println(msg);
            throw new Exception(msg);
        } finally {
            em.close();
        }
    }

    public Recipe getById(int idRecipe) throws Exception{

        Recipe recipe = null;
        EntityManager em = JPAUtil.getEMF().createEntityManager();

        String query = "SELECT u FROM Recipe u WHERE u.idRecipe = :idRecipe";
        TypedQuery<Recipe> tq = em.createQuery(query, Recipe.class);
        tq.setParameter("idRecipe", idRecipe);

        try {
            recipe = tq.getSingleResult();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw new Exception("WARNING: Persistence error in getById method");
        }
        finally {
            em.close();
        }

        return recipe;
    }

    public List<Recipe> getAll() throws Exception {
        List<Recipe> recipes = new ArrayList<>();

        EntityManager em = JPAUtil.getEMF().createEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Recipe> query = criteriaBuilder.createQuery(Recipe.class);
        Root<Recipe> root = query.from(Recipe.class);
        query.select(root).where(criteriaBuilder.equal(root.get("active"), true)); // Filtra por recetas activas

        try {
            recipes = em.createQuery(query).getResultList();
        } catch (Exception e) {
            String msg = "Error de persistencia - Método GetAll: " + e.getMessage();
            System.out.println(msg);
            throw new Exception(msg);
        } finally {
            em.close();
        }
        return recipes;
    }

    public List<Recipe> getByUser(User user) throws Exception {
        List<Recipe> recipes = new ArrayList<>();

        EntityManager em = JPAUtil.getEMF().createEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Recipe> query = criteriaBuilder.createQuery(Recipe.class);
        Root<Recipe> root = query.from(Recipe.class);
        Predicate byUser = criteriaBuilder.and(criteriaBuilder.equal(root.get("user"), user),
                criteriaBuilder.equal(root.get("active"), true)); // Filtra por recetas activas
        query.select(root).where(byUser);

        try {
            recipes = em.createQuery(query).getResultList();
        } catch (Exception e) {
            String msg = "Error de persistencia - Método GetRecipesByUser: " + e.getMessage();
            System.out.println(msg);
            throw new Exception(msg);
        } finally {
            em.close();
        }
        return recipes;
    }

    public List<Recipe> getByFilter(Category category, String title, String ingredients, int timeSince, int timeUntil, int pageNumber, int pageSize) throws Exception {
        int startPosition = (pageNumber - 1) * pageSize;

        List<Recipe> recipes = new ArrayList<>();
        EntityManager em = JPAUtil.getEMF().createEntityManager();

        try {
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<Recipe> query = criteriaBuilder.createQuery(Recipe.class);
            Root<Recipe> root = query.from(Recipe.class);

            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("active"), true)); // Filtra por recetas activas

            if (category != null) {
                predicates.add(criteriaBuilder.equal(root.get("category"), category));
            }
            if (!title.isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("title"), "%" + title + "%"));
            }
            if (!ingredients.isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("ingredients"), "%" + ingredients + "%"));
            }

            if (timeSince != 0 && timeUntil != 0) {
                predicates.add(criteriaBuilder.between(root.get("preparationTime"), timeSince, timeUntil));
            } else if (timeSince != 0) {
                predicates.add(criteriaBuilder.greaterThan(root.get("preparationTime"), timeSince));
            } else if (timeUntil != 0) {
                predicates.add(criteriaBuilder.lessThan(root.get("preparationTime"), timeUntil));
            }

            Predicate and = criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            query.select(root).where(and);

            TypedQuery<Recipe> typedQuery = em.createQuery(query);
            typedQuery.setFirstResult(startPosition);
            typedQuery.setMaxResults(pageSize);

            recipes = typedQuery.getResultList();
        } catch (Exception e) {
            String msg = "Error de persistencia - Método getByFilterWithPagination: " + e.getMessage();
            System.out.println(msg);
            throw new Exception(msg);
        } finally {
            em.close();
        }
        return recipes;
    }

    public List<Recipe> getRecipesByPopularity(int pageSize, int pageNumber) throws Exception {
        List<Recipe> recipes = null;
        EntityManager em = JPAUtil.getEMF().createEntityManager();

        try {
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<Recipe> query = criteriaBuilder.createQuery(Recipe.class);
            Root<Recipe> root = query.from(Recipe.class);
            query.select(root).where(criteriaBuilder.equal(root.get("active"), true)); // Filtra por recetas activas
            query.orderBy(criteriaBuilder.desc(root.get("popularity")));

            TypedQuery<Recipe> typedQuery = em.createQuery(query);
            typedQuery.setFirstResult((pageNumber - 1) * pageSize);
            typedQuery.setMaxResults(pageSize);

            recipes = typedQuery.getResultList();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw new Exception("WARNING: Persistence error in getUsersByPopularity method");
        } finally {
            em.close();
        }

        return recipes;
    }
}
