/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Entidades.RolUsuario;
import Entidades.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import at.favre.lib.crypto.bcrypt.BCrypt;
import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
/**
 *
 * @author javie
 */
@WebServlet(name = "ValidarLogin", urlPatterns = {"/ValidarLogin"})
public class ValidarLogin extends HttpServlet {

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
       
       String user, pass;
       user = request.getParameter("txtUsuario");
       pass = request.getParameter("txtClave");
       
       ConexionBD dbhandle = new ConexionBD();
       Connection conn = dbhandle.connected();
       if (conn == null) {
           response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
           request.setAttribute("msg", "Error al iniciar sesión");
           request.getRequestDispatcher("500.jsp").forward(request, response);
           return;
       }
       
       PreparedStatement ps = null;
       ResultSet rs = null;
       
       try {
           final String sql = "SELECT * FROM t_usuario WHERE IdUsuario=?";
           ps = conn.prepareStatement(sql);
           ps.setString(1, user);
           rs = ps.executeQuery();
           
           if (rs.next() == false)
               request.getRequestDispatcher("ErrorLogin").forward(request, response);
           else {
               final String userId = rs.getString("IdUsuario");
               final String passHash = rs.getString("Passwd");
               final RolUsuario role = RolUsuario.valueOf(rs.getString("rol"));
               if (BCrypt.verifyer(BCrypt.Version.VERSION_2A)
                       .verify(pass.toCharArray(), passHash).verified) {
                   Usuarios nuser = new Usuarios(userId, passHash.toCharArray(), role);
                   HttpSession session = request.getSession();
                   session.setAttribute("user", nuser);
                   //request.getRequestDispatcher("index.jsp").forward(request, response);
                   response.sendRedirect("index.jsp");
               }
               else {
                   request.getRequestDispatcher("ErrorLogin").forward(request, response);
               }
           }
           
       } catch (SQLException e) {
           response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
           request.setAttribute("msg", "Error al iniciar sesión");
           request.getRequestDispatcher("500.jsp").forward(request, response);
       } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("No se pudo cerrar el PreparedStatement o el ResultSet"
                        + e.getMessage());
            }
            
            dbhandle.disconnect();
       }
       
       /*boolean ok = Objects.equals(user, correctUser)
               && BCrypt.verifyer().verify(pass.toCharArray(), correctPassword.toCharArray()).verified;
       
       if (ok) {
           String passHash = BCrypt.with(BCrypt.Version.VERSION_2A).hashToString(12, pass.toCharArray());
           Usuarios nuser=new Usuarios(user, passHash);
           HttpSession session = request.getSession();
           session.setAttribute("user", nuser);
           request.getRequestDispatcher("index.jsp").forward(request, response);
       }
       else{
           request.getRequestDispatcher("ErrorLogin").forward(request, response);
       }*/
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
