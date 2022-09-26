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
    private double saleMargin;
    private int quantity;
    private int point;

    public VoucherTypeDTO() {
    }

    public VoucherTypeDTO(int typeID, String voucherName, double saleMargin, int quantity, int point) {
        this.typeID = typeID;
        this.voucherName = voucherName;
        this.saleMargin = saleMargin;
        this.quantity = quantity;
        this.point = point;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getVoucherName() {
        return voucherName;
    }

    public void setVoucherName(String voucherName) {
        this.voucherName = voucherName;
    }

    public double getSaleMargin() {
        return saleMargin;
    }

    public void setSaleMargin(double saleMargin) {
        this.saleMargin = saleMargin;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "VoucherTypeDTO{" + "typeID=" + typeID + ", voucherName=" + voucherName + ", saleMargin=" + saleMargin + ", quantity=" + quantity + ", point=" + point + '}';
    }
    
}
