/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.controller;

import com.nestf.customer.CustomerDAO;
import com.nestf.customer.CustomerDTO;
import com.nestf.voucher.VoucherDAO;
import com.nestf.voucher.VoucherDTO;
import com.nestf.vouchertype.VoucherTypeDAO;
import com.nestf.vouchertype.VoucherTypeDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
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
@WebServlet(name = "BuyVoucherServlet", urlPatterns = {"/BuyVoucherServlet"})
public class BuyVoucherServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String LOAD_VOUCHER = "LoadVoucherServlet";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOAD_VOUCHER;
        try {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession(false);
            if (session != null) {
                CustomerDTO customer = (CustomerDTO) session.getAttribute("CUSTOMER");
                int customerPoint = customer.getPoint();
                int typeID = Integer.parseInt(request.getParameter("typeID"));
                VoucherTypeDAO typeDAO = new VoucherTypeDAO();
                int requiredPoint = typeDAO.getVoucher(typeID).getPoint();
                if (customerPoint >= requiredPoint) {
                    String phone = customer.getCustomerPhone();
                    VoucherDAO dao = new VoucherDAO();
                    VoucherDTO voucher = dao.addVoucherToWaller(typeID);
                    if (voucher != null) {
                        List<VoucherDTO> voucherWallet = (List<VoucherDTO>) session.getAttribute("VOUCHER_WALLET");
                        voucherWallet.add(voucher);
                        int newPoint = customerPoint - requiredPoint;
                        int newQuantity = typeDAO.getVoucher(typeID).getQuantity() - 1;
                        CustomerDAO customerDAO = new CustomerDAO();
                        if (customerDAO.buyVoucher(phone, newPoint) && typeDAO.updateQuantity(typeID, newQuantity)) {
                            customer.setPoint(newPoint);
                            session.setAttribute("CUSTOMER", customer);
                            url += "?success=true";                        
                        }
                    } else {
                        url += "?success=false";
                    }
                } else {
                    url += "?success=false";
                }
            }
        } catch (NamingException ex) {
            Logger.getLogger(BuyVoucherServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BuyVoucherServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            response.sendRedirect(url);
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
