<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : index
    Created on : 19/11/2021, 07:15:10 PM
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
        <h1>Inicio de Sesión</h1>
        <form action="ValidarLogin" method="post">   
            <table border="1">
                    <tr>
                        <td>Usuario</td>
                        <td><input type="text" name="txtUsuario"></td>
                    </tr>
                    <tr>
                        <td>Clave</td>
                        <td><input type="password" name="txtClave"></td>
                    </tr> 
            </table>        
            <input type="submit" name="validar" value="Aceptar"> 
        </form>
    </body>
</html>
