package com.medical.controller.commands;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    String execute(HttpServletRequest request);
    boolean checkAuthority(String role);
}
