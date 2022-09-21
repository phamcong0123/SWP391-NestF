/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.customer;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class CustomerDTO implements Serializable{
    private int customerPhone;
    private String password;
    private String customerName;
    private String customerAddress;
    private boolean gender;
    private int point;
    
}
