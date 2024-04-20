package com.example.demo4.servlet;


import com.example.demo4.entity.Group;
import com.example.demo4.repo.GroupRepo;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.UUID;

import static com.example.demo4.repo.BaseRepo.entityManagerFactory;

@WebServlet(name = "addGroup", value = "/group/add")
public class AddGroupServlet extends HttpServlet {
    GroupRepo groupRepo = new GroupRepo();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Group group = Group
                .builder()
                .name(name)
                .build();
        groupRepo.save(group);
        resp.sendRedirect("/group.jsp");
    }
}