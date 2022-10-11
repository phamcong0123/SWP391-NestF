/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.controller;

import com.nestf.cart.CartDAO;
import com.nestf.cart.CartItemDTO;
import com.nestf.customer.CustomerDTO;
import com.nestf.product.ProductDAO;
import com.nestf.product.ProductDTO;
import com.nestf.util.MyAppConstant;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
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
 * @author DELL
 */
@WebServlet(name = "AddToCartServlet", urlPatterns = {"/AddToCartServlet"})
public class AddToCartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String CART_PAGE = "cart.jsp";
    private static final String ERROR_PAGE = "error.html";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //ServletContext context = request.getServletContext();
        //Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        //String url = (String) siteMap.get(MyAppConstant.ShoppingFeatures.SHOPPING_ACTION);
        String url = request.getHeader("Referer");
        if (url.contains("productDetail")) {
            url = url.split("&")[0] + "&";
        } else {
            if (url.contains("?")) {
                url = url.split("\\?")[0];
            }
            url += "?";
        }
        String param = "";
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                if (request.getParameter("productID") != null) {
                    int productID = Integer.parseInt(request.getParameter("productID"));
                    ProductDAO pDao = new ProductDAO();
                    ProductDTO product = pDao.getProductDetail(productID);
                    if (product != null) {
                        CustomerDTO customer = (CustomerDTO) session.getAttribute("CUSTOMER");
                        String phone = customer.getCustomerPhone();
                        CartDAO cartDAO = new CartDAO();
                        cartDAO.setPHONE(phone);
                        List<CartItemDTO> cart = (List<CartItemDTO>) session.getAttribute("CART");
                        if (cart == null) {
                            cart = new ArrayList<>();
                            int amount = 1;
                            if (request.getParameter("quantity") != null) {
                                amount = Integer.parseInt(request.getParameter("quantity"));
                            }
                            if (amount <= product.getQuantity()) {
                                CartItemDTO item = new CartItemDTO(product, amount);
                                if (cartDAO.addItemToCart(item)) {
                                    cart.add(item);
                                    param = "fail=false";
                                }
                            } else {
                                param = "fail=maxAmount";
                            }
                        } else {
                            cartDAO.setCarts(cart);
                            if (!cartDAO.checkProductExisted(productID)) {
                                int amount = 1;
                                if (request.getParameter("quantity") != null) {
                                    amount = Integer.parseInt(request.getParameter("quantity"));
                                }
                                if (amount <= product.getQuantity()) {
                                    CartItemDTO item = new CartItemDTO(product, amount);
                                    if (cartDAO.addItemToCart(item)) {
                                        cart.add(item);
                                        param = "fail=false";
                                    }
                                } else {
                                    param = "fail=maxAmount";
                                }
                            } else {
                                CartItemDTO item = cartDAO.getItemByID(productID);
                                int index = cart.indexOf(item);
                                int newAmount;
                                if (request.getParameter("newQuantity") != null) {
                                    newAmount = Integer.parseInt(request.getParameter("newQuantity"));
                                } else {
                                    int amount = 1;
                                    if (request.getParameter("quantity") != null) {
                                        amount = Integer.parseInt(request.getParameter("quantity"));
                                    }
                                    newAmount = item.getAmount() + amount;
                                }
                                if (newAmount <= item.getProduct().getQuantity()) {
                                    item.setAmount(newAmount);
                                    if (cartDAO.updateItemAmount(item)) {
                                        cart.set(index, item);
                                        param = "fail=false";
                                    }
                                } else {
                                    param = "fail=maxAmount";
                                }
                            }
                        }
                        url += param;
                        session.setAttribute("CART", cart);
                    } else {
                        url = ERROR_PAGE;
                    }
                    if ("true".equals(request.getParameter("buynow")) && param.equals("fail=false")) {
                        url = CART_PAGE;
                    }
                }
            }
        } catch (SQLException ex) {
            log("Error at AddtoCartServlet_SQL: " + ex.getMessage());
        } catch (NamingException ex) {
            log("Error at AddtoCartServlet_Naming: " + ex.getMessage());
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
