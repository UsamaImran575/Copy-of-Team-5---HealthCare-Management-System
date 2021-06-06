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
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Medicine{
    private int id;
    private String name;
    private int price;
    private ArrayList<Disease> treatable_Diseases;
private Connection con;

public Medicine()
{
    
}
public Medicine(int id,String name,int price)
{       
    this.id=id;
    this.name=name;
    this.price=price;    
}

public void addTD(Disease d)
{
    if (!treatable_Diseases.contains(d))
    {
        treatable_Diseases.add(d);
    }
}

public void print()     
{
    System.out.println(name);
    System.out.println(price);
    System.out.println("Its Treatable Diseases are");
    for(int i=0;i<treatable_Diseases.size();i++)
    {
        treatable_Diseases.get(i).printing11();
    }
}   
 public boolean compare_Disease(Disease d)
 {
     for (int i=0;i<treatable_Diseases.size();i++)
     {
         if(treatable_Diseases.get(i).get_Name().equalsIgnoreCase(d.get_Name()))
         {
             
             return true;
         }
     }
     return false;
 }
    public void set_Treatable_By_Database() throws ClassNotFoundException, SQLException
    {
        con=ConnectionProvider.getConnection();
        //getting disease from database
       
                      
                        try
                        {
                              String query2="select name ,id from treatableDiseaseByMedicine inner join Disease on "
                                      + "treatableDiseaseByMedicine.diseaseID=Disease.ID  "
                                      + "where medID="+id;
                               treatable_Diseases=new ArrayList<>();

                            PreparedStatement pstmt1=this.con.prepareStatement(query2);
                            ResultSet  set=pstmt1.executeQuery();
                            while(set.next())
                            {
                              String name1=set.getString("name");
                              int id1=set.getInt("id");
                              Disease a=new Disease();
                              a.setnamedatabase(id1, name1);
                              treatable_Diseases.add(a);
                            }
                        }
                        catch(SQLException e)
                        {
                             e.printStackTrace();
                        }
           
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<Disease> getTreatable_Diseases() {
        return treatable_Diseases;
    }

    public void setTreatable_Diseases(ArrayList<Disease> treatable_Diseases) {
        this.treatable_Diseases = treatable_Diseases;
    }
    
}
