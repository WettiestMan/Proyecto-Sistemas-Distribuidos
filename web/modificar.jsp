<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : index
    Created on : 19/11/2021, 07:15:10 PM
    Author     : javie
--%>

<%@page import="java.util.List"%>
<%@page import="Entidades.Cliente"%>
<%@page contentType="text/html; charset-UTF-8"%>
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
            List<Cliente> Lista= (List<Cliente>) request.getAttribute("Lista");
        %>
        <h1>Modifica Clientes</h1>
        <form action="ControlerCliente" method="post">   
            <table border="1">
   
                <c:forEach var="campo" items="${Lista}">
                    <tr>
                        <td>Id Cliente</td>
                        <td>${campo.id}</td>
                        <input type="hidden" name="Id" value="${campo.id}">
                    </tr>
                    <tr>
                        <td>Apellidos</td>
                        <td><input type="text" name="apellidos" value="${campo.apellidos}"></td>
                    </tr>
                    <tr>
                        <td>Nombres</td>
                        <td><input type="text" name="nombres" value="${campo.nombres}"></td>
                    </tr>     
                    <tr>
                        <td>DNI</td>
                        <td><input type="text" name="DNI" value="${campo.DNI}"></td>
                    </tr>        
                    <tr>
                        <td>Dirección</td>
                        <td><input type="text" name="direccion" value="${campo.direccion}"></td>
                    </tr>  
                    <tr>
                        <td>Teléfono</td>
                        <td><input type="text" name="telefono" value="${campo.telefono}"></td>
                    </tr>                 
                    <tr>
                        <td>Móvil</td>
                        <td><input type="text" name="movil" value="${campo.movil}"></td>
                    </tr>                 
                </c:forEach>
            </table>
            <input type="submit" name="modificar" value="Modificar"> 
        </form>
    </body>
</html>
