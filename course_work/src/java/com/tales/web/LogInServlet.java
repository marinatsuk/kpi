package com.tales.web;

import com.tales.model.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import com.tales.services.UserService;

public class LogInServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getSession().invalidate();
        
        ServletContext context = getServletContext();
        UserService userService = (UserService) context.getAttribute("userService");

        String log = request.getParameter("login");
        User user = userService.getByLogin(log);
        
        if (user == null) {
            request.getRequestDispatcher("/WEB-INF/jsp/errorpage.jsp").forward(request, response);
            return;
        }
        
        String pass = request.getParameter("password");

        if (!userService.checkPassword(user, pass)) {
            request.getRequestDispatcher("/WEB-INF/jsp/errorpage.jsp").forward(request, response);
            return;
        }
        
        request.getSession().setAttribute("user", user);
        
        if(user.isAdmin()) {
            request.getRequestDispatcher("AdminServlet").forward(request, response);
        }
        else {
            request.getRequestDispatcher("/WEB-INF/jsp/userPage.jsp").forward(request, response);
        }
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
