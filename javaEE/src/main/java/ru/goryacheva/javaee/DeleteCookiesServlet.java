package ru.goryacheva.javaee;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DeleteCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("some_id", "");

        //при значении setMaxAge(-1) куки будут удаляться из браузера клиента при закрытии браузера
        //чтобы удалить куки передаем setMaxAge(0)
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
