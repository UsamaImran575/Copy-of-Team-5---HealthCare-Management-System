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
import java.util.ArrayList;
 
import java.util.ArrayList;

import java.sql.SQLException;

/**
/**
 *
 * @author HP
 */
public class ENT extends Doctor 
{
    String specilization;
    private ArrayList<Disease> cureable;
    
    public String get_Specializtion()
    {
        return specilization;
    }
    public ENT()throws SQLException, ClassNotFoundException
    {
        specilization="ENT";
        
    }
    public ENT(String username,String uid ,String password ,Connection con ,int role)throws SQLException, ClassNotFoundException
    {
         super(username,uid ,password ,con ,role);
         specilization="ENT";
    }
    public ArrayList<Disease> getCureable() {
        return cureable;
    }

    public void setCureable(ArrayList<Disease> cureable) {
        this.cureable = cureable;
    }
    
}
