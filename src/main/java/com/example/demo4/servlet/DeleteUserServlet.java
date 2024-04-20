package com.example.demo4.servlet;

import com.example.demo4.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

import static com.example.demo4.repo.BaseRepo.entityManagerFactory;

@WebServlet(name = "delete user", value = "/user/delete")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Student user = entityManager.find(Student.class, UUID.fromString(req.getParameter("userId")));

        entityManager.remove(user);

        entityManager.getTransaction().commit();
        resp.sendRedirect("/user.jsp");
    }
}
