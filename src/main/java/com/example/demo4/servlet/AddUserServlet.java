package com.example.demo4.servlet;

import com.example.demo4.entity.Role;
import com.example.demo4.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.io.IOException;
import java.util.*;

import static com.example.demo4.repo.BaseRepo.entityManagerFactory;

@WebServlet(name = "add user", value = "/user/add")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        String[] rolesIds = req.getParameterValues("role");
        List<Role> roles = new ArrayList<>();
        for (String role : rolesIds) {
            roles.add(entityManager.find(Role.class, Integer.parseInt(role)));
        }

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        int age = Integer.parseInt(req.getParameter("age"));
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String passwordRepeat = req.getParameter("passwordRepeat");
        if (!password.equals(passwordRepeat)) {
            resp.sendRedirect("/addUser.jsp");
            return;
        }
        Student user = Student.builder()
                .firstName(firstName)
                .lastName(lastName)
                .age(age)
                .password(password)
                .email(email)
                .roles(roles)
                .build();

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<Student>> constraintViolations = validator.validate(user);

        if (constraintViolations.isEmpty()) {

            entityManager.persist(user);
            entityManager.getTransaction().commit();
            resp.sendRedirect("/user.jsp");
        } else {
            Map<String, String> map = new HashMap<>();
            for (ConstraintViolation<?> constraintViolation : constraintViolations) {
                map.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
            }
            req.setAttribute("errors", map);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/addUser.jsp");
            requestDispatcher.forward(req, resp);
            resp.sendRedirect("/addUser.jsp");
        }
    }
}