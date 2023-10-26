/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlet.tany;

import com.dto.PersonDTO;
import com.module.tany.TanyLocal;
import dto.bank.AccountDTO;
import dto.tany.TanyDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cartel
 */
public class TanyServlet extends HttpServlet {
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
    
    // Ito no angalana azy
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String cin = request.getParameter("cin");

        try {
        //        1 - Maka personne avy amin'ny C#
            PersonDTO personne = this.tanyEJB.getPersonne(cin);
            // System.out.println(" Info personne :::  " + personne.getFirstName() );
        //        2 - Maka ny information ana banque indray ( EJB Remote )
            AccountDTO account = this.tanyEJB.getBank(cin);
        //        3 - Alaina ny Tanin'ilay olona
            Vector<TanyDTO> tanys = this.tanyEJB.getTany(cin);
        //        Okey azoko daholo ny données ilaiko rehetra
        // Alefa any amin'ny affichage izy zao
        // Ndao ary ehhh
            request.setAttribute("personne", personne);
            request.setAttribute("compte", account);
            request.setAttribute("tany", tanys);

            request.getRequestDispatcher("information.jsp").forward(request, response);

        } catch(Exception e) {
            e.printStackTrace();
            out.print( e.getMessage() );
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
        // 1 - Alefa any amin'ny C# aloha ny cin an'ilay olona
        // 2 - Tonga any amin'ny C# ilay Cin, de alaina ny Information an'ilay olona
        // 3 - Alaina ny information ana santé ( C# )
        // 4 - Alaina indray avy eo ny banque ( EJB banque - remote )
        // 5 - Alaina indray avy eo ny resaka tany ( EJB tany - locale )
        // 6 - Alefa any amin'ny affichage de apoitra ilay izy
        // Atreo aloha no vitaina
        
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
