/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.billdetail;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class BillDetailDTO implements Serializable{
    private int billDetailID;
    private int billID;
    private int productID;
    private float price;
    private int quantity;
    private double total; // sql bigint

    
}
