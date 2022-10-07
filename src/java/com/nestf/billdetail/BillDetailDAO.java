/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.billdetail;

import com.nestf.util.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class BillDetailDAO {
    public List<BillDetailDTO> getAllBillDetail() {
        List<BillDetailDTO> listBillDetail = new ArrayList<>();
        String query = "SELECT * FROM tblBillDetail ORDER BY billDetailID DESC";
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(query);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    listBillDetail.add(new BillDetailDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDouble(5), rs.getDouble(6)));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBillDetail;
    }

    public boolean AddBillDetail(BillDetailDTO billsdetail) {
        String query = "INSERT INTO tblBill VALUES (?,?,?,?,?) ";
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBHelper.makeConnection();
            ptm = conn.prepareStatement(query);
            ptm.setInt(1, billsdetail.getBillID());
            ptm.setInt(2, billsdetail.getProductID());
            ptm.setInt(3, billsdetail.getQuantity());
            ptm.setDouble(4, billsdetail.getPrice());
            ptm.setDouble(5, billsdetail.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
