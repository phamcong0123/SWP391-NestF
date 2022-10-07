/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.voucher;

import com.nestf.vouchertype.VoucherTypeDTO;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class VoucherDTO implements Serializable{
    private int voucherID;
    private VoucherTypeDTO voucherType;
    private int customerPhone;
    private boolean status;
    private String expiredDate;

    public VoucherDTO(int voucherID, VoucherTypeDTO voucherType, int customerPhone, boolean status, String expiredDate) {
        this.voucherID = voucherID;
        this.voucherType = voucherType;
        this.customerPhone = customerPhone;
        this.status = status;
        this.expiredDate = expiredDate;
    }

    public int getVoucherID() {
        return voucherID;
    }

    public VoucherTypeDTO getVoucherType() {
        return voucherType;
    }

    public int getCustomerPhone() {
        return customerPhone;
    }

    public boolean isStatus() {
        return status;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setVoucherID(int voucherID) {
        this.voucherID = voucherID;
    }

    public void setVoucherType(VoucherTypeDTO voucherType) {
        this.voucherType = voucherType;
    }

    public void setCustomerPhone(int customerPhone) {
        this.customerPhone = customerPhone;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    
    
}
