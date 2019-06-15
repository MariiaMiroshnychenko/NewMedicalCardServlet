package servlet;

import model.dao.FactoryDao;
import model.dao.PersonalRegDataDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.atomic.AtomicReference;

@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        AtomicReference<PersonalRegDataDao> personalRegDataDao =
                new AtomicReference<>(FactoryDao.getInstance().getPersonalRegDataJdbcDao());

        final ServletContext servletContext = servletContextEvent.getServletContext();

        servletContext.setAttribute("personalRegDataDao", personalRegDataDao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
