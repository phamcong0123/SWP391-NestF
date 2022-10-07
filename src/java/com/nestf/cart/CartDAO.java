/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.cart;

import com.nestf.product.ProductDAO;
import com.nestf.product.ProductDTO;
import com.nestf.util.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author Admin
 */
public class CartDAO implements Serializable{
    private List<CartItemDTO> carts;

    public List<CartItemDTO> getCarts(){
        return carts;
    }
    
    public static int PHONE;
    
    public void setPhone(int customerPhone){
        PHONE = customerPhone;
    }

    public void loadCart() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
//        1. Make connection
            con = DBHelper.makeConnection();

            if (con != null) {
                //          2. Create SQL Stirng . co khoang trang sau username
                String sql = "Select cartID, productID, amount "
                        + "From tblCart "
                        + "Where customerPhone = ?";
//          3. Create Statement Object
                statement = con.prepareStatement(sql);
                statement.setInt(1, PHONE);
                
//          4. Execute Query
                rs = statement.executeQuery();

//          5. Process result
                while (rs.next()) {

                    int productID = rs.getInt("productID");
                    ProductDAO dao = new ProductDAO();
                    ProductDTO product = dao.getProductDetail(productID);
                    int amount = rs.getInt("amount");
                    CartItemDTO dto = new CartItemDTO(product, amount);                  
                    if (this.carts == null) {
                        this.carts = new ArrayList<>();
                    }
                    this.carts.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
//  TH1: Cust thêm/bớt số lượng sản phẩm trong giỏ hàng
    public void addItemToCart(ProductDTO product, int amount) throws NamingException, SQLException {
        if (this.carts == null) {
            this.carts = new ArrayList<>();
        } 
        if (product == null) {
            return;
        }
        boolean result = false;

        for (CartItemDTO dto : carts) {
//            Nếu có sẵn trong giỏ thì update số lượng
            /*if (dto.getProductID() == product.getProductID()) {
                dto.setAmount(amount);
                result = updateProductQuantityInCart(dto);
                break;
            }*/
        }
//        Chưa có sẵn trong giỏ => thêm mới
        if (!result) {
            result = insertProductToCart(product, amount);
        }
        
        if(result){
            loadCart();
        }
            
    }
    
//  TH2: Cust bấm Thêm vào giỏ từ trang shop.jsp nhiều lần (+1) 
    public void addItemToCartFromShopPage(ProductDTO product) throws NamingException, SQLException{
        if (this.carts == null) {
            this.carts = new ArrayList<>();
        } 
        if (product == null) {
            return;
        }
        boolean result = false;
        int amount = 1;
        for (CartItemDTO dto : carts) {
        //    Nếu có sẵn trong giỏ thì +1 số lượng
            /*if (dto.getProductID() == product.getProductID()) {
                dto.setAmount(dto.getAmount() + amount);
                result = updateProductQuantityInCart(dto);
                break;
            }*/
        }
          //Chưa có sẵn trong giỏ => thêm mới
        if (!result) {
            result = insertProductToCart(product, amount);
        }
        
        if(result){
            loadCart();
        }
    }
    
//    TH3: Cust bấm Thêm vào giỏ kèm số lượng từ trang product Detail
    public void addItemToCartFromPDetail(ProductDTO product, int amount) throws NamingException, SQLException{
        if (this.carts == null) {
            this.carts = new ArrayList<>();
        } 
        if (product == null) {
            return;
        }
        boolean result = false;

        for (CartItemDTO dto : carts) {
//            Nếu có sẵn trong giỏ thì update số lượng
            /*if (dto.getProductID() == product.getProductID()) {
                dto.setAmount(dto.getAmount() + amount);
                result = updateProductQuantityInCart(dto);
                break;
            }*/
        }
//        Chưa có sẵn trong giỏ => thêm mới
        if (!result) {
            result = insertProductToCart(product, amount);
        }
        
        if(result){
            loadCart();
        }
    }
    
//  TH1: Xóa từng sản phẩm
    public boolean removeItemFromCart(int productID) throws SQLException, NamingException {
        loadCart();
        
        
        if (carts == null){
            return true;
        }
        
        Connection con = null;
        PreparedStatement statement = null;
        try {

//        1. Make connection
            con = DBHelper.makeConnection();

            if (con != null) {
                //          2. Create SQL Statement String 
                String sql = "Delete From tblCart "
                        + "Where customerPhone = ? And productID = ? ";
//          3. Create Statement Object
                statement = con.prepareStatement(sql);
                statement.setInt(1, PHONE);
                statement.setInt(2, productID);

//          4. Execute Query
                int affectRow = statement.executeUpdate();
                
//          5. Process result
                if (affectRow > 0) {
                    return true;
                }
            } // end if connection is not null

        } finally {

            if (statement != null) {
                statement.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
    public boolean updateProductQuantityInCart(CartItemDTO dto) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        if (dto == null) {
            return false;
        }
        
        //int productID = dto.getProductID();
        int amount = dto.getAmount();

        try {
//        1. Make connection
            con = DBHelper.makeConnection();

            if (con != null) {
                //          2. Create SQL Stirng . co khoang trang sau username
                String sql = "Update tblCart " 
                            + "Set amount = ? " 
                            + "where customerPhone = ? AND productID = ? ";
                
                statement = con.prepareStatement(sql);
                statement.setInt(1, amount);
                statement.setInt(2, PHONE);
                //statement.setInt(3, productID);

//          4. Execute Query
                int affectRow = statement.executeUpdate();

//          5. Process result
                if (affectRow > 0) {
                    return true;
                }

            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
    
  
    public boolean insertProductToCart(ProductDTO product, int amount) throws SQLException, NamingException{
       Connection con = null;
        PreparedStatement statement = null;
        try {

//        1. Make connection
            con = DBHelper.makeConnection();

            if (con != null) {
                //          2. Create SQL Statement String 
                String sql = "Insert Into tblCart(customerPhone, productID, amount) "
                        + "Values(?,?,?) ";
//          3. Create Statement Object
                statement = con.prepareStatement(sql);
                statement.setInt(1, PHONE);
                statement.setInt(2, product.getProductID());
                statement.setInt(3, amount);

//          4. Execute Query
                int affectRow = statement.executeUpdate();
                
//          5. Process result
                if (affectRow > 0) {
                    return true;
                }
            } // end if connection is not null

        } finally {

            if (statement != null) {
                statement.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
}
