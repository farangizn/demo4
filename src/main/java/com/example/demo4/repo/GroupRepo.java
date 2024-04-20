package com.example.demo4.repo;

import com.example.demo4.entity.Group;
import com.example.demo4.entity.Student;

import java.util.List;
import java.util.UUID;

public class GroupRepo extends BaseRepo {
    public void save(Group group) {
        begin();
        em.persist(group);
        commit();
    }

    public void deleteById(UUID id) {
        begin();
        Group group = em.find(Group.class, id);
        em.remove(group);
        commit();
    }

    public List<Group> findAll() {
        return em.createQuery("from Group ", Group.class).getResultList();
    }

    public void update(Group group) {
        begin();
        group.setName(group.getName());
        commit();
    }
}
