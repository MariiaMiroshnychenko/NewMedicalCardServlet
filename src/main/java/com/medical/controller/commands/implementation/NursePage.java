package com.medical.controller.commands.implementation;

import com.medical.container.PagesContainer;
import com.medical.container.RoleContainer;
import com.medical.controller.commands.Command;
import com.medical.controller.commands.PageLocalization;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

public class NursePage implements Command {
    private String[] hasAuthority = {RoleContainer.ROLE_NURSE};
    private PageLocalization pageLocalization;

    public NursePage(PageLocalization pageLocalization) {
        this.pageLocalization = pageLocalization;
    }

    @Override
    public String execute(HttpServletRequest request) {
        pageLocalization.setAttributeWithLocalUserData(request);
        return PagesContainer.PAGE_NURSE_ACCOUNT;
    }

    @Override
    public boolean checkAuthority(String role) {
        return Arrays.asList(hasAuthority).contains(role);
    }
}
