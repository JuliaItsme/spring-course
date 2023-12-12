package ru.goryacheva.javaee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RedirectForwardServlet", value = "/test-redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //redirect это ответ для пользователя, поэтому response
        //redirect действует внутри и снаружи сервера, поэтому мы можем перенаправлять на сторонний сайт
        response.sendRedirect("https://swiftbook.org/");

        //redirect на jsp форму
        response.sendRedirect("/redirectJsp.jsp");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
