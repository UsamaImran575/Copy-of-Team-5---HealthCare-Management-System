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
import com.health.helper.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
      
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Pharmacist extends User{
    ArrayList <Medicine> my_Medicines;
    Connection con;
    public ArrayList<Medicine> suggest_Medicine(Disease d)
    {
        ArrayList<Medicine> med=new ArrayList<>();
        for(int i=0;i<my_Medicines.size();i++)
        {
            if(my_Medicines.get(i).compare_Disease(d))
            {
                med.add(my_Medicines.get(i));
            }
        }
        return med;
    }
    public Pharmacist() throws ClassNotFoundException 
    {
        
        this.pharmacist_database();
    }
    public Pharmacist(String name,String uid,String Pass ,Connection con,int role) throws ClassNotFoundException
    {
        super(name,uid,Pass,con,role);
        this.pharmacist_database();
        
    }
     public void remove_Medicine(int obj_No)
    {
         if(my_Medicines.isEmpty())
         {
             
         }
         else
             my_Medicines.remove(obj_No);
    }
     
    public void printmedicines() 
    {
        
        for(int i=0;i<my_Medicines.size();i++)
        {
            my_Medicines.get(i).print();
        }
        
    }
    public void pharmacist_database() throws ClassNotFoundException
    {
        con=ConnectionProvider.getConnection();
        //getting disease from database
       
                      
                        try
                        {
                              String query2="Select * from Medicine";
                              my_Medicines=new ArrayList<>();

                            PreparedStatement pstmt1=this.con.prepareStatement(query2);
                            ResultSet  set=pstmt1.executeQuery();
                            while(set.next())
                            {
                                
                              String name1=set.getString("name");
                              int id1=set.getInt("id");
                              int price=set.getInt("price");
                              Medicine a=new Medicine();
                              a.setId(id1);
                              a.setName(name1);
                              a.setPrice(price);
                              a.set_Treatable_By_Database();
                              my_Medicines.add(a);
                              
                            }
                        }
                        catch(SQLException e)
                        {
                             e.printStackTrace();
                        }
           
    }
    

    public ArrayList<Medicine> getMy_Medicines() {
        return my_Medicines;
    }
    
    public void addTDP(Medicine m)
    {
        my_Medicines.add(m);
    }

    public void setMy_Medicines(ArrayList<Medicine> my_Medicines) {
        this.my_Medicines = my_Medicines;
    }

   
   
    
}
