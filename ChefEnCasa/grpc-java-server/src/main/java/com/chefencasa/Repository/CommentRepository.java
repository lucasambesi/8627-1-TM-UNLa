package com.chefencasa.Repository;

import com.chefencasa.Model.Comment;
import com.chefencasa.Model.Rating;
import com.chefencasa.Model.Recipe;
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

public class CommentRepository {
    private static CommentRepository repository;

    public static CommentRepository getInstance() {
        if(repository == null) {
            repository = new CommentRepository();
        }
        return repository;
    }

    public Comment saveOrUpdateComment(Comment comment) throws Exception {

        EntityManager em = JPAUtil.getEMF().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        Comment entity = null;

        try {
            transaction.begin();
            entity = em.merge(comment);
            transaction.commit();
        }
        catch (Exception e){
            String msg = "Persistence error - saveOrUpdateComment method: " + e.getMessage();
            System.out.println(msg);
            throw new Exception(msg);
        }
        finally {
            em.close();
        }

        return entity;
    }

    public List<Comment> getByRecipe(Recipe recipe, int pageNumber, int pageSize) throws Exception{
        List<Comment> comments = new ArrayList<Comment>();
        int startPosition = (pageNumber - 1) * pageSize;

        EntityManager em = JPAUtil.getEMF().createEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Comment> query = criteriaBuilder.createQuery(Comment.class);

        Root<Comment> root = query.from(Comment.class);
        Predicate predicate = criteriaBuilder.equal(root.get("recipe"), recipe);
        query.select(root).where(predicate);

        try {
            TypedQuery<Comment> typedQuery = em.createQuery(query);
            typedQuery.setFirstResult(startPosition);
            typedQuery.setMaxResults(pageSize);

            comments = typedQuery.getResultList();
        } catch (Exception e) {
            String msg = "Error de persistencia - Método GetCommentsByRecipe: " + e.getMessage();
            System.out.println(msg);
            throw new Exception(msg);
        } finally {
            em.close();
        }

        return comments;
    }
}
