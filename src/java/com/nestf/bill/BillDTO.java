/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.bill;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class BillDTO implements Serializable{
    private int billID;
    private int customerPhone;
    private int sellerID;
    private String address;
    private int statusID;
    private Date time;
    private double total;

    public BillDTO() {
    }

    public BillDTO(int billID, int customerPhone, int sellerID, String address, int statusID, Date time, double total) {
        this.billID = billID;
        this.customerPhone = customerPhone;
        this.sellerID = sellerID;
        this.address = address;
        this.statusID = statusID;
        this.time = time;
        this.total = total;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public int getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(int customerPhone) {
        this.customerPhone = customerPhone;
    }

    public int getSellerID() {
        return sellerID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "BillDTO{" + "billID=" + billID + ", customerPhone=" + customerPhone + ", sellerID=" + sellerID + ", address=" + address + ", statusID=" + statusID + ", time=" + time + ", total=" + total + '}';
    }
}
