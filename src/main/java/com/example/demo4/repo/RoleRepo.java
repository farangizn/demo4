package com.example.demo4.repo;

import com.example.demo4.entity.Role;

import java.util.List;

public class RoleRepo extends BaseRepo {
    public List<Role> findAll() {
        return em.createQuery("from Role ", Role.class).getResultList();
    }

}
