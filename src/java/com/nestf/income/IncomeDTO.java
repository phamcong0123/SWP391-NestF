/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.income;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author DELL
 */
public class IncomeDTO implements Serializable{
    private int incomeID;
    private int sellerID;
    private Date date;
    private double total;
    
}
