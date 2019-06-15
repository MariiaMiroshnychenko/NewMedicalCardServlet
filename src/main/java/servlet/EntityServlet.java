package servlet;

import servlet.commands.Command;
import servlet.commands.implementation.Login;

import javax.servlet.Registration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class EntityServlet extends HttpServlet {
    Map<String, Command> commands;
    @Override
    public void init() throws ServletException {
        commands = new HashMap<>();
        commands.put("login", new Login());
        commands.put("logout", new Logout());
        commands.put("registration", new Registration());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF8");

        setServletAttribute(req);

        setServletDispatcher(req, resp);
    }

    public abstract void setServletDispatcher(HttpServletRequest req, HttpServletResponse resp)
                  throws ServletException, IOException;

    public abstract void setServletAttribute(HttpServletRequest req);
}