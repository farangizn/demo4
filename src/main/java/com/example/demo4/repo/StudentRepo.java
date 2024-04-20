package com.example.demo4.repo;


import com.example.demo4.config.DBConfig;
import com.example.demo4.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class StudentRepo {
    public static final EntityManager entityManager = DBConfig.entityManagerFactory.createEntityManager();

    public void save(Student student) {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
    }

    public void deleteById(UUID id) {
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
        entityManager.getTransaction().commit();
    }

    public List<Student> findAll() {
        return entityManager.createQuery("from Student ", Student.class).getResultList();
    }

    public Optional<Student> findByEmail(String email) {
        entityManager.getTransaction().begin();
        TypedQuery<Student> query = entityManager.createQuery("select s from Student s where s.email =:email ", Student.class);
        query.setParameter("email", email);

        Student singleResult = query.getSingleResult();
        entityManager.getTransaction().commit();
        return Optional.of(singleResult);
    }

    public Student findUserById(UUID userId) {
        return entityManager.createQuery("select t from Student t where t.id = : userId", Student.class)
                .setParameter("userId", userId)
                .getSingleResult();
    }
}
