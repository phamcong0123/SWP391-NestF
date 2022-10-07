/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.seller;

import com.nestf.util.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author Admin
 */
public class SellerDAO {
    public SellerDTO getSellerInformation(int sellerID) throws SQLException, NamingException{
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        SellerDTO seller = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                String sql = "SELECT * FROM tblSeller WHERE sellerID = ?";
                ptm = conn.prepareStatement(sql);
                ptm.setInt(1, sellerID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String password = rs.getNString("password");
                    String name = rs.getNString("name");
                    int phone = rs.getInt("phone");
                    boolean isAdmin = rs.getBoolean("isAdmin");
                    seller = new SellerDTO(sellerID, password, name, phone, isAdmin);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return seller;
    }
    
}
