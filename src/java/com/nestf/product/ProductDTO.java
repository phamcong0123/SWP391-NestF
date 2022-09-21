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
    private String sellerID;
    private String name;
    private float price;
    private int quantity;
    private int categoryID;
    private float discountPrice;
    private String productDes;
    private String image;
    private String detailDes;
    
}
