/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.health.data;

/**
 *
 * @author HP
 */

import com.health.helper.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
    import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author HP
 */
public class Admin 
{
    Connection con;
    private String adminname;
    private String adminid;
    private String pass;
    private ArrayList <Doctor> doctors_List;
    private ArrayList <Pharmacist> pharmacists_List;
    private ArrayList <Patient> patients_List;
    public Admin() throws ClassNotFoundException, SQLException
    {
         con=ConnectionProvider.getConnection();
       get_Patient_From_Database();
       get_Pharmacist_From_Database();
       get_Doctor_From_Database();
    }
     public void remove_Doctor(int obj_No)
    {
         if(doctors_List.isEmpty())
         {
             
         }
         else
             doctors_List.remove(obj_No);
    }
     public Doctor AssignDoc()
     {
        Random rand= new Random();
        int y= rand.nextInt(doctors_List.size());
        return doctors_List.get(y);
     }
    public void add_Doctor(Doctor d)
    {
      if(doctors_List.isEmpty())
      {
                 doctors_List=new ArrayList<>();
                 doctors_List.add(d);
       }
     else
          doctors_List.add(d);
     
    }
     public void add_Pharmacist(Pharmacist a)
    {
      if(pharmacists_List.isEmpty())
      {
                 pharmacists_List=new ArrayList<>();
                 pharmacists_List.add(a);
       }
     else
          pharmacists_List.add(a);
     
      
    }
      public void remove_Pharmacist(int obj_No)
    {
         if(pharmacists_List.isEmpty())
         {
             
         }
         else
             pharmacists_List.remove(obj_No);
    }
    public void remove_Patient(int obj_No)
    {
         if(patients_List.isEmpty())
         {
             
         }
         else
             patients_List.remove(obj_No);
    }
    public Admin(String adminname,String adminid,String pass,Connection con) throws SQLException, ClassNotFoundException
    {
        this.adminname=adminname;
        this.adminid=adminid;
        this.pass=pass;
        this.con=con;
       get_Patient_From_Database();
       get_Pharmacist_From_Database();
       get_Doctor_From_Database();
        
    }
    
    public Doctor getFreeDoctor()
    {
        Random rand= new Random();
        return doctors_List.get(rand.nextInt(doctors_List.size()));
    }
    public void get_Patient_From_Database() throws SQLException, ClassNotFoundException
    {
        
        try
        {   
           
           String query="Select * from Users where urole="+1;
           
           PreparedStatement pstmt=this.con.prepareStatement(query);
           
          
           patients_List=new ArrayList<>();
           ResultSet set=pstmt.executeQuery();
           while(set.next())
           {
             
                String name1=set.getString("username");
                String userid1=set.getString("userid");
                String pass1=set.getString("pass");
                int urole1=set.getInt("urole");
                Connection con=ConnectionProvider.getConnection();
                Patient a=new Patient(name1,userid1,pass1,con,urole1);
                patients_List.add(a);
      
           }
        }
            catch(SQLException e)
        {
            e.printStackTrace();
        }
        System.out.println("hey");       
    }
    public void get_Pharmacist_From_Database() throws ClassNotFoundException 
    {
         try
        {   
           
           String query="Select * from Users where urole="+3;
           
           PreparedStatement pstmt=this.con.prepareStatement(query);
           
          
           pharmacists_List=new ArrayList<>();
           ResultSet set=pstmt.executeQuery();
           while(set.next())
           {
             
                String name1=set.getString("username");
                String userid1=set.getString("userid");
                String pass1=set.getString("pass");
                int urole1=set.getInt("urole");
                Connection con=ConnectionProvider.getConnection();
                Pharmacist a=new Pharmacist(name1,userid1,pass1,con,urole1);
               pharmacists_List.add(a);
      
           }
        }
             catch(SQLException e)
        {
            e.printStackTrace();
        }
         
         
    }
    public void get_Doctor_From_Database() throws ClassNotFoundException
    {
        try
        {   
           
           String query="Select * from Users where urole="+2;
           
           PreparedStatement pstmt=this.con.prepareStatement(query);
           
          
           doctors_List=new ArrayList<>();
           ResultSet set=pstmt.executeQuery();
           while(set.next())
           {
             
                String name1=set.getString("username");
                String userid1=set.getString("userid");
                String pass1=set.getString("pass");
                int urole1=set.getInt("urole");
                Connection con=ConnectionProvider.getConnection();
                Doctor a=new Doctor(name1,userid1,pass1,con,urole1);
               doctors_List.add(a);
      
           }
        }
             catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getAdminid() {
        return adminid;
    }

    public void setAdminid(String adminid) {
        this.adminid = adminid;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public ArrayList<Doctor> getDoctors_List() {
        return doctors_List;
    }

    public void setDoctors_List(ArrayList<Doctor> doctors_List) {
        this.doctors_List = doctors_List;
    }

    public ArrayList<Pharmacist> getPharmacists_List() {
        return pharmacists_List;
    }

    public void setPharmacists_List(ArrayList<Pharmacist> pharmacists_List) {
        this.pharmacists_List = pharmacists_List;
    }

    public ArrayList<Patient> getPatients_List() {
        return patients_List;
    }

    public void setPatients_List(ArrayList<Patient> patients_List) {
        this.patients_List = patients_List;
    }

    
    
    
    
}

    

