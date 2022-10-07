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
    private Long saleMargin;
    private int quantity;
    private int point;

    public VoucherTypeDTO() {
    }

    public VoucherTypeDTO(int typeID, String voucherName, Long saleMargin, int quantity, int point) {
        this.typeID = typeID;
        this.voucherName = voucherName;
        this.saleMargin = saleMargin;
        this.quantity = quantity;
        this.point = point;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public void setVoucherName(String voucherName) {
        this.voucherName = voucherName;
    }

    public void setSaleMargin(Long saleMargin) {
        this.saleMargin = saleMargin;
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

    public Long getSaleMargin() {
        return saleMargin;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPoint() {
        return point;
    }

    
    
}
