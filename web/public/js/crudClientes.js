/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


const formElems = {
    id: document.getElementById("clienteId"),
    apellidos: document.getElementById("clienteApellidos"),
    nombres: document.getElementById("clienteNombres"),
    dni: document.getElementById("clienteDni"),
    direccion: document.getElementById("clienteDireccion"),
    telefono: document.getElementById("clienteTelefono"),
    movil: document.getElementById("clienteMovil")
};

const sunat = {
    ruc: document.getElementById("sunatRuc"),
    rucSend: document.getElementById("sunatRucEnviar"),
    dni: document.getElementById("sunatDni"),
    dniSend: document.getElementById("sunatDniEnviar")
};

function esIdentificadorValido(longitud, str) {
    return (str.length === longitud && /^[0-9]+$/.test(str));
}

sunat.rucSend.addEventListener("click", (event) => {
    event.preventDefault();
    if (esIdentificadorValido(11, sunat.ruc.value)) {
        fetch("ConsultarCliente", {
            method: "POST",
            headers: {'Content-Type' : 'application/json; charset=utf-8'},
            body: JSON.stringify({
                tipo: "ruc",
                val: sunat.ruc.value 
            })
        }).then(res => {
            if (!res.ok) {
                switch(res.status) {
                    case 404:
                        throw new Error("Este RUC parece no pertenecer a ningún usuario");
                    case 500:
                        throw new Error("El servidor no pudo procesar la solicitud");
                    default:
                        throw new Error("Error desconocido, pruebe a cambiar la entrada e intente de nuevo. O hágalo más tarde");
                }
            }
            else {
                return res.json();
            }
        }).then(data => {
            formElems.nombres.value = data.nombre_o_razon_social;
            formElems.direccion.value = data.direccion;
            formElems.telefono.value = data.numero;
        }).catch(error => {
            alert(error.message);
        });
    }
});

sunat.dniSend.addEventListener("click", (event) => {
    event.preventDefault();
    if (esIdentificadorValido(8, sunat.dni.value)) {
        fetch("ConsultarCliente", {
            method: "POST",
            headers: {'Content-Type' : 'application/json; charset=utf-8'},
            body: JSON.stringify({
                tipo: "dni",
                val: sunat.dni.value 
            })
        }).then(res => {
            if (!res.ok) {
                switch(res.status) {
                    case 404:
                        throw new Error("Este DNI parece no pertenecer a ningún usuario");
                    case 500:
                        console.log(res.text());
                        throw new Error("El servidor no pudo procesar la solicitud");
                    case 400:
                        throw new Error("Solicitud inválida, intente con un DNI válido");
                }
            }
            else {
                return res.json();
            }
        }).then(data => {
            formElems.nombres.value = data.nombres;
            formElems.apellidos.value = data.apellidoPaterno + " " + data.apellidoMaterno;
            formElems.dni.value = data.numeroDocumento;
        }).catch(error => {
            alert(error.message);
        });
    }
});