/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.controller;

import com.nestf.cart.CartDAO;
import com.nestf.cart.CartItemDTO;
import com.nestf.util.MyAppConstant;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.naming.NamingException;
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
@WebServlet(name = "RemoveFromCartServlet", urlPatterns = {"/RemoveFromCartServlet"})
public class RemoveFromCartServlet extends HttpServlet {

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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

//        ServletContext context = request.getServletContext();
//        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = CART_PAGE;

        try {
//            1 Customer goes to their cart place
            HttpSession session = request.getSession(false);

            if (session != null) {
//                    2. Customer take their cart
                List<CartItemDTO> cart = (List<CartItemDTO>) session.getAttribute("CART");
                if (cart != null) {
                    String[] removedItem = request.getParameterValues("productID");
                    if (removedItem != null) {
                        CartDAO dao = new CartDAO();                       
                        for (String product : removedItem) {
                            if(dao.removeItemFromCart(Integer.parseInt(product))){
                                dao.setCarts(cart);
                                CartItemDTO item = dao.getItemByID(Integer.parseInt(product));
                                cart.remove(item);
                            }
                        }
                        if (cart.size()>0) session.setAttribute("CART", cart);
                        else session.removeAttribute("CART");
                    }
                }

            }
        } catch (SQLException ex) {
            log("Error at RemovedFromCartServlet_SQL: " + ex.getMessage());
        } catch (NamingException ex) {
            log("Error at RemovedFromCartServlet_Naming: " + ex.getMessage());
        } finally {
//           6. refresh - call view cart again
//            String urlRewriting = (String) siteMap.get(MyAppConstant.RemoveItemsFeatures.CART_PAGE);
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
