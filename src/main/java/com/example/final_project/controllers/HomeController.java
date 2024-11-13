package com.example.final_project.controllers;

import com.example.final_project.models.UsersDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "home", urlPatterns = {"/", "/portal"})
public class HomeController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        HttpSession session = request.getSession(false);
        UsersDTO user = null;
        if (session != null) {
            user = (UsersDTO) session.getAttribute("user");
        }
        request.setAttribute("user", user);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/login.jsp");
        dispatcher.forward(request, response);
    }
}