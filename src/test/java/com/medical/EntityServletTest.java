package com.medical;

import com.medical.controller.servlet.EntityServlet;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class EntityServletTest {
    private static final String PATH = "/WEB-INF/view/templates/registration.jsp";
    private static final String URI = "/registration";

    @Test
    public void doGetTest() throws ServletException, IOException {
        final EntityServlet entityServlet = new EntityServlet();

        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        final RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);

        when(request.getRequestDispatcher(PATH)).thenReturn(requestDispatcher);
        when(request.getRequestURI()).thenReturn(URI);

        entityServlet.init();
        entityServlet.doGet(request, response);

        verify(request, times(1)).getRequestDispatcher(PATH);
        verify(requestDispatcher).forward(request, response);

    }
}
