package servlet.filter;

import model.dao.PersonalRegDataDao;
import model.dao.RoleDao;
import model.entity.PersonalRegData;
import model.entity.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        final String login = request.getParameter("login");
        final String password = request.getParameter("password");

        @SuppressWarnings("unchecked") final AtomicReference<PersonalRegDataDao> personalRegDataDao =
                (AtomicReference<PersonalRegDataDao>) request.getServletContext()
                        .getAttribute("personalRegDataDao");
        @SuppressWarnings("unchecked") final AtomicReference<RoleDao> roleDao =
                (AtomicReference<RoleDao>) request.getServletContext()
                        .getAttribute("roleDao");

        final HttpSession session = request.getSession();
        System.out.println(login);
        System.out.println(password);
        System.out.println(Objects.nonNull(personalRegDataDao.get().findPersonalRegDataByLoginAndPassword(login, password)));
        if (Objects.nonNull(session) &&
                Objects.nonNull(session.getAttribute("user")) &&
                Objects.nonNull(session.getAttribute("role"))) {

            filterChain.doFilter(request, response);
        } else if (Objects.nonNull(personalRegDataDao.get().findPersonalRegDataByLoginAndPassword(login, password))) {

            final PersonalRegData personalRegData = personalRegDataDao.get()
                    .findPersonalRegDataByLoginAndPassword(login, password);
            final String role = roleDao.get().findRoleTitleByLoginAndPassword(login, password).getTitle();

            request.getSession().setAttribute("user", personalRegData);
            request.getSession().setAttribute("role", role);

            redirectToAccount(request, response, role);
        } else {
            request.getRequestDispatcher("/WEB-INF/view/templates/login.jsp").forward(request, response);
        }
    }

    private void redirectToAccount(final HttpServletRequest request, final HttpServletResponse response,
                                   final String role) throws ServletException, IOException {
        switch (role) {
            case ("Пацієнт"):
                request.getRequestDispatcher("/WEB-INF/view/templates/patientPage.jsp").forward(request, response);
            case ("Сімейний лікар"):
                request.getRequestDispatcher("/WEB-INF/view/templates/doctorPage.jsp").forward(request, response);
            case ("Лікар за спеціальністю"):
                request.getRequestDispatcher("/WEB-INF/view/templates/specDoctorPage.jsp)").forward(request, response);
            case ("Медичний персонал"):
                request.getRequestDispatcher("/WEB-INF/view/templates/medEmployeePage.jsp)").forward(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
