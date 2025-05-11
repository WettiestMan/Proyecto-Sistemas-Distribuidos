<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : index
    Created on : 19/11/2021, 07:15:10 PM
    Author     : javie
--%>
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
        <h1>Inserta Clientes</h1>
        <form id="sunat">
            <label for="sunatRuc">Ingrese un RUC para obtener datos de SUNAT</label><br>
            <input type="text" id="sunatRuc" minLength="11" maxLength="11">
            <button type="button" id="sunatRucEnviar">Enviar</button><br><br>
            
            <label for="sunatDni">O ingrese un DNI en su lugar</label><br>
            <input type="text" id="sunatDni" minLength="8" maxLength="8">
            <button type="button" id="sunatDniEnviar">Enviar</button><br><br>
        </form>
        <form action="ControlerCliente" method="post">   
            <table border="1">
                    <tr>
                        <td>Id Cliente</td>
                        <td><input type="hidden" name="Id" id="clienteId"></td>
                    </tr>
                    <tr>
                        <td>Apellidos</td>
                        <td><input type="text" name="apellidos" id="clienteApellidos"></td>
                    </tr>
                    <tr>
                        <td>Nombres</td>
                        <td><input type="text" name="nombres" id="clienteNombres"></td>
                    </tr>     
                    <tr>
                        <td>DNI</td>
                        <td><input type="text" name="DNI" id="clienteDni"></td>
                    </tr>        
                    <tr>
                        <td>Dirección</td>
                        <td><input type="text" name="direccion" id="clienteDireccion"></td>
                    </tr>  
                    <tr>
                        <td>Teléfono</td>
                        <td><input type="text" name="telefono" id="clienteTelefono"></td>
                    </tr>
                    <tr>
                        <td>Móvil</td>
                        <td><input type="text" name="movil" id="clienteMovil"></td>
                    </tr>                 
            </table>
            <input type="submit" name="modificar" value="Grabar"> 
        </form>
        
        <script src="public/js/crudClientes.js" type="text/javascript" charset="UTF-8"></script>
    </body>
</html>


