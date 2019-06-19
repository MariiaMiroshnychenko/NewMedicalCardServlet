package com.medical.controller.commands.implementation;

import com.medical.controller.commands.Command;

import javax.servlet.http.HttpServletRequest;

public class DoctorPage implements Command {
    private PageLocalization pageLocalization;

    public DoctorPage(PageLocalization pageLocalization) {
        this.pageLocalization = pageLocalization;
    }

    @Override
    public String execute(HttpServletRequest request) {
        pageLocalization.setAttributeWithLocalUserData(request);
        return "/WEB-INF/view/templates/doctorPage.jsp";
    }
}
