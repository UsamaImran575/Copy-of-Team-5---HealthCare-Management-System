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
/**
 *
 * @author HP
 */
public class Doctor extends User {
   

    private ArrayList<Disease> list_Disease;
    private String speciality;
    private float rating;
    Connection con;
    
    public Doctor() throws SQLException, ClassNotFoundException
    {
         con=ConnectionProvider.getConnection();
        //getting disease from database
       
                      
                        try
                        {
                            String query2="Select name ,id from Disease";
                            list_Disease=new ArrayList<>();
                            PreparedStatement pstmt1=this.con.prepareStatement(query2);
                            ResultSet  set=pstmt1.executeQuery();
                            while(set.next())
                            {
                              String name1=set.getString("name");
                              int id1=set.getInt("id");
                              Disease a=new Disease();
                              a.setnamedatabase(id1, name1);
                              list_Disease.add(a);
                            }
                        }
                        catch(SQLException e)
                        {
                             e.printStackTrace();
                        }
           
                
           
       
        
    
    }
    public Doctor(String name,String uid,String Pass ,Connection con,int role) throws ClassNotFoundException
    {
        super(name,uid,Pass,con,role);
        this.con=con;
        //getting disease from database
       
                      
                        try
                        {
                            String query2="Select name ,id from Disease";
                            list_Disease=new ArrayList<>();
                            PreparedStatement pstmt1=con.prepareStatement(query2);
                            ResultSet  set=pstmt1.executeQuery();
                            while(set.next())
                            {
                              String name1=set.getString("name");
                              int id1=set.getInt("id");
                              Disease a=new Disease();
                              a.setnamedatabase(id1, name1);
                              list_Disease.add(a);
                            }
                        }
                        catch(SQLException e)
                        {
                             e.printStackTrace();
                        }
                       
        
    }
    
    public ArrayList<String> get_Review()
    {
        int RID=0;
        ArrayList<String> reviews= new ArrayList();
        try {
                String query= "select ID from users where userid='"+ this.getUid()+ "'" ;
                PreparedStatement pstmt=con.prepareStatement(query);
                ResultSet set= pstmt.executeQuery();
                
                if (set.next())
                {
                    RID= set.getInt("ID");
                }
            }
            catch (SQLException e){
                e.printStackTrace();
    }
        try{
            String query= "select docdescription from Rating where doctorID="+ RID;
            PreparedStatement pstmt=con.prepareStatement(query);
            ResultSet set= pstmt.executeQuery();
            
            while (set.next())
            {
                reviews.add(set.getString("docdescription"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return reviews;
    }
    public String get_Specializtion()
    {
        int RID=0;
        String spec="";
        try {
                String query= "select ID from users where userid='"+ this.getUid()+ "'" ;
                PreparedStatement pstmt=con.prepareStatement(query);
                ResultSet set= pstmt.executeQuery();
                
                if (set.next())
                {
                    RID= set.getInt("ID");
                }
            }
            catch (SQLException e){
                e.printStackTrace();
    }
        try {
            String query= "select Specializtion_in from Specialist where doctorID=" + RID;
            PreparedStatement pstmt= con.prepareStatement(query);
            ResultSet set= pstmt.executeQuery();
            if (set.next())
            {
               spec= set.getString("specializtion_in");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return spec;
    }
    
    
    public ArrayList<Disease> getList_Disease() {
        return list_Disease;
    }

    public void setList_Disease(ArrayList<Disease> list_Disease) {
        this.list_Disease = list_Disease;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }


   public float getRate_Value() throws ClassNotFoundException
   {
       float TRate=0;
       float TCount=0;
       float FinalRating=0;
       Connection con= ConnectionProvider.getConnection();
       String ID=this.getUid();
       int RID=0;
            try {
                String query= "select ID from users where userid='"+ ID+ "'" ;
                PreparedStatement pstmt=con.prepareStatement(query);
                ResultSet set= pstmt.executeQuery();
                
                if (set.next())
                {
                    RID= set.getInt("ID");
                }
            }
            catch (SQLException e){
                e.printStackTrace();
            }
            
            try
            {
                
                String query= "select rating from Rating where doctorID="+ RID;
                PreparedStatement pstmt= con.prepareStatement(query);
                ResultSet set= pstmt.executeQuery();
                
                while (set.next())
                {
                    TRate+= set.getInt("rating");
                    TCount++;
                }
                if (TCount!=0)
                {
                    FinalRating= TRate/TCount;
                }
             }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            return FinalRating;
   }
    
     public void remove_Disease(int obj_No)
    {
         if(list_Disease.isEmpty())
         {
             
         }
         else
             list_Disease.remove(obj_No);
    }
     
    public Disease checkDisease(ArrayList<Symptom>a) throws ClassNotFoundException
    {
        ArrayList<diseasecount> ab=new ArrayList<>();
     for (int i=0;i<list_Disease.size();i++)
     {
         int c=list_Disease.get(i).compare_Symptoms(a);
         diseasecount q=new diseasecount();
         q.setType(list_Disease.get(i));
         q.setCount(c);
         ab.add(q);
     }
      int count=0;
      Disease found=new Disease();
     for(int i=0;i<ab.size();i++)
     {
         
         if(i==0)
         {
            count=ab.get(i).getCount();
            found=ab.get(i).getType();
         }
         else
         {
             if(ab.get(i).getCount()>count)
             {
              count = ab.get(i).getCount();
              found=ab.get(i).getType();
             }
             
         }
     }
     return found;
    }

      
 
    
    
    
}
