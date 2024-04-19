package com.example.demo4.servlet;

import com.example.demo4.entity.Student;
import com.example.demo4.repo.StudentRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "user", value = "/user")
public class UserServlet extends HttpServlet {
    StudentRepo studentRepo = new StudentRepo();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> all = studentRepo.findAll();
        for (Student student : all) {
            resp.getWriter().println(student);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Student student = Student.builder()
                .email(email)
                .password(password)
                .build();
        studentRepo.save(student);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        studentRepo.deleteById(id);
    }
}
