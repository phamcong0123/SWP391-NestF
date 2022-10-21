/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.controller;

import com.nestf.account.AccountDAO;
import com.nestf.account.AccountDTO;
import com.nestf.account.AccountError;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    private static final String ERROR = "register.jsp";
    private static final String SUCCESS = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = ERROR;
        try {
            String phone = request.getParameter("phone").trim();
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
            int point = Integer.parseInt(request.getParameter("point"));
            String role = "US";
            AccountError error = new AccountError();
            AccountDAO dao = new AccountDAO();
            AccountDTO acc = new AccountDTO(phone, password, name, address, gender, point, role);
            boolean check = true;
            boolean checkInsert = false;
            boolean checkDup = dao.checkDuplicate(phone);
            if (checkDup) {
                check = false;
                error.setName("Số điện thoại đã có người đăng ký!");
            }
            if (check) {
                checkInsert = dao.insert(acc);
                if (checkInsert) {
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("CUS_ERROR", error);
            }
        } catch (Exception e) {
            log("Error at RegisterServlet: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
