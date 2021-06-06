/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.health.servlets;

import com.health.data.Doctor;
import com.health.data.Pharmacist;
import com.health.helper.ConnectionProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Adr3
 */
public class    MedicineRemovala extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DiseaseRemovala</title>");            
            out.println("</head>");
            out.println("<body>");
            
         
                
        int obj_No= Integer.parseInt(request.getParameter("objectNo")) ;
           String uname= request.getParameter("dname");
            int r=0;
              Connection con=ConnectionProvider.getConnection();
                try
                {   
                       
                        String query="delete from Medicine where name=?";
                        PreparedStatement pstmt=con.prepareStatement(query);
                        pstmt.setString(1, uname);
                        r=pstmt.executeUpdate();
                        
            
                }
                         catch(SQLException e)
                {
                          e.printStackTrace();
                }
                 RequestDispatcher rd2=request.getRequestDispatcher("removemedicine.jsp");
                if(r==0)
                {
                         out.println("<h1>Medicine not Removed</h1>");
                         rd2.include(request, response);

                }
                if (r>0)
                {
                        HttpSession s=request.getSession();
                       Pharmacist D= (Pharmacist)s.getAttribute("currentUser");
                        D.remove_Medicine(obj_No);
                         out.println("<h1>Medicine Removed Successfully</h1>");
                         rd2.include(request, response);
                         
                }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DiseaseRemovala.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DiseaseRemovala.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DiseaseRemovala.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DiseaseRemovala.class.getName()).log(Level.SEVERE, null, ex);
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
