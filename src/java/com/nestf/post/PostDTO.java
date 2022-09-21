/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.post;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class PostDTO implements Serializable{
    
    private int postID;
    private int sellerID;
    private String title;
    private Date dateTime;
    private boolean status; //? bit in sql
    private String filePath;
    
    
}
