/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.health.servlets;


import com.health.helper.ConnectionProvider;
import com.health.data.User;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
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
public class RegisterServelet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     *
     * 
     */
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            System.out.println("hidsafasgsd");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServelet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");
            String uname= request.getParameter("username");
            String uid= request.getParameter("userid");
            String psw= request.getParameter("psw");
            int urole=Integer.parseInt( request.getParameter("urole"));
                 
        
           User a=new User();
           a.setName(uname);
           a.setUid(uid);
           a.setPass(psw);
           a.setRole(urole);
           a.setConnection(ConnectionProvider.getConnection());
           
            RequestDispatcher rd2=request.getRequestDispatcher("login.jsp");
             
            if(a.saveUser(a))
            {   
                
                  out.println("<h1>Registered Successfully</h1>");
                  rd2.include(request, response);
                  
            }
            else
            {
               
                 out.println("<h1>Registration Failed UserID Already Exists</h1>");
                 RequestDispatcher rd=request.getRequestDispatcher("signup.jsp");
                rd.include(request, response);
                
            }
            /*
       String userID=request.getParameter("userID");
            String pass=request.getParameter("pass");
            User a=new User("32","432","432");
            a.setConnection(ConnectionProvider.getConnection());
           
            RequestDispatcher rd2=request.getRequestDispatcher("login.jsp");
             User u=a.Login(userID, pass);
            if(u==null)
            {   
                
                  out.println("<h1>User not Found</h1>");
                  rd2.include(request, response);
                  
            }
             else
            {
                 HttpSession s=request.getSession();
                s.setAttribute("currentUser", u);
                
                
                 RequestDispatcher rd=request.getRequestDispatcher("about.jsp");
                rd.forward(request, response);
            }
            */
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
            Logger.getLogger(RegisterServelet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RegisterServelet.class.getName()).log(Level.SEVERE, null, ex);
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
