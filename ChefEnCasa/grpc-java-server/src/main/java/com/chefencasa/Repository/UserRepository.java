package com.chefencasa.Repository;

import com.chefencasa.Model.Recipe;
import com.chefencasa.Model.Step;
import com.chefencasa.Model.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserRepository {
    private static UserRepository repository;

    public static UserRepository getInstance() {
        if(repository == null) {
            repository = new UserRepository();
        }
        return repository;
    }

    public User saveOrUpdate(User user) throws Exception {

        EntityManager em = JPAUtil.getEMF().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        User entity = null;

        try {
            transaction.begin();
            entity = em.merge(user);
            transaction.commit();
        }
        catch (Exception e){
            String msg = "Persistence error - saveOrUpdate method: " + e.getMessage();
            System.out.println(msg);
            throw new Exception(msg);
        }
        finally {
            em.close();
        }

        return entity;
    }

    public User getById(int idUser) throws Exception{

        User user = null;
        EntityManager em = JPAUtil.getEMF().createEntityManager();

        String query = "SELECT u FROM User u WHERE u.idUser = :idUser";
        TypedQuery<User> tq = em.createQuery(query, User.class);
        tq.setParameter("idUser", idUser);

        try {
            user = tq.getSingleResult();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw new Exception("WARNING: Persistence error in getById method");
        }
        finally {
            em.close();
        }

        return user;
    }

    public User getByUserIdAndPassword(String userName, String password) throws Exception{

        User user = null;

        EntityManager em = JPAUtil.getEMF().createEntityManager();

        String query = "SELECT u FROM User u WHERE u.username=:userName AND u.password=:password";

        TypedQuery<User> tq = em.createQuery(query, User.class);
        tq.setParameter("userName", userName);
        tq.setParameter("password", password);

        try {
            user = tq.getSingleResult();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw new Exception("Error: " + e.getMessage());
        }
        finally {
            em.close();
        }

        return user;
    }

    public List<User> getUsersByPopularity(int pageSize, int pageNumber) throws Exception {
        List<User> users = null;
        EntityManager em = JPAUtil.getEMF().createEntityManager();

        try {
            String query = "SELECT u FROM User u ORDER BY u.popularity DESC";
            TypedQuery<User> tq = em.createQuery(query, User.class);

            tq.setFirstResult((pageNumber - 1) * pageSize);
            tq.setMaxResults(pageSize);

            users = tq.getResultList();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw new Exception("WARNING: Persistence error in getUsersByPopularity method");
        } finally {
            em.close();
        }

        return users;
    }

    public List<Recipe> getFavorites(int idUser) throws Exception {
        List<Recipe> recipes = null;
        EntityManager em = JPAUtil.getEMF().createEntityManager();

        try {
            String query = "SELECT f FROM User u INNER JOIN u.favorites f WHERE u.idUser = :idUser";
            TypedQuery<Recipe> tq = em.createQuery(query, Recipe.class);
            tq.setParameter("idUser", idUser);

            recipes = tq.getResultList();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw new Exception("WARNING: Persistence error in getFavorites method");
        } finally {
            em.close();
        }

        return recipes;
    }
}
