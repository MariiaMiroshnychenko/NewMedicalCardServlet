package com.medical.controller.commands.implementation;

import com.medical.container.PagesContainer;
import com.medical.container.RoleContainer;
import com.medical.controller.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

public class Logout implements Command {
    private String[] hasAuthority = {RoleContainer.ROLE_DOCTOR, RoleContainer.ROLE_PATIENT, RoleContainer.ROLE_NURSE};
    @Override
    public String execute(HttpServletRequest req) {
        final HttpSession session = req.getSession();
//        session.removeAttribute("user");
//        session.removeAttribute("role");

        try {
            req.logout();
        } catch (ServletException e) {
            e.printStackTrace();
        }

        return PagesContainer.PAGE_LOGIN;
    }

    @Override
    public boolean checkAuthority(String role) {
        return Arrays.asList(hasAuthority).contains(role);
    }
}
