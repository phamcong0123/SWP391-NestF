/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.customer;

/**
 *
 * @author Admin
 */
public class CustomerError {
    
    private String failLogin;
    private String customerPhoneDuplicate;
    private String passwordDuplicate;
    private String passwordWrong;

    public void setPasswordWrong(String passwordWrong) {
        this.passwordWrong = passwordWrong;
    }

    public String getPasswordWrong() {
        return passwordWrong;
    }

    public String getCustomerPhoneDuplicate() {
        return customerPhoneDuplicate;
    }

    public String getPasswordDuplicate() {
        return passwordDuplicate;
    }

    public void setCustomerPhoneDuplicate(String customerPhoneDuplicate) {
        this.customerPhoneDuplicate = customerPhoneDuplicate;
    }

    public void setPasswordDuplicate(String passwordDuplicate) {
        this.passwordDuplicate = passwordDuplicate;
    }
    

}