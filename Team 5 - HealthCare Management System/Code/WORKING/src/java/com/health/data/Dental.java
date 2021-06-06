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
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Dental extends Doctor{
      private ArrayList<Disease> cureable;
     private String specilization;
    public String get_Specializtion()
    {
        return specilization;
    }
    public Dental()throws SQLException, ClassNotFoundException
    {
        specilization="Dental";
          
    }
    public Dental(String username,String uid ,String password ,Connection con ,int role)throws SQLException, ClassNotFoundException
    {
         super(username,uid ,password ,con ,role);
         specilization="Dental";
    }
     
    
    public ArrayList<Disease> getCureable() {
        return cureable;
    }

    public void setCureable(ArrayList<Disease> cureable) {
        this.cureable = cureable;
    }
}
