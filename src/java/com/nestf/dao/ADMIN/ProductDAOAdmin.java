/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.dao.ADMIN;

import com.nestf.category.CategoryDTO;
import com.nestf.product.ProductDTO;
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
 * @author DELL
 */
public class ProductDAOAdmin {

    public static final String GET_PRO_DETAIL = "SELECT ps.selPhone, name, price, quantity, cat.categoryID, cat.categoryName, discountPrice, productDes, image, status\n"
            + "FROM  tblProducts pro\n"
            + "INNER JOIN tblCategory cat\n"
            + "ON pro.categoryID = cat.categoryID\n"
            + "INNER JOIN tblProductSeller ps\n"
            + "ON pro.productID = ps.productID \n"
            + "AND pro.productID = ?";

    public static final String SET_STATUS_TRUE = "UPDATE tblProducts\n"
            + "SET status = 1\n"
            + "WHERE productID = ?";

    public static final String SET_STATUS_FALSE = "UPDATE tblProducts\n"
            + "SET status = 0\n"
            + "WHERE productID = ?";

    public static final String UPDATE_PRODUCT = "UPDATE tblProducts\n"
            + "SET name = ? , price = ? , quantity = ? , categoryID = ? , discountPrice = ? , productDes = ? , image = ? , status = ?\n"
            + "WHERE productID = ? ";

    public static final String GET_LIST_ACTIVE = "SELECT pro.productID, ps.selPhone, name, price, quantity, cat.categoryID, cat.categoryName, discountPrice, productDes, image, detailDes\n"
            + "FROM  tblProducts pro\n"
            + "INNER JOIN tblCategory cat\n"
            + "ON pro.categoryID = cat.categoryID\n"
            + "INNER JOIN tblProductSeller ps\n"
            + "ON pro.productID = ps.productID \n"
            + "AND pro.status = 1";

    public static final String GET_LIST_NON_ACTIVE = "SELECT pro.productID, ps.selPhone, name, price, quantity, cat.categoryID, cat.categoryName, discountPrice, productDes, image, detailDes\n"
            + "FROM  tblProducts pro\n"
            + "INNER JOIN tblCategory cat\n"
            + "ON pro.categoryID = cat.categoryID\n"
            + "INNER JOIN tblProductSeller ps\n"
            + "ON pro.productID = ps.productID \n"
            + "AND pro.status = 0";

    public static final String DEACTIVE_PRODUCT_SELLER = "UPdate tblProductSeller \n"
            + "SET isActive = 0\n"
            + "WHERE productID = ? AND selPhone = ?";
    
    public static final String REGEX = "-(ptth)";
    public static final String INSERT_REGEX = "-ptth";

    public static List<ProductDTO> getListActiveProduct() throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_LIST_ACTIVE);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = Integer.parseInt(rs.getString("productID"));
                    String selPhone = rs.getString("selPhone");
                    String name = rs.getString("name");
                    float price = Float.parseFloat(rs.getString("price"));
                    int categoryID = Integer.parseInt(rs.getString("categoryID"));
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    String categoryName = rs.getString("categoryName");
                    float discountPrice = Float.parseFloat(rs.getString("discountPrice"));
                    String productDes = rs.getString("productDes");
                    String image = rs.getString("image");
                    String[] imageLink = image.split(REGEX);
                    list.add(new ProductDTO(productID, selPhone, name, price, quantity, new CategoryDTO(categoryID, categoryName), discountPrice, productDes, ".", true, imageLink));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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

    public static List<ProductDTO> getListNonActiveProduct() throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_LIST_NON_ACTIVE);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = Integer.parseInt(rs.getString("productID"));
                    String selPhone = rs.getString("selPhone");
                    String name = rs.getString("name");
                    float price = Float.parseFloat(rs.getString("price"));
                    int categoryID = Integer.parseInt(rs.getString("categoryID"));
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    String categoryName = rs.getString("categoryName");
                    float discountPrice = Float.parseFloat(rs.getString("discountPrice"));
                    String productDes = rs.getString("productDes");
                    String image = rs.getString("image");
                    String[] imageLink = image.split(REGEX);
                    list.add(new ProductDTO(productID, selPhone, name, price, quantity, new CategoryDTO(categoryID, categoryName), discountPrice, productDes, ".", false, imageLink));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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

//    Chèn vào product + productSeller
    public boolean insertProduct(ProductDTO dto) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        if (dto == null) {
            return false;
        }

        try {
//        1. Make connection
            con = DBHelper.makeConnection();

            if (con != null) {
                String sql = "Insert Into tblProducts(productID, name, price, quantity, categoryID, discountPrice,  productDes, image, detailDes, status) "
                        + "Values(?,?,?,?,?,?,?,?,?,?) ";
//          3. Create Statement Object
                statement = con.prepareStatement(sql);
                statement.setInt(1, dto.getProductID());
                statement.setString(2, dto.getName());
                statement.setDouble(3, dto.getPrice());
                statement.setInt(4, dto.getQuantity());
                statement.setInt(5, dto.getCategory().getCategoryID());
                statement.setDouble(6, dto.getDiscountPrice());
                statement.setString(7, dto.getProductDes());
                statement.setString(8, dto.getImage());
                statement.setString(9, dto.getDetailDes());
                statement.setBoolean(10, dto.isStatus());

//          4. Execute Query
                int affectRow = statement.executeUpdate();
//          5. Process result
                if (affectRow > 0) {
                    insertNEWProductSeller(dto);
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

//    TH1: Khi thêm mới 1 sản phẩm sẽ tự động insert vào ProductSeller với seller.status true
    public static boolean insertNEWProductSeller(ProductDTO dto) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        if (dto == null) {
            return false;
        }

        try {
//        1. Make connection
            con = DBHelper.makeConnection();

            if (con != null) {
                String sql = "Insert Into tblProductSeller(productID, selPhone, isActive) "
                        + "Values(?,?,?) ";
//          3. Create Statement Object
                statement = con.prepareStatement(sql);
                statement.setInt(1, dto.getProductID());
                statement.setString(2, dto.getSelPhone());
                statement.setBoolean(3, true);

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

    public boolean updateProductWithSameSeller(ProductDTO dto) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        if (dto == null) {
            return false;
        }

        try {
//            1. make connection
            con = DBHelper.makeConnection();

//            2. Create sql string 
            if (con != null) {
//                String sql = "UPDATE tblProducts\n"
//                        + "SET name = ? , price = ? , quantity = ? , categoryID = ? , discountPrice = ? , productDes = ? , image = ? , status = ?\n"
//                        + "WHERE productID = ? ";
                statement = con.prepareStatement(UPDATE_PRODUCT);
                statement.setString(1, dto.getName());
                statement.setFloat(2, (float)dto.getPrice());
                statement.setInt(3, dto.getQuantity());
                statement.setInt(4, dto.getCategory().getCategoryID());
                statement.setFloat(5, (float)dto.getDiscountPrice());
                statement.setString(6, dto.getProductDes());
                statement.setString(7, dto.getImage());
                statement.setBoolean(8, dto.isStatus());
                statement.setInt(9, dto.getProductID());
//          4. Execute Query
                int affectRow = statement.executeUpdate();

//          5. Process result
                if (affectRow > 0) {
                    return true;
                }

            }// end if connection is not null

        } finally {
            if (statement != null) {
                statement.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean updateProductWithDiffSeller(ProductDTO dto, String oldSelPhone) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        if (dto == null) {
            return false;
        }

        try {
//            1. make connection
            con = DBHelper.makeConnection();

//            2. Create sql string 
            if (con != null) {
                String sql = "UPDATE tblProductSeller\n"
                        + "SET isActive = 0 \n"
                        + "Where productID = ? AND selPhone = ?";
                statement = con.prepareStatement(sql);
                statement.setInt(1, dto.getProductID());
                statement.setString(2, oldSelPhone);
//          4. Execute Query
                int affectRow = statement.executeUpdate();

//          5. Process result
                if (affectRow > 0) {
                    updateProductWithSameSeller(dto);
                    insertNEWProductSeller(dto);
                    return true;
                }

            }// end if connection is not null

        } finally {
            if (statement != null) {
                statement.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public static ProductDTO getProductDetail(int productID) throws SQLException, NamingException {
        ProductDTO producDetail = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_PRO_DETAIL);
                ptm.setInt(1, productID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String selPhone = rs.getString("selPhone");
                    String name = rs.getString("name");
                    double price = Double.parseDouble(rs.getString("price"));
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    int categoryID = Integer.parseInt(rs.getString("categoryID"));
                    String category = rs.getString("categoryName");
                    double discountPrice = Double.parseDouble(rs.getString("discountPrice"));
                    String productDes = rs.getString("productDes");
                    String image = rs.getString("image");
                    boolean status = rs.getBoolean("status");
                    String[] imageLink = image.split(REGEX);
                    producDetail = new ProductDTO(productID, selPhone, name, price, quantity, new CategoryDTO(categoryID, category), discountPrice, productDes, ".", status, imageLink);
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
        return producDetail;
    }

    public boolean disableProduct(ProductDTO dto) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement statement = null;
        if (dto == null) {
            return false;
        }

        try {
//            1. make connection
            con = DBHelper.makeConnection();

//            2. Create sql string 
            if (con != null) {
                statement = con.prepareStatement(SET_STATUS_FALSE);
                statement.setInt(1, dto.getProductID());

//          4. Execute Query
                int affectRow = statement.executeUpdate();

//          5. Process result
                if (affectRow > 0) {
                    return true;
                }

            }

        } finally {
            if (statement != null) {
                statement.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

//    public static List<ProductDTO> getProductWithoutSeller() throws SQLException {
//        List<ProductDTO> list = new ArrayList<>();
//        Connection conn = null;
//        PreparedStatement ptm = null;
//        ResultSet rs = null;
//        try {
//            conn = DBHelper.makeConnection();
//            if (conn != null) {
//                ptm = conn.prepareStatement(GET_LIST_NON_ACTIVE);
//                rs = ptm.executeQuery();
//                while (rs.next()) {
//                    int productID = Integer.parseInt(rs.getString("productID"));
//                    int sellerID = Integer.parseInt(rs.getString("sellerID"));
//                    String name = rs.getString("name");
//                    float price = Float.parseFloat(rs.getString("price"));
//                    int quantity = Integer.parseInt(rs.getString("quantity"));
//                    String category = rs.getString("categoryName");
//                    float discountPrice = Float.parseFloat(rs.getString("discountPrice"));
//                    String productDes = rs.getString("productDes");
//                    String image = rs.getString("image");
//                    list.add(new ProductDTO(productID, sellerID, name, price, quantity, category, discountPrice, productDes, image, "."));
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (rs != null) rs.close();
//            if (ptm != null) ptm.close();
//            if (conn != null) conn.close();
//        }
//        return list;
//    }
    public static boolean acceptProduct(ProductDTO dto) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement statement = null;
        if (dto == null) {
            return false;
        }

        try {
//            1. make connection
            con = DBHelper.makeConnection();

//            2. Create sql string 
            if (con != null) {
                statement = con.prepareStatement(SET_STATUS_TRUE);
                statement.setInt(1, dto.getProductID());

//          4. Execute Query
                int affectRow = statement.executeUpdate();

//          5. Process result
                if (affectRow > 0) {
                    return true;
                }

            }// end if connection is not null

        } finally {
            if (statement != null) {
                statement.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean deactiveProductSeller(ProductDTO dto) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement statement = null;
        if (dto == null) {
            return false;
        }

        try {
//            1. make connection
            con = DBHelper.makeConnection();

//            2. Create sql string 
            if (con != null) {
                statement = con.prepareStatement(DEACTIVE_PRODUCT_SELLER);
                statement.setInt(1, dto.getProductID());
                statement.setString(2, dto.getSelPhone());

//          4. Execute Query
                int affectRow = statement.executeUpdate();

//          5. Process result
                if (affectRow > 0) {
                    return true;
                }

            }// end if connection is not null

        } finally {
            if (statement != null) {
                statement.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

}
