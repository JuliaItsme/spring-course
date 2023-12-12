<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First JSP</title>
</head>
<body>
    <h1>Testing JSP</h1>
    <p>
        <%@ page import="java.util.Date" %>
        <%="Good morning, Julia!" %>
        <br/>
        <%
            Date now = new Date();
            String date = "Текущая дата: " + now;
            for (int i=0; i<10; i++){
                out.println("<p>" + "Good day! Today is " + i + " day!" + "</p>");
            }

            String name = request.getParameter("name");

        %>
        <%= date %>
        <br/>
        <%= "Hello, my dear " + name + "!"%>
    </p>
</body>
</html>
<%----%>