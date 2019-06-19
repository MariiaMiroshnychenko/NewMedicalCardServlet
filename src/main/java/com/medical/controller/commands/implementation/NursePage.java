package com.medical.controller.commands.implementation;

import com.medical.controller.commands.Command;

import javax.servlet.http.HttpServletRequest;

public class NursePage implements Command {
    private PageLocalization pageLocalization;

    public NursePage(PageLocalization pageLocalization) {
        this.pageLocalization = pageLocalization;
    }

    @Override
    public String execute(HttpServletRequest request) {
        pageLocalization.setAttributeWithLocalUserData(request);
        return "/WEB-INF/view/templates/medEmployeePage.jsp";
    }
}
