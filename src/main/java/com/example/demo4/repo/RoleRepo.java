package com.example.demo4.repo;

import com.example.demo4.config.DBConfig;
import com.example.demo4.entity.Role;
import jakarta.persistence.EntityManager;

import java.util.List;

public class RoleRepo {
    public static final EntityManager entityManager = DBConfig.entityManagerFactory.createEntityManager();

    public List<Role> findAll() {
        return entityManager.createQuery("from Role ", Role.class).getResultList();
    }

}
