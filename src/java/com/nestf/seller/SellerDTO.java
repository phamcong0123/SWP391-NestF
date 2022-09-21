/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.seller;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class SellerDTO implements Serializable{
    private int sellerID;
    private String password;
    private int name;
    private int phone;
    private boolean isAdmin;
    
}
