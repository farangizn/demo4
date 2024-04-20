package com.example.demo4.repo;

import com.example.demo4.config.DBConfig;
import com.example.demo4.entity.Group;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.UUID;

public class GroupRepo{
    public static final EntityManager entityManager = DBConfig.entityManagerFactory.createEntityManager();

    public void save(Group group) {
        entityManager.getTransaction().begin();
        entityManager.persist(group);
        entityManager.getTransaction().commit();
    }

    public void deleteById(UUID id) {
        entityManager.getTransaction().begin();
        Group group = entityManager.find(Group.class, id);
        entityManager.remove(group);
        entityManager.getTransaction().commit();
    }

    public List<Group> findAll() {
        return entityManager.createQuery("from Group ", Group.class).getResultList();
    }

    public void update(Group group) {
        entityManager.getTransaction().begin();
        group.setName(group.getName());
        entityManager.getTransaction().commit();
    }
}
