/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.dao.ADMIN;

import com.nestf.account.*;
import com.nestf.util.DBHelper;
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
public class SellerDAOAdmin {

    public static final String GET_LIST = "SELECT phone, password, name, address, gender, point, role\n"
            + "FROM tblAccount\n";

    public static final String GET_LIST_SELLER_ONLY = "SELECT account.phone, password, account.name, address, gender, point, count(ps.selPhone) as selQuantity\n"
            + "            FROM tblProductSeller ps\n"
            + "			RIGHT JOIN (SELECT p.productID\n"
            + "						FROM tblProducts p\n"
            + "						WHERE p.status = 1) as p\n"
            + "			ON ps.productID = p.productID\n"
            + "			FULL JOIN (SELECT acc.phone, password, name, address, gender, point\n"
            + "						fROM tblAccount acc\n"
            + "						WHERE acc.role = 'SE') as account\n"
            + "            ON account.phone = ps.selPhone \n"
            + "            Group by account.phone, password, name, address, gender, point";

    public static final String GET_SELLER_GIVEN_NAME = "SELECT acc.phone, password, address, gender, point\n"
            + "FROM tblAccount acc\n"
            + "WHERE acc.role = 'SE' AND acc.name = ?";

    public static final String GET_LIST_SELLER_INCOME = "Select a.name, a.phone, a.address, SUM(d.total) as total, a.status\n"
            + "FROM tblBillDetail d\n"
            + "Right join tblAccount a\n"
            + "ON d.selPhone = a.phone \n"
            + "WHERE a.role = 'SE'\n"
            + "Group by  a.name, a.phone, a.address, a.status\n"
            + "Order by total DESC";

    public static List<AccountDTO> getListSellerOnly() throws SQLException, NamingException {
        List<AccountDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_LIST_SELLER_ONLY);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String phone = rs.getString("phone");
                    String password = rs.getString("password");
                    String name = rs.getString("name");
                    String address = rs.getString("address");
                    boolean gender = rs.getBoolean("gender");
                    double point = rs.getDouble("point");
                    int selQuantity = rs.getInt("selQuantity");
                    list.add(new AccountDTO(phone, password, name, address, gender, point, "SE", selQuantity));
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
        return list;
    }

    public static List<AccountDTO> getListSellerIncome() throws SQLException, NamingException {
        List<AccountDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_LIST_SELLER_INCOME);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String phone = rs.getString("phone");
                    String name = rs.getString("name");
                    String address = rs.getString("address");
                    double total = rs.getDouble("total");
                    boolean status = rs.getBoolean("status");
                    list.add(new AccountDTO(phone, name, address, total, status));
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
        return list;
    }

    public boolean updateAdminProflie(AccountDTO dto, String name, String password, String phone) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        if (dto == null) {
            return false;
        }

        //int productID = dto.getProductID();
        String adPhone = dto.getPhone();

        try {
//        1. Make connection
            con = DBHelper.makeConnection();

            if (con != null) {
//          2. Create SQL Stirng . co khoang trang sau username
                String sql = "Update tblAccount "
                        + "Set password = ? , name = ? , phone = ? "
                        + "Where phone = ? ";

                statement = con.prepareStatement(sql);
                statement.setString(1, password);
                statement.setString(2, name);
                statement.setString(3, phone);
                statement.setString(4, adPhone);

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

    public boolean getExistPhone(String phone) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                String sql = "SELECT * FROM tblAccount WHERE phone = ? ";
                ptm = conn.prepareStatement(sql);
                ptm.setString(1, phone);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    result = true;
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
        return result;
    }

    public static AccountDTO getSellerGivenName(String name) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_SELLER_GIVEN_NAME);
                ptm.setString(1, name);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String phone = rs.getString("phone");
                    String password = rs.getString("password");
                    String address = rs.getString("address");
                    boolean gender = rs.getBoolean("gender");
                    double point = rs.getDouble("point");
                    return new AccountDTO(phone, password, name, address, gender, point, "SE");
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
        return null;
    }

}
