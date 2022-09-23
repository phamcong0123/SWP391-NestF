/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.util;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class MyAppConstant implements Serializable {

    public static class RemoveItemsFeatures {
        public static final String CART_PAGE = "cartPage";
    }

    public class LoginFeatures {
        public static final String INVALID_PAGE = "invalid";
        public static final String SEARCH_ACTION = "searchAction";
    }
    
    public class SearchAccountFeatures {
        public static final String SEARCH_PAGE = "searchPage";
    }
    
    public class ShoppingFeatures{
        public static final String SHOPPING_PAGE = "shopPage";
        public static final String SHOPPING_ACTION = "shopAction";
    }
    
}
