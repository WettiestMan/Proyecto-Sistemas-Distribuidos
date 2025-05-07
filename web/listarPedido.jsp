<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : listar
    Created on : 17/09/2022, 10:54:58 AM
    Author     : javie
--%>
<%@page import="java.util.List"%>
<%@page import="Entidades.Pedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Pedido> Lista= (List<Pedido>) request.getAttribute("Lista");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de Pedidos</h1>
        <table border="1">
                <tr>
                    <td>Id Pedido</td>
                    <td>Id Cliente</td>
                    <td>Apellidos</td>
                    <td>Nombres</td>
                    <td>Fecha</td>
                    <td>Total Pedido</td>
                </tr>
                
                <c:forEach var="campo" items="${Lista}">
                <tr>
                   <td>${campo.getId_Pedido()}</td>
                   <td>${campo.getId_Cliente()}</td>
                   <td>${campo.getApellidos()}</td>
                   <td>${campo.getNombres()}</td>
                   <td>${campo.getFecha()}</td>
                   <td>${campo.getTotalVenta()}</td>
                   <td><a href="ControlerPedido?Op=Consultar&Id=${campo.getId_Pedido()}">Consultar</a></td>
                   <td><a href="ControlerPedido?Op=Eliminar&Id=${campo.getId_Pedido()}">Eliminar</a></td>>
                </tr>
                </c:forEach>
                
        </table> 
    </body>
</html>
