package controller.servlet;

import controller.commands.Command;
import controller.commands.implementation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EntityServlet extends HttpServlet {
    private Map<String, Command> commands;

    @Override
    public void init() throws ServletException {
        commands = new HashMap<>();
        commands.put("login", new Login());
        commands.put("logout", new Logout());
        commands.put("registration", new Registration());
        commands.put("patientPage", new PatientPage(new PageLocalization()));
        commands.put("doctorPage", new DoctorPage(new PageLocalization()));
        commands.put("nursePage", new NursePage(new PageLocalization()));
        commands.put("doctor-appointment", new DoctorAppointment(new PageLocalization()));
        commands.put("procedures", new ProcedureByMedEmployee(new PageLocalization()));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF8");

        String path = req.getRequestURI();

        path = path.replaceAll(".*/", "");
        path = path.replaceAll("\\?*", "");
        Command command = commands.getOrDefault(path, (r) -> "/WEB-INF/view/templates/login.jsp");
        String page = command.execute(req);
        req.getRequestDispatcher(page).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}