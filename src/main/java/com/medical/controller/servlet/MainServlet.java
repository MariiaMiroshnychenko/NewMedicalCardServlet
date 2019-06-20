package com.medical.controller.servlet;

import com.medical.controller.commands.Command;
import com.medical.controller.commands.PageLocalization;
import com.medical.controller.commands.implementation.*;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(MainServlet.class.getSimpleName());
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
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF8");

        String path = req.getRequestURI();

        path = path.replaceAll(".*/", "");
        path = path.replaceAll("\\?*", "");

        Command command = commands.getOrDefault(path, commands.get("login"));
        String page;
        String role = (String) req.getSession().getAttribute("role");

        if (command.checkAuthority(role)) {
            page = command.execute(req);
        } else {
            LOGGER.error("Attempt of moving to forbidden page");
            page = "/WEB-INF/view/templates/403.jsp";

        }
        req.getRequestDispatcher(page).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}