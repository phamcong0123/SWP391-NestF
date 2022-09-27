/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.customer;

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
public class CustomerDAO {

    public CustomerDTO checkLogin(int customerPhone, String password) throws SQLException {
        CustomerDTO customer = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        String query = "SELECT * FROM tblCustomer WHERE customerPhone=? AND password=?";
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(query);
                ptm.setInt(1, customerPhone);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    return new CustomerDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getInt(6));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        return customer;
    }

}
