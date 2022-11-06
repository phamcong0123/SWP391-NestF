/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.account;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class AccountDTO implements Serializable{
    private String phone;
    private String password;
    private String name;
    private String address;
    private boolean gender;
    private double point;
    private String role;
    private int selQuantity;

    public AccountDTO() {
    }

    public double getPoint() {
        return point;
    }

    public AccountDTO(String phone, String password, String name, String address, boolean gender, double point, String role) {
        this.phone = phone;
        this.password = password;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.point = point;
        this.role = role;
    }
    
    public AccountDTO(String phone, String password, String name, String address, boolean gender, double point, String role, int selQuantity) {
        this.phone = phone;
        this.password = password;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.point = point;
        this.role = role;
        this.selQuantity = selQuantity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    
    public void setPoint(double point) {
        this.point = point;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getSelQuantity() {
        return selQuantity;
    }

    public void setSelQuantity(int selQuantity) {
        this.selQuantity = selQuantity;
    }
    
    

    @Override
    public String toString() {
        return "AccountDTO{" + "phone=" + phone + ", password=" + password + ", name=" + name + ", address=" + address + ", gender=" + gender + ", point=" + point + ", role=" + role + '}';
    }
    
}
