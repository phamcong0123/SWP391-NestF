/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.account;

/**
 *
 * @author Admin
 */
public class AccountError {

    private String phone;
    private String password;
    private String name;
    private String address;
    private String gender;
    private String point;
    private String role;

    public AccountError() {
        this.phone = "";
        this.password = "";
        this.name = "";
        this.address = "";
        this.gender = "";
        this.point = "";
        this.role = "";
    }

    public AccountError(String phone, String password, String name, String address, String gender, String point, String role) {
        this.phone = phone;
        this.password = password;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.point = point;
        this.role = role;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
