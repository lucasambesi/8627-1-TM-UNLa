package com.chefencasa.Repository;

import com.chefencasa.Model.Recipe;

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

    public Recipe createRecipe(Recipe recipe) throws Exception {

        EntityManager em = JPAUtil.getEMF().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        Recipe entity = null;

        try {
            transaction.begin();
            entity = em.merge(recipe);
            transaction.commit();
        }
        catch (Exception e){
            String msg = "Persistence error - addRecipe method: " + e.getMessage();
            System.out.println(msg);
            throw new Exception(msg);
        }
        finally {
            em.close();
        }

        return entity;
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

    public List<Recipe> getAll() throws Exception{
        List<Recipe> recipes = new ArrayList<Recipe>();

        EntityManager em = JPAUtil.getEMF().createEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Recipe> query = criteriaBuilder.createQuery(Recipe.class);
        Root<Recipe> root = query.from(Recipe.class);
        query.select(root);

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
}
