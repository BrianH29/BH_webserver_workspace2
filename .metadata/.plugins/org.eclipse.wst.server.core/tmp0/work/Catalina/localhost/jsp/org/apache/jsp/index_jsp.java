/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.57
 * Generated at: 2020-09-24 00:11:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kh.member.model.vo.Member;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/views/common/menubar.jsp", Long.valueOf(1600236797534L));
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
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!-- \r\n");
      out.write("\t\t* 회원서비스\t\t|  C(Insert)  |  R(Select)  |  U(Update)  |  D(Delete)\r\n");
      out.write("\t\t=========================================================================\r\n");
      out.write("\t\t    로그인\t\t\t|             |      O      |             |\r\n");
      out.write("\t\t   회원가입\t\t\t|      O      |             |             |\r\n");
      out.write("\t\t 마이페이지\t\t|\t\t\t  |      O\t\t|\t\t\t  |\r\n");
      out.write("\t\t  정보변경\t\t\t|\t\t\t  |\t\t\t\t|      O      |\r\n");
      out.write("\t\t [아이디중복체크]  |             |      O      |             |\r\n");
      out.write("\t\t 회원탈퇴                  |   \t\t  |   \t\t    |\t    O     |\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t \r\n");
      out.write("\t\t* 공지사항서비스 - 공지사항리스트조회(R)/상세조회(R)/공지사항작성(C)/공지사항수정(U)/공지사항삭제(U)\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t* 일반게시판서비스 - 게시판리스트조회(R)/상세조회(R)/게시판작성(C)/게시판수정(U)/게시판삭제(U)/[댓글리스트조회(R)/댓글작성(C)]\r\n");
      out.write("\t\t* 사진게시판서비스 - 썸네일리스트조회(R)/상세조회(R)/게시판작성,첨부파일업로드(C)\r\n");
      out.write("\t\t\r\n");
      out.write("\t-->\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- \r\n");
      out.write("\t\t* DB 구축하고 오기\r\n");
      out.write("\t\r\n");
      out.write("\t\t* 제일 먼저 셋팅 할 것들 \r\n");
      out.write("\t\t1. 이클립스 환경 Java EE 환경으로 셋팅하기\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t2. 보여지는 UI 탭들 셋팅하기  [Window - Show View]\r\n");
      out.write("\t\t   Project Explorer, Navigator, Servers, Problems, Console\r\n");
      out.write("\t\t   \r\n");
      out.write("\t\t3. [Window - Preferences]\r\n");
      out.write("\t\t\t1) 인코딩 관련 한 것들 UTF-8로 바꿔주기\r\n");
      out.write("\t\t\t\t>> Window - Preferences - General - Workspace \r\n");
      out.write("\t\t\t\t>> General - Editors - Text Editors - Spelling \r\n");
      out.write("\t\t\t\t>> Web - CSS Files, HTML Files, JSP Files\r\n");
      out.write("\t\t\t\t>> JSON - JSON Files \r\n");
      out.write("\t\t\t\t>> XML - XML Files\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t2) Server - Runtime Environment - Add  톰캣 설치경로 잡아주기\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t4. [Window - Perspective - Customize Perspective  =>  Shortcuts 탭]\r\n");
      out.write("\t\t   New 할 때 보여지는 부분 자주 사용되는 것들 지정하기\r\n");
      out.write("\t\t   >> General - File, Folder\r\n");
      out.write("\t\t   >> Java - Class, Interface, Package\r\n");
      out.write("\t\t   >> Web - CSS File, JSP File, Dynamic Web Project, HTML File, Filter, Listener, Servlet\r\n");
      out.write("\t\t   \r\n");
      out.write("\t\t5. Dynamic Web Project 생성하기\r\n");
      out.write("\t\t   1) New - Dynamic Web Project\r\n");
      out.write("\t\t   2) 프로젝트명 신중하게 작성 후 Next\r\n");
      out.write("\t\t   3) 하단의 default output folder 경로 수정 : WebContent\\WEB-INF\\classes로 변경 (직접 입력) 후 Next\r\n");
      out.write("\t\t       \r\n");
      out.write("\t\t       ** classes 폴더 위치를 바꾸는 이유 **\r\n");
      out.write("\t\t\t   >> Dynamic Web Project에 src폴더에서 작성된 자바코드는 자동으로 컴파일 되어  위에서 지정된 Default output folder 내부에 저장되는데\r\n");
      out.write("\t\t\t\t    톰캣을 이용하여 자바웹 어플리케이션 실행 시 톰캣이 직접적으로 사용하는 파일들은  프로젝트 전체가 아닌 WEB-INF폴더 하위 만을 읽는다!\r\n");
      out.write("\t\t\t\t    그래서 컴파일된 자바코드의 모음인 classes 폴더의 위치를 WEB-INF하위로 옮겨 자동으로 인식시킨다.(web.xml도 WEB-INF 아래에 있다!)\r\n");
      out.write("\t\t\t   >> 웹 어플리케이션의 실행 파일들을 배포를 위한 war 형식의 파일이 요구하는 구성으로 정리.\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t   ** 경로 재설정 안하고 바로 프로젝트 그냥 생성 후\r\n");
      out.write("\t\t\t      Properties > Java Build Path > Source 탭 > Default output folder 변경할 수 있지만 해당 방법은 추천하지 않음!!\r\n");
      out.write("\t\t\t\t     왜? => 변경한다고 해서   프로젝트폴더/.settings/org.eclipse.wst.common.component 파일 내부에 저장되는 java-output-path 의 값이 변경되지 않는다!\t\r\n");
      out.write("\t\t\t\t     \r\n");
      out.write("\t\t   4) Context root : 웹 서버 실행시 최상위 경로(root)명의 이름을 지정해줌 (자동으로 contextPath명으로 됨)\r\n");
      out.write("\t\t                                              기본값으로 프로젝트명으로 되어있음 (간단하게 변경해도됨 단!! 고유하게)\r\n");
      out.write("\t\t   5) Content directory : 배포되는 폴더의 최상위 폴더명 지정 (기본값 WebContent)\r\n");
      out.write("\t\t   6) Generate web.xml deployment descriptor 체크하기 (안그러면 web.xml 안생김..)\r\n");
      out.write("\t\t   \t    왜만들어야되? => web.xml이란 파일은 컴포넌트들을 설명하고, 각종 초기화 파라미터들과 서버 기능을 활용하기 위한 컨테이너가 관리하는 보안 제한 구역을 지정하는 파일이다.\r\n");
      out.write("\t\t\t\t                        톰캣이 실행되면 이 파일을 제일 먼저 읽어 초기화를 진행한다.\r\n");
      out.write("\t\t\t\t         \r\n");
      out.write("\t\t   7) index.jsp 페이지 만들기 (WebContent/  경로에 만들어줘야됨 그래야만 제대로 찾음) \r\n");
      out.write("\t\t\r\n");
      out.write("\t\t5. Server 생성하기\r\n");
      out.write("\t\t   1) 서버 생성후 더블클릭하여 수정하기\r\n");
      out.write("\t\t      >> 왼쪽 아래 Server modules without publishing 체크박스 꼭 체크해주기 \r\n");
      out.write("\t\t      \t  왜? ==> 내가 지정한 output folder에 제대로 동기화가 돼야되는데 안할 시 이상한 경로로 동기화됨\r\n");
      out.write("\t\t      >> 포트번호 바꾸기 \r\n");
      out.write("\t\t                    왜? ==> 오라클 포트번호(8080)와 충돌 안나게 \r\n");
      out.write("\t\t   2) 생성된 서버에 구동하고자 하는 프로젝트 올리기\r\n");
      out.write("\t\t      >> Add and Remove 를 통해서\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t6. Server Start 후 해당 웹 애플리케이션 index.jsp 페이지 잘 열리는지 체크\r\n");
      out.write("\t\t   \r\n");
      out.write("\t \r\n");
      out.write("\t   * 위쪽의 전반적인 세팅 다 끝났으면 프로젝트 내에 해야되는 세팅 과정 \r\n");
      out.write("\t \t\r\n");
      out.write("\t \t=> 프로젝트 내에 필요한 폴더 및 패키지 미리 만들어 놓기\r\n");
      out.write("\t \t\r\n");
      out.write("\t \t   >> 폴더 생성 (WebContent/)\r\n");
      out.write("\t \t       외부 문서들 관리하기 위한 폴더들 : WebContent/resources/css,js,images\r\n");
      out.write("\t \t       각 화면들 관리하기 위한 폴더들    : WebContent/views/common,member,board,notice\r\n");
      out.write("\t \t   \r\n");
      out.write("\t \t   >> 패키지 생성 (src/com.kh.)\r\n");
      out.write("\t \t   common\r\n");
      out.write("\t \t   member.controller / member.model.vo / member.model.service / member.model.dao\r\n");
      out.write("\t \t   notice.controller / notice.model.vo / notice.model.service / notice.model.dao\r\n");
      out.write("\t \t   board.controller / board.model.vo / board.model.service / board.model.dao\r\n");
      out.write("\t \t   \r\n");
      out.write("\t \t   >> 각종 driver 정보들, 쿼리문들 저장할 properties 파일들 담아줄 폴더 생성  (src/sql)\r\n");
      out.write("\t \t   >> 각 폴더에 .properties 파일까지 만들기\r\n");
      out.write("\t \t   sql/driver/driver.properties\r\n");
      out.write("\t \t   sql/member/member-mapper.properties\r\n");
      out.write("\t \t   sql/notice/\r\n");
      out.write("\t \t   sql/board/\r\n");
      out.write("\t \t   \r\n");
      out.write("\t    3. com.kh.common 패키지에 JDBCTemplate 완성시키기\r\n");
      out.write("\t    \r\n");
      out.write("\t    4. ojdbc6 라이브러리 WebContent/WEB-INF/lib 폴더에 추가하기\r\n");
      out.write("\t \t   \r\n");
      out.write("\t  -->\r\n");
      out.write("\t  \r\n");
      out.write("\t  ");
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
