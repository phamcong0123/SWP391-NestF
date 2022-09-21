/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.bill;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author DELL
 */
public class BillDTO implements Serializable{
    private int billID;
    private int customerPhone;
    private String sellerID;
    private String address;
    private int statusID;
    private Date time;
    private double total; // sql bigint
    
}
