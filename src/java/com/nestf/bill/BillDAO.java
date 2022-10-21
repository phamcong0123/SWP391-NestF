/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.bill;

import com.nestf.util.DBHelper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class BillDAO {

    public static final String GET_BILL = "SELECT billID, customerPhone, address, sellerID, status, time, total\n"
            + "FROM tblBill tb\n"
            + "INNER JOIN tblStatus ts\n"
            + "ON tb.statusID=ts.statusID\n";

    public static final String GET_ALL_BILL_BY_PHONE = "SELECT billID, customerPhone, address, sellerID, status, time, total\n"
            + "FROM tblBill tb\n"
            + "INNER JOIN tblStatus ts\n"
            + "ON tb.statusID=ts.statusID\n"
            + "customerPhone=?\n";
    public static final String GET_CONFIRM_SHIPPING_BILL = "SELECT billID, customerPhone, address, sellerID, status, time, total\n"
            + "FROM tblBill tb\n"
            + "INNER JOIN tblStatus ts\n"
            + "ON tb.statusID=ts.statusID\n"
            + "WHERE (tb.statusID=1 OR tb.statusID=2 OR tb.statusID=3) AND customerPhone=?\n";

    public static final String GET_CANCEL_REJECT = "SELECT billID, customerPhone, address, sellerID, status, time, total\n"
            + "FROM tblBill tb\n"
            + "INNER JOIN tblStatus ts\n"
            + "ON tb.statusID=ts.statusID\n"
            + "WHERE (tb.statusID=4 OR tb.statusID=5 OR tb.statusID=6) AND customerPhone=?\n";

    public List<BillDTO> getAllBill() {
// statusID
//=1:Chờ xác nhận
//=2:Chờ lấy hàng
//=3:Đang giao
//=4:Đã giao
//=5:đã hủy
//=6:Trả hàng/Hoàn tiền
        List<BillDTO> listBill = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_BILL);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    listBill.add(new BillDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), Integer.parseInt(rs.getString(5)), rs.getDate(6), rs.getDouble(7)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBill;
    }

    public List<BillDTO> getAllBillByPhone(String customerPhone) {
// statusID
//=1:Chờ xác nhận
//=2:Chờ lấy hàng
//=3:Đang giao
//=4:Đã giao
//=5:đã hủy
//=6:Trả hàng/Hoàn tiền
        List<BillDTO> listBill = new ArrayList<>();
        String query = "SELECT * FROM tblBill WHERE customerPhone =? ORDER BY billID DESC";
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(query);
                ptm.setString(1, customerPhone);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    listBill.add(new BillDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), Integer.parseInt(rs.getString(5)), rs.getDate(6), rs.getDouble(7)));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBill;
    }

    public List<BillDTO> getAllBillConfirmAndShipping(String customerPhone) {
// statusID
//=1:Chờ xác nhận
//=2:Chờ lấy hàng
//=3:Đang giao
//=4:Đã giao
//=5:đã hủy
//=6:Trả hàng/Hoàn tiền
        List<BillDTO> listBill = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_CONFIRM_SHIPPING_BILL);
                ptm.setString(1, customerPhone);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    listBill.add(new BillDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), Integer.parseInt(rs.getString(5)), rs.getDate(6), rs.getDouble(7)));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBill;
    }

    public List<BillDTO> getAllBillConfirm() {
// statusID
//=1:Chờ xác nhận
//=2:Chờ lấy hàng
//=3:Đang giao
//=4:Đã giao
//=5:đã hủy
//=6:Trả hàng/Hoàn tiền
        List<BillDTO> listBill = new ArrayList<>();
        String query = "SELECT * FROM tblBill WHERE StatusID=1";
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(query);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    listBill.add(new BillDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), Integer.parseInt(rs.getString(5)), rs.getDate(6), rs.getDouble(7)));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBill;
    }

    public List<BillDTO> getAllBillDelivering() {
// statusID
//=1:Chờ xác nhận
//=2:Chờ lấy hàng
//=3:Đang giao
//=4:Đã giao
//=5:đã hủy
//=6:Trả hàng/Hoàn tiền
        List<BillDTO> listBill = new ArrayList<>();
        String query = "SELECT * FROM tblBill WHERE StatusID=2";
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(query);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    listBill.add(new BillDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), Integer.parseInt(rs.getString(5)), rs.getDate(6), rs.getDouble(7)));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBill;
    }

    public List<BillDTO> getAllBillShipping() {
// statusID
//=1:Chờ xác nhận
//=2:Chờ lấy hàng
//=3:Đang giao
//=4:Đã giao
//=5:đã hủy
//=6:Trả hàng/Hoàn tiền
        List<BillDTO> listBill = new ArrayList<>();
        String query = "SELECT * FROM tblBill WHERE StatusID=3 ";
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(query);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    listBill.add(new BillDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), Integer.parseInt(rs.getString(5)), rs.getDate(6), rs.getDouble(7)));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBill;
    }

    public List<BillDTO> getAllBillDelivered() {
// statusID
//=1:Chờ xác nhận
//=2:Chờ lấy hàng
//=3:Đang giao
//=4:Đã giao
//=5:đã hủy
//=6:Trả hàng/Hoàn tiền
        List<BillDTO> listBill = new ArrayList<>();
        String query = "SELECT * FROM tblBill WHERE StatusID=4";
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(query);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    listBill.add(new BillDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), Integer.parseInt(rs.getString(5)), rs.getDate(6), rs.getDouble(7)));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBill;
    }

    public List<BillDTO> getAllBillCancelled(String customerPhone) {
// statusID
//=1:Chờ xác nhận
//=2:Chờ lấy hàng
//=3:Đang giao
//=4:Đã giao
//=5:đã hủy
//=6:Trả hàng/Hoàn tiền
        List<BillDTO> listBill = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_CANCEL_REJECT);
                ptm.setString(1, customerPhone);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    listBill.add(new BillDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), Integer.parseInt(rs.getString(5)), rs.getDate(6), rs.getDouble(7)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBill;
    }

    public List<BillDTO> getAllBillBackMoney() {
// statusID
//=1:Chờ xác nhận
//=2:Chờ lấy hàng
//=3:Đang giao
//=4:Đã giao
//=5:đã hủy
//=6:Trả hàng/Hoàn tiền
        List<BillDTO> listBill = new ArrayList<>();
        String query = "SELECT * FROM tblBill WHERE StatusID=6";
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(query);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    listBill.add(new BillDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), Integer.parseInt(rs.getString(5)), rs.getDate(6), rs.getDouble(7)));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBill;
    }

    public List<BillDTO> getAllBillCancelAndReject() {
// statusID
//=1:Chờ xác nhận
//=2:Chờ lấy hàng
//=3:Đang giao
//=4:Đã giao
//=5:đã hủy
//=6:Trả hàng/Hoàn tiền
        List<BillDTO> listBill = new ArrayList<>();
        String query = "SELECT * FROM tblBill WHERE StatusID=5";
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(query);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    listBill.add(new BillDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), Integer.parseInt(rs.getString(5)), rs.getDate(6), rs.getDouble(7)));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBill;
    }

    public List<BillDTO> getAllBillById(int billID) {
// statusID
//=1:Chờ xác nhận
//=2:Chờ lấy hàng
//=3:Đang giao
//=4:Đã giao
//=5:đã hủy
//=6:Trả hàng/Hoàn tiền
        List<BillDTO> listBill = new ArrayList<>();
        String query = "SELECT * FROM tblBill WHERE billID=?";
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(query);
                ptm.setInt(1, billID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    listBill.add(new BillDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), Integer.parseInt(rs.getString(5)), rs.getDate(6), rs.getDouble(7)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBill;
    }

    public boolean AddBill(BillDTO bills) {
// statusID
//=1:Chờ xác nhận
//=2:Chờ lấy hàng
//=3:Đang giao
//=4:Đã giao
//=5:đã hủy
//=6:Trả hàng/Hoàn tiền
        String query = "INSERT INTO tblBill VALUES (?,?,?,?,?,?) ";
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBHelper.makeConnection();
            ptm = conn.prepareStatement(query);
            ptm.setInt(1, bills.getCusPhone());
            ptm.setInt(2, bills.getSellerID());
            ptm.setString(3, bills.getAddress());
            ptm.setInt(4, bills.getStatusID());
            ptm.setDate(5, Date.valueOf(LocalDate.now()));
            ptm.setDouble(6, bills.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
