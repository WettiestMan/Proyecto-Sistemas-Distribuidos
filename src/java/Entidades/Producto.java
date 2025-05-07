/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author javie
 */
public class Producto {
    private String Id;
    private String Descripcion;
    private float Costo;
    private float Precio;
    private int Cantidad;

    public Producto() {
        this.Id="";
        this.Descripcion="";
        this.Costo=0;
        this.Precio=0;
        this.Cantidad=0;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public float getCosto() {
        return Costo;
    }

    public void setCosto(float Costo) {
        this.Costo = Costo;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

}
