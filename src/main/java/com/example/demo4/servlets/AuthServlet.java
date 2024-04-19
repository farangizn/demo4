package com.example.demo4.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(name = "auth", value = "/auth/login")
public class AuthServlet extends HttpServlet {
}
