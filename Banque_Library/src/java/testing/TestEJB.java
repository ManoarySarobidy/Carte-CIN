/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package testing;

import com.module.banque.BanqueLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.module.tany.TanyEJBRemote;

/**
 *
 * @author Cartel
 */
public class TestEJB extends HttpServlet {
    
    @EJB
    private BanqueLocal banqueEjb;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            this.banqueEjb.getBankAccount("123456");
            this.callTanyRemotely();
        } finally {
            out.close();
        }
    }
    
    private void callTanyRemotely(){
        try{
            Properties props = new Properties();
            props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
            props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
            InitialContext context = new InitialContext(props);
            TanyEJBRemote remoted = (TanyEJBRemote) context.lookup("java:global/Tany_EJB_EAR/Tany_Module_EJB/TanyEJB!com.module.tany.TanyEJBRemote");        
            remoted.getTany("123456");
        }catch(Exception e){
            e.printStackTrace();
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
