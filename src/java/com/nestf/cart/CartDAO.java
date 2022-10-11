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
public class CartDAO implements Serializable {

    private List<CartItemDTO> cart;

    public void setCarts(List<CartItemDTO> cart) {
        this.cart = cart;
    }

    public List<CartItemDTO> getCarts() {
        return cart;
    }

    public static String PHONE;

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    
    public boolean checkProductExisted(int productID){
        for (int i=0; i < cart.size(); i++){
            if (cart.get(i).getProduct().getProductID() == productID) return true;
        }
        return false;
    }
    
    public CartItemDTO getItemByID(int productID){
        for (int i=0; i < cart.size(); i++){
            if (cart.get(i).getProduct().getProductID() == productID) return cart.get(i);
        }
        return null;
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
                statement.setString(1, PHONE);

//          4. Execute Query
                rs = statement.executeQuery();

//          5. Process result
                while (rs.next()) {

                    int productID = rs.getInt("productID");
                    ProductDAO dao = new ProductDAO();
                    ProductDTO product = dao.getProductDetail(productID);
                    int amount = rs.getInt("amount");
                    CartItemDTO dto = new CartItemDTO(product, amount);
                    if (this.cart == null) {
                        this.cart = new ArrayList<>();
                    }
                    this.cart.add(dto);
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

    public boolean addItemToCart(CartItemDTO item) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement ptm = null;
        boolean check = false;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "INSERT INTO tblCart (customerPhone, productID, amount) VALUES (?, ?, ?)";
                ptm = con.prepareStatement(sql);
                ptm.setString(1, PHONE);
                ptm.setInt(2, item.getProduct().getProductID());
                ptm.setInt(3, item.getAmount());
                check = ptm.executeUpdate() > 0;
            }
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }
    
    public boolean updateItemAmount(CartItemDTO item) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement ptm = null;
        boolean check = false;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "UPDATE tblCart SET amount = ? WHERE customerPhone = ? AND productID = ?";
                ptm = con.prepareStatement(sql);
                ptm.setInt(1, item.getAmount());
                ptm.setString(2, PHONE);
                ptm.setInt(3, item.getProduct().getProductID());
                check = ptm.executeUpdate() > 0;
            }
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

//  TH1: Xóa từng sản phẩm
    public boolean removeItemFromCart(int productID) throws SQLException, NamingException {
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
                statement.setString(1, PHONE);
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

}
