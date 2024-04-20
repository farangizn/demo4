package com.example.demo4.config;


import com.example.demo4.entity.Student;
import com.example.demo4.repo.StudentRepo;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.*;

@WebFilter(urlPatterns = "/*")
public class SecurityFilter implements Filter {

    List<String> openPages = new ArrayList<>(List.of(
            "/",
            "/login.jsp",
            "/auth/login",
            "/auth/logout",
            "/register",
            "/search",
            "/index.jsp"
    ));

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Object object = request.getSession().getAttribute("currentUser");
        String requestURI = request.getRequestURI();
        StudentRepo studentRepo = new StudentRepo();
        if (openPages.contains(requestURI)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        if (object != null) {
            Student user = (Student) object;
            if (user.getRoleByName("admin").getName() != null) {
                filterChain.doFilter(request, response);
                return;
            }
        }
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("userId")) {
                UUID userId = UUID.fromString(cookie.getValue());
                Student user = studentRepo.findUserById(userId);
                if (user != null) {
                    request.getSession().setAttribute("currentUser", user);
                    if (user.getRoleByName("admin").getName()!=null) {
                        filterChain.doFilter(request, response);
                        return;
                    }
                    break;
                }
            }
        }

    }


//        for (String openPage : openPages) {
//            if (requestURI.equalsIgnoreCase(openPage)) {
//                filterChain.doFilter(servletRequest, servletResponse);
//                return;
//            }
//        }
//        if (currentUser == null) {
//            Optional<Cookie> cookieOptional = Arrays.stream(req.getCookies()).filter(cookie -> cookie.getName().equals("userId")).findFirst();
//            if (cookieOptional.isPresent()) {
//                Cookie cookie = cookieOptional.get();
//                UUID userId = UUID.fromString(cookie.getValue());
//                Student user = studentRepo.findUserById(userId);
//                if (user != null) {
//                    session.setAttribute("currentUser", user);
//                    if (user.getRoleByName("admin").getName().equalsIgnoreCase("admin")) {
//                        filterChain.doFilter(servletRequest, servletResponse);
//                        resp.sendRedirect("/admin/admin.jsp");
//                    } else {
//                        resp.sendRedirect("/");
//                    }
//                } else {
//                    resp.sendRedirect("/404");
//                }
//            } else {
//                resp.sendRedirect("/404");
//            }
//        }
//    }
}
