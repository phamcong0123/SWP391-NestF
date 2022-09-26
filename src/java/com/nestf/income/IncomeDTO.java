/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.income;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author DELL
 */
public class IncomeDTO implements Serializable{
    private int incomeID;
    private int sellerID;
    private Date date;
    private double total;

    public IncomeDTO() {
    }

    public IncomeDTO(int incomeID, int sellerID, Date date, double total) {
        this.incomeID = incomeID;
        this.sellerID = sellerID;
        this.date = date;
        this.total = total;
    }

    public int getIncomeID() {
        return incomeID;
    }

    public void setIncomeID(int incomeID) {
        this.incomeID = incomeID;
    }

    public int getSellerID() {
        return sellerID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "IncomeDTO{" + "incomeID=" + incomeID + ", sellerID=" + sellerID + ", date=" + date + ", total=" + total + '}';
    }
    
}
