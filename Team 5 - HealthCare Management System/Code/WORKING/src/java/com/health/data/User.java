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
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author HP
 */
public class User 
{
    
   private String name;
   private String uid;
   private String Pass;
   private Connection con;
   private int role;
   public User() throws ClassNotFoundException
   {
   }
   public User(String name,String uid,String Pass ,Connection con,int role)
   {
    this.name=name;
    this.uid=uid;
    this.Pass=Pass;
    this.con=con;
    this.role=role;
   }

   
   public void setRole(int r)
   {
       this.role=r;
   }
   public int getRole()
   {
       return role;
   }
    public void setConnection(Connection con)
    {
        this.con=con;
    }
    
    public ArrayList<Message> getAllMessages() throws SQLException 
    {
        ArrayList<Message> ret= new ArrayList();
        try{
            String query= "Select * from chatbox";
            PreparedStatement pstmt= con.prepareStatement(query);
            ResultSet s=pstmt.executeQuery();
            
            while (s.next())
            {
               Message t= new Message(s.getString("messagetxt"),s.getString("messageBy"));
               ret.add(t);
            }
        }
            catch(SQLException e)
                    {
                    e.printStackTrace();
                    }
            return ret;
    }
   
   
  
    public User Login(String uid,String pass) throws ClassNotFoundException
    {
        User user=null;
        try
        {   
           Statement aa;
           String query="Select * from Users where userid=? and pass=?";
           
           PreparedStatement pstmt=this.con.prepareStatement(query);
           pstmt.setString(1, uid);
           pstmt.setString(2, pass);
          
        
           ResultSet set=pstmt.executeQuery();
           if(set.next())
           {
             user=new User();
           String name1=set.getString("username");
            String userid1=set.getString("userid");
           String pass1=set.getString("pass");
           int urole1=set.getInt("urole");
           user.setName(name1);
           user.setRole(urole1);
           user.setPass(pass1);
           user.setUid(userid1);
                   
           
           }
           
           
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return user;

    }

    public String getName() {
        return name;
    }

    public String getUid() {
        return uid;
    }

    public String getPass() {
        return Pass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }
   
     public boolean saveUser(User user)
    {   boolean f=false;
        try
        {   
             Statement aa;
            String query="insert into users (username,userid,pass,urole)values(?,?,?,?)";
           PreparedStatement pstmt=this.con.prepareStatement(query);
           pstmt.setString(1, user.getName());
           pstmt.setString(2, user.getUid());
           pstmt.setString(3, user.getPass());
           pstmt.setInt(4, user.getRole());
           pstmt.executeUpdate();
            f=true;
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return f;
    }
        
    
}

