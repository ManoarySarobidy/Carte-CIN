/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlet.tany;

import com.module.tany.TanyLocal;
import dto.tany.Coordinate;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cartel
 */
@WebServlet(name = "BorneController", urlPatterns = {"/Borne"})
public class BorneController extends HttpServlet {
    @EJB
    private TanyLocal tanyEJB;
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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BorneController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BorneController at " + request.getContextPath() + "</h1>");
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
        // processRequest(request, response);
        // 1 - Alaina ny idTany
        int idTany = Integer.valueOf(request.getParameter("idTany"));
        // 2 - Alaina ny longitudes irery aloha
        String[] longitudes = request.getParameterValues("longitudes[]");
        String[] latitudes = request.getParameterValues("latitudes[]");
        // 3 - Avadika coordonées ireo zavatra ireo
        Coordinate[] coordinates = new Coordinate[ longitudes.length ];
        for( int i = 0; i < coordinates.length ; i++ ){
            coordinates[i] = new Coordinate( idTany, longitudes[i], latitudes[i] );
        }
        // 4 - Alefa any amin'ny EJB amin'izay ilay izy
        try{
            this.tanyEJB.ajouterBorne(coordinates);
            
        }catch( Exception e ){
            e.printStackTrace( response.getWriter() );
            throw new ServletException(e);
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
