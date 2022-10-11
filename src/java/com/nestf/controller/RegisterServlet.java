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
            String customerPhone = request.getParameter("customerPhone").trim();
            String password = request.getParameter("password");
            String customerName = request.getParameter("customerName");
            String customerAddress = request.getParameter("customerAddress");
            boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
            int point = Integer.parseInt(request.getParameter("point"));
            CustomerDAO dao = new CustomerDAO();
            CustomerDTO customer = new CustomerDTO(customerPhone, password, customerName, customerAddress, gender, point);
            boolean check = true;
            boolean checkInsert = false;
            CustomerError cusError = new CustomerError();
            boolean checkDup = dao.checkDuplicate(customerPhone);
            if (checkDup) {
                cusError.setCustomerPhoneDuplicate("Số điện thoại đã có người đăng ký!");
                check = false;
            }          
            if (check) {
                checkInsert = dao.insert(customer);
                if (checkInsert) {
                    url = SUCCESS;
                } 
            } else {
                request.setAttribute("CUS_ERROR", cusError);              
            }
        } catch (Exception e) {
            log("Error at Register: " + e.toString());
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
