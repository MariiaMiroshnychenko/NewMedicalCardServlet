package com.medical.controller.filter;

import com.medical.constants.RegexConstant;
import com.medical.exception.IncorrectInputException;
import com.medical.model.dao.FactoryDao;
import com.medical.model.entity.UserData;
import com.medical.model.services.UserDataProcessor;
import com.medical.model.services.implementation.UserDataService;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationFilter implements Filter {
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

        final String encodingPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        try {
            checkData(surnameUk, RegexConstant.NAME_SURNAME_REGEX_UK, INCORRECT_NAME_UKR);
        } catch (IncorrectInputException exception) {
            request.setAttribute("error", exception.getMessage());
            request.getRequestDispatcher("WEB-INF/view/templates/registration.jsp").forward(request, response);
        }

        UserDataProcessor userDataProcessor = new UserDataService(FactoryDao.getInstance().getUserDataJdbcDao());

        UserData userData = userDataProcessor.identifyPersonByLogin(login);

        if (userData != null) {
            request.setAttribute("loginError", "Try to enter new user login!");
        }

        userData = new UserData(surnameUk, surnameEn, nameUk, nameEn, patronymicUk, patronymicEn, login, encodingPassword);
        userData.setRole("patient");
        userData.setPhoto("http://teplota.kh.ua/wp-content/uploads/2013/02/ЧЕЛОВЕЧЕК.jpg");

        userDataProcessor.toSignUp(userData);

        request.getRequestDispatcher("/WEB-INF/view/templates/login.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
    }

    private void checkData(String data, String regex, String errorMessage) throws IncorrectInputException {
        if (!data.matches(regex)) {
            throw new IncorrectInputException(errorMessage);
        }
    }
}
