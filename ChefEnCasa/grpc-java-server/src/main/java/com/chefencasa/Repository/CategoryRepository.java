package com.chefencasa.Repository;

import com.chefencasa.Model.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

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
}
