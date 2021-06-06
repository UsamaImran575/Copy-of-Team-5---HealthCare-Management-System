/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.health.helper;
import java.sql.*;

/**
 *
 * @author HP
 */
public class ConnectionProvider {
    private static Connection con;
  
    /**
     *
     * @return
     * @throws java.lang.ClassNotFoundException
     */
    public static Connection getConnection() throws ClassNotFoundException
    {   
        
        
        
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try
        {   
            if(con==null)
            {
             con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=finalproj;;user=sa;password=123456789");
            }
           
                  
        }
        catch(SQLException E)
         {   
                   
                           
                    E.printStackTrace();
         }
        
        
       return con;
       
    }
    
}
