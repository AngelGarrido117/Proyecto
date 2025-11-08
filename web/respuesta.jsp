<%-- 
    Document   : respuesta
    Created on : 8/11/2025, 12:49:05 PM
    Author     : linkl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% out.print(request.getParameter("respuesta")); %>
    </body>
</html>
