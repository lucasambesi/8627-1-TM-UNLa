package com.chefencasa.Repository;

import com.chefencasa.Model.Rating;
import com.chefencasa.Model.Recipe;
import com.chefencasa.Model.Step;
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

    public Rating getByUserAndRecipe(User user, Recipe recipe) throws Exception{
        Rating rating = new Rating();

        EntityManager em = JPAUtil.getEMF().createEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Rating> query = criteriaBuilder.createQuery(Rating.class);

        Root<Rating> root = query.from(Rating.class);

        Predicate predicate = criteriaBuilder.and(
                criteriaBuilder.equal(root.get("user"), user),
                criteriaBuilder.equal(root.get("recipe"), recipe)
        );

        query.select(root).where(predicate);

        try {
            rating = em.createQuery(query).getSingleResult();
        } catch (Exception e) {
            String msg = "Error de persistencia - Método getByUserAndRecipe: " + e.getMessage();
            System.out.println(msg);
            throw new Exception(msg);
        } finally {
            em.close();
        }
        return rating;
    }
}
