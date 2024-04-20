package com.example.demo4.servlet;

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

import static com.example.demo4.repo.BaseRepo.entityManagerFactory;

@WebServlet(name = "delete group", value = "/group/delete")
public class DeleteGroupServlet extends HttpServlet {
    GroupRepo groupRepo = new GroupRepo();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Group group = entityManager.find(Group.class, UUID.fromString(req.getParameter("groupId")));
        groupRepo.deleteById(group.getId());
        resp.sendRedirect("/group.jsp");
    }
}