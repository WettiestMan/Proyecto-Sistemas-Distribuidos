<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : index
    Created on : 19/11/2021, 07:15:10 PM
    Author     : javie
--%>

<%@page import="java.util.List"%>
<%@page import="Entidades.DetallePedido"%>
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
        <%
            List<DetallePedido> Lista= (List<DetallePedido>) request.getAttribute("Lista");
        %>
        <h1>Consulta de Pedido</h1>
        <table border="1">
              
            <c:forEach var="campo" items="${Lista}">
                <tr>
                    <td>Id Pedido</td>
                    <td>${campo.getId_Pedido()}</td>
                </tr>
                <tr>
                    <td>Id Producto</td>
                    <td>${campo.getId_Prod()}</td>
                </tr>
                <tr>
                    <td>Descripción</td>
                    <td>${campo.getDescripcion()}</td>
                </tr>     
                <tr>
                    <td>Cantidad</td>
                    <td>${campo.getCantidad()}</td>
                </tr>        
                <tr>
                    <td>Precio</td>
                    <td>${campo.getPrecio()}</td>
                </tr>  
                <tr>
                    <td>Total Detalle</td>
                    <td>${campo.getTotalDeta()}</td>
                </tr>                
            </c:forEach>
        </table>

    </body>
</html>