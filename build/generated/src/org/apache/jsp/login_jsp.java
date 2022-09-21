package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test_nobody.release();
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <title>Đăng nhập</title>\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\" https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css\" />\n");
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
      out.write("                    <li class=\"nav-item col-7 d-inline-block text-center\">\n");
      out.write("                    </li>         \n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"d-inline-block col-8\" id=\"login-form\">\n");
      out.write("            <h1 class=\"text-center\">Đăng nhập</h1><br>\n");
      out.write("            <form action=\"loginAction\" method=\"post\">\n");
      out.write("                <div class=\"m-3 d-inline-block col-2\">Số điện thoại</div><input type=\"text\" name=\"customerPhone\" class=\"col-3\"><br>\n");
      out.write("                <div class=\"m-3 d-inline-block col-2\">Mật khẩu</div><input type=\"text\"name=\"password\" class=\"col-3\"><br>   \n");
      out.write("                ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                <a href=\"forgotPassword\" class=\"nav-link col-5 d-inline-block \" id=\"forgetPass\">Quên mật khẩu</a><br>\n");
      out.write("                <a href=\"register\"><input type=\"button\" value=\"ĐĂNG KÝ\" id=\"link-button\"></a>\n");
      out.write("                <input type=\"submit\" value=\"ĐĂNG NHẬP\" id=\"color-button\">\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"d-inline-block\" id=\"sidepic\">\n");
      out.write("            <img\n");
      out.write("                src=\"img/loginPic.jpg\">\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test_nobody.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(false);
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test_nobody.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test_nobody.reuse(_jspx_th_c_if_0);
    return false;
  }
}
