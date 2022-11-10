/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.dao.ADMIN;

import com.nestf.account.AccountDAO;
import com.nestf.account.AccountDTO;
import com.nestf.post.PostDTO;
import com.nestf.util.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author toanm
 */
public class PostDAOAdmin {

    private static final String POST_LIST_ACTIVE = "SELECT [postID],[adPhone],[title],[dateTime],[status],[filePath],[image] FROM [NestF].[dbo].[tblPost] WHERE status=1 ORDER BY dateTime DESC ";
    private static final String POST_LIST_NONACTIVE = "SELECT [postID],[adPhone],[title],[dateTime],[status],[filePath],[image] FROM [NestF].[dbo].[tblPost] WHERE status=0 ORDER BY dateTime DESC ";
    public static final String SET_STATUS_TRUE = "UPDATE tblPost\n"
            + "SET status = 1\n"
            + "WHERE postID = ?";

    public static final String SET_STATUS_FALSE = "UPDATE tblPost\n"
            + "SET status = 0\n"
            + "WHERE postID = ?";
    private static final String ADD_POST = "INSERT INTO tblPost (adPhone, title, dateTime, status, filePath , image) "
            + " VALUES(?,?,?,?,?,?)";
    private static final String CHECK_DUPLICATE_POSTID = "SELECT postID from tblPost WHERE postID = ?";

    public static List<PostDTO> getPostListActive() throws SQLException, NamingException {
        List<PostDTO> list = new ArrayList();
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                stm = conn.createStatement();
                rs = stm.executeQuery(POST_LIST_ACTIVE);
                while (rs.next()) {
                    int postID = rs.getInt("postID");
                    String phone = rs.getString("adPhone");
                    AccountDAO dao = new AccountDAO();
                    AccountDTO seller = dao.getUserByPhone(phone);
                    String title = rs.getString("title");
                    Date date = new Date(rs.getTimestamp("dateTime").getTime());
                    boolean status = rs.getBoolean("status");
                    String filePath = rs.getString("filePath");
                    String image = rs.getString("image");
                    list.add(new PostDTO(postID, seller, title, date, status, filePath, image));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public static PostDTO getPostListActiveByID(int postID) throws SQLException, NamingException {
        PostDTO post = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(POST_LIST_ACTIVE);
                ptm.setInt(1, postID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String phone = rs.getString("adPhone");
                    AccountDAO dao = new AccountDAO();
                    AccountDTO seller = dao.getUserByPhone(phone);
                    String title = rs.getString("title");
                    Date date = new Date(rs.getTimestamp("dateTime").getTime());
                    boolean status = rs.getBoolean("status");
                    String filePath = rs.getString("filePath");
                    String image = rs.getString("image");
                    post = new PostDTO(postID, seller, title, date, status, filePath, image);
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

    public static boolean acceptPost(PostDTO dto) throws SQLException, NamingException {
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
                statement.setInt(1, dto.getPostID());

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

    public void acceptedPost(int postID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement statement = null;

        try {
//            1. make connection
            con = DBHelper.makeConnection();

//            2. Create sql string 
            if (con != null) {
                statement = con.prepareStatement(SET_STATUS_TRUE);
                statement.setInt(1, postID);

//          4. Execute Query
                int affectRow = statement.executeUpdate();

//          5. Process result
            }// end if connection is not null

        } finally {
            if (statement != null) {
                statement.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void pendingPost(int postID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement statement = null;

        try {
//            1. make connection
            con = DBHelper.makeConnection();

//            2. Create sql string 
            if (con != null) {
                statement = con.prepareStatement(SET_STATUS_FALSE);
                statement.setInt(1, postID);

//          4. Execute Query
                int affectRow = statement.executeUpdate();

//          5. Process result
            }// end if connection is not null

        } finally {
            if (statement != null) {
                statement.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public static boolean disablePost(PostDTO dto) throws SQLException, NamingException {
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
                statement.setInt(1, dto.getPostID());

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

    public static List<PostDTO> getPostListNonActive() throws SQLException, NamingException {
        List<PostDTO> list = new ArrayList();
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                stm = conn.createStatement();
                rs = stm.executeQuery(POST_LIST_NONACTIVE);
                while (rs.next()) {
                    int postID = rs.getInt("postID");
                    String phone = rs.getString("adPhone");
                    AccountDAO dao = new AccountDAO();
                    AccountDTO seller = dao.getUserByPhone(phone);
                    String title = rs.getString("title");
                    Date date = new Date(rs.getTimestamp("dateTime").getTime());
                    boolean status = rs.getBoolean("status");
                    String filePath = rs.getString("filePath");
                    String image = rs.getString("image");
                    list.add(new PostDTO(postID, seller, title, date, status, filePath, image));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        return list;

    }

    public PostDTO insertPost(PostDTO dto) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement ptm = null;
        if (dto == null) {
            return null;
        }
        try {
//        1. Make connection
            con = DBHelper.makeConnection();
            if (con != null) {
//          3. Create Statement Object
                ptm = con.prepareStatement(ADD_POST);
                ptm.setInt(1, dto.getPostID());
                ptm.setString(2, dto.getSeller().getPhone());
                ptm.setString(3, dto.getTitle());
                ptm.setDate(4, (Date) dto.getDateTime());
                ptm.setBoolean(5, dto.isStatus());
                ptm.setString(6, dto.getFilePath());
                ptm.setString(7, dto.getImage());

//          4. Execute Query
                int affectRow = ptm.executeUpdate();
                if (affectRow > 0) {
                    int postID = getPostIDInDB(dto); // lay productID
                    dto.setPostID(postID);
                    return dto;
                }
            }
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    private int getPostIDInDB(PostDTO dto) throws SQLException, NamingException {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement statement = null;
        if (dto == null) {
            return 0;
        }

        try {
//            1. make connection
            con = DBHelper.makeConnection();

//            2. Create sql string 
            if (con != null) {
                String GET_PRODUCTID_IN_DB = "SELECT postID\n"
                        + "FROM tblPost p\n"
                        + "INNER JOIN tblAccount a"
                        + "ON a.adPhone=p.phone"
                        + "WHERE a.phone = ? \n"
                        + "AND p.title = ?\n"
                        + "AND p.dateTime = ? \n"
                        + "AND p.status = ? \n"
                        + "AND p.filePath = ?\n"
                        + "AND p.image = ? \n";

                statement = con.prepareStatement(GET_PRODUCTID_IN_DB);
                statement.setString(1, dto.getSeller().getPhone());
                statement.setString(2, dto.getTitle());
                statement.setDate(3, (java.sql.Date) dto.getDateTime());
                statement.setBoolean(4, dto.isStatus());
                statement.setString(5, dto.getFilePath());
                statement.setString(6, dto.getImage());
//          4. Execute Query
                rs = statement.executeQuery();

//          5. Process result
                if (rs.next()) {
                    return rs.getInt("postID");
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
        return 0;
    }

    public boolean checkDuplicatePostID(int postID) throws SQLException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                statement = conn.prepareStatement(CHECK_DUPLICATE_POSTID);
                statement.setInt(1, postID);
                rs = statement.executeQuery();
                if (rs.next()) {
                    result = true;
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            };
            if (conn != null) {
                conn.close();
            };

        }
        return result;
    }
}
