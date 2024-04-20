package com.example.demo4.config;


import com.example.demo4.entity.Student;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(urlPatterns = "/*")
public class SecurityFilter implements Filter {

    List<String> openPages = new ArrayList<>(List.of(
            "/",
            "/auth",
            "/register",
            "/search",
            "/index.jsp"
    ));

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        Object currentUser = req.getSession().getAttribute("currentUser");
        String requestURI = req.getRequestURI();
        for (String openPage : openPages) {
            if (requestURI.equalsIgnoreCase(openPage)) {
                filterChain.doFilter(req, resp);
            }
        }
        Student student;
        if (currentUser != null) {
            student = (Student) currentUser;
            if (student.getRoleByName("admin").getName().equalsIgnoreCase("admin") || (student.getRoleByName("student").getName().equalsIgnoreCase("student"))) {
                resp.sendRedirect("/");
            }
        }
    }
}
