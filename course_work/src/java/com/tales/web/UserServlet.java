package com.tales.web;

import com.tales.model.*;
import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tales.services.*;
import java.util.List;

public class UserServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext context = getServletContext();
        UserService userService = (UserService) context.getAttribute("userService");
        
        List<Tales> liked = (List<Tales>) userService.getLiked((List<Tales>) request.getSession().getAttribute("liked"));
        List<Tales> lastWatched = (List<Tales>) userService.getLastWatched((List<Tales>) request.getSession().getAttribute("tales"));
        
       
        request.setAttribute("liked", liked);
        request.setAttribute("lastWatched", lastWatched);
        
        request.getRequestDispatcher("/WEB-INF/jsp/personalPage.jsp").forward(request, response);
    }
}
