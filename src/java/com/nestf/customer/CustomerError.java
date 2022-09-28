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

    private String customerPhoneError;
    private String passwordError;
    private String customerNameError;
    private String customerAddressError;
    private String genderError;
    private String pointError;
    private String errorMsg;
    private String confirm;

    public CustomerError() {
        this.customerPhoneError = "";
        this.passwordError = "";
        this.customerNameError = "";
        this.customerAddressError = "";
        this.genderError = "";
        this.pointError = "";
        this.errorMsg = "";
        this.confirm = "";
    }

    public CustomerError(String customerPhoneError, String passwordError, String customerNameError, String customerAddressError, String genderError, String pointError, String errorMsg, String confirm) {
        this.customerPhoneError = customerPhoneError;
        this.passwordError = passwordError;
        this.customerNameError = customerNameError;
        this.customerAddressError = customerAddressError;
        this.genderError = genderError;
        this.pointError = pointError;
        this.errorMsg = errorMsg;
        this.confirm = confirm;
    }

    public String getCustomerPhoneError() {
        return customerPhoneError;
    }

    public void setCustomerPhoneError(String customerPhoneError) {
        this.customerPhoneError = customerPhoneError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getCustomerNameError() {
        return customerNameError;
    }

    public void setCustomerNameError(String customerNameError) {
        this.customerNameError = customerNameError;
    }

    public String getCustomerAddressError() {
        return customerAddressError;
    }

    public void setCustomerAddressError(String customerAddressError) {
        this.customerAddressError = customerAddressError;
    }

    public String isGenderError() {
        return genderError;
    }

    public void setGenderError(String genderError) {
        this.genderError = genderError;
    }

    public String getPointError() {
        return pointError;
    }

    public void setPointError(String pointError) {
        this.pointError = pointError;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

}
