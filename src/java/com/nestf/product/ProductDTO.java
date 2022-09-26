/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.product;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class ProductDTO implements Serializable{
    private int productID;
    private int sellerID;
    private String name;
    private float price;
    private int quantity;
    private String category;
    private float discountPrice;
    private String productDes;
    private String image;
    private String detailDes;
    private boolean status;
    
}
