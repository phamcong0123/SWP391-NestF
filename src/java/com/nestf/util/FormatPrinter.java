/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.util;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Admin
 */
public class FormatPrinter {
    public static String printDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss dd/MM/YYYY");
        String dateString = sdf.format(date);
        return dateString;
    }
    public static String printMoney(double price) {
        Locale vie = new Locale("vi", "VN");
        Currency vnd = Currency.getInstance(vie);
        NumberFormat vndFormat = NumberFormat.getCurrencyInstance(vie);
        return vndFormat.format(price).replace("đ", "₫");
    }
}
