<%-- 
    Document   : index
    Created on : 17/09/2022, 08:38:47 AM
    Author     : javie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");  
            if (session.getAttribute("user")==null){
                response.sendRedirect("login.jsp");
            }
        %>
         
        <h1>Menú Principal</h1>
        <form action="ValidarLogin" method="GET">  
            <p><a href="Clientes.jsp">Clientes</a></p>
            <p><a href="Productos.jsp">Producto</a></p>
            <p><a href="Pedidos.jsp">Pedidos</a></p>
            <p><a href="CerrarSesion">Cerrar Sesión</a></p>
        </form>
    </body>
</html>
