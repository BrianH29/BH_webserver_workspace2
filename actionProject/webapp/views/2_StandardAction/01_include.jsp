<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Include</h3>
	<p>또다른 jsp를 포함하고자 할 떄 쓰이는 방식</p>
	
	<h4>1. 기본의 include 지시어 이용한 방식(정적 include방식 == 컴파일시 포함되는 형태)</h4>
	<%--
	<%@ include file="footer.jsp"%> <br><br>
	
	특징 : 포함한 저 페이지에서 선언된 변수를 현재 이페이지에서도 사용 할 수 있음<br>
	include한 페이지의 year변수값: <%=year %><br><br>
	
	단, 문제점 : 현재 이 페이지에서 동일한 이름의 변수로 선언 불가<br> 
	<%String year = "2020"; %>
	--%>
	
	<h4>2. JSP 표준 액션 태그를 이용한 방식(동적 include방식 == 런타임시 포함되는 형태)</h4>
	<%--<jsp:include></jsp:include>--%>
	<jsp:include page="footer.jsp" />
	
	특징 1 : include한 저 페이지에서 선언된 변수를 공유하지 않음!! == 현재 이 페이지에 쓸 수 없음 == 동일한 이름의 변수로 선언 가능 <br> 
	<%--
	<%=year %>
	<% int year = 1900; %>
	--%>
	
	특징 2 : 포함하고자 하는 페이지로 값을 전달하면서 포함 가능 <br> 
	<jsp:include page="footer.jsp">
		<jsp:param name="test" value="HelloWorld"></jsp:param>
	</jsp:include>
	
	<br><br>
	<jsp:include page="footer.jsp">
		<jsp:param name ="test" value="ByeWorld"></jsp:param>
	</jsp:include>
	
</body>
</html>