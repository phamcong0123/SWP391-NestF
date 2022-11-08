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

    private List<BillDTO> bills;

    public List<BillDTO> getBills() {
        return bills;
    }

    public BillDTO validOnProcessingOrder(int billID, String phone) throws NamingException, SQLException {
        getMyAllBills(phone);
        List<BillDTO> onProcessing = getThisStatusBills(bills, 1, 2);
        for (BillDTO bill : onProcessing) {
            if (bill.getBillID() == billID) {
                return bill;
            }
        }
        return null;
    }

    public boolean cancelOrder(int billID, String phone, String cancelReason) throws NamingException, SQLException {
        boolean check = false;
        BillDTO bill = validOnProcessingOrder(billID, phone);
        if (bill == null) {
            return check;
        }
        if (bill.getStatus().getStatusID() > 2) {
            return check;
        }
        if (updateOrderStatus(billID, 5)) {
            addCancelReason(billID, cancelReason);
            check = true;
        }
        return check;
    }

    public List<BillDTO> getThisStatusBills(List<BillDTO> bills, int... statusIDs) {
        List<BillDTO> atStatusBills = new ArrayList<>();
        for (BillDTO bill : bills) {
            for (int i = 0; i < statusIDs.length; i++) {
                if (bill.getStatus().getStatusID() == statusIDs[i]) {
                    atStatusBills.add(bill);
                    break;
                }
            }
        }
        return atStatusBills;
    }
    final String ALL_BILL = "SELECT billID, address, transactionID, statusID, time, total, cancelReason FROM tblBill WHERE cusPhone = ? ORDER BY time DESC";

    public void getMyAllBills(String phone) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                ptm = con.prepareStatement(ALL_BILL);
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
                    String cancelReason = rs.getNString("cancelReason");
                    BillDTO dto = new BillDTO(billID, phone, address, transactionID, status, date, total, cancelReason, billDetail);
                    if (bills == null) {
                        bills = new ArrayList<>();
                    }
                    bills.add(dto);
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
    final String CHECK_OUT = "INSERT tblBill([cusPhone], [address],[transactionID], [statusID], [time], [total]) VALUES (?,?,?,1, GETDATE(),?) ";

    public int checkOut(String phone, String address, String transactionID, double total) {
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
                    if (ptm.getGeneratedKeys().next()) {
                        billID = ptm.getGeneratedKeys().getInt(1);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return billID;
    }
    private final String UPDATE = "UPDATE tblBill SET statusID = ? WHERE billID = ?";

    public boolean updateOrderStatus(int billID, int statusID) throws NamingException, SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setInt(1, statusID);
                ptm.setInt(2, billID);
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
    private final String CANCEL = "UPDATE tblBill SET cancelReason = ? WHERE billID = ?";
    public boolean addCancelReason(int billID, String cancelReason) throws NamingException, SQLException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CANCEL);
                ptm.setString(1, cancelReason);
                ptm.setInt(2, billID);
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
