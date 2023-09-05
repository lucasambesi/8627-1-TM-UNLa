package com.chefencasa.Repository;

import com.chefencasa.Model.Step;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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

}
