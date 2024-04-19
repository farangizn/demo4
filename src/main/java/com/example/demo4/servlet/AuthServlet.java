package com.example.demo4.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(name = "auth", value = "/auth/login")
public class AuthServlet extends HttpServlet {
}
