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
    private int quantity;
    private double price;
    private double total;

    public BillDetailDTO() {
    }

    public BillDetailDTO(int billDetailID, int billID, int productID, int quantity, double price, double total) {
        this.billDetailID = billDetailID;
        this.billID = billID;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
    }

    public int getBillDetailID() {
        return billDetailID;
    }

    public void setBillDetailID(int billDetailID) {
        this.billDetailID = billDetailID;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "BillDetailDTO{" + "billDetailID=" + billDetailID + ", billID=" + billID + ", productID=" + productID + ", quantity=" + quantity + ", price=" + price + ", total=" + total + '}';
    }

}
