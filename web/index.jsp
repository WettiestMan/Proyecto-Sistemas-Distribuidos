<%-- 
    Document   : index
    Created on : 17/09/2022, 08:38:47 AM
    Author     : javie
--%>

<%@page import="Entidades.RolUsuario"%>
<%@page import="Entidades.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");  
    if (session.getAttribute("user")==null){
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Menú Principal</h1>
        <p><a href="Cliente/Clientes.jsp">Clientes</a></p>
        <p><a href="Cliente/Productos.jsp">Producto</a></p>
        <p><a href="Cliente/Pedidos.jsp">Pedidos</a></p>
        <% 
            Usuarios usr = (Usuarios)session.getAttribute("user");
            if (usr != null && usr.getRol() == RolUsuario.ADMINISTRADOR) {%>
            <p><a href="Usuarios.jsp">Usuarios</a></p>
        <% } %>
        <p><a href="CerrarSesion">Cerrar Sesión</a></p>
    </body>
</html>
