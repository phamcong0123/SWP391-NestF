/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.product;

import com.nestf.category.CategoryDTO;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/**
 *
 * @author DELL
 */
public class ProductDTO implements Serializable{
    private int productID;
    private String name;
    private long price;
    private int quantity;
    private CategoryDTO category;
    private double discountPrice;
    private String productDes;
    private String image;
    private String detailDes;
    private boolean status;

    public ProductDTO() {
    }

    public ProductDTO(int productID, String name, long price, int quantity, CategoryDTO category, long discountPrice, String productDes, String image, String detailDes, boolean status) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
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
    
    public String printPrice(long price) {
        Locale vie = new Locale("vi", "VN");
        Currency vnd = Currency.getInstance(vie);
        NumberFormat vndFormat = NumberFormat.getCurrencyInstance(vie);
        return vndFormat.format(price).replace("đ", "₫");
    }
}
