/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.controller.AD;

import com.nestf.account.AccountDTO;
import com.nestf.category.CategoryDAO;
import com.nestf.category.CategoryDTO;
import com.nestf.dao.ADMIN.ProductDAOAdmin;
import com.nestf.dao.ADMIN.SellerDAOAdmin;
import com.nestf.error.ADMIN.ProductError;
import com.nestf.product.ProductDTO;
import com.nestf.util.MyAppConstant;
import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet(name = "AddNewProductServlet", urlPatterns = {"/AddNewProductServlet"})
public class AddNewProductServlet extends HttpServlet {

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
        request.setCharacterEncoding("utf-8");
        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITEMAP");
        String url = (String) siteMap.get(MyAppConstant.AdminFeatures.ADD_PRODUCT_PAGE);

        String name = request.getParameter("txtName");
        double price = !request.getParameter("numprice").isEmpty() ? Double.parseDouble(request.getParameter("numprice")) : 0;
        int quantity = !request.getParameter("quantity").isEmpty() ? Integer.parseInt(request.getParameter("quantity")) : 0;
        double discountPrice = !request.getParameter("disPrice").isEmpty() ? Double.parseDouble(request.getParameter("disPrice")) : 0;
        String productDes = request.getParameter("productdesc");
        String image1 = request.getParameter("image1");
        String image2 = request.getParameter("image2");
        String image3 = request.getParameter("image3");
        String image4 = request.getParameter("image4");
        String image5 = request.getParameter("image5");
        String detailDes = request.getParameter("detaildesc");
        boolean status = true;
        String categoryName = request.getParameter("categoryName");
        String selName = request.getParameter("selName");

        String btAction = request.getParameter("btAction");

        ProductError error = new ProductError();
        boolean foundErr = false;

        try {
            if (name.isEmpty()) {
                error.setName("Nhập tên sản phẩm!");
                foundErr = true;
            }
            if (price == 0.0) {
                error.setPrice("Nhập giá sản phẩm!");
                foundErr = true;
            }
            if (quantity == 0) {
                error.setQuantity("Nhập số lượng!");
                foundErr = true;
            }
            if (discountPrice > price) {
                error.setDiscountPrice("Giá mới thấp hơn giá gốc hoặc không có");
                foundErr = true;
            }
            if (productDes.isEmpty()) {
                error.setProductDes("Nhập mô tả sản phẩm!");
                foundErr = true;
            }
            if (image1.isEmpty() && image2.isEmpty() && image3.isEmpty() && image4.isEmpty() && image5.isEmpty()) {
                error.setImage("Nhập link ảnh");
                foundErr = true;
            }
            if (categoryName.isEmpty()) {
                error.setCategory("Chọn category name");
                foundErr = true;
            }
            if (selName.isEmpty()) {
                error.setSellerID("Chọn seller");
                foundErr = true;
            }
            CategoryDTO category = CategoryDAO.getCategoryID(categoryName);
//            TH thêm mới category
            if (category == null) {
                category = new CategoryDTO(categoryName);
            }
            String[] imageLink = {image1, image2, image3, image4, image5};
            String selPhone = null;
            if(!selName.isEmpty()){
                selPhone = SellerDAOAdmin.getSellerGivenName(selName).getPhone();
            }
            if (selPhone == null) {
                error.setSellerID("Chọn seller");
                foundErr = true;
            }
            ProductDTO dto = new ProductDTO( selPhone, name, price, quantity, category, discountPrice, productDes, detailDes, status, imageLink, selName);
            request.setAttribute("PRODUCT_DETAIL", dto);

            if (foundErr) {
                request.setAttribute("PRODUCT_ERR", error);
                url = (String) siteMap.get(MyAppConstant.AdminFeatures.ADD_PRODUCT_PAGE);
            } else {
                HttpSession session = request.getSession();
//                1. Tạo Productdto tạm thời chứa các entity 
                if (dto != null) {
                    request.setAttribute("PREVIEW_PRODUCT", dto);
                }
                if (btAction.equalsIgnoreCase("Submit")) {
//                    1. Xem same category ko
                    
//                    Nếu dto ko co cateID => new category => insert db 
                    if (dto.getCategory().getCategoryID() == 0) {
                        CategoryDAO.insertCategory(dto.getCategory().getCategoryName());
                    }
                    ProductDAOAdmin dao = new ProductDAOAdmin();
                    String image = "";
                    for (int i = 0; i < imageLink.length; i++) {
                        if (imageLink[i] != null) {
                            image += imageLink[i] + ProductDAOAdmin.INSERT_REGEX;
                        }
                    }
                    dto.setImage(image);
                    
//                2. Insert dto vào DB
//                3. Update lai product detail
                    ProductDTO productDetail = dao.insertProduct(dto);
                    if (productDetail != null) {
                        request.setAttribute("PRODUCT_DETAIL", productDetail);
                        request.setAttribute("SUBMIT_PRODUCT", productDetail);
                    }
                    
//                4. Add product to pending or accepted 
                    List<ProductDTO> listAccepted;
                    List<ProductDTO> listPending;

                    listAccepted = ProductDAOAdmin.getListActiveProduct();
                    session.setAttribute("LIST_PRODUCT", listAccepted);

                    listPending = ProductDAOAdmin.getListNonActiveProduct();
                    session.setAttribute("LIST_PENDING", listPending);

                    List<AccountDTO> listSeller = SellerDAOAdmin.getListSellerOnly();
                    session.setAttribute("LIST_SELLER", listSeller);

                    List<CategoryDTO> listCategory = CategoryDAO.getListCategory();
                    session.setAttribute("LIST_CATEGORY", listCategory);
                }
            }

        } catch (NamingException ex) {
            log("AddNewProductServlet _ Naming " + ex.getMessage());
        } catch (SQLException ex) {
            log("AddNewProductServlet _ SQL " + ex.getMessage());
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
