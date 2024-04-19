package com.example.demo4.servlet;

import com.example.demo4.entity.Student;
import com.example.demo4.repo.StudentRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "name", value = "/test")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentRepo studentRepo = new StudentRepo();
        for (Student student : studentRepo.findAll()) {
            resp.getWriter().println(student.getEmail());
        }

        System.out.println(studentRepo.findAll().size());
    }
}
