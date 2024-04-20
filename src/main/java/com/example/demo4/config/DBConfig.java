package com.example.demo4.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DBConfig {

    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo4");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();
}
