package servlet.filter;

import model.dao.FactoryDao;
import model.entity.UserData;
import model.services.PersonIdentifier;
import model.services.PersonRegistration;
import model.services.implementation.PersonIdentifierService;
import model.services.implementation.PersonRegistrationService;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationFilter implements Filter {
    private PersonIdentifier personIdentifier;
    private PersonRegistration personRegistration;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(final ServletRequest servletRequest,
                         final ServletResponse servletResponse,
                         final FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        final String surnameUk = request.getParameter("surname_uk");
        final String surnameEn = request.getParameter("surname_en");
        final String nameUk = request.getParameter("name_uk");
        final String nameEn = request.getParameter("name_en");
        final String patronymicUk = request.getParameter("patronymic_uk");
        final String patronymicEn = request.getParameter("patronymic_en");
        final String login = request.getParameter("login");
        final String password = request.getParameter("password");
        final String role = request.getParameter("role");
        final String photo = request.getParameter("photo");

        final String encodingPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        personIdentifier = new PersonIdentifierService(FactoryDao.getInstance().getUserDataJdbcDao());
        personRegistration = new PersonRegistrationService();

        UserData userData = personIdentifier.identifyPerson(login);

        if (userData != null) {
            request.setAttribute("loginError", "Try to enter new user login!");
        }

        userData = new UserData(surnameUk, surnameEn, nameUk, nameEn, patronymicUk, patronymicEn,
                login, encodingPassword, role, photo);
        userData.setRole("patient");
        userData.setPhoto("http://teplota.kh.ua/wp-content/uploads/2013/02/ЧЕЛОВЕЧЕК.jpg");
        personRegistration.toSignUp(userData);

        request.getRequestDispatcher("/WEB-INF/view/templates/login.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
    }
}
