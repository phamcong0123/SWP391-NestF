/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.vouchertype;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class VoucherTypeDTO implements Serializable{
    
    private int typeID;
    private String voucherName;
    private double saleMargin;// bigint in sql?
    private int quantity;
    private int point;
}
