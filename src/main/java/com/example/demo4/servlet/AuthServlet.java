package com.example.demo4.servlet;

import com.example.demo4.entity.Student;
import com.example.demo4.repo.StudentRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "auth", value = "/auth/login")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StudentRepo studentRepo = new StudentRepo();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Optional<Student> userOptional = studentRepo.findByEmail(email);

        if (userOptional.isPresent()) {
            Student student = userOptional.get();
            if (student.getPassword().equals(password)) {
                student.authenticate(resp, req);
            } else {
                resp.sendRedirect("/login.jsp");
            }
        }

    }
}
