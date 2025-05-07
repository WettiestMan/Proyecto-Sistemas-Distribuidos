/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Entidades.DetallePedido;
import Entidades.Pedido;
import conexion.ConexionBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author javie
 */
@WebServlet(name = "ControlerPedido", urlPatterns = {"/ControlerPedido"})
public class ControlerPedido extends HttpServlet {

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
            out.println("<title>Servlet ControlerPedido</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControlerPedido at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        
        String Op =request.getParameter("Op");
        ArrayList<Pedido> Lista= new ArrayList<Pedido>();
        ArrayList<DetallePedido> ListaDet= new ArrayList<DetallePedido>();
        ConexionBD conBD = new ConexionBD();
        Connection conn = conBD.connected();
        PreparedStatement ps;
        ResultSet rs;
        switch(Op){
            case "Listar":
                try{
                    String sql="SELECT Id_Pedido, A.Id_Cliente, B.Apellidos, B.Nombres, A.Fecha,"+
                               "A.SubTotal, A.TotalVenta FROM t_pedido A inner join t_cliente B on A.Id_Cliente=B.Id_Cliente";
                    //String sql="SELECT * FROM t_pedido";
                    ps= conn.prepareStatement(sql);
                    rs= ps.executeQuery();
                    while(rs.next()){
                        Pedido Pedido=new Pedido();
                        Pedido.setId_Pedido(rs.getString(1));
                        Pedido.setId_Cliente(rs.getString(2));
                        Pedido.setApellidos(rs.getString(3));
                        Pedido.setNombres(rs.getString(4));
                        Pedido.setFecha(rs.getDate(5));
                        Pedido.setSubTotal(rs.getDouble(6));
                        Pedido.setTotalVenta(rs.getDouble(7));
                        Lista.add(Pedido);
                    }
                    request.setAttribute("Lista", Lista);
                    request.getRequestDispatcher("listarPedido.jsp").forward(request, response);
                }catch(SQLException ex){
                    System.out.println("Error de SQL..."+ex.getMessage());
                }finally{
                    conBD.disconnect();
                }
                break;
            case "Consultar":
                 try{
                    String Id=request.getParameter("Id");
                    String sql="SELECT Id_Pedido,A.Id_Prod,Descripcion,A.Cantidad, A.Precio, TotalDeta "+
                            "FROM t_detalle_pedido A inner join t_producto B on A.Id_Prod=B.Id_Prod "+
                            "WHERE Id_Pedido=?";
                    ps= conn.prepareStatement(sql);
                    ps.setString(1, Id);
                    rs= ps.executeQuery();
                    DetallePedido DetaPed=new DetallePedido();
                    while(rs.next()){
                        DetaPed.setId_Pedido(rs.getString(1));
                        DetaPed.setId_Prod(rs.getString(2));
                        DetaPed.setDescripcion(rs.getString(3));
                        DetaPed.setCantidad(rs.getDouble(4));
                        DetaPed.setPrecio(rs.getDouble(5));
                        DetaPed.setTotalDeta(rs.getDouble(6));
                        ListaDet.add(DetaPed);
                    }
                    request.setAttribute("Lista", ListaDet);
                    request.getRequestDispatcher("consultarPedido.jsp").forward(request, response);
                }catch(SQLException ex){
                    System.out.println("Error de SQL..."+ex.getMessage());
                } finally{
                    conBD.disconnect();
                }                
                break;                   

            case "Eliminar":
                
            case "Nuevo":
                request.getRequestDispatcher("nuevoPedido.jsp").forward(request, response);
                break;
        }      
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
