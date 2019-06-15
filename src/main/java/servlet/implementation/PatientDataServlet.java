package servlet.implementation;//package controller.servlet.implementation;
//
//import controller.servlet.EntityServlet;
//import JdbcFactoryDao;
//import view.PagesConstant;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class PatientDataServlet extends EntityServlet implements PagesConstant {
//    @Override
//    public void setServletAttribute(HttpServletRequest req) {
//        List<Patient> patients = JdbcFactoryDao.getInstance().getPatientJdbcDao().getAll();
//        List<Doctor> doctors = JdbcFactoryDao.getInstance().getDoctorJdbcDao().getAll();
//        List<Visit> visits = JdbcFactoryDao.getInstance().getVisitJdbcDao().getAll();
//
//        req.setAttribute("patients", patients);
//        req.setAttribute("doctors", doctors);
//        req.setAttribute("visits", visits);
//    }
//
//    @Override
//    public void setServletDispatcher(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        req.getRequestDispatcher(INDEX).forward(req, resp);
//    }
//}
