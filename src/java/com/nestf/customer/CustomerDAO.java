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

    public CustomerDTO checkLogin(int customerPhone, String password) throws SQLException, NamingException {
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

    private static final String CHECK_DUPLICATE = "SELECT [customerPhone], [password], [customerName], [customerAddress], [gender], [point] FROM [NestF].[dbo].[tblCustomer] WHERE [customerPhone] = ?";
    private static final String INSERT = "INSERT INTO [NestF].[dbo].[tblCustomer]([customerPhone], [password], [customerName], [customerAddress], [gender], [point]) VALUES (?, ?, ?, ?, ?, ?)";

    public boolean checkDuplicate(int customerPhone) throws SQLException, NamingException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            ptm = conn.prepareStatement(CHECK_DUPLICATE);
            ptm.setInt(1, customerPhone);
            rs = ptm.executeQuery();
            if (rs.next()) {
                check = true;
            }
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return check;
    }

    public boolean insert(CustomerDTO customer) throws SQLException, NamingException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT);
                ptm.setInt(1, customer.getCustomerPhone());
                ptm.setString(2, customer.getPassword());
                ptm.setString(3, customer.getCustomerName());
                ptm.setString(4, customer.getCustomerAddress());
                ptm.setBoolean(5, customer.isGender());
                ptm.setInt(6, customer.getPoint());
                check = ptm.executeUpdate() > 0;
            }
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    private static final String UPDATE_NAME = "UPDATE [NestF].[dbo].[tblCustomer] SET [customerName]= ? "
            + " WHERE [customerPhone]=?";

    public boolean updateCusName(int phone, String newName) throws SQLException, NamingException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_NAME);
                ptm.setNString(1, newName);
                ptm.setInt(2, phone);
                check = ptm.executeUpdate() > 0;
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ptm != null) {
                ptm.close();
            }
        }
        return check;
    }

    private static final String UPDATE_ADDRESS = "UPDATE [NestF].[dbo].[tblCustomer] SET [customerAddress]=? "
            + " WHERE [customerPhone]=?";

    public boolean updateCusAddress(int phone, String newAddress) throws SQLException, NamingException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_ADDRESS);
                ptm.setNString(1, newAddress);
                ptm.setInt(2, phone);
                check = ptm.executeUpdate() > 0;
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ptm != null) {
                ptm.close();
            }
        }
        return check;
    }

    private static final String UPDATE_PASSWORD = "UPDATE [NestF].[dbo].[tblCustomer] SET [password]=? "
            + " WHERE [customerPhone]=?";

    public boolean updateCusPassword(int phone, String newPass) throws SQLException, NamingException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_PASSWORD);
                ptm.setNString(1, newPass);
                ptm.setInt(2, phone);
                check = ptm.executeUpdate() > 0;
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ptm != null) {
                ptm.close();
            }
        }
        return check;
    }
}
