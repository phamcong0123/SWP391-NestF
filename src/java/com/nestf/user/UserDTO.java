/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.user;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class UserDTO implements Serializable {

    private String userPhone;
    private String password;
    private String name;
    private String address;
    private boolean gender;
    private int point;
    private String role;

    public UserDTO() {
    }

    public UserDTO(String userPhone, String password, String name, String address, boolean gender, int point, String role) {
        this.userPhone = userPhone;
        this.password = password;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.point = point;
        this.role = role;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public boolean isGender() {
        return gender;
    }

    public int getPoint() {
        return point;
    }

    public String getRole() {
        return role;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setRole(String role) {
        this.role = role;
    }

    

}
