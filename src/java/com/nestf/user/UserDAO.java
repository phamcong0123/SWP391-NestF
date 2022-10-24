/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.user;

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
public class UserDAO {

    public UserDTO checkLogin(String phone, String password) throws SQLException, NamingException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        String query = "SELECT * FROM tblAccount WHERE phone=? AND password=?";
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(query);
                ptm.setString(1, phone);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    user = new UserDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getInt(6), rs.getString(7));
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
        return user;
    }
    
    public boolean checkDuplicate(String customerPhone) throws SQLException, NamingException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null){
                String sql = "SELECT phone FROM tblAccount WHERE phone = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, customerPhone);
            rs = ptm.executeQuery();
            if (rs.next()) {
                check = true;
            }
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

    public boolean insert(UserDTO customer) throws SQLException, NamingException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                String INSERT = "INSERT INTO [NestF].[dbo].[tblAccount]([phone], [password], [name], [address], [gender], [point], [role]) VALUES (?, ?, ?, ?, ?, ?, ?)";
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, customer.getUserPhone());
                ptm.setString(2, customer.getPassword());
                ptm.setString(3, customer.getName());
                ptm.setString(4, customer.getAddress());
                ptm.setBoolean(5, customer.isGender());
                ptm.setInt(6, customer.getPoint());
                ptm.setString(7, customer.getRole());
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

    public boolean updateCusName(String phone, String newName) throws SQLException, NamingException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                String UPDATE_NAME = "UPDATE [NestF].[dbo].[tblAccount] SET [name]= ? "
            + " WHERE [phone]=?";
                ptm = conn.prepareStatement(UPDATE_NAME);
                ptm.setNString(1, newName);
                ptm.setString(2, phone);
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

    public boolean updateCusAddress(String phone, String newAddress) throws SQLException, NamingException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                String UPDATE_ADDRESS = "UPDATE [NestF].[dbo].[tblAccount] SET [address]=? "
            + " WHERE [phone]=?";
                ptm = conn.prepareStatement(UPDATE_ADDRESS);
                ptm.setNString(1, newAddress);
                ptm.setString(2, phone);
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

    public boolean updateCusPassword(String phone, String newPass) throws SQLException, NamingException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                 String UPDATE_PASSWORD = "UPDATE [NestF].[dbo].[tblAccount] SET [password]=? "
            + " WHERE [phone]=?";
                ptm = conn.prepareStatement(UPDATE_PASSWORD);
                ptm.setNString(1, newPass);
                ptm.setString(2, phone);
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
    public boolean buyVoucher(String phone, int newPoint) throws NamingException, SQLException{
        Boolean check = false;      
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                String sql = "UPDATE tblAccount SET point = ? WHERE phone = ?";
                ptm = conn.prepareStatement(sql);
                ptm.setInt(1, newPoint);
                ptm.setString(2, phone);             
                if(ptm.executeUpdate() > 0){
                    check = true;
                }
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
    public UserDTO GetUserByPhone(String phone) throws NamingException, SQLException{
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        String query = "SELECT * FROM tblAccount WHERE phone=?";
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(query);
                ptm.setString(1, phone);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    return new UserDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getInt(6), rs.getString(7));
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
        return user;
    }
}
