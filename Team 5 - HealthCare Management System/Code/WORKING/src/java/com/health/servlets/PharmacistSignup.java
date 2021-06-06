/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.health.servlets;

import com.health.data.Admin;
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
 * @author HP
 */
public class PharmacistSignup extends HttpServlet {

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
            out.println("<title>Servlet PharmacistSignup</title>");            
            out.println("</head>");
            out.println("<body>");
           
            out.println("</body>");
            out.println("</html>");
            out.println("</br>");
            String uname= request.getParameter("username");
            String uid= request.getParameter("userid");
            String psw= request.getParameter("psw");
            Connection con;
           
            con=ConnectionProvider.getConnection();
            int urole=Integer.parseInt( request.getParameter("urole"));
            int r=0;
             try
                {   
                       
                        String query="insert into users (username,userid,pass,urole)values(?,?,?,?)";
                        PreparedStatement pstmt=con.prepareStatement(query);
                        pstmt.setString(1, uname);
                        pstmt.setString(2, uid);
                        pstmt.setString(3, psw);
                        pstmt.setInt(4, urole);
                        r= pstmt.executeUpdate();
                      
            
                }
                         catch(SQLException e)
                {
                          e.printStackTrace();
                }
              RequestDispatcher rd2=request.getRequestDispatcher("AddPharmacist.jsp");
                if(r>0)
                {
                        HttpSession session=request.getSession();
                        Admin ab=(Admin) session.getAttribute("currentUser");
                        Pharmacist a=new Pharmacist(uname,uid,psw,con,urole);
                        ab.add_Pharmacist(a);
                         
                         out.println("<h1>Registered Successfully</h1>");
                         rd2.include(request, response);
                }
                if(r==0)
                {
                    out.println("<h1>Pharmacist not Registered User id already exists</h1>");
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
            Logger.getLogger(PharmacistSignup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PharmacistSignup.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PharmacistSignup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PharmacistSignup.class.getName()).log(Level.SEVERE, null, ex);
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
