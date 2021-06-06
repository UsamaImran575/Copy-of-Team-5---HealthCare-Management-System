/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.health.servlets;

import com.health.data.Admin;
import com.health.data.Dental;
import com.health.data.Dermatologist;

import com.health.data.Doctor;
import com.health.data.ENT;

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
 * @author HP
 */
public class DoctorSignup extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
                   
            out.println("</head>");
            out.println("<body>");
            
            out.println("</body>");
            out.println("</html>");
            String uname= request.getParameter("username");
            String uid= request.getParameter("userid");
            String psw= request.getParameter("psw");
            Connection con;
           
            con=ConnectionProvider.getConnection();
            int urole=Integer.parseInt( request.getParameter("urole"));
            String specializtion= request.getParameter("fruit");
            Doctor a;
            a=new Doctor();
            if(specializtion.equalsIgnoreCase("Derm"))
            {
                a=new Dermatologist(uname,uid,psw,con,urole);
            }
            if(specializtion.equalsIgnoreCase("ENT"))
            {
             a=new ENT(uname,uid,psw,con,urole);  ;   
            }
            if(specializtion.equalsIgnoreCase("Den"))
            {
              a=new Dental(uname,uid,psw,con,urole);     
            }
                 boolean f=false;
      
                try
                {   
                       
                        String query="insert into users (username,userid,pass,urole)values(?,?,?,?)";
                        PreparedStatement pstmt=con.prepareStatement(query);
                        pstmt.setString(1, a.getName());
                        pstmt.setString(2, a.getUid());
                        pstmt.setString(3, a.getPass());
                        pstmt.setInt(4, a.getRole());
                        pstmt.executeUpdate();
                        f=true;
            
                }
                         catch(SQLException e)
                {
                          e.printStackTrace();
                }
                int id=0;
                 if (f==true)
                {
                        try
                        {   
                       
                            String query="Select ID from users where userid='"+a.getUid()+"'";
                            PreparedStatement pstmt=con.prepareStatement(query);
                            ResultSet set=pstmt.executeQuery();
                            if(set.next())
                            {
             
                                     id=set.getInt("ID");
                               
           
                            }
            
                        }   
                         catch(SQLException e)
                        {
                             e.printStackTrace();
                        }
                }
                 RequestDispatcher rd2=request.getRequestDispatcher("AddDoctor.jsp");
                  if(f==true)
                {
                    
                        try
                        {   
                       
                            String query="insert into Specialist (doctorID, Specializtion_in)values(?,?)";
                            PreparedStatement pstmt=con.prepareStatement(query);
                            pstmt.setString(2, a.get_Specializtion());
                            pstmt.setInt(1, id);
                            pstmt.executeUpdate();
                            f=true;
            
                        }
                        catch(SQLException e)
                        {
                            e.printStackTrace();
                        }
                        HttpSession session=request.getSession();
                        Admin ab=(Admin) session.getAttribute("currentUser");
                         ab.add_Doctor(a);
                         
                         out.println("<h1>Registered Successfully</h1>");
                         rd2.include(request, response);
                }
                  else
                  {
                       out.println("<h1>Registration Failed DoctorID Already Exist</h1>");
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
        } catch (SQLException ex) {
            Logger.getLogger(DoctorSignup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoctorSignup.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DoctorSignup.class.getName()).log(Level.SEVERE, null, ex);
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
