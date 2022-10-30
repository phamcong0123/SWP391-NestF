/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.bill;

import com.nestf.billdetail.BillDetailDAO;
import com.nestf.billdetail.BillDetailDTO;
import com.nestf.status.StatusDAO;
import com.nestf.status.StatusDTO;
import com.nestf.util.DBHelper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author Admin
 */
public class BillDAO {

    final String PROCESSING_LIST = "SELECT billID, address, transactionID, statusID, time, total FROM tblBill WHERE cusPhone = ? AND statusID BETWEEN 1 AND 3 ";

    public List<BillDTO> getMyOnProcessingBills(String phone) throws NamingException, SQLException {
        List<BillDTO> list = null;
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                ptm = con.prepareStatement(PROCESSING_LIST);
                ptm.setString(1, phone);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int billID = rs.getInt("billID");
                    BillDetailDAO billDetailDAO = new BillDetailDAO();
                    List<BillDetailDTO> billDetail = billDetailDAO.getBillDetail(billID);
                    String address = rs.getNString("address");
                    String transactionID = rs.getString("transactionID");
                    int statusID = rs.getInt("statusID");
                    StatusDAO statusDAO = new StatusDAO();
                    StatusDTO status = statusDAO.getStatus(statusID);
                    Date date = new Date(rs.getTimestamp("time").getTime());
                    Double total = rs.getDouble("total");
                    BillDTO dto = new BillDTO(billID, phone, address, transactionID, status, date, total, billDetail);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
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
        return list;
    }
    final String COMPLETED_LIST = "SELECT billID, address, transactionID, statusID, time, total FROM tblBill WHERE cusPhone = ? AND statusID BETWEEN 4 AND 6 ";

    public List<BillDTO> getMyCompletedBills(String phone) throws NamingException, SQLException {
        List<BillDTO> list = null;
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                ptm = con.prepareStatement(COMPLETED_LIST);
                ptm.setString(1, phone);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int billID = rs.getInt("billID");
                    BillDetailDAO billDetailDAO = new BillDetailDAO();
                    List<BillDetailDTO> billDetail = billDetailDAO.getBillDetail(billID);
                    String address = rs.getNString("address");
                    String transactionID = rs.getString("transactionID");
                    int statusID = rs.getInt("statusID");
                    StatusDAO statusDAO = new StatusDAO();
                    StatusDTO status = statusDAO.getStatus(statusID);
                    Date date = new Date(rs.getTimestamp("time").getTime());
                    Double total = rs.getDouble("total");
                    BillDTO dto = new BillDTO(billID, phone, address, transactionID, status, date, total, billDetail);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
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
        return list;
    }

    final String CHECK_OUT = "INSERT tblBill([cusPhone], [address],[transactionID], [statusID], [total]) VALUES (?,?,?,1,?) ";

    public int checkOut(String phone, String address,String transactionID, double total) {
// statusID
//=1:Chờ xác nhận
//=2:Chờ lấy hàng
//=3:Đang giao
//=4:Đã giao
//=5:đã hủy
//=6:Trả hàng/Hoàn tiền        
        int billID = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_OUT, Statement.RETURN_GENERATED_KEYS);
                ptm.setString(1, phone);
                ptm.setNString(2, address);
                ptm.setString(3, transactionID);
                ptm.setDouble(4, total);
                int check = ptm.executeUpdate();
                if (check > 0) {
                    if (ptm.getGeneratedKeys().next()) billID = ptm.getGeneratedKeys().getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return billID;
    }
    private final String CANCEL = "";
    public boolean cancelOrder(int billID) throws NamingException, SQLException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try{
            conn = DBHelper.makeConnection();
            if (conn != null){
                ptm = conn.prepareStatement(CANCEL);
                ptm.setInt(1, billID);            
                check = ptm.executeUpdate() > 0;
            }
        } finally {
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }
        return check;
    }
}
