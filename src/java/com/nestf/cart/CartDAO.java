/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class CartDAO implements Serializable{
    private Map<Integer, Integer> items;
    
    public Map<Integer, Integer> getItems() {
        return items;
    }
    
    public void addItemToCart(int productID){
        if(this.items == null){
            this.items = new HashMap<>();
        } // items are not existed
        if(productID <= 0 ){
            return;
        }
        //items has existed
        int quantity = 1;
        if(this.items.containsKey(productID)){
            quantity = this.items.get(productID) + 1;
        }
//        update quantity of productID
        this.items.put(productID, quantity);
        
    }
    
    
    public void removeBookFromCart(int productID){
        
        if(this.items == null){
            return;
        }
//        items have existed
        if(this.items.containsKey(productID)){
            this.items.remove(productID);
            if(this.items.isEmpty()){
                this.items = null;
            }
        } // item existed in items
    }
    
}
