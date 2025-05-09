<%-- 
    Document   : Pedidos
    Created on : 12/10/2022, 05:11:15 PM
    Author     : javie
--%>

<%@page contentType="text/html; charset-UTF-8"%>
<%  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");  
    if (session.getAttribute("user") == null){
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
        <h1>Menú Pedido</h1>
        <p><a href="ControlerPedido?Op=Listar">Listar Pedidos</a></p>
        <p><a href="ControlerPedido?Op=Nuevo">Nuevo Pedido</a></p>
    </body>
</html>
