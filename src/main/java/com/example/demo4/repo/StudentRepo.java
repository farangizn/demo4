package com.example.demo4.repo;


import com.example.demo4.entity.Student;

import java.util.List;
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
}
