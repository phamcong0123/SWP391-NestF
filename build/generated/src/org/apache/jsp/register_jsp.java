package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <title>Đăng ký</title>\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Poppins\">\n");
      out.write("        <link href=\"css/nestf.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"navbar\">\n");
      out.write("            <nav class=\"navbar-expand bg-light navbar-light\">\n");
      out.write("                <ul class=\"navbar\">\n");
      out.write("                    <li class=\"nav-item col-2 d-inline-block\">\n");
      out.write("                        <a href=\"home\"><img src=\"img/logo.png\" id=\"logo\" class=\"col-3\"></a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item col-1 d-inline-block\">\n");
      out.write("                        <a href=\"shop\" class=\"nav-link\">Shop</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item col-1 d-inline-block\">\n");
      out.write("                        <a href=\"handbook\" class=\"nav-link\">Cẩm nang</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item col-1 d-inline-block\">\n");
      out.write("                        <a href=\"about\" class=\"nav-link\">Về chúng tôi</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item col-3 d-inline-block text-center\">                      \n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item col-2 d-inline-block text-center\">\n");
      out.write("                        <div ><a href=\"login\" class=\"nav-link\"><i class=\"fas fa-user    \"></i>Đăng nhập</a></div>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item col-1 d-inline-block text-center\">                      \n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item col-1 d-inline-block text-center\">\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"d-inline-block container-fluid text-center\" id=\"register-form\">\n");
      out.write("            <img src=\"img/account.svg\" alt=\"\">\n");
      out.write("            <h1>Đăng ký</h1>\n");
      out.write("            <form action=\"registerAction\" method=\"post\">\n");
      out.write("                <div class=\"m-3 d-inline-block col-2\">Họ và tên</div><input type=\"text\" name=\"customerName\"><br>\n");
      out.write("                <div class=\"m-3 d-inline-block col-2\">Giới tính</div>          \n");
      out.write("                <div id=\"gender\">\n");
      out.write("                    <input type=\"radio\" id=\"male\" name=\"gender\" value=\"1\">\n");
      out.write("                    <label for=\"male\">Nam&emsp;</label>\n");
      out.write("                    <input type=\"radio\" id=\"female\" name=\"gender\" value=\"0\">\n");
      out.write("                    <label for=\"female\">Nữ</label>\n");
      out.write("                </div><br>\n");
      out.write("                <div class=\"m-3 d-inline-block col-2\">Số điện thoại</div><input type=\"text\" name=\"customerPhone\"><br>\n");
      out.write("                <div class=\"m-3 d-inline-block col-2\">Mật khẩu</div><input type=\"text\" name=\"password\"><br>\n");
      out.write("                <div class=\"m-3 d-inline-block col-2\">Xác nhận mật khẩu</div><input type=\"text\" name=\"confirm\"><br>\n");
      out.write("                <div class=\"d-inline-block col-2\">Địa chỉ</div><input type=\"text\" name=\"customerAddress\"><br>\n");
      out.write("                <a href=\"home\"><input type=\"button\" value=\"HUỶ\" id=\"link-button\"></a>\n");
      out.write("                <input type=\"submit\" value=\"ĐĂNG KÝ\" id=\"color-button\">\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
