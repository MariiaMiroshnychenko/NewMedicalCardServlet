package controller.commands.implementation;

import controller.commands.Command;

import javax.servlet.http.HttpServletRequest;

public class PatientPage implements Command {
    private PageLocalization pageLocalization;

    public PatientPage(PageLocalization pageLocalization) {
        this.pageLocalization = pageLocalization;
    }

    @Override
    public String execute(HttpServletRequest request) {
        pageLocalization.defineLanguageForUserAccount(request);
        return "/WEB-INF/view/templates/patientPage.jsp";
    }
}
