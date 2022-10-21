/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.bill;

import com.nestf.product.ProductDTO;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class BillDTO implements Serializable {

    private int billID;
    private String cusPhone;
    private String address;
    private int sellerID;
    private int statusID;
    private Date time;
    private double total;
    ProductDTO p;

    public BillDTO() {
    }

    public BillDTO(int billID, String cusPhone, String address, int sellerID, int statusID, Date time, double total, ProductDTO p) {
        this.billID = billID;
        this.cusPhone = cusPhone;
        this.address = address;
        this.sellerID = sellerID;
        this.statusID = statusID;
        this.time = time;
        this.total = total;
        this.p = p;
    }

    public BillDTO(int billID, String cusPhone, String address, int sellerID, int statusID, Date time, double total) {
        this.billID = billID;
        this.cusPhone = cusPhone;
        this.address = address;
        this.sellerID = sellerID;
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

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSellerID() {
        return sellerID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
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

    public ProductDTO getP() {
        return p;
    }

    public void setP(ProductDTO p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return "BillDTO{" + "billID=" + billID + ", customerPhone=" + cusPhone + ", address=" + address + ", sellerID=" + sellerID + ", statusID=" + statusID + ", time=" + time + ", total=" + total + ", p=" + p + '}';
    }

   
}
