package servlet.commands.implementation;

import servlet.commands.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogOut implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        final HttpSession session = req.getSession();

        session.removeAttribute("user");
        session.removeAttribute("role");

        return "/WEB-INF/view/templates/login.jsp";
    }
}
