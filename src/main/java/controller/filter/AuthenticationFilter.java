package controller.filter;

import controller.commands.implementation.DoctorPage;
import controller.commands.implementation.NursePage;
import controller.commands.implementation.PageLocalization;
import controller.commands.implementation.PatientPage;
import model.dao.UserDataDao;
import model.entity.UserData;
import org.mindrot.jbcrypt.BCrypt;

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


        @SuppressWarnings("unchecked") final AtomicReference<UserDataDao> userDataDao =
                (AtomicReference<UserDataDao>) request.getServletContext()
                        .getAttribute("userDataDao");

        final HttpSession session = request.getSession();

        if (Objects.nonNull(session) &&
                Objects.nonNull(session.getAttribute("user")) &&
                Objects.nonNull(session.getAttribute("role"))) {

            filterChain.doFilter(request, response);
        } else if (Objects.nonNull(userDataDao.get().findUserDataByLogin(login))) {
            final UserData userData = userDataDao.get()
                    .findUserDataByLogin(login);

            if (BCrypt.checkpw(password, userData.getPassword())) {
                request.getSession().setAttribute("user", userData);
                request.getSession().setAttribute("role", userData.getRole());

                redirectToAccount(request, response, userData.getRole());
            }
        } else {
            request.getRequestDispatcher("/WEB-INF/constants/templates/login.jsp").forward(request, response);
        }
    }

    private void redirectToAccount(final HttpServletRequest request, final HttpServletResponse response,
                                   final String role) throws ServletException, IOException {
        switch (role) {
            case ("patient"):
                PatientPage patientPage = new PatientPage(new PageLocalization());
                request.getRequestDispatcher(patientPage.execute(request)).forward(request, response);
            case ("doctor"):
                DoctorPage doctorPage = new DoctorPage(new PageLocalization());
                request.getRequestDispatcher(doctorPage.execute(request)).forward(request, response);
            case ("nurse"):
                NursePage nursePage = new NursePage(new PageLocalization());
                request.getRequestDispatcher(nursePage.execute(request)).forward(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
