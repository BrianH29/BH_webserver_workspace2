/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.57
 * Generated at: 2020-09-23 07:06:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kh.member.model.vo.Member;

public final class boardEnrollForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/views/board/../common/menubar.jsp", Long.valueOf(1600236797534L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.kh.member.model.vo.Member");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write(".outer {\r\n");
      out.write("\tbackground: black;\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("\tmargin: auto;\r\n");
      out.write("\twidth: 900px;\r\n");
      out.write("\theight: 500px;\r\n");
      out.write("\tmargin-top: 50px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#insertForm>table {\r\n");
      out.write("\tborder: 1px solid white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#insertForm>table input, #insertForm>table textarea {\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\tbox-sizing: border-box;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\r\n");

	String contextPath = request.getContextPath();
	
	Member loginUser = (Member)session.getAttribute("loginUser");
	// 로그인 전 : null
	// 로그인 후 : 로그인 성공한 회원정보들이 담겨있는 객체  
	
	String alertMsg = (String)session.getAttribute("alertMsg");
	// > 서비스 요청 전: null
	// > 서비스 요청 성공 후 : alert띄어줄 메시지 문구 

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("#loginForm, #userInfo {\r\n");
      out.write("\tfloat: right;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#loginForm button {\r\n");
      out.write("\tborder: none;\r\n");
      out.write("\tpadding: 5px;\r\n");
      out.write("\tborder-radius: 5px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#loginForm button:first-child {\r\n");
      out.write("\tbackground: yellowgreen;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#loginForm button:last-child {\r\n");
      out.write("\tbackground: orangered;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#userInfo a {\r\n");
      out.write("\tcolor: black;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".navWrap {\r\n");
      out.write("\tbackground: black;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".menu {\r\n");
      out.write("\tdisplay: table-cell;\r\n");
      out.write("\theight: 50px;\r\n");
      out.write("\twidth: 150px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".menu a {\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\tfont-size: 16px;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight: 100%;\r\n");
      out.write("\tline-height: 50px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".menu a:hover{text-decoration:none; color:white;}\r\n");
      out.write(".menu:hover {\r\n");
      out.write("\tbackground: darkgrey;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\tvar msg = \"");
      out.print( alertMsg );
      out.write("\"; //자바스크립트 변수\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(msg != \"null\"){ // msg가 담겨있을 경우 \r\n");
      out.write("\t\t\talert(msg);\r\n");
      out.write("\t\t\t//알람창 띄어준 후에 session에 담긴 메세지 지워야됨\r\n");
      out.write("\t\t\t//안그러면 menubar.jsp가 포함되어있는 페이지 열때마나다 alert 계속뜰거임\r\n");
      out.write("\t\t\t");
 session.removeAttribute("alertMsg"); 
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});//e.function\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<h1 align=\"center\">Welcome JSP World!!</h1>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"loginArea\">\r\n");
      out.write("\r\n");
      out.write("\t\t");
 if(loginUser == null) { 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- 1. 로그인 전에 보여지는 로그인 form -->\r\n");
      out.write("\t\t<form id=\"loginForm\" action=\"");
      out.print(request.getContextPath() );
      out.write("/login.me\" method=\"post\">\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th><label for=\"userId\">ID : </label></th>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" id=\"userId\" name=\"userId\" required></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th><label for=\"userPwd\">password:</label></th>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"password\" id=\"userPwd\" name=\"userPwd\"\r\n");
      out.write("\t\t\t\t\t\trequired></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th colspan=\"2\" style=\"text-align:center;\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"submit\">LOGIN</button>\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" onclick=\"enrollPage();\">REGISTER</button>\r\n");
      out.write("\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\t\tfunction enrollPage(){\r\n");
      out.write("\t\t\t\t//location.href=\"/jsp/views/member/memberEnrollForm.jsp\";\r\n");
      out.write("\t\t\t\t// 웹 어플리케이션의 디렉토리 구조가 url에 노출되면 보안에 위험\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t// 단순한 정적인 페이지 이동이라고 해도 반드시 servlet 거쳐갈것!! => url에\t 서블릿 매핑값만 노출됨! \r\n");
      out.write("\t\t\t\tlocation.href=\"");
      out.print(request.getContextPath());
      out.write("/enrollForm.me\";\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t");
} else { 
      out.write("\r\n");
      out.write("\t\t<!-- 2.로그인 성공 후 보여지는 div-->\r\n");
      out.write("        <div id=\"userInfo\">\r\n");
      out.write("            <b>");
      out.print(loginUser.getUserName() );
      out.write("님</b>의 방문을 환영합니다. <br><br>\r\n");
      out.write("\r\n");
      out.write("            <div align=\"center\">\r\n");
      out.write("                <a href=\"");
      out.print( contextPath );
      out.write("/myPage.me\">MyPage</a>\r\n");
      out.write("                <a href=\"");
      out.print(request.getContextPath() );
      out.write("/logout.me\">Logout</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div> <!-- e.loginArea -->\r\n");
      out.write("\r\n");
      out.write("\t<br clear=\"both\">\r\n");
      out.write("\t<!-- 위 내용들 무시-->\r\n");
      out.write("\t<br>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"navWrap\" align=\"center\">\r\n");
      out.write("\t\t<div class=\"menu\">\r\n");
      out.write("\t\t\t<a href=\"");
      out.print( contextPath);
      out.write("\">HOME</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"menu\">\r\n");
      out.write("\t\t\t<a href=\"");
      out.print( contextPath );
      out.write("/list.no\">공지사항</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"menu\">\r\n");
      out.write("\t\t\t<a href=\"");
      out.print( contextPath);
      out.write("/list.bo?currentPage=1\">일반게시판</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"menu\">\r\n");
      out.write("\t\t\t<a href=\"");
      out.print(contextPath);
      out.write("/list.th\">사진게시판</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\t<div class=\"outer\">\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\t\t<h2 align=\"center\">게시판 작성하기</h2>\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\r\n");
      out.write("\t\t<form action=\"");
      out.print(contextPath );
      out.write("/insert.bo\" id=\"insertForm\" method=\"POST\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t\t\t<!-- 카테고리, 제목, 내용, 첨부파일, 작성자회원번호-->\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"userNo\" value=\"");
      out.print( loginUser.getUserNo() );
      out.write("\">\r\n");
      out.write("\t\t\t<table align=\"center\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th width=\"70\">분야</th>\r\n");
      out.write("\t\t\t\t\t<td width=\"500\"><select name=\"category\" id=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"10\">공통</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"20\">운동</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"30\">등산</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"40\">게임</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"50\">낚시</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"60\">요리</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"70\">기타</option>\r\n");
      out.write("\t\t\t\t\t</select></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th>제목</th>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"title\" required /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th>내용</th>\r\n");
      out.write("\t\t\t\t\t<td><textarea name=\"content\" rows=\"10\" style=\"resize: none\"></textarea>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th>첨부파일</th>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"file\" name=\"upfile\" /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<br />\r\n");
      out.write("\t\t\t<div align=\"center\">\r\n");
      out.write("\t\t\t\t<button type=\"submit\">작성하기</button>\r\n");
      out.write("\t\t\t\t<button type=\"reset\">취소하기</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
