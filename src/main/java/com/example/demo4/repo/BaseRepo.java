package com.example.demo4.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class BaseRepo {
    public static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo4");
    public static final EntityManager em = entityManagerFactory.createEntityManager();

    public void begin() {
        em.getTransaction().begin();
    }

    public void commit() {
        em.getTransaction().commit();
    }

}
