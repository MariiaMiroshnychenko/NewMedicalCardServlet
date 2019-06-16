package servlet.filter;

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
                System.out.println(userData.getRole());
                request.getSession().setAttribute("user", userData);
                request.getSession().setAttribute("role", userData.getRole());

                redirectToAccount(request, response, userData.getRole());
            }
        } else {
            request.getRequestDispatcher("/WEB-INF/view/templates/login.jsp").forward(request, response);
        }
    }

    private void redirectToAccount(final HttpServletRequest request, final HttpServletResponse response,
                                   final String role) throws ServletException, IOException {
        switch (role) {
            case ("patient"):
                request.getRequestDispatcher("/WEB-INF/view/templates/patientPage.jsp").forward(request, response);
            case ("doctor"):
                request.getRequestDispatcher("/WEB-INF/view/templates/doctorPage.jsp").forward(request, response);
//            case ("Лікар за спеціальністю"):
//                request.getRequestDispatcher("/WEB-INF/view/templates/specDoctorPage.jsp)").forward(request, response);
            case ("nurse"):
                request.getRequestDispatcher("/WEB-INF/view/templates/medEmployeePage.jsp)").forward(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
