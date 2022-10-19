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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author Admin
 */
public class BillDAO {
    static String customerPhone;

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
    
    final String PROCESSING_LIST = "SELECT billID, address, statusID, time, total FROM tblBill WHERE customerPhone = ? AND statusID BETWEEN 1 AND 3 ";
    
    public List<BillDTO> getBillOnProcessing() throws NamingException, SQLException{
        List<BillDTO> list = null;
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null){
                ptm = con.prepareStatement(PROCESSING_LIST);
                ptm.setString(1, customerPhone);
                rs = ptm.executeQuery();
                while (rs.next()){
                    int billID = rs.getInt("billID");
                    BillDetailDAO billDetailDAO  = new BillDetailDAO();
                    List<BillDetailDTO> billDetail = billDetailDAO.getBillDetail(billID);
                    String address = rs.getNString("address");
                    int statusID = rs.getInt("statusID");
                    StatusDAO statusDAO = new StatusDAO();
                    StatusDTO status = statusDAO.getStatus(statusID);
                    Date date = new Date(rs.getTimestamp("time").getTime());
                    Double total = rs.getDouble("total");
                    BillDTO dto = new BillDTO(billID, address, status, date, total, billDetail);
                    if (list == null){
                        list = new ArrayList<>();
                    }
                    list.add(dto);
                }
            }
        } finally {
            if (rs != null ) rs.close();
            if (ptm != null) ptm.close();
            if (con != null) con.close();
        }
        return list;
    }
        final String COMPLETED_LIST = "SELECT billID, address, statusID, time, total FROM tblBill WHERE customerPhone = ? AND statusID BETWEEN 4 AND 6 ";
    
        public List<BillDTO> getCompletedBill() throws NamingException, SQLException{
        List<BillDTO> list = null;
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null){
                ptm = con.prepareStatement(COMPLETED_LIST);
                ptm.setString(1, customerPhone);
                rs = ptm.executeQuery();
                while (rs.next()){
                    int billID = rs.getInt("billID");
                    BillDetailDAO billDetailDAO  = new BillDetailDAO();
                    List<BillDetailDTO> billDetail = billDetailDAO.getBillDetail(billID);
                    String address = rs.getNString("address");
                    int statusID = rs.getInt("statusID");
                    StatusDAO statusDAO = new StatusDAO();
                    StatusDTO status = statusDAO.getStatus(statusID);
                    Date date = new Date(rs.getTimestamp("time").getTime());
                    Double total = rs.getDouble("total");
                    BillDTO dto = new BillDTO(billID, address, status, date, total, billDetail);
                    if (list == null){
                        list = new ArrayList<>();
                    }
                    list.add(dto);
                }
            }
        } finally {
            if (rs != null ) rs.close();
            if (ptm != null) ptm.close();
            if (con != null) con.close();
        }
        return list;
    }
}
