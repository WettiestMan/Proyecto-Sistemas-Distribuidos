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
        <h1>Inserta Clientes</h1>
        <form action="ControlerCliente" method="post">   
            <table border="1">
                    <tr>
                        <td>Id Cliente</td>
                        <td><input type="hidden" name="Id"></td>
                    </tr>
                    <tr>
                        <td>Apellidos</td>
                        <td><input type="text" name="apellidos"></td>
                    </tr>
                    <tr>
                        <td>Nombres</td>
                        <td><input type="text" name="nombres"></td>
                    </tr>     
                    <tr>
                        <td>DNI</td>
                        <td><input type="text" name="DNI"></td>
                    </tr>        
                    <tr>
                        <td>Dirección</td>
                        <td><input type="text" name="direccion"></td>
                    </tr>  
                    <tr>
                        <td>Teléfono</td>
                        <td><input type="text" name="telefono"></td>
                    </tr>                 
                    <tr>
                        <td>Móvil</td>
                        <td><input type="text" name="movil"></td>
                    </tr>                 
            </table>
            <input type="submit" name="modificar" value="Grabar"> 
        </form>
    </body>
</html>


