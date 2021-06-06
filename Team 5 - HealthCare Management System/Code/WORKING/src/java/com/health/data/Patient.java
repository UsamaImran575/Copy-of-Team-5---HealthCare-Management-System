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

import java.util.ArrayList;
import com.health.helper.*;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author HP
 */
public class Patient extends User {
    private ArrayList<History> history_Of_Disease ;
    private Doctor assigned_Doctor;
    private Pharmacist assigned_pharmacist;
    private Disease current_Disease;
    private ArrayList<Symptom> my_Symptoms;
    private ArrayList<Medicine> current_Medicicines;
    private Doctor specialist;
    public void askPharmacist() 
    {
        current_Medicicines= assigned_pharmacist.suggest_Medicine( current_Disease);
    }
    public ArrayList<History> get_History()
    {
       return history_Of_Disease;
    }

    public void askDoctor(ArrayList<Symptom>f) throws ClassNotFoundException
    {
        current_Disease = assigned_Doctor.checkDisease(f);
    }
    public Patient() throws SQLException, ClassNotFoundException
    {
        assigned_Doctor=new Doctor();
        assigned_pharmacist=new Pharmacist();
        this.get_MY_History_Of_Disease() ;
    }
    public Patient(String name,String uid,String Pass ,Connection con,int role) throws SQLException, ClassNotFoundException
    {
       
        super(name,uid,Pass,con,role);
        assigned_Doctor=new Doctor();
        this.get_MY_History_Of_Disease() ;
        assigned_pharmacist=new Pharmacist();
        
    }
    public void AskForDoc() throws ClassNotFoundException, SQLException
    {
            Admin temp= new Admin();
            assigned_Doctor = temp.AssignDoc();
    }
    public String GetAssignDocName() throws ClassNotFoundException, SQLException
    {
        return assigned_Doctor.getName();
    }

    public ArrayList<Medicine> getCurrent_Medicicines() {
        return current_Medicicines;
    }
    

    public void setCurrent_Medicicines(ArrayList<Medicine> current_Medicicines) {
        this.current_Medicicines = current_Medicicines;
    }
    
    public void updateHistory(String name ,String uid  ) throws ClassNotFoundException, SQLException
    {   
        
       Date a=new Date();
       SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        String date=sdf.format(a);
    //   history_Of_Disease.add(new History(name,date));
       //now update datbase
       //fist find id of user and id of disease from database
       int diseaseid=0;
       int userbackid=0;
        try
        {   Connection con=ConnectionProvider.getConnection();
           
            String query="Select ID from users where userid='"+uid+"'";
           PreparedStatement pstmt=con.prepareStatement(query);
          
        
           ResultSet set=pstmt.executeQuery();
           if(set.next())
           {
            userbackid=set.getInt("ID");
           }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        try
        {   Connection con=ConnectionProvider.getConnection();
           
            String query="Select ID from Disease where name='"+name+"'";
           PreparedStatement pstmt=con.prepareStatement(query);
          
        
           ResultSet set=pstmt.executeQuery();
           if(set.next())
           {
            diseaseid=set.getInt("ID");
           }
        }
         catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        try
        {   Connection con=ConnectionProvider.getConnection();
           String query="insert  into patientDiseases (patientid,diseaseid,diagnosedate)values(?,?,?)";
           PreparedStatement pstmt=con.prepareStatement(query);
           pstmt.setInt(1,userbackid );
           pstmt.setInt(2, diseaseid);
           
           pstmt.setString(3, date);
      
         int ab= pstmt.executeUpdate(); 
         if(ab>0)
         {
               history_Of_Disease.add(new History(name,date));
         }
           
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
      
    }
    public void get_MY_History_Of_Disease() throws ClassNotFoundException, SQLException
    
    {
           
        try
        {   Connection con=ConnectionProvider.getConnection();
           
            String query="select name ,diagnosedate from patientDiseases join Users on patientDiseases.patientid=Users.ID "
                          + "join Disease on patientDiseases.diseaseid=Disease.ID\n" +
                                "where USERs.userid='"+ this.getUid() + "'" ;;
           PreparedStatement pstmt=con.prepareStatement(query);
           history_Of_Disease =new ArrayList<>();
        
           ResultSet set=pstmt.executeQuery();
           while(set.next())
           {
            History a=new History(set.getString("name"),set.getString("diagnosedate"));
             history_Of_Disease.add(a);
           }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
      
    }

 

    public Doctor getAssigned_Doctor() {
        return assigned_Doctor;
    }

    public void setAssigned_Doctor(Doctor assigned_Doctor) {
        this.assigned_Doctor = assigned_Doctor;
    }

    public Pharmacist getAssigned_pharmacist() {
        return assigned_pharmacist;
    }

    public void setAssigned_pharmacist(Pharmacist assigned_pharmacist) {
        this.assigned_pharmacist = assigned_pharmacist;
    }

    public Disease getCurrent_Disease() {
        return current_Disease;
    }

    public void setCurrent_Disease(Disease current_Disease) {
        this.current_Disease = current_Disease;
    }

    public ArrayList<Symptom> getMy_Symptoms() {
        return my_Symptoms;
    }

    public void setMy_Symptoms(ArrayList<Symptom> my_Symptoms) {
        this.my_Symptoms = my_Symptoms;
    }
    
    
}
