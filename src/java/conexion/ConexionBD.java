/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;
import java.sql.Connection;
import io.github.cdimascio.dotenv.Dotenv;
//com.mysql.cj.jdbc.JdbcConnection;
//com.mysql.jdbc.Driver
import java.sql.DriverManager;
import java.sql.SQLException;
//import javax.swing.JOptionPane;

/**
 *
 * @author javie
 */
public class ConexionBD {
    private final static String driver = "com.mysql.cj.jdbc.Driver";
    private final static String url;
    private final static String user;
    private final static String pass;
    protected Connection conn = null;
    
    static {
        // Cargue un .env en la carpeta bin de su apache tomcat
        final Dotenv environmentHandle = Dotenv.configure()
                .ignoreIfMissing()
                .load();
        user = environmentHandle.get("USER", "root");
        pass = environmentHandle.get("PASS", "");
        url = environmentHandle.get("DB_URL");
    }
    
    public ConexionBD() {
        try{
            Class.forName(driver);
            conn = (Connection)DriverManager.getConnection(url,user,pass);
            if (conn != null){
                System.out.println("Conexión realizada..."+conn);
                //JOptionPane.showMessageDialog(null,"Conectado");
        }
        } catch (SQLException ex) {
            System.out.println("Conexión fallida..." + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Falta Driver " + ex.getMessage());
        }       
    }
    public Connection connected(){
        return conn;
    }
    public Connection disconnect(){    
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error de desconexión.. "+ex.getMessage());
        }
        return null;
    }
}
