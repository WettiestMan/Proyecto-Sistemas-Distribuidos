<%-- 
    Document   : 500
    Created on : 9 may 2025, 2:28:23
    Author     : santi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Object check = request.getAttribute("msg");
    
    String msg = check != null ?
                (String) check : "Error al procesar la solicitud";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error interno del servidor</title>
    </head>
    <body>
        <h1>Error interno del servidor (500)</h1>
        <p><%= msg %></p>
    </body>
</html>
