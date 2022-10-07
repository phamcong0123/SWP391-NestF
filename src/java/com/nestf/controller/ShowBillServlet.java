/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.controller;

import com.nestf.bill.BillDAO;
import com.nestf.bill.BillDTO;
import com.nestf.customer.CustomerDTO;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "ShowBillServlet", urlPatterns = {"/ShowBillServlet"})
public class ShowBillServlet extends HttpServlet {

    private static final String CART = "cart.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = CART;
        try {
            HttpSession session = request.getSession();
            if (session != null) {
                CustomerDTO customer = (CustomerDTO) session.getAttribute("CUSTOMER");
                int customerPhone = customer.getCustomerPhone();
                BillDAO dao = new BillDAO();
                List<BillDTO> ShowBill = dao.getAllBillByPhone(customerPhone);
                List<BillDTO> ShowBillConfirm = dao.getAllBillConfirmAndShipping(customerPhone);
                List<BillDTO> ShowBillCancelled = dao.getAllBillCancelled(customerPhone);
                if (ShowBill != null) {
                    request.setAttribute("SHOWBILL", ShowBill);
                    request.setAttribute("SHOWBILLCONFIRM", ShowBillConfirm);
                    request.setAttribute("SHOWBILLCANCEL", ShowBillCancelled);
                    url = CART;
                }
            }
        } catch (Exception e) {
            log("Error at ShowBillServlet: " + e.toString());
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
