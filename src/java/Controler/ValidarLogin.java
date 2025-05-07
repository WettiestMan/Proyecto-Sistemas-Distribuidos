/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Entidades.Usuarios;
import io.github.cdimascio.dotenv.Dotenv;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import at.favre.lib.crypto.bcrypt.BCrypt;
import java.util.Objects;
/**
 *
 * @author javie
 */
@WebServlet(name = "ValidarLogin", urlPatterns = {"/ValidarLogin"})
public class ValidarLogin extends HttpServlet {
    
    private static final Dotenv env;
    
    static {
        env = Dotenv.configure().load();
    }

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
       
       String correctUser = env.get("PAGE_USER", ""); // admin
       String correctPassword = env.get("PAGE_PASS_HASH", ""); // 1234
       
       if (correctUser.isEmpty() || correctPassword.isEmpty()) {
           throw new RuntimeException("No hay un usuario y contraseña de administrador registrados para iniciar sesión.");
       }
       
       boolean ok = Objects.equals(user, correctUser)
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
