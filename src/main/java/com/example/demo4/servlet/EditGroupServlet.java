package com.example.demo4.servlet;

import com.example.demo4.config.DBConfig;
import com.example.demo4.entity.Group;
import com.example.demo4.repo.GroupRepo;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;



@WebServlet(name = "edit group", value = "/group/edit")
public class EditGroupServlet extends HttpServlet {
    GroupRepo groupRepo = new GroupRepo();
    public static final EntityManager entityManager = DBConfig.entityManagerFactory.createEntityManager();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        entityManager.getTransaction().begin();

        UUID id = UUID.fromString(req.getParameter("id"));
        String name = req.getParameter("name");
        Group group = entityManager.find(Group.class, id);
        group.setName(name);
        groupRepo.update(group);
        entityManager.getTransaction().commit();
        resp.sendRedirect("/group.jsp");
    }
}