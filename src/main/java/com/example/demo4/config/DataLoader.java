package com.example.demo4.config;

import com.example.demo4.entity.Group;
import com.example.demo4.entity.Role;
import com.example.demo4.entity.Student;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.util.ArrayList;
import java.util.List;
import static com.example.demo4.config.DBConfig.entityManager;
import static com.example.demo4.config.DBConfig.entityManagerFactory;


@WebListener
public class DataLoader implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

//        entityManagerFactory = Persistence.createEntityManagerFactory("demo4");
//        entityManager = entityManagerFactory.createEntityManager();
//        initData();
        ServletContextListener.super.contextInitialized(sce);
    }

//    private void initData() {
//        entityManager.getTransaction().begin();
//        Group group = new Group();
//        group.setName("F34");
//        Group group1 = new Group();
//        group.setName("T56");
//        Group group2 = new Group();
//        group.setName("G43");
//
//        entityManager.persist(group);
//        entityManager.persist(group1);
//        entityManager.persist(group2);
//
//        List<Role> roles = entityManagerFactory.createEntityManager().createQuery("from Role ", Role.class).getResultList();
//
//
//        Student user = Student.builder()
//                .age(18)
//                .email("eshmat@gmail.com")
//                .password("root123")
//                .firstName("Hikmat")
//                .roles(roles)
//                .lastName("Hikmatov")
//                .build();
//        entityManager.persist(user);
//
//        entityManager.getTransaction().commit();
//    }


}