<%-- 
    Document   : Productos
    Created on : 12/10/2022, 05:11:07 PM
    Author     : javie
--%>

<%@page import="Entidades.RolUsuario"%>
<%@page import="Entidades.Usuarios"%>
<%@page contentType="text/html; charset-UTF-8"%>
<%  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    if (session.getAttribute("user") == null 
        || ((Usuarios)session.getAttribute("user")).getRol() != RolUsuario.ADMINISTRADOR){
        response.sendRedirect("../login.jsp");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>En Construcci�n....</h1>
    </body>
</html>
