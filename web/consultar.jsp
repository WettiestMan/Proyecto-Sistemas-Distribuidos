<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : index
    Created on : 19/11/2021, 07:15:10 PM
    Author     : javie
--%>

<%@page import="java.util.List"%>
<%@page import="Entidades.Cliente"%>
<%@page contentType="text/html; charset-UTF-8"%>
<%
    List<Cliente> Lista= (List<Cliente>) request.getAttribute("Lista");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Consulta de Clientes</h1>
        <table border="1">
              
                <c:forEach var="campo" items="${Lista}">
                <tr>
                    <td>Id Cliente</td>
                    <td>${campo.id}</td>
                </tr>
                <tr>
                    <td>Apellidos</td>
                    <td>${campo.apellidos}</td>
                </tr>
                <tr>
                    <td>Nombres</td>
                    <td>${campo.nombres}</td>
                </tr>     
                <tr>
                    <td>DNI</td>
                    <td>${campo.DNI}</td>
                </tr>        
                <tr>
                    <td>Dirección</td>
                    <td>${campo.direccion}</td>
                </tr>  
                <tr>
                    <td>Teléfono</td>
                    <td>${campo.telefono}</td>
                </tr>                 
                <tr>
                    <td>Móvil</td>
                    <td>${campo.movil}</td>
                </tr>                 
                </c:forEach>
        </table>

    </body>
</html>