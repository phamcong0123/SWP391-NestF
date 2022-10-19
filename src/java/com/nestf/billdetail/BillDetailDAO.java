/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.billdetail;

import com.nestf.product.ProductDAO;
import com.nestf.product.ProductDTO;
import com.nestf.util.DBHelper;
import java.math.BigDecimal;
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
public class BillDetailDAO {
    public List<BillDetailDTO> getBillDetail(int billID) throws NamingException, SQLException {
        List<BillDetailDTO> list = null;        
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                String query = "SELECT productID, quantity, price, total FROM tblBillDetail WHERE billID = ?";
                ptm = conn.prepareStatement(query);
                ptm.setInt(1, billID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("productID");
                    ProductDAO dao = new ProductDAO();
                    ProductDTO product = dao.getProductDetail(productID);
                    int quantity = rs.getInt("quantity");
                    long price = rs.getLong("price");
                    BigDecimal total = rs.getBigDecimal("total");
                    if (list == null){
                        list = new ArrayList<>();
                    }
                    BillDetailDTO dto = new BillDetailDTO(product, quantity, price, total);
                    list.add(dto);
                }
            }

        } finally {
            if (rs != null) rs.close();
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }
        return list;
    }

    
}
