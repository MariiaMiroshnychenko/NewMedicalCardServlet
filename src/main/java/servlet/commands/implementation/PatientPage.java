package servlet.commands.implementation;

import servlet.commands.Command;

import javax.servlet.http.HttpServletRequest;

public class PatientPage implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/view/templates/patientPage.jsp";
    }
}
