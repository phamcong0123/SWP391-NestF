/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.controller;

import com.nestf.cart.CartDAO;
import com.nestf.customer.CustomerDTO;
import com.nestf.product.ProductDAO;
import com.nestf.product.ProductDTO;
import com.nestf.util.MyAppConstant;
import java.io.IOException;
import java.sql.SQLException;
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        ServletContext context = request.getServletContext();
        
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(MyAppConstant.ShoppingFeatures.SHOPPING_ACTION);
        
        try {
//            1.Cust go to cart place 
            HttpSession session = request.getSession();

//            2. Customer take his cart
            CustomerDTO customer = (CustomerDTO) session.getAttribute("CUSTOMER");
            CartDAO cart = (CartDAO) session.getAttribute("CART");
            if (cart == null) {
                cart = new CartDAO();
            }
            cart.setPhone(customer.getCustomerPhone());
            cart.loadCart();
//            3. Customer take item to his cart
            if (request.getParameter("productID") != null) {
                int productID = Integer.parseInt(request.getParameter("productID"));
                ProductDAO pDao = new ProductDAO();
                ProductDTO product = pDao.getProductDetail(productID);

//                4. Customer drops item to cart
//                Nếu có quantity thì set theo quantity Else +1
                if(request.getParameter("quantity") != null){
                    int amount = Integer.parseInt(request.getParameter("quantity"));
                    
//                    Add product in product detail page Else Add in cart page 
                    if(request.getParameter("addInPDetail") != null){
                        cart.addItemToCartFromPDetail(product, amount);
                    } else{
                       cart.addItemToCart(product, amount); 
                    }
                } else {
                    cart.addItemToCartFromShopPage(product);
                } 
            }
//          5. Update scope
            session.setAttribute("CART", cart);
        } catch (SQLException ex) {
            log("Error at AddtoCartServlet_SQL: " + ex.getMessage());
        } catch (NamingException ex) {
            log("Error at AddtoCartServlet_Naming: " + ex.getMessage());
        } finally {
//            6. forward to shopping page
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
