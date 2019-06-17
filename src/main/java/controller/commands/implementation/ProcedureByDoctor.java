package controller.commands.implementation;

import controller.commands.Command;

import javax.servlet.http.HttpServletRequest;

public class ProcedureByDoctor implements Command {
    private PageLocalization pageLocalization;

    public ProcedureByDoctor(PageLocalization pageLocalization) {
        this.pageLocalization = pageLocalization;
    }

    @Override
    public String execute(HttpServletRequest request) {
        pageLocalization.
        return "/WEB-INF/view/templates/procedure.jsp";
    }
}
