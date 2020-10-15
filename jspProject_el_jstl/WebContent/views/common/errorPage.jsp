<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <h1 align="center" style="color:red">${errorMsg }</h1>
    
    <div align="center">
        <button onclick="history.back();">이전페이지</button>
        <button onclick="location.href='${contextPath }';">메인페이지</button>
    </div>
</body>
</html>