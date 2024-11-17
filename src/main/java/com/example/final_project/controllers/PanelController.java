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

@WebServlet(name = "panel", urlPatterns = {"/panel"})
public class PanelController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductsDaoImpl productsDao = new ProductsDaoImpl();
        List<ProductsDTO> productsDTOS = productsDao.getAllProducts2();
        request.setAttribute("products", productsDTOS);
        RequestDispatcher dispatcher = request.getRequestDispatcher("panel.jsp");
        dispatcher.forward(request, response);
    }
}
