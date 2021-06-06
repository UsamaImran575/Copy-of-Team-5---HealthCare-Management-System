/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.health.servlets;

import com.health.data.Disease;
import com.health.data.Doctor;
import com.health.data.Symptom;
import com.health.helper.ConnectionProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class AddDisease extends HttpServlet {

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
            out.println("<title>Servlet AddDisease</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
            String dname= request.getParameter("dname");
            String Symptom1 = request.getParameter("Symptom1");
            String Symptom2 = request.getParameter("Symptom2");
            String Symptom3 = request.getParameter("Symptom3");
            String Symptom4 = request.getParameter("Symptom4");
            String Symptom5 = request.getParameter("Symptom5");
            String Symptom6 = request.getParameter("Symptom6");
            String Symptom7 = request.getParameter("Symptom7");
            String Constraint1 = request.getParameter("Constraint1");
            String Constraint2 = request.getParameter("Constraint2");
            String Constraint3 = request.getParameter("Constraint3");
            String Constraint4 = request.getParameter("Constraint4");
            String Constraint5 = request.getParameter("Constraint5");
            String Constraint6 = request.getParameter("Constraint6");
            String Constraint7 = request.getParameter("Constraint7");
            ///hhhhhhaahhhh
            ArrayList<String> sym = new ArrayList();
                                sym.add(Symptom1);
                                sym.add(Symptom2);
                                if(Symptom3 != "")
                                {
                                    sym.add(Symptom3);
                                }
                                if(Symptom4 != "")
                                {
                                    sym.add(Symptom4);
                                }
                                if(Symptom5 != "")
                                {
                                    sym.add(Symptom5);
                                }
                                if(Symptom6 != "")
                                {
                                    sym.add(Symptom6);
                                }
                                if(Symptom7 != "")
                                {
                                    sym.add(Symptom7);
                                }
                                 ArrayList<String> cons=new ArrayList();
                                cons.add(Constraint1);
                                if(Constraint2 != "")
                                {
                                    cons.add(Constraint2);
                                }
                                if(Constraint3 != "")
                                {
                                    cons.add(Constraint3);
                                }
                                if(Constraint4 != "")
                                {
                                   cons.add(Constraint4);
                                }
                                if(Constraint5 != "")
                                {
                                   cons.add(Constraint5);
                                }
                                if(Constraint6 != "")
                                {
                                    cons.add(Constraint6);
                                }
                                if(Constraint7 != "")
                                {
                                   cons.add(Constraint7);
                                }
            ////ahhhhggahhh
             ArrayList <String> constraintsD;
             int countcon=0;
             int countsym=0;
             int countnewsym=0;
              int did=0;
              int sid=0;
            ArrayList <Symptom> my_SymptomsD;
            RequestDispatcher rd2=request.getRequestDispatcher("addDisease.jsp");
            HttpSession s=request.getSession();
            Doctor D= (Doctor)s.getAttribute("currentUser");
            Connection con=ConnectionProvider.getConnection();
            int v=0;
            for(int ii=0 ; ii<D.getList_Disease().size();ii++)
            {
                      String sss1=new String (dname);
                       String ssss1= new String(D.getList_Disease().get(ii).get_Name());
                
               if( sss1.equals(ssss1))
               {
                   v=1;
               }
       
                
            }
            if (v==1)
            {
                //disease exit
                 out.println("<h1>Disease already  EXIST </h1>");
                 rd2.include(request, response);
            }
            else
            {  
                
               //insert Disease in data base and take the id of that disease
                try
                     {
                            String query="insert into Disease (name)values(?)";
                            PreparedStatement pstmt=con.prepareStatement(query);
                            pstmt.setString(1, dname);
                            pstmt.executeUpdate();
                            try
                            {
                            String query1="Select ID from Disease where name='"+dname+"'";
                            PreparedStatement pstmt1=con.prepareStatement(query1);
                            ResultSet set=pstmt1.executeQuery();
                            set.next();
                            did=set.getInt("ID");
                            }
                            catch(SQLException e)
                            {
                              out.println("<h1>Disease ID  jaha hu rahe hyn waha masla hy</h1>");
                              rd2.include(request, response);
                              e.printStackTrace();
                      
                             }
                     }
                     catch(SQLException e)
                     {
                           rd2.include(request, response);
                           e.printStackTrace();
                      
                     }
                
              
               // take out all symptoms from data base
               my_SymptomsD=new ArrayList<>();
              
               try
                    {
                              String query2=" select name from symptoms ";
                              PreparedStatement pstmt=con.prepareStatement(query2);
                               countsym=0;
                               ResultSet set=pstmt.executeQuery();
                               while(set.next())
                                 {
                                   String name1=set.getString("name");
                                   my_SymptomsD.add(new Symptom(name1));
                                   countsym++;
                                   
                                  }
                             
                    }
                catch(SQLException e)
                   {
                        e.printStackTrace();
                        
                   }
               //matching and inserting data in Symptoms
               int j=0;
             
               ArrayList<Integer> a=new ArrayList();
               for (int i=0; i<sym.size(); i++)
               {
                   j=0;
                   while(j<my_SymptomsD.size() && i<sym.size())
                   {
                       String sss=new String (sym.get(i));
                       String ssss= new String(my_SymptomsD.get(j).getNames());
                        if ( sss.equals(ssss))
                        {
                            try
                            {
                            String query1="Select ID from symptoms where name='"+sym.get(i)+"'";
                            PreparedStatement pstmt1=con.prepareStatement(query1);
                            ResultSet set=pstmt1.executeQuery();
                            set.next();
                            sid=set.getInt("ID");
                            a.add(sid);
                            }
                            catch(SQLException e)
                             {
                             out.println("<h1>symptoms ID jaha hu rahe hyn waha masla hy</h1>");
                             rd2.include(request, response);
                             e.printStackTrace();
                             }
                            i++;
                            j=0;
                            
                        }
                        else if(sss != ssss)
                        {
                            j++;
                        }
                   }
                   if(j>=my_SymptomsD.size())
                   {
                       try
                     {
                            String query="insert into symptoms (name)values(?)";
                            PreparedStatement pstmt=con.prepareStatement(query);
                            pstmt.setString(1,sym.get(i));
                            pstmt.executeUpdate();
                            countnewsym++;
                            try
                            {
                            String query1="Select ID from symptoms where name='"+sym.get(i)+"'";
                            PreparedStatement pstmt1=con.prepareStatement(query1);
                            ResultSet set=pstmt1.executeQuery();
                            set.next();
                            sid=set.getInt("ID");
                            a.add(sid);
                            }
                            catch(SQLException e)
                             {
                             out.println("<h1>symptoms ID jaha hu rahe hyn waha masla hy</h1>");
                             rd2.include(request, response);
                             e.printStackTrace();
                             }
                     }
                     catch(SQLException e)
                     {
                             out.println("<h1>symptoms insert jaha hu rahe hyn waha masla hy</h1>");
                           
                             rd2.include(request, response);
                             e.printStackTrace();
                     }
                       
                   }
               }
                            // ADDing data in contraint of Diseases 
               for(int i=0 ; i<cons.size();  i++)
               {
                try
                     {
                            String query="insert into constraintOfDisease (foodName,diseaseID) values(?,?)";
                            PreparedStatement pstmt=con.prepareStatement(query);
                            pstmt.setString(1,cons.get(i));
                            pstmt.setInt(2, did);
                            pstmt.executeUpdate();
                         
                     }
                     catch(SQLException e)
                     {
                           out.println("<h1>constraintOfDisease insert jaha hu rahe hyn waha masla hy</h1>");
                           rd2.include(request, response);
                           e.printStackTrace();
                     }
               }
               //insert into symptomsofDisease
int bb=0;
               for(int i=0 ;i<a.size(); i++)
               {
                try
                     {
                            String query="insert into  symptomsOfDisease(diseaseID,symptomID) values(?,?)";
                            PreparedStatement pstmt=con.prepareStatement(query);
                            pstmt.setInt(1, did);
                            bb=a.get(i);
                            pstmt.setInt(2,bb);
                            pstmt.executeUpdate();
                         
                     }
                     catch(SQLException E)
                     {
                         
                      out.println("<h1>symptomsOfDisease insert jaha hu rahe hyn waha masla hy</h1>");
                      rd2.include(request, response);
                      E.printStackTrace();
                       
                     }
               }
                
               
                  ArrayList<Disease> list_Disease1=D.getList_Disease();
                   try
                        {
                            
                            String query2="Select name ,id from Disease";
                            list_Disease1=new ArrayList<>();
                            PreparedStatement pstmt1=con.prepareStatement(query2);
                            ResultSet  set=pstmt1.executeQuery();
                            while(set.next())
                            {
                              String name1=set.getString("name");
                              int id1=set.getInt("id");
                              Disease nd=new Disease();
                              nd.setnamedatabase(id1, name1);
                              list_Disease1.add(nd);
                            }
                        }
                        catch(SQLException e)
                        {
                             e.printStackTrace();
                        }
             
               D.setList_Disease(list_Disease1);
                out.println("<h1>Disease Added successfully</h1>");
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
            Logger.getLogger(AddDisease.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddDisease.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddDisease.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddDisease.class.getName()).log(Level.SEVERE, null, ex);
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
