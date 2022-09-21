/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.voucher;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class VoucherDTO implements Serializable{
    private int voucherID;
    private int typeID;
    private int customerPhone;
    private boolean status; // bit in sql
    
}
