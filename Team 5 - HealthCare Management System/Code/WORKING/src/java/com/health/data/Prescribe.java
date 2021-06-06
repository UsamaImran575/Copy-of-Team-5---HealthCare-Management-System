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


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author HP
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.health.helper.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.*;
/**
 *
 * @author HP
 */
public class Prescribe{
    int Dosage;
    int time;
    int Duration;
    
   public Prescribe(String disname ,int Medid,int age) throws ClassNotFoundException
    { 
        Connection a=ConnectionProvider.getConnection();
        try
        {   
           
            String query="select * from treatableDiseaseByMedicine join Disease On Disease.ID= treatableDiseaseByMedicine.diseaseID where Disease.name='"  +disname+ "'AND medID ="+Medid + " AND minage<"+ age+  " AND maxage>"+ age  ;
          
          PreparedStatement pstmt=a.prepareStatement(query);
          ResultSet set= pstmt.executeQuery();
          if(set.next())
          {
              Dosage=set.getInt("dosage");
              time=set.getInt("times");
              Duration=set.getInt("duration");
          }
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
    }
   
    public int getDosage() {
        return Dosage;
    }

    public void setDosage(int Dosage) {
        this.Dosage = Dosage;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int Duration) {
        this.Duration = Duration;
    }

   
    
}

