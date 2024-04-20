package com.example.demo4.entity;

import com.example.demo4.repo.BaseRepo;
import jakarta.persistence.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
public class Student extends BaseEntity {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Integer age;
    @ManyToOne
    private Group group;
    @ManyToMany
    private List<Role> roles;


    @SneakyThrows
    public void authenticate(HttpServletResponse resp, HttpServletRequest req) {
        String rememberMe = req.getParameter("rememberMe");
        HttpSession session = req.getSession();
        session.setAttribute("currentUser", this);
        if (Objects.equals(rememberMe, "on")) {
            Cookie cookie = new Cookie("userId", this.getId().toString());
            cookie.setPath("/");
            cookie.setSecure(false);
            cookie.setMaxAge(60 * 60);
            resp.addCookie(cookie);
            resp.sendRedirect("http://localhost:8080");
        } else {
            resp.sendRedirect("/");
        }
    }

    public Role getRoleByName(String roleName) {
        EntityManager em = BaseRepo.entityManagerFactory.createEntityManager();
        TypedQuery<Role> nameRole = em.createQuery("select r from Role r where r.name=:nameRole", Role.class).setParameter("nameRole", roleName);
        return nameRole.getSingleResult();
    }

}
