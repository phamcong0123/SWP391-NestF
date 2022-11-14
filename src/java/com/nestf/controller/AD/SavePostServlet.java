/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.controller.AD;

import com.nestf.account.AccountDAO;
import com.nestf.account.AccountDTO;
import com.nestf.dao.ADMIN.PostDAOAdmin;
import com.nestf.dao.ADMIN.ProductDAOAdmin;
import com.nestf.error.ADMIN.PostError;
import com.nestf.post.PostDTO;
import com.nestf.util.MyAppConstant;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author toanm
 */
@WebServlet(name = "SavePostServlet", urlPatterns = {"/SavePostServlet"})
public class SavePostServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, NamingException {
        request.setCharacterEncoding("utf-8");
        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITEMAP");
        String url = (String) siteMap.get(MyAppConstant.AdminFeatures.EDIT_POST_PAGE);
        String phone = request.getParameter("adPhone");
        AccountDAO dao = new AccountDAO();
        AccountDTO admin = dao.getUserByPhone(phone);
        String title = request.getParameter("title");
        boolean status = true;
        String content = request.getParameter("content");
        String thumbnail = request.getParameter("thumbnail");
        PostError error = new PostError();
        boolean foundErr = false;

        try {
            if (title.isEmpty()) {
                error.setTitle("Nhập tiêu đề bài viết!");
                foundErr = true;
            }
            if (content.isEmpty()) {
                error.setContent("Nhập nội dung bài viết!");
                foundErr = true;
            }
            if (thumbnail.isEmpty()) {
                error.setThumbnail("Nhập đường dẫn ảnh của bài viết!");
                foundErr = true;
            }
            PostDTO dto = new PostDTO(admin, title, status, content, thumbnail);
            request.setAttribute("POST_DETAIL", dto);
            if (foundErr) {
                request.setAttribute("POST_ERROR", error);
                url = (String) siteMap.get(MyAppConstant.AdminFeatures.EDIT_POST_PAGE);
            } else {
                HttpSession session = request.getSession();
                if (dto != null) {
                    request.setAttribute("PREVIEW_POST", dto);
                    PostDAOAdmin daoA = new PostDAOAdmin();
                    PostDTO post = (PostDTO) request.getAttribute("POST_DETAIL");
                    post = daoA.updatePost(dto);
                    if (post != null) {
                        request.setAttribute("POST_DETAIL", post);
                    }
                    List<PostDTO> listActivePost = PostDAOAdmin.getPostListActive();
                    session.setAttribute("LIST_POST", listActivePost);
                    List<PostDTO> listPending = PostDAOAdmin.getPostListNonActive();
                    session.setAttribute("LIST_PENDING_POST", listPending);

                }
            }
        } catch (NamingException ex) {
            log("AddNewPostServlet _ Naming " + ex.getMessage());
        } catch (SQLException ex) {
            log("AddNewPostServlet _ SQL " + ex.getMessage());
        } finally {

            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SavePostServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(SavePostServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SavePostServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(SavePostServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
