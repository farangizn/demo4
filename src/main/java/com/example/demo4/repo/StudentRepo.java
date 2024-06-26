package com.example.demo4.repo;


import com.example.demo4.entity.Student;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class StudentRepo extends BaseRepo {

    public void save(Student student) {
        begin();
        em.persist(student);
        commit();
    }

    public void deleteById(UUID id) {
        begin();
        Student student = em.find(Student.class, id);
        em.remove(student);
        commit();
    }

    public List<Student> findAll() {
        return em.createQuery("from Student ", Student.class).getResultList();
    }

    public Optional<Student> findByEmail(String email) {
        begin();
        TypedQuery<Student> query = em.createQuery("select s from Student s where s.email =:email ", Student.class);
        query.setParameter("email", email);

        Student singleResult = query.getSingleResult();
        commit();
        return Optional.of(singleResult);
    }

    public Student findUserById(UUID userId) {
        return em.createQuery("select t from Student t where t.id = : userId", Student.class)
                .setParameter("userId", userId)
                .getSingleResult();
    }
}
