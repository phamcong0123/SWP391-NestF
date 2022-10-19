/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.billdetail;

import com.nestf.product.ProductDTO;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author DELL
 */
public class BillDetailDTO implements Serializable{
    private ProductDTO product;
    private int quantity;
    private long price;
    private BigDecimal total;

    public BillDetailDTO() {
    }

    public BillDetailDTO(ProductDTO product, int quantity, long price, BigDecimal total) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public long getPrice() {
        return price;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    

}
