package com.chefencasa.Repository;

import com.chefencasa.Model.Rating;
import com.chefencasa.Model.Recipe;
import com.chefencasa.Model.Step;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class RatingRepository {

    private static RatingRepository repository;

    public static RatingRepository getInstance() {
        if(repository == null) {
            repository = new RatingRepository();
        }
        return repository;
    }

    public Rating saveOrUpdateRating(Rating rating) throws Exception {

        EntityManager em = JPAUtil.getEMF().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        Rating entity = null;

        try {
            transaction.begin();
            entity = em.merge(rating);
            transaction.commit();
        }
        catch (Exception e){
            String msg = "Persistence error - saveOrUpdateRating method: " + e.getMessage();
            System.out.println(msg);
            throw new Exception(msg);
        }
        finally {
            em.close();
        }

        return entity;
    }

    public Rating getById(int idRating) throws Exception{

        Rating rating = null;
        EntityManager em = JPAUtil.getEMF().createEntityManager();

        String query = "SELECT u FROM Rating u WHERE u.idRating = :idRating";
        TypedQuery<Rating> tq = em.createQuery(query, Rating.class);
        tq.setParameter("idRating", idRating);

        try {
            rating = tq.getSingleResult();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw new Exception("WARNING: Persistence error in Rating getById method");
        }
        finally {
            em.close();
        }

        return rating;
    }

    /*public Rating getByUserAndRecipe(int idUser, int idRecipe) throws Exception{

        Rating rating = null;
        EntityManager em = JPAUtil.getEMF().createEntityManager();

        String query = "SELECT u FROM Rating u WHERE u.idUser = :idUser AND u.idRecipe = :idRecipe";
        TypedQuery<Rating> tq = em.createQuery(query, Rating.class);
        tq.setParameter("idUser", idUser);
        tq.setParameter("idRecipe", idRecipe);

        try {
            rating = tq.getSingleResult();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw new Exception("WARNING: Persistence error in Rating getById method");
        }
        finally {
            em.close();
        }

        return rating;
    }*/
}
