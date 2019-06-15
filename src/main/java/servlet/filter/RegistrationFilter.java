package servlet.filter;

import model.dao.PersonalRegDataDao;
import model.dao.RoleDao;
import model.dao.implementation.PersonalRegDataJdbcDao;
import model.entity.PersonalRegData;
import model.entity.Role;
import org.mindrot.jbcrypt.BCrypt;
import servlet.mapper.implementation.PersonalRegDataMapper;
import servlet.mapper.implementation.RoleMapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class RegistrationFilter implements Filter {
    private PersonalRegDataMapper personalRegDataMapper = new PersonalRegDataMapper();
    private RoleMapper roleMapper = new RoleMapper();
    private Map<Integer, PersonalRegData> personalRegDataMap = new HashMap<>();
    private Map<Integer, Role> roleMap = new HashMap<>();


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(final ServletRequest servletRequest,
                         final ServletResponse servletResponse,
                         final FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        final String surname = request.getParameter("surname");
        final String name = request.getParameter("name");
        final String patronymic = request.getParameter("patronymic");
        final String birthDate = request.getParameter("birthDate");
        final String phone = request.getParameter("phone");
        final String email = request.getParameter("email");
        final String login = request.getParameter("login");
        final String password = request.getParameter("password");
        final String code = request.getParameter("code");
        final String docSpeciality = request.getParameter("docSpeciality");

//        checkByRegex(request, response, nameUkr.matches(UKR_NAME_SURNAME_REGEX), USER_NAME_UKR_INCORRECT);
//        checkByRegex(request, response, nameEn.matches(LAT_NAME_SURNAME_REGEX), USER_NAME_LAT_INCORRECT);
//        checkByRegex(request, response, surnameUkr.matches(UKR_NAME_SURNAME_REGEX), USER_SURNAME_UKR_INCORRECT);
//        checkByRegex(request, response, surnameEn.matches(LAT_NAME_SURNAME_REGEX), USER_SURNAME_LAT_INCORRECT);
//        checkByRegex(request, response, login.matches(LOGIN_PASSWORD_REGEX), LOGIN_INCORRECT);
//        checkByRegex(request, response, password.matches(LOGIN_PASSWORD_REGEX), PASSWORD_INCORRECT);
//        checkByRegex(request, response, email.matches(EMAIL_REGEX), EMAIL_INCORRECT);

        @SuppressWarnings("unchecked") final AtomicReference<PersonalRegDataDao> personalRegDataDao =
                (AtomicReference<PersonalRegDataDao>) request.getServletContext()
                        .getAttribute("personalRegDataDao");
        @SuppressWarnings("unchecked") final AtomicReference<RoleDao> roleDao =
                (AtomicReference<RoleDao>) request.getServletContext()
                        .getAttribute("roleDao");

        PersonalRegData userData = personalRegDataDao.get().findPersonalRegDataByLogin(login);
        if (userData == null && !code.equals("")) {

        }
//        Role employee = personalRegDataDao.get()..personalRegDataMapper.findRoleByCode(code);


//        Role patient = roleRepo.findRoleByCodeIsNull();
//
//        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
//
//        if (userData == null && !code.equals("")) {
//            user.setEnabled(true);
//            user.setRoleId(employee);
//            user.setPhoto("https://www.pngkey.com/maxpic/u2q8u2w7e6y3r5y3/");
//            personalRegDataRepo.save(user);
//
//            MedicalEmployee medicalEmployee = MedicalEmployee.builder()
//                    .person(user)
//                    .speciality(speciality)
//                    .build();
//            medicalEmployeeRepo.save(medicalEmployee);
//
//        } else if (userData == null && code.equals("")) {
//            user.setEnabled(true);
//            user.setRoleId(patient);
//
//            personalRegDataRepo.save(user);
//
//            List<MedicalEmployee> attendingDoctors = medicalEmployeeRepo.findAllByPerson_RoleId_Title("Сімейний лікар");
//            Random random = new Random();
//
//            Patient newPatient = Patient.builder()
//                    .person(user)
//                    .medicalCard(patientRepo.selectPatientDescLimit() + 1)
//                    .attendingDoctor(attendingDoctors.get(random.nextInt(attendingDoctors.size())))
//                    .build();
//            patientRepo.save(newPatient);
//
//        } else {
//            model.put("message", "User exists!");
//            return "registration";
//        }
//
//        personalRegDataRepo.save(user);
//        return "redirect:/login";
        final String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt());

//        PersonalRegData personalRegData = new PersonalRegData(nameUkr, nameEn, surnameUkr, surnameEn,
//                login, hashPassword, gender, email, "client");
//        try {
//            new UserRegistrationService().register(user);
//        } catch (LoginAlreadyExistsException e) {
//            request.setAttribute("warning", LOGIN_EXISTS);
//            request.getRequestDispatcher("/WEB-INF/view/registration.jsp").forward(request, response);
//        }
//        request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
    }



    private void checkByRegex(HttpServletRequest request, HttpServletResponse response,

                              boolean matches, String warning) throws ServletException, IOException {

        if (!matches) {

            request.setAttribute("warning", warning);

            request.getRequestDispatcher("/WEB-INF/view/registration.jsp").forward(request, response);

        }

    }
}
