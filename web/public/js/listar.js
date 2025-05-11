/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


const botones = document.getElementsByClassName("BotonEliminarUsuario");

if (botones.length > 0) {
    Array.from(botones).forEach(boton => {
        boton.addEventListener("click", evt => {
            evt.preventDefault();
            const href = evt.currentTarget.href;

            const decision = confirm("¿Estás seguro que deseas eliminar este cliente?");
            if (decision) {
                window.location.href = href;
            }
        });
    });
}