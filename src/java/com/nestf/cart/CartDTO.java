/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.cart;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class CartDTO implements Serializable{
    private int cartID;
    private int customerPhone;
    private int productID;
    private int amount;
}
