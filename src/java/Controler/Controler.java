/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;
import conexion.ConexionBD;
import Entidades.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author javie
 */
@WebServlet(name = "Controler", urlPatterns = {"/Controler"})
public class Controler extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controler</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controler at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
       /* String Op =request.getParameter("Op");
        ArrayList<cliente> Lista= new ArrayList<cliente>();
        ConexionBD conBD = new ConexionBD();
        Connection conn = conBD.connected();
        PreparedStatement ps;
        ResultSet rs;
        switch(Op){
            case "Listar":
                try{
                    String sql="SELECT * FROM t_cliente";
                    ps= conn.prepareStatement(sql);
                    rs= ps.executeQuery();
                    while(rs.next()){
                        Cliente client=new Cliente();
                        client.setId(rs.getString("Id_Cliente"));
                        client.setApellidos(rs.getString("Apellidos"));
                        client.setNombres(rs.getString("Nombres"));
                        client.setDNI(rs.getString("DNI"));
                        client.setDireccion(rs.getString("Direccion"));
                        client.setTelefono(rs.getString("Telefono"));
                        client.setMovil(rs.getString("Movil"));
                        Lista.add(client);
                    }
                    request.setAttribute("Lista", Lista);
                    request.getRequestDispatcher("listar.jsp").forward(request, response);
                }catch(SQLException ex){
                    System.out.println("Error de SQL..."+ex.getMessage());
                } finally{
                    conBD.disconnect();
                }
                break;
            case "Consultar":
                try{
                    String Id=request.getParameter("Id");
                    String sql="select * from t_cliente where Id_Cliente=?";
                    ps= conn.prepareStatement(sql);
                    ps.setString(1, Id);
                    rs= ps.executeQuery();
                    Cliente client=new Cliente();
                    while(rs.next()){
                        client.setId(rs.getString("Id_Cliente"));
                        client.setApellidos(rs.getString("Apellidos"));
                        client.setNombres(rs.getString("Nombres"));
                        client.setDNI(rs.getString("DNI"));
                        client.setDireccion(rs.getString("Direccion"));
                        client.setTelefono(rs.getString("Telefono"));
                        client.setMovil(rs.getString("Movil"));
                        Lista.add(client);
                    }
                    request.setAttribute("Lista", Lista);
                    request.getRequestDispatcher("consultar.jsp").forward(request, response);
                }catch(SQLException ex){
                    System.out.println("Error de SQL..."+ex.getMessage());
                } finally{
                    conBD.disconnect();
                }                
                break;    
            case "Modificar":
                try{
                    String Id=request.getParameter("Id");
                    String sql="select * from t_cliente where Id_Cliente=?";
                    ps= conn.prepareStatement(sql);
                    ps.setString(1, Id);
                    rs= ps.executeQuery();
                    Cliente client=new Cliente();
                    while(rs.next()){
                        client.setId(rs.getString("Id_Cliente"));
                        client.setApellidos(rs.getString("Apellidos"));
                        client.setNombres(rs.getString("Nombres"));
                        client.setDNI(rs.getString("DNI"));
                        client.setDireccion(rs.getString("Direccion"));
                        client.setTelefono(rs.getString("Telefono"));
                        client.setMovil(rs.getString("Movil"));
                        Lista.add(client);
                    }
                    request.setAttribute("Lista", Lista);
                    request.getRequestDispatcher("modificar.jsp").forward(request, response);
                }catch(SQLException ex){
                    System.out.println("Error de SQL..."+ex.getMessage());
                } finally{
                    conBD.disconnect();
                }                 
                
                break;
            case "Eliminar":
                try{
                    String Id=request.getParameter("Id");
                    String sql="delete from t_cliente where Id_Cliente=?";
                    ps= conn.prepareStatement(sql);
                    ps.setString(1, Id);
                    ps.executeUpdate();
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }catch(SQLException ex){
                    System.out.println("Error de SQL..."+ex.getMessage());
                } finally{
                    conBD.disconnect();
                }                          
                break;
            case "Nuevo":
                request.getRequestDispatcher("nuevo.jsp").forward(request, response);
                break;
        }*/
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        response.setCharacterEncoding("UTF-8");
        String vUsuario = request.getParameter("txtUsuario");
        String vClave = request.getParameter("txtClave");
        String vPaswd="";
        String vUser="";
        ConexionBD conBD = new ConexionBD();
        Connection conn = conBD.connected();
        PreparedStatement ps;
        ResultSet rs; 
            try{
                    String sql="select * from t_usuario where IdUsuario=?";
                    ps= conn.prepareStatement(sql);
                    ps.setString(1, vUsuario);                    
                    rs= ps.executeQuery();
                    while(rs.next()){
                        vUser = rs.getString(1);
                        vPaswd=rs.getString(2);
                    }
                    
                    if(vUser.equals(vUsuario) && vPaswd.equals(vClave)){
                        //Respuesta(response,"Acceso Válido");
                        //HttpSession varSesion1 = request.getSession();
                        //varSesion1.setAttribute("SessionUser",vUsuario);
                        response.sendRedirect("index.jsp");
                    }else{
                        Respuesta(response,"Acceso no Válido");
                        //response.sendRedirect("index.jsp");
                    }
                    //request.getRequestDispatcher("listar.jsp").forward(request, response);
                }catch(SQLException ex){
                    System.out.println("Error de SQL..."+ex.getMessage());
                } finally{
                    conBD.disconnect();
                }        

      /*  String Id =request.getParameter("Id");       
        String Apellidos=request.getParameter("apellidos"); 
        String Nombres=request.getParameter("nombres"); 
        String DNI=request.getParameter("DNI");
        String Direccion=request.getParameter("direccion"); 
        String Telefono=request.getParameter("telefono"); 
        String Movil=request.getParameter("movil"); 
        Cliente client=new Cliente();
        
        client.setId(Id);
        client.setApellidos(Apellidos);
        client.setNombres(Nombres);
        client.setDNI(DNI);
        client.setDireccion(Direccion);
        client.setTelefono(Telefono);
        client.setMovil(Movil);     
        
        ConexionBD conBD = new ConexionBD();
        Connection conn = conBD.connected();
        PreparedStatement ps;
        ResultSet rs;        
        if(Id.isEmpty()){
            String sql="insert into t_cliente(Id_Cliente, apellidos, nombres, DNI, direccion, telefono, movil) values(?, ?, ?, ?, ?, ?, ?)";

            try{*/
                /*Algoritmo para autogeneral el código*/
               /* String Id_Cliente="C00016";
                ps= conn.prepareStatement(sql);
                ps.setString(1, Id_Cliente);
                ps.setString(2, client.getApellidos());
                ps.setString(3, client.getNombres());
                ps.setString(4, client.getDNI());
                ps.setString(5, client.getDireccion());
                ps.setString(6, client.getTelefono());
                ps.setString(7, client.getMovil());
                
                ps.executeUpdate(); 
            }catch(SQLException ex){
                System.out.println("Error actualizando tabla..."+ex.getMessage());
            } finally{
                conBD.disconnect();
            }               
        }else{
            String sql="update t_cliente set apellidos=?, nombres=?, DNI=?, direccion=?, telefono=?, movil=? where Id_Cliente=?";

            try{
                ps= conn.prepareStatement(sql);
                ps.setString(1, client.getApellidos());
                ps.setString(2, client.getNombres());
                ps.setString(3, client.getDNI());
                ps.setString(4, client.getDireccion());
                ps.setString(5, client.getTelefono());
                ps.setString(6, client.getMovil());
                ps.setString(7, client.getId());
                ps.executeUpdate(); 
            }catch(SQLException ex){
                System.out.println("Error actualizando tabla..."+ex.getMessage());
            } finally{
                conBD.disconnect();
            }               
        }
        
  
        response.sendRedirect("index.jsp");*/
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    private void Respuesta(HttpServletResponse objRespuesta, String Mensaje)
    throws ServletException, IOException{
        objRespuesta.setContentType("text/html;charset=UTF-8");
        PrintWriter out= objRespuesta.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<t1>"+Mensaje+"</t1>");
        out.println("</body>");
        out.println("</html>");
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
