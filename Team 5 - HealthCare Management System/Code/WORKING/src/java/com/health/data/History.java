/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.health.data;

import sun.util.calendar.BaseCalendar.Date;

/**
 *
 * @author HP
 */
public class History 
{
    private String name;
    private String date;
    
    public History(String name,String date)
    {   
        this.name=name;
        this.date=date;
        
    }
    public String getName()
    {
        return name;
    }
    public String getDate()
    {
        return date;
    }
    
}
