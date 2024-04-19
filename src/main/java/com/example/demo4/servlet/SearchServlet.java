package com.example.demo4.servlet;

import com.example.demo4.entity.Student;
import com.example.demo4.repo.StudentRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "search", value = "/search")
public class SearchServlet extends HttpServlet {
    StudentRepo studentRepo = new StudentRepo();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        List<Student> students = studentRepo.findAll();
        List<Student> suitableStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getFirstName().toLowerCase().contains(name) ||
                    student.getLastName().toLowerCase().contains(name)) {
                suitableStudents.add(student);
            }
        }
        req.getSession().setAttribute("validStudents", suitableStudents);
        resp.sendRedirect("/index.jsp");
    }
}
