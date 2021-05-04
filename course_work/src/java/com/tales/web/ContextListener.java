package com.tales.web;

import com.tales.dao.DaoFactory;
import com.tales.daoImpl.Database;
import com.tales.daoImpl.TestData;
import com.tales.model.Tales;
import com.tales.services.*;

import java.util.Collection;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Database database = new Database();
        TestData.generateTestData(database);
        DaoFactory daoFactory = database.getDaoFactory();
        
        TalesService talesService = new TalesServiceImpl(daoFactory);
        sce.getServletContext().setAttribute("talesService", talesService);
        
        UserService userService = new UserServiceImpl(daoFactory);
        sce.getServletContext().setAttribute("userService", userService);
        
        Collection<Tales> allTales = talesService.getAllTales();
        sce.getServletContext().setAttribute("allTales", allTales);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
    
}
