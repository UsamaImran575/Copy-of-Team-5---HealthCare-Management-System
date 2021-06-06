/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.health.servlets;

import com.health.data.Admin;
import com.health.data.Doctor;
import com.health.data.Patient;
import com.health.data.Pharmacist;
import com.health.data.User;
import com.health.helper.ConnectionProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
public class LoginServelet extends HttpServlet {

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
            out.println("<title>Servlet LoginServelet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<script>alert('aloo');</script>");

            out.println("</body>");
            out.println("</html>");
            String userID=request.getParameter("userID");
            String pass=request.getParameter("pass");
             Connection con=ConnectionProvider.getConnection();
            
            User t=new User();
            t.setConnection(ConnectionProvider.getConnection());
           
            RequestDispatcher rd2=request.getRequestDispatcher("login.jsp");
             User u=t.Login(userID, pass);
            if(u==null)
            {   
                  out.println("<h1>User not Found</h1>");
                  rd2.include(request, response);
                  
            }
             else
            {
                int g=u.getRole();
                 if(g==0)
                    
                {
                //it means it is admin

                    Admin a=new Admin(u.getName(),u.getUid(),u.getPass(),ConnectionProvider.getConnection());
                                 out.println("<script>alert('admin');</script>");
                    HttpSession s=request.getSession();
                    s.setAttribute("currentUser", a);
                
                
                    RequestDispatcher rd=request.getRequestDispatcher("Admin.jsp");
                    
     
                    rd.forward(request, response);
                
                }
                if(g==1)
                    
                {
                //it means it is patient
                    Patient p=new Patient(u.getName(),u.getUid(),u.getPass(),ConnectionProvider.getConnection(),u.getRole());
                    p.AskForDoc();
                    HttpSession s=request.getSession();
                   // p.AskForDoc();
                    s.setAttribute("currentUser", p);
                    s.setAttribute("done",0);
                    RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                
                }
                if(g==2)
                    
                {
                //it means it is doctor
                    Doctor d=new Doctor(u.getName(),u.getUid(),u.getPass(),ConnectionProvider.getConnection(),u.getRole());
                    HttpSession s=request.getSession();
                    s.setAttribute("currentUser", d);
                
                
                    RequestDispatcher rd=request.getRequestDispatcher("DoctorView.jsp");
                    rd.forward(request, response);
                
                }
                 if(g==3)
                    
                {
                //it means it is pharmacist
                   Pharmacist ph=new Pharmacist(u.getName(),u.getUid(),u.getPass(),ConnectionProvider.getConnection(),u.getRole());
                    HttpSession s=request.getSession();
                    s.setAttribute("currentUser", ph);
                
                
                    RequestDispatcher rd=request.getRequestDispatcher("Pharmacistview.jsp");
                    rd.forward(request, response);
                
                }
            
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
            Logger.getLogger(LoginServelet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServelet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LoginServelet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServelet.class.getName()).log(Level.SEVERE, null, ex);
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
