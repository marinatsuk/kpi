package com.tales.web;

import com.tales.model.Tales;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tales.services.TalesService;

//@WebServlet (name="MainPageServlet", urlPatterns= {"/MainPageServlet"})
public class MainPageServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        ServletContext context= getServletContext();
        
        TalesService talesService = (TalesService) context.getAttribute("talesService");
        Tales tales = talesService.getById(Integer.parseInt(request.getParameter("Open")));
        request.setAttribute("Tales", tales);
        request.getRequestDispatcher("mainpage.jsp").forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
