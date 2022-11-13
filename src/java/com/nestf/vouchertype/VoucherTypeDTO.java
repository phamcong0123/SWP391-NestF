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
    private Double saleValue;
    private int quantity;
    private int point;

    public VoucherTypeDTO() {
    }

    public VoucherTypeDTO(int typeID, String voucherName, Double saleValue, int quantity, int point) {
        this.typeID = typeID;
        this.voucherName = voucherName;
        this.saleValue = saleValue;
        this.quantity = quantity;
        this.point = point;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public void setVoucherName(String voucherName) {
        this.voucherName = voucherName;
    }

    public void setSaleMargin(Double saleValue) {
        this.saleValue = saleValue;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getTypeID() {
        return typeID;
    }

    public String getVoucherName() {
        return voucherName;
    }

    public Double getSaleMargin() {
        return saleValue;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPoint() {
        return point;
    }

    
    
}
