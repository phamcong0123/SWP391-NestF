/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.bill;

import com.nestf.billdetail.BillDetailDTO;
import com.nestf.product.ProductDTO;
import com.nestf.status.StatusDTO;
import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author DELL
 */
public class BillDTO implements Serializable {

    private int billID;
    private String cusPhone;
    private String address;
    private StatusDTO status;
    private Date time;
    private double total;
    private List<BillDetailDTO> detail;

    public BillDTO() {
    }

    public BillDTO(int billID, String cusPhone, String address, StatusDTO status, Date time, double total, List<BillDetailDTO> detail) {
        this.billID = billID;
        this.cusPhone = cusPhone;
        this.address = address;
        this.status = status;
        this.time = time;
        this.total = total;
        this.detail = detail;
    }

    public int getBillID() {
        return billID;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public String getAddress() {
        return address;
    }

    public StatusDTO getStatus() {
        return status;
    }

    public Date getTime() {
        return time;
    }

    public double getTotal() {
        return total;
    }

    public List<BillDetailDTO> getDetail() {
        return detail;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStatus(StatusDTO status) {
        this.status = status;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setDetail(List<BillDetailDTO> detail) {
        this.detail = detail;
    }    
}
