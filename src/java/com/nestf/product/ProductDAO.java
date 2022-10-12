/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.product;

import com.nestf.util.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ProductDAO {
    
    public static final String GET_LIST = "SELECT productID, sellerID, name, price, quantity, categoryName, discountPrice, productDes, image, detailDes\n" +
                                          "FROM tblProducts pro\n" +
                                          "INNER JOIN tblCategory cat\n" +
                                          "ON pro.categoryID = cat.categoryID";
    
    public static final String FILTER_CATE = "SELECT productID, sellerID, name, price, quantity, categoryName, discountPrice, productDes, image, detailDes, pro.categoryID\n" +
                                            "FROM tblProducts pro\n" +
                                            "INNER JOIN tblCategory cat\n" +
                                            "ON pro.categoryID = cat.categoryID\n" +
                                            "WHERE pro.categoryID = ?";
    
    public static final String FILTER_PRICE = "SELECT productID, sellerID, name, price, quantity, categoryName, discountPrice, productDes, image, detailDes, pro.categoryID\n" +
                                            "FROM tblProducts pro\n" +
                                            "INNER JOIN tblCategory cat\n" +
                                            "ON pro.categoryID = cat.categoryID\n" +
                                            "WHERE price BETWEEN ? AND ?";
    
    public static final String FILTER_BOTH = "SELECT productID, sellerID, name, price, quantity, categoryName, discountPrice, productDes, image, detailDes, pro.categoryID\n" +
                                            "FROM tblProducts pro\n" +
                                            "INNER JOIN tblCategory cat\n" +
                                            "ON pro.categoryID = cat.categoryID\n" +
                                            "WHERE pro.categoryID = ?\n" + 
                                            "AND price BETWEEN ? AND ?";
    
    public static final String GET_PRO_DETAIL = "SELECT productID, sellerID, name, price, quantity, categoryName, discountPrice, productDes, image, detailDes\n" +
                                                "FROM tblProducts pro\n" +
                                                "INNER JOIN tblCategory cat\n" +
                                                "ON pro.categoryID = cat.categoryID\n" + 
                                                "WHERE productID = ?";

    public static final String GET_LIST_RELATE = "SELECT productID, sellerID, name, price, quantity, categoryName, discountPrice, productDes, image, detailDes\n" +
                                                "FROM tblProducts pro\n" +
                                                "INNER JOIN tblCategory cat\n" +
                                                "ON pro.categoryID = cat.categoryID\n" +
                                                "WHERE cat.categoryName = ?\n" + 
                                                "AND productID != ?";
    
    public static final String SEARCH_PRODUCT = "SELECT productID, sellerID, name, price, quantity, categoryName, discountPrice, productDes, image, detailDes, pro.categoryID\n" +
                                                "FROM tblProducts pro\n" +
                                                "INNER JOIN tblCategory cat\n" +
                                                "on pro.categoryID = cat.categoryID\n" +
                                                "where name like ?";
    
    public List<ProductDTO> getListProduct() throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_LIST);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = Integer.parseInt(rs.getString("productID"));
                    int sellerID = Integer.parseInt(rs.getString("sellerID"));
                    String name = rs.getString("name");
                    float price = Float.parseFloat(rs.getString("price"));
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    String category = rs.getString("categoryName");
                    float discountPrice = Float.parseFloat(rs.getString("discountPrice"));
                    String productDes = rs.getString("productDes");
                    String image = rs.getString("image");
                    list.add(new ProductDTO(productID, sellerID, name, price, quantity, category, discountPrice, productDes, image, "."));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }
        return list;
    }
    
    public List<ProductDTO> getFilterProductCategory(int categoryID) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(FILTER_CATE);
                ptm.setInt(1, categoryID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = Integer.parseInt(rs.getString("productID"));
                    int sellerID = Integer.parseInt(rs.getString("sellerID"));
                    String name = rs.getString("name");
                    float price = Float.parseFloat(rs.getString("price"));
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    String category = rs.getString("categoryName");
                    float discountPrice = Float.parseFloat(rs.getString("discountPrice"));
                    String productDes = rs.getString("productDes");
                    String image = rs.getString("image");
                    list.add(new ProductDTO(productID, sellerID, name, price, quantity, category, discountPrice, productDes, image, "."));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }
        return list;
    }
    
    public List<ProductDTO> getFilterProductPrice(int priceMin, int priceMax) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(FILTER_PRICE);
                ptm.setInt(1, priceMin);
                ptm.setInt(2, priceMax);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = Integer.parseInt(rs.getString("productID"));
                    int sellerID = Integer.parseInt(rs.getString("sellerID"));
                    String name = rs.getString("name");
                    float price = Float.parseFloat(rs.getString("price"));
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    String category = rs.getString("categoryName");
                    float discountPrice = Float.parseFloat(rs.getString("discountPrice"));
                    String productDes = rs.getString("productDes");
                    String image = rs.getString("image");
                    list.add(new ProductDTO(productID, sellerID, name, price, quantity, category, discountPrice, productDes, image, "."));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }
        return list;
    }
    
    public List<ProductDTO> getFilterProductBoth(int categoryID, int priceMin, int priceMax) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(FILTER_BOTH);
                ptm.setInt(1, categoryID);
                ptm.setInt(2, priceMin);
                ptm.setInt(3, priceMax);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = Integer.parseInt(rs.getString("productID"));
                    int sellerID = Integer.parseInt(rs.getString("sellerID"));
                    String name = rs.getString("name");
                    float price = Float.parseFloat(rs.getString("price"));
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    String category = rs.getString("categoryName");
                    float discountPrice = Float.parseFloat(rs.getString("discountPrice"));
                    String productDes = rs.getString("productDes");
                    String image = rs.getString("image");
                    list.add(new ProductDTO(productID, sellerID, name, price, quantity, category, discountPrice, productDes, image, "."));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }
        return list;
    }
    
    public ProductDTO getProductDetail(int productID) throws SQLException {
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
                    int sellerID = Integer.parseInt(rs.getString("sellerID"));
                    String name = rs.getString("name");
                    float price = Float.parseFloat(rs.getString("price"));
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    String category = rs.getString("categoryName");
                    float discountPrice = Float.parseFloat(rs.getString("discountPrice"));
                    String productDes = rs.getString("productDes");
                    String image = rs.getString("image");
                    producDetail = new ProductDTO(productID, sellerID, name, price, quantity, category, discountPrice, productDes, image, ".");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }
        return producDetail;
    }
    
    public List<ProductDTO> getListRelateProduct(String category, int productID) throws SQLException {
        List<ProductDTO> listRelate = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_LIST_RELATE);
                ptm.setString(1, category);
                ptm.setInt(2, productID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int relatedID = rs.getInt("productID");
                    int sellerID = Integer.parseInt(rs.getString("sellerID"));
                    String name = rs.getString("name");
                    float price = Float.parseFloat(rs.getString("price"));
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    float discountPrice = Float.parseFloat(rs.getString("discountPrice"));
                    String productDes = rs.getString("productDes");
                    String image = rs.getString("image");
                    listRelate.add(new ProductDTO(relatedID, sellerID, name, price, quantity, category, discountPrice, productDes, image, "."));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }
        return listRelate;
        
    }
    
    public List<ProductDTO> searchProduct(String search) throws SQLException {
        List<ProductDTO> searchList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH_PRODUCT);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = Integer.parseInt(rs.getString("productID"));
                    int sellerID = Integer.parseInt(rs.getString("sellerID"));
                    String name = rs.getString("name");
                    float price = Float.parseFloat(rs.getString("price"));
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    String category = rs.getString("categoryName");
                    float discountPrice = Float.parseFloat(rs.getString("discountPrice"));
                    String productDes = rs.getString("productDes");
                    String image = rs.getString("image");
                    searchList.add(new ProductDTO(productID, sellerID, name, price, quantity, category, discountPrice, productDes, image, "."));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }
        return searchList;
    } 
}
