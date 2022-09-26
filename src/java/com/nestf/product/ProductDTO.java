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
    private double price;
    private int quantity;
    private int categoryID;
    private double discountPrice;
    private String productDes;
    private String image;
    private String detailDes;
    private boolean status;

    public ProductDTO() {
    }

    public ProductDTO(int productID, int sellerID, String name, double price, int quantity, int categoryID, double discountPrice, String productDes, String image, String detailDes, boolean status) {
        this.productID = productID;
        this.sellerID = sellerID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categoryID = categoryID;
        this.discountPrice = discountPrice;
        this.productDes = productDes;
        this.image = image;
        this.detailDes = detailDes;
        this.status = status;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getSellerID() {
        return sellerID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getProductDes() {
        return productDes;
    }

    public void setProductDes(String productDes) {
        this.productDes = productDes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetailDes() {
        return detailDes;
    }

    public void setDetailDes(String detailDes) {
        this.detailDes = detailDes;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProductDTO{" + "productID=" + productID + ", sellerID=" + sellerID + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", categoryID=" + categoryID + ", discountPrice=" + discountPrice + ", productDes=" + productDes + ", image=" + image + ", detailDes=" + detailDes + ", status=" + status + '}';
    }
    
}
