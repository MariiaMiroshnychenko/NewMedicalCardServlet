package servlet.commands.implementation;

import servlet.commands.Command;

import javax.servlet.http.HttpServletRequest;

public class Registration implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "WEB-INF/view/templates/registration.jsp";
    }
}
