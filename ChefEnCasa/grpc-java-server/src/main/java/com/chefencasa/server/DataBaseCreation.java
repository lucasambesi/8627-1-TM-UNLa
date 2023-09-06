package com.chefencasa.server;

import com.chefencasa.Repository.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataBaseCreation {
    public static void main(String[] args) {
        // Crea un EntityManagerFactory basado en la configuración en persistence.xml
        EntityManagerFactory entityManagerFactory = JPAUtil.getEMF();

        // Crea un EntityManager para interactuar con la base de datos
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.close();
        entityManagerFactory.close();
    }
}
