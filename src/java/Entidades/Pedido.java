/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

import java.sql.Date;
/**
 *
 * @author javie
 */
public class Pedido {
    private String Id_Pedido;
    private String Id_Cliente;
    private String Apellidos;
    private String Nombres;
    private Date Fecha;
    private double SubTotal;
    private double TotalVenta;

    public Pedido() {
        this.Id_Pedido="";
        this.Id_Cliente="";
        this.Apellidos="";
        this.Nombres="";
        this.Fecha= null;
        this.SubTotal=0;
        this.TotalVenta=0;
    }

    public String getId_Pedido() {
        return Id_Pedido;
    }

    public void setId_Pedido(String Id_Pedido) {
        this.Id_Pedido = Id_Pedido;
    }

    public String getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(String Id_Cliente) {
        this.Id_Cliente = Id_Cliente;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(double SubTotal) {
        this.SubTotal = SubTotal;
    }

    public double getTotalVenta() {
        return TotalVenta;
    }

    public void setTotalVenta(double TotalVenta) {
        this.TotalVenta = TotalVenta;
    }
    
}
