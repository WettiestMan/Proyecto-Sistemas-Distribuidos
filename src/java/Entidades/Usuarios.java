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
public class Usuarios {
    private String user;
    private char pass[];
    private RolUsuario rol;

    public Usuarios(String user, char pass[], RolUsuario rol) {
        this.user = user;
        this.pass = pass;
        this.rol = rol;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public char[] getPass() {
        return pass;
    }

    public void setPass(char pass[]) {
        this.pass = pass;
    }
    
    public RolUsuario getRol() {
        return rol;
    }
    
    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }
}
