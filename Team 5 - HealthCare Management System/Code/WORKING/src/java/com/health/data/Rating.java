/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.health.data;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Rating {
    private float rate_Value ;
    private int rate_count;
    private ArrayList<String> Descriptions;
    
    Rating()
    {
        rate_Value=0;
        rate_count=0;
        Descriptions= new ArrayList();
    }

    public float getRate_Value() {
        return rate_Value;
    }
    public void incRC()
    {
        rate_count++;
    }
    
    public int getRC()
    {
        return rate_count;
    }

    public void setRate_Value(float latestRate) {
        incRC();
        this.rate_Value = (rate_Value+latestRate/rate_count);
        
    }
    public void addNewDesc(String abc)
    {
        Descriptions.add(abc);
    }
    

    public ArrayList<String> getDescription() {
        return Descriptions;
    }

    public void setDescription(ArrayList<String> Description) {
        this.Descriptions = Description;
    }
    
}
