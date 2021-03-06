package com.medical.controller.listener;

import com.medical.model.dao.FactoryDao;
import com.medical.model.dao.UserDataDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.atomic.AtomicReference;

@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        AtomicReference<UserDataDao> userDataDao =
                new AtomicReference<>(FactoryDao.getInstance().getUserDataJdbcDao());

        final ServletContext servletContext = servletContextEvent.getServletContext();

        servletContext.setAttribute("userDataDao", userDataDao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
