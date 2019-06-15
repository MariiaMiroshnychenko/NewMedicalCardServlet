package servlet;

import model.dao.FactoryDao;
import model.dao.PersonalRegDataDao;
import model.dao.RoleDao;

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

        AtomicReference<RoleDao> roleDao =
                new AtomicReference<>(FactoryDao.getInstance().getRoleJdbcDao());

        final ServletContext servletContext = servletContextEvent.getServletContext();

        servletContext.setAttribute("personalRegDataDao", personalRegDataDao);
        servletContext.setAttribute("roleDao", roleDao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
