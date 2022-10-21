/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.account;

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
public class AccountDAO {

    private static final String CHECK_DUPLICATE_ACCOUNT = "SELECT [phone], [password], [name], [address], [gender], [point], [role] "
            + "FROM [NestF].[dbo].[tblAccount] WHERE [phone] = ?";
    private static final String INSERT = "INSERT INTO [NestF].[dbo].[tblAccount]([phone], [password], [name], [address], [gender], [point], [role]) "
            + "VALUES(?,?,?,?,?,?,?)";
    private static final String UPDATE_NAME = "UPDATE [NestF].[dbo].[tblAccount] SET [name]= ? "
            + " WHERE [phone]=?";
    private static final String UPDATE_ADDRESS = "UPDATE [NestF].[dbo].[tblAccount] SET [address]=? "
            + " WHERE [phone]=?";
    private static final String UPDATE_PASSWORD = "UPDATE [NestF].[dbo].[tblAccount] SET [password]=? "
            + " WHERE [phone]=?";

    public AccountDTO checkLogin(String phone, String password) throws SQLException, NamingException {
        AccountDTO account = null;
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
                while (rs.next()) {
                    return new AccountDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getInt(6), rs.getString(7));
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
        return account;
    }

    public boolean checkDuplicate(String phone) throws SQLException, NamingException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            ptm = conn.prepareStatement(CHECK_DUPLICATE_ACCOUNT);
            ptm.setString(1, phone);
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

    public boolean insert(AccountDTO account) throws SQLException, NamingException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, account.getPhone());
                ptm.setString(2, account.getPassword());
                ptm.setString(3, account.getName());
                ptm.setString(4, account.getAddress());
                ptm.setBoolean(5, account.isGender());
                ptm.setInt(6, account.getPoint());
                ptm.setString(6, account.getRole());
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
}
