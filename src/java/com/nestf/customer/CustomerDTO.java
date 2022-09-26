/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.customer;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class CustomerDTO implements Serializable{
    private int customerPhone;
    private String password;
    private String customerName;
    private String customerAddress;
    private boolean gender;
    private int point;

    public CustomerDTO() {
    }

    public CustomerDTO(int customerPhone, String password, String customerName, String customerAddress, boolean gender, int point) {
        this.customerPhone = customerPhone;
        this.password = password;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.gender = gender;
        this.point = point;
    }

    public int getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(int customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" + "customerPhone=" + customerPhone + ", password=" + password + ", customerName=" + customerName + ", customerAddress=" + customerAddress + ", gender=" + gender + ", point=" + point + '}';
    }

    
}
