package com.example.final_project.controllers;

import com.example.final_project.databaseaccesslayer.ProductsDaoImpl;
import com.example.final_project.models.ProductsDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "admin_panel", urlPatterns = {"/admin_panel", "/add_product"})
public class AdminPanelController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/admin_panel")) {
            panel(request, response);
        }
        if(path.equals("/add_product")) {
            addProductPage(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/add_product")) {
            addProduct(request, response);
        }
    }

    public void panel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductsDaoImpl productsDao = new ProductsDaoImpl();
        List<ProductsDTO> productsDTOS = productsDao.getAllProducts();
        request.setAttribute("products", productsDTOS);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin_panel.jsp");
        dispatcher.forward(request, response);
    }

    public void addProductPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/add_product.jsp");
        dispatcher.forward(request, response);
    }

    public void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductsDaoImpl productsDao = new ProductsDaoImpl();
        productsDao.addProduct(request.getParameter("product_name"), Double.parseDouble(request.getParameter("product_price")));
        response.sendRedirect("admin_panel");
    }
}
