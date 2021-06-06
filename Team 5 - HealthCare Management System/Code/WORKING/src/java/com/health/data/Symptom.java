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
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Symptom { 
       
    private String name;
    void print()
    {
        System.out.println(name);
       
    }
  public   Symptom(String name)
    {
        this.name=name;
    }
  public   Symptom()
    {
        
    }
    public String getNames() {
        return name;
    }

    public void setNames(String name) {
        this.name = name;
    }
    public ArrayList<String> get_All_symptoms () throws ClassNotFoundException, SQLException
    {
        Connection con;
        con= ConnectionProvider.getConnection();
        ArrayList<String>k=new ArrayList<String>();
         try
        {   
            Statement aa;
            String query="Select  * from symptoms";
            PreparedStatement pstmt=con.prepareStatement(query);
          
            ResultSet set = pstmt.executeQuery();
            while (set.next())
            {
                k.add(set.getString(2));
            }
          
             return k;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
       
         return k;
      
         
    }
    
    
}
