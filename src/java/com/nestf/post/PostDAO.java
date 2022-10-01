/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.post;

import com.nestf.util.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author Admin
 */
public class PostDAO {

    private static String POST_LIST = "SELECT [postID],[sellerID],[title],[dateTime],[status],[filePath],[image] FROM [NestF].[dbo].[tblPost]";

    public List<PostDTO> postList() throws SQLException, NamingException {
        List<PostDTO> postList = new ArrayList();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(POST_LIST);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int postID = Integer.parseInt(rs.getString("postID"));
                    int sellerID = Integer.parseInt(rs.getString("sellerID"));
                    String title = rs.getString("title");
                    Date dateTime = rs.getDate("dateTime");
                    boolean status = Boolean.parseBoolean(rs.getString("status"));
                    String filePath = rs.getString("filePath");
                    String image = rs.getString("image");
                    postList.add(new PostDTO(postID, sellerID, title, dateTime, status, filePath, image));
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
        return postList;
    }

    private static String POST = "SELECT [postID],[sellerID],[title],[dateTime],[status],[filePath],[image] FROM [NestF].[dbo].[tblPost] WHERE [postID] = ?";

    public PostDTO getPost(int postID) throws NamingException, SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        PostDTO post = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(POST);
                ptm.setInt(1,postID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    int sellerID = rs.getInt("sellerID");
                    String title = rs.getString("title");
                    Date date = new Date(rs.getDate("dateTime").getTime());
                    boolean status = rs.getBoolean("status");
                    String filePath = rs.getString("filePath");
                    String image = rs.getString("image");
                    post = new PostDTO(postID, sellerID, title, date, status, filePath, image);
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
        return post;
    }
}
