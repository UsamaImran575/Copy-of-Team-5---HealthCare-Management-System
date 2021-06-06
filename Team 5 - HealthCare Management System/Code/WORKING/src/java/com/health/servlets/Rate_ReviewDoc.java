/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.health.servlets;

import com.health.data.Doctor;
import com.health.data.Patient;
import com.health.helper.ConnectionProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class Rate_ReviewDoc extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Rate_ReviewDoc</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Rate_ReviewDoc at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            HttpSession h= request.getSession();
            Connection con= ConnectionProvider.getConnection();
            Patient t= (Patient) h.getAttribute("currentUser");
            String rating= request.getParameter("rating");
            h.setAttribute("done", 1);
            int rate=Integer.parseInt(rating);
            Doctor temp= t.getAssigned_Doctor();
            String ID= temp.getUid();
             String descr= request.getParameter("comment");
            int RID=0;
            try {
                String query= "select ID from users where userid='"+ ID+ "'" ;
                PreparedStatement pstmt=con.prepareStatement(query);
                ResultSet set= pstmt.executeQuery();
                
                if (set.next())
                {
                    RID= set.getInt("ID");
                }
            }
            catch (SQLException e){
                e.printStackTrace();
            }
           
             try
             {  
           
           String query="insert into Rating(doctorID,rating,docdescription)values(?,?,?)";
           PreparedStatement pstmt=con.prepareStatement(query);
           pstmt.setInt(1, RID);
           pstmt.setInt(2, rate);
           pstmt.setString(3, descr);
           pstmt.executeUpdate();               
         
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
            
            RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);
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
            Logger.getLogger(Rate_ReviewDoc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Rate_ReviewDoc.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Rate_ReviewDoc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Rate_ReviewDoc.class.getName()).log(Level.SEVERE, null, ex);
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
