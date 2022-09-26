/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.seller;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class SellerDTO implements Serializable{
    private int sellerID;
    private String password;
    private String name;
    private int phone;
    private boolean isAdmin;

    public SellerDTO() {
    }

    public SellerDTO(int sellerID, String password, String name, int phone, boolean isAdmin) {
        this.sellerID = sellerID;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.isAdmin = isAdmin;
    }

    public int getSellerID() {
        return sellerID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "SellerDTO{" + "sellerID=" + sellerID + ", password=" + password + ", name=" + name + ", phone=" + phone + ", isAdmin=" + isAdmin + '}';
    }
    
}
