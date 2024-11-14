package com.example.final_project.controllers;

import com.example.final_project.models.UsersDTO;
import com.example.final_project.repositories.AuthenticationRepo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "authentication", urlPatterns = {"/register", "/login", "/logout", "/login2"})
public class AuthenticationController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

        switch (path) {
            case "/login":
                showLogin(request, response);
                break;
            case "/login2":
                showLogin2(request, response);
                break;
            case "/logout":
                performLogout(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        switch (path) {
            case "/login":
                processLogin(request, response);
                break;
            case "/login2":
                processLogin2(request, response);
                break;
        }
    }

    private void showLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            UsersDTO user = (UsersDTO) session.getAttribute("user");
            if (user != null) {
                response.sendRedirect("home");
                return;
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/login.jsp");
        dispatcher.forward(request, response);
    }

    private void showLogin2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            UsersDTO user = (UsersDTO) session.getAttribute("user");
            if (user != null) {
                response.sendRedirect("home");
                return;
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/login2.jsp");
        dispatcher.forward(request, response);
    }

    private void processLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pwd = request.getParameter("password");
        AuthenticationRepo repo = new AuthenticationRepo();
        try {
            UsersDTO user = repo.checkLoginData(email, pwd);
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(60 * 60 * 12);
            //check user role type
            String roleName = repo.returnUserRole(user.getUid());
            if (roleName.equals("admin")) {
                response.sendRedirect("admin_panel");
            } else {
                response.sendRedirect("panel");
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/login.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void processLogin2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pwd = request.getParameter("password");
        System.out.println(email);
        System.out.println(pwd);
        AuthenticationRepo repo = new AuthenticationRepo();
        try {
            UsersDTO user = repo.checkLoginData2(email, pwd);
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(60 * 60 * 12);
            //check user role type
            String roleName = repo.returnUserRole(user.getUid());
            if (roleName.equals("admin")) {
                response.sendRedirect("admin_panel");
            } else {
                response.sendRedirect("panel");
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/login2.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void performLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect("login");
    }
}
