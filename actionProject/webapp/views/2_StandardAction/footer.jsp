<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		/*
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy"); 
		String year = sdf.format(today); 
		*/
		String year = new SimpleDateFormat("yyyy").format(new Date()); 
	%>

	<h4>Copyright © 1998-<%=year %> KH Information Educational Institute All Right Reserved</h4>
	
	test : ${param.test } <br>
</body>
</html>