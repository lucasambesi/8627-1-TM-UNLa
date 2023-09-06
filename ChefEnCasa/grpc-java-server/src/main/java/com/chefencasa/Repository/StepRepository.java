package com.chefencasa.Repository;

import com.chefencasa.Model.Recipe;
import com.chefencasa.Model.Step;
import com.chefencasa.Model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class StepRepository {
    private static StepRepository repository;

    public static StepRepository getInstance() {
        if(repository == null) {
            repository = new StepRepository();
        }
        return repository;
    }

    public Step createStep(Step step) throws Exception {

        EntityManager em = JPAUtil.getEMF().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        Step entity = null;

        try {
            transaction.begin();
            entity = em.merge(step);
            transaction.commit();
        }
        catch (Exception e){
            String msg = "Persistence error - addStep method: " + e.getMessage();
            System.out.println(msg);
            throw new Exception(msg);
        }
        finally {
            em.close();
        }

        return entity;
    }

    public List<Step> getByRecipe(Recipe recipe) throws Exception{
        List<Step> steps = new ArrayList<Step>();

        EntityManager em = JPAUtil.getEMF().createEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Step> query = criteriaBuilder.createQuery(Step.class);

        Root<Step> root = query.from(Step.class);
        Predicate byRecipe = criteriaBuilder.equal(root.get("recipe"), recipe);
        query.select(root).where(byRecipe);

        try {
            steps = em.createQuery(query).getResultList();
        } catch (Exception e) {
            String msg = "Error de persistencia - Método GetStepsByRecipe: " + e.getMessage();
            System.out.println(msg);
            throw new Exception(msg);
        } finally {
            em.close();
        }
        return steps;
    }
}
