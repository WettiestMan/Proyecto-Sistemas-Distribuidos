/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package migracion;

import Entidades.RolUsuario;
import at.favre.lib.crypto.bcrypt.BCrypt;
import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author santi
 */
public class MigracionUsuarios {
    
    private static class Usuario {
        public String user;
        public char pass[];
        public RolUsuario rol;
        
        public Usuario(String usr, char pswd[], RolUsuario rl) {
            user = usr;
            pass = pswd;
            rol = rl;
        }
    }
    
    public static void main(String[] args) {
        final Usuario paraLlenar[] = {
            new Usuario("JGARCIA", BCrypt.with(BCrypt.Version.VERSION_2A).hashToChar(12, "12345678".toCharArray()), RolUsuario.USUARIO),
            new Usuario("JPEREZ", BCrypt.with(BCrypt.Version.VERSION_2A).hashToChar(12, "HolaMundo".toCharArray()), RolUsuario.USUARIO),
            new Usuario("admin", BCrypt.with(BCrypt.Version.VERSION_2A).hashToChar(12, "1234".toCharArray()), RolUsuario.ADMINISTRADOR)
        };
        
        final String sql = "INSERT INTO t_usuario VALUES (?,?,?)";
        
        final ConexionBD dbhandle = new ConexionBD();
        final Connection conn = dbhandle.connected();
        
        if (conn == null)
            throw new RuntimeException("No se pudo conectar con la base de datos");
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            for (final Usuario us : paraLlenar) {
                ps.setString(1, us.user);
                ps.setString(2, new String(us.pass));
                ps.setString(3, us.rol.toString());
                ps.executeUpdate();
                ps.clearParameters();
            }
        } catch (SQLException e) {
            System.err.println("Error populando tabla de usuarios... " + e.getMessage());
        } finally {
            dbhandle.disconnect();
        }
    }
}
