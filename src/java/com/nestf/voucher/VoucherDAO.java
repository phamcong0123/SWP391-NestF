/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.voucher;

import com.nestf.util.DBHelper;
import com.nestf.vouchertype.VoucherTypeDAO;
import com.nestf.vouchertype.VoucherTypeDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author Admin
 */
public class VoucherDAO {

    List<VoucherDTO> list = null;

    public List<VoucherDTO> getList() {
        return list;
    }

    public void loadVoucherWallet(int phone) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT * FROM tblVoucher WHERE status = 1";
                ptm = con.prepareStatement(sql);
                ptm.setInt(1, phone);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int voucherID = rs.getInt("voucherID");
                    VoucherTypeDAO dao = new VoucherTypeDAO();
                    VoucherTypeDTO voucherType = dao.getVoucher(rs.getInt("typeID"));
                    boolean status = rs.getBoolean("status");
                    Date date = rs.getDate("expiredDate");
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    String expiredDate = formatter.format(date);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    VoucherDTO dto = new VoucherDTO(voucherID, voucherType, phone, status, expiredDate);
                    list.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public boolean addVoucherToWaller(int phone, int typeID) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement ptm = null;
        boolean check = false;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                LocalDate expiredDate = LocalDate.now().plusDays(30);
                java.sql.Date date = java.sql.Date.valueOf(expiredDate);
                String sql = "INSERT INTO tblVoucher (typeID, customerPhone, status, expiredDate) VALUES (?, ?, 0, ?)";
                ptm = con.prepareStatement(sql);
                ptm.setInt(1, typeID);
                ptm.setInt(2, phone);
                ptm.setDate(3, date);
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
}
