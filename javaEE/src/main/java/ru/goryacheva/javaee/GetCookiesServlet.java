package ru.goryacheva.javaee;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class GetCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        for(Cookie c : cookies){
            out.println("<h1>" + c.getName() +": "+ c.getValue() + "</h1>");
        }

        out.println("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
