/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.health.data;

import com.health.helper.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.util.Pair;

/**
 *
 * @author HP
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Disease {
    private Connection con;
    private String name;
    private ArrayList <String> constraints;
    private ArrayList <Symptom> my_Symptoms;
    public void printing11()
    {   
        System.out.println("Name of Diseaase");
        System.out.println(name);
                System.out.println("Its constraints are");
        for(int i=0;i<constraints.size();i++)
        {
            System.out.println(constraints.get(i));
        }
        System.out.println("Its symptoms are ");
        for(int i=0;i<my_Symptoms.size();i++)
        {
            my_Symptoms.get(i).print();
        }
        
    }
    public Disease() throws ClassNotFoundException
    {
         con=ConnectionProvider.getConnection();
    }
    public String get_Name()
    {
        return name;
    }
    public void setnamedatabase(int id ,String name)
    {
        this.name=name;
         try
        {   
          
           String query=" select foodName from constraintOfDisease where diseaseID="+id;
           PreparedStatement pstmt=this.con.prepareStatement(query);
         
           ResultSet set=pstmt.executeQuery();
           constraints=new ArrayList<>();
           while(set.next())
           {
                

                constraints.add(set.getString("foodName"));
           }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
          
                my_Symptoms=new ArrayList<>();
              
               try
                        {
                              String query2="select symptoms.name from symptomsOfDisease "
                                      + "inner join symptoms on symptomsOfDisease.symptomID=symptoms.ID inner join Disease"
                                      + " ON symptomsOfDisease.diseaseID=Disease.ID where Disease.ID="+id;
                              PreparedStatement pstmt=this.con.prepareStatement(query2);
         
                             ResultSet set=pstmt.executeQuery();
                              while(set.next())
                              {
                              String name1=set.getString("name");
                              my_Symptoms.add(new Symptom(name1));
                              }
                             
                        }
                        catch(SQLException e)
                        {
                             e.printStackTrace();
                        }
           
                
           
        
       
    }
    public ArrayList<String> getConstraints() {
        return constraints;
    }

    public void setConstraints(ArrayList<String> constraints) {
        this.constraints = constraints;
    }

    public ArrayList<Symptom> getMy_Symptoms() {
        return my_Symptoms;
    }

    public void setMy_Symptoms(ArrayList<Symptom> my_Symptoms) {
        this.my_Symptoms = my_Symptoms;
    }
 public  int compare_Symptoms(ArrayList<Symptom>a)
         
    {
        int count=0;
        int size=a.size();
        for(int i=0;i<size;i++)
        {
            String k=a.get(i).getNames();
            int size1=my_Symptoms.size();
            for(int j=0;j<size1;j++)
            {
                if(k.equalsIgnoreCase(my_Symptoms.get(j).getNames()))
                {
                    count++;
                }
                
            }
        }
        return count;
    }
}

