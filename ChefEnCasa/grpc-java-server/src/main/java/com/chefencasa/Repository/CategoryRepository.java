package com.chefencasa.Repository;

import com.chefencasa.Model.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    private static CategoryRepository repository;

    public static CategoryRepository getInstance() {
        if(repository == null) {
            repository = new CategoryRepository();
        }
        return repository;
    }

    public Category createCategory(Category category) throws Exception {

        EntityManager em = JPAUtil.getEMF().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        Category entity = null;

        try {
            transaction.begin();
            entity = em.merge(category);
            transaction.commit();
        }
        catch (Exception e){
            String msg = "Persistence error - addCategory method: " + e.getMessage();
            System.out.println(msg);
            throw new Exception(msg);
        }
        finally {
            em.close();
        }

        return entity;
    }

    public Category getById(int idCategory) throws Exception{

        Category category = null;
        EntityManager em = JPAUtil.getEMF().createEntityManager();

        String query = "SELECT u FROM Category u WHERE u.idCategory = :idCategory";
        TypedQuery<Category> tq = em.createQuery(query, Category.class);
        tq.setParameter("idCategory", idCategory);

        try {
            category = tq.getSingleResult();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw new Exception("WARNING: Persistence error in getById method");
        }
        finally {
            em.close();
        }

        return category;
    }

    public List<Category> getAll() throws Exception{
        List<Category> categories = new ArrayList<Category>();

        EntityManager em = JPAUtil.getEMF().createEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Category> query = criteriaBuilder.createQuery(Category.class);
        Root<Category> root = query.from(Category.class);
        query.select(root);

        try {
            categories = em.createQuery(query).getResultList();
        } catch (Exception e) {
            String msg = "Error de persistencia - Método GetAll: " + e.getMessage();
            System.out.println(msg);
            throw new Exception(msg);
        } finally {
            em.close();
        }
        return categories;
    }
}
