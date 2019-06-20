package com.medical.controller.commands.implementation;

import com.medical.container.PagesContainer;
import com.medical.controller.commands.Command;

import javax.servlet.http.HttpServletRequest;

public class Registration implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return PagesContainer.PAGE_REGISTRATION;
    }

    @Override
    public boolean checkAuthority(String role) {
        return true;
    }
}
