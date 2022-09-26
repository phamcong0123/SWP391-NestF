/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.cart;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class CartDTO implements Serializable{
    private int cartID;
    private int customerPhone;
    private int productID;
    private int amount;

    public CartDTO() {
    }

    public CartDTO(int cartID, int customerPhone, int productID, int amount) {
        this.cartID = cartID;
        this.customerPhone = customerPhone;
        this.productID = productID;
        this.amount = amount;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(int customerPhone) {
        this.customerPhone = customerPhone;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CartDTO{" + "cartID=" + cartID + ", customerPhone=" + customerPhone + ", productID=" + productID + ", amount=" + amount + '}';
    }
    
    
}
