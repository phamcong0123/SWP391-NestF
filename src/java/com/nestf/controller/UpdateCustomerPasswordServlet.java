/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.controller;

import com.nestf.customer.CustomerDAO;
import com.nestf.customer.CustomerDTO;
import com.nestf.customer.CustomerError;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "UpdateCustomerPasswordServlet", urlPatterns = {"/UpdateCustomerPasswordServlet"})
public class UpdateCustomerPasswordServlet extends HttpServlet {
    
    private static final String ERROR = "account.jsp";
    private static final String SUCCESS = "LogoutServlet";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;        
        try {            
            HttpSession session = request.getSession();
            CustomerDTO customer = (CustomerDTO) session.getAttribute("CUSTOMER");
            String password = request.getParameter("password");
            String newPass = request.getParameter("newPass").trim();          
            boolean check = true;
            String curPassword = customer.getPassword(); 
            CustomerError cusError = new CustomerError();
            if (curPassword.equals(newPass)) {
                check = false;             
                cusError.setPasswordDuplicate("Mật khẩu mới không khả dụng!");
            }
            if (!curPassword.equals(password)){
                check = false;
                cusError.setPasswordWrong("Mật khẩu hiện tại không chính xác!");
            }
            if (check) {               
                String phone = customer.getCustomerPhone();
                CustomerDAO dao = new CustomerDAO();
                boolean checkDao = dao.updateCusPassword(phone, newPass);
                if (checkDao) {
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("ERROR", cusError);
            }
        } catch (Exception e) {
            log("Error at UpdateCustomerPassword: " + e.toString());
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
