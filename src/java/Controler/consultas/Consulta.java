/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler.consultas;

/**
 *
 * @author santi
 */
public class Consulta {
    private String tipo;
    private String val;

    public Consulta() {
        tipo = null;
        val = null;
    }

    public String getTipo() {
        return tipo;
     }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Consulta{" + "tipo=" + tipo + ", val=" + val + '}';
    }
}
