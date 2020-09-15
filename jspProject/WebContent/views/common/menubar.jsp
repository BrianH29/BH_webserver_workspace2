<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.kh.member.model.vo.Member" %>
<%
	String contextPath = request.getContextPath();
	
	Member loginUser = (Member)session.getAttribute("loginUser");
	// 로그인 전 : null
	// 로그인 후 : 로그인 성공한 회원정보들이 담겨있는 객체  
	
	String alertMsg = (String)session.getAttribute("alertMsg");
	// > 서비스 요청 전: null
	// > 서비스 요청 성공 후 : alert띄어줄 메시지 문구 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#loginForm, #userInfo {
	float: right;
}

#loginForm button {
	border: none;
	padding: 5px;
	border-radius: 5px;
}

#loginForm button:first-child {
	background: yellowgreen;
}

#loginForm button:last-child {
	background: orangered;
}

#userInfo a {
	color: black;
	text-decoration: none;
	font-size: 12px;
}

.navWrap {
	background: black;
}

.menu {
	display: table-cell;
	height: 50px;
	width: 150px;
}

.menu a {
	text-decoration: none;
	color: white;
	font-weight: bold;
	font-size: 16px;
	display: block;
	width: 100%;
	height: 100%;
	line-height: 50px;
}

.menu a:hover{text-decoration:none; color:white;}
.menu:hover {
	background: darkgrey;
}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script>
	$(function(){
		var msg = "<%= alertMsg %>"; //자바스크립트 변수
		
		if(msg != "null"){ // msg가 담겨있을 경우 
			alert(msg);
			//알람창 띄어준 후에 session에 담긴 메세지 지워야됨
			//안그러면 menubar.jsp가 포함되어있는 페이지 열때마나다 alert 계속뜰거임
			<% session.removeAttribute("alertMsg"); %>
		}
	});//e.function
</script>
</head>
<body>
	<h1 align="center">Welcome JSP World!!</h1>

	<div class="loginArea">

		<% if(loginUser == null) { %>

		<!-- 1. 로그인 전에 보여지는 로그인 form -->
		<form id="loginForm" action="<%=request.getContextPath() %>/login.me" method="post">
			<table>
				<tr>
					<th><label for="userId">ID : </label></th>
					<td><input type="text" id="userId" name="userId" required></td>
				</tr>
				<tr>
					<th><label for="userPwd">password:</label></th>
					<td><input type="password" id="userPwd" name="userPwd"
						required></td>
				</tr>
				<tr>
					<th colspan="2" style="text-align:center;">
						<button type="submit">LOGIN</button>
						<button type="button" onclick="enrollPage();">REGISTER</button>
					</th>
				</tr>
			</table>
		</form>
		<script>
			function enrollPage(){
				//location.href="/jsp/views/member/memberEnrollForm.jsp";
				// 웹 어플리케이션의 디렉토리 구조가 url에 노출되면 보안에 위험
				
				// 단순한 정적인 페이지 이동이라고 해도 반드시 servlet 거쳐갈것!! => url에	 서블릿 매핑값만 노출됨! 
				location.href="<%=request.getContextPath()%>/enrollForm.me";
				
			}
		</script>
		<%} else { %>
		<!-- 2.로그인 성공 후 보여지는 div-->
        <div id="userInfo">
            <b><%=loginUser.getUserName() %>님</b>의 방문을 환영합니다. <br><br>

            <div align="center">
                <a href="<%= contextPath %>/myPage.me">MyPage</a>
                <a href="<%=request.getContextPath() %>/logout.me">Logout</a>
            </div>
        </div>
		<%} %>
		
	</div> <!-- e.loginArea -->

	<br clear="both">
	<!-- 위 내용들 무시-->
	<br>

	<div class="navWrap" align="center">
		<div class="menu">
			<a href="<%= contextPath%>">HOME</a>
		</div>
		<div class="menu">
			<a href="<%= contextPath %>/list.no">공지사항</a>
		</div>
		<div class="menu">
			<a href="<%= contextPath%>/list.bo?currentPage=1">일반게시판</a>
		</div>
		<div class="menu">
			<a href="">사진게시판</a>
		</div>
	</div>
</body>
</html>