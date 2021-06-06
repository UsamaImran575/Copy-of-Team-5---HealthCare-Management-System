/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.health.data;

/**
 *
 * @author Adr3
 */
public class Message {

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageBy() {
        return messageBy;
    }

    public void setMessageBy(String messageBy) {
        this.messageBy = messageBy;
    }
    String messageText;
    String messageBy;
    
    Message(String mt, String mb)
    {
        messageText=mt;
        messageBy=mb;
    }
}
