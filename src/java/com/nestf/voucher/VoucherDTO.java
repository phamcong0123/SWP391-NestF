/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.voucher;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class VoucherDTO implements Serializable{
    private int voucherID;
    private int typeID;
    private int customerPhone;
    private boolean status;
    private Date expriredDate;

    public VoucherDTO() {
    }

    public VoucherDTO(int voucherID, int typeID, int customerPhone, boolean status, Date expriredDate) {
        this.voucherID = voucherID;
        this.typeID = typeID;
        this.customerPhone = customerPhone;
        this.status = status;
        this.expriredDate = expriredDate;
    }

    public int getVoucherID() {
        return voucherID;
    }

    public void setVoucherID(int voucherID) {
        this.voucherID = voucherID;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public int getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(int customerPhone) {
        this.customerPhone = customerPhone;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getExpriredDate() {
        return expriredDate;
    }

    public void setExpriredDate(Date expriredDate) {
        this.expriredDate = expriredDate;
    }

    @Override
    public String toString() {
        return "VoucherDTO{" + "voucherID=" + voucherID + ", typeID=" + typeID + ", customerPhone=" + customerPhone + ", status=" + status + ", expriredDate=" + expriredDate + '}';
    }
    
}
