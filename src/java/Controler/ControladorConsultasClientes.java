/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controler;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Controler.consultas.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 *
 * @author santi
 */
@WebServlet(name = "ConsultarCliente", urlPatterns = {"/ConsultarCliente"})
public class ControladorConsultasClientes extends HttpServlet {
    private final static String RUC_TOKEN;
    private final static String DNI_TOKEN;
    
    static {
        final Dotenv environment = Dotenv.configure().load();
        RUC_TOKEN = environment.get("RUC_COM_TOKEN");
        DNI_TOKEN = environment.get("API_DNI_TOKEN");
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
        /*response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code.
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorConsultasClientes</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorConsultasClientes at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    /*@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }*/

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
        final StringBuilder jsonbuf = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonbuf.append(line);
            }
        }
        
        final String respJson = jsonbuf.toString();
        
        final ObjectMapper om = new ObjectMapper();
        try {
            final Consulta consulta = om.readValue(respJson, Consulta.class);
            HttpClient cliente = HttpClient.newHttpClient();
            switch (consulta.getTipo()) {
                case "ruc":
                    HttpRequest reqRuc = HttpRequest.newBuilder()
                            .uri(new URI("https://ruc.com.pe/api/v1/consultas"))
                            .header("Content-Type", "application/json")
                            .POST(HttpRequest.BodyPublishers.ofString(
                                    String.format(
                                            "{ \"token\": \"%s\", \"ruc\": \"%s\" }"
                                            , RUC_TOKEN, consulta.getVal())
                            ))
                            .build();
                    
                    HttpResponse<String> respRuc = cliente.send(reqRuc, HttpResponse.BodyHandlers.ofString());
                    
                    response.setStatus(respRuc.statusCode());
                    response.setContentType("application/json; charset=utf-8");
                    PrintWriter wrRuc = response.getWriter();
                    wrRuc.print(respRuc.body());
                    wrRuc.flush();
                    break;

                case "dni":
                    HttpRequest req = HttpRequest.newBuilder()
                            .uri(new URI("https://api.apis.net.pe/v2/reniec/dni?numero=" + consulta.getVal()))
                            .header("Content-Type", "application/json")
                            .header("Authorization", "Bearer " + DNI_TOKEN)
                            .GET()
                            .build();
                    
                    HttpResponse<String> resp = cliente.send(req, HttpResponse.BodyHandlers.ofString());
                    
                    response.setStatus(resp.statusCode());
                    response.setContentType("application/json; charset=utf-8");
                    PrintWriter wr = response.getWriter();
                    wr.print(resp.body());
                    wr.flush();
                    break;
            }
        } catch (Exception e) {
            response.setStatus(500);
            PrintWriter wrt = response.getWriter();
            wrt.print("Error del servidor: " + e.getMessage());
            wrt.flush();
        }
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
