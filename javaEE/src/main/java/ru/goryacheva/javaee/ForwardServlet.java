package ru.goryacheva.javaee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ForwardServlet", value = "/test-forward")
public class ForwardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //forward действует только внутри сервера, и мы можем перенаправлять пользователя только на внутренние адреса этого сервера

        RequestDispatcher dispatcher = request.getRequestDispatcher("/forwardJsp.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
