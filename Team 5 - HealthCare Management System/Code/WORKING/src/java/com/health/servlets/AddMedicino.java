/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.health.servlets;

import com.health.data.Medicine;
import com.health.data.Pharmacist;
import com.health.helper.ConnectionProvider;
//import static com.oracle.webservices.api.databinding.DatabindingModeFeature.ID;
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
public class AddMedicino extends HttpServlet {

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
            out.println("<title>Servlet AddMedicino</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddMedicino at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            HttpSession session=request.getSession();
            Pharmacist p=(Pharmacist)session.getAttribute("currentUser");
            String mname= request.getParameter("name");
            String Price = request.getParameter("price");
            int price= Integer.parseInt(Price);
            String dis1 = request.getParameter("Treat1");
            float dos1 = Float.parseFloat(request.getParameter("Dos1"));
            int time1 = Integer.parseInt(request.getParameter("Times1"));
            int dura1= Integer.parseInt(request.getParameter("Dora1"));
            int minage1 = Integer.parseInt(request.getParameter("minage1"));
            int maxage1 = Integer.parseInt(request.getParameter("maxage1"));
            
            Connection con= ConnectionProvider.getConnection();
            int r=0;
             try
                {   
                       
                        String query="insert into medicine (name,price) values (?,?)";                        
                        PreparedStatement pstmt=con.prepareStatement(query);
                        pstmt.setString(1, mname);
                        pstmt.setInt(2, price);
                        r=pstmt.executeUpdate();
                        
            
                }
                         catch(SQLException e)
                {
                          e.printStackTrace();
                }
              int MID=0;
              int DID=0;
                if (r==0)
                {
                    out.println("<h3>Medicine not added<h3>");
                    RequestDispatcher rd=request.getRequestDispatcher("addmedicine.jsp");
                    rd.include(request, response);
                }
               
                else if (r>0)
                {
                    try {
                String query= "select ID from Medicine where name='"+ mname+ "'" ;
                PreparedStatement pstmt=con.prepareStatement(query);
                ResultSet set= pstmt.executeQuery();
                
                if (set.next())
                {
                    MID= set.getInt("ID");
                }
            }
            catch (SQLException e){
                e.printStackTrace();
            }
                     try {
                String query= "select ID from   Disease  where name='"+ dis1+ "'" ;
                PreparedStatement pstmt=con.prepareStatement(query);
                ResultSet set= pstmt.executeQuery();
                
                if (set.next())
                {
                    DID= set.getInt("ID");
                }
                else 
                {
                    try{
                        query= "insert into disease (name) values (?)";
                        pstmt= con.prepareStatement(query);
                        pstmt.setString(1,dis1);
                        pstmt.executeUpdate();
                    }
                    catch (SQLException e)
                    {
                        e.printStackTrace();
                    }
                    try{
                        query= "select ID from disease where name='"+ dis1+ "'";
                        pstmt= con.prepareStatement(query);
                        set=pstmt.executeQuery();
                        
                        if (set.next())
                        {
                            DID= set.getInt("ID");
                        }
                    }
                    catch (SQLException e)
                    {
                        e.printStackTrace();
                    }
                    
                }
            }
            catch (SQLException e){
                e.printStackTrace();
            }
                    String query= "insert into treatableDiseaseByMedicine (medID,diseaseID,dosage,times,duration,minage,maxage) values (?,?,?,?,?,?,?)";
                    PreparedStatement pstmt= con.prepareStatement(query);
                    pstmt.setInt(1, MID);
                    pstmt.setInt(2,DID);
                    pstmt.setFloat(3,dos1);
                    pstmt.setInt(4,time1);
                    pstmt.setInt(5,dura1);
                    pstmt.setInt(6,minage1);
                    pstmt.setInt(7,maxage1);
                    pstmt.executeUpdate();
                    Medicine temp= new Medicine(MID,mname,price);
                    p.addTDP(temp);
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
            Logger.getLogger(AddMedicino.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddMedicino.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddMedicino.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddMedicino.class.getName()).log(Level.SEVERE, null, ex);
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
