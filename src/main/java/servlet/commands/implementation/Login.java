package servlet.commands.implementation;

import servlet.commands.Command;

import javax.servlet.http.HttpServletRequest;

public class Login implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        return "/WEB-INF/view/templates/login.jsp";
    }
}
