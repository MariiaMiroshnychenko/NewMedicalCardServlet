package com.medical.controller.commands.implementation;

import com.medical.container.PagesContainer;
import com.medical.container.RoleContainer;
import com.medical.controller.commands.Command;

import javax.servlet.http.HttpServletRequest;

public class Login implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        return PagesContainer.PAGE_LOGIN;
    }

    @Override
    public boolean checkAuthority(String role) {
        return true;
    }
}
