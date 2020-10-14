<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>forward</h1>
	<p>jsp에서 또다른 jsp로 바로 포워딩 가능하게 하는 표준액션 태그가 있음</p>
	
	<% if(request.getAttribute("status").equals("success")){ %>
		<jsp:forward page="successPage.jsp">
			<jsp:param name="msg" value="${status }" />
		</jsp:forward>
	<%}else { %>
		<jsp:forward page="failPage.jsp">
			<jsp:param name="msg" value="실패했습니다" />
		</jsp:forward>
	<%} %>
	
	<!-- 
		이 페이지에 전달된 결과값을 가지고 각기 다른 jsp페이지로 포워딩할때 사용하게 됨 
	 -->
</body>
</html>