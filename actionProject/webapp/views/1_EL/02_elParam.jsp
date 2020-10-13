<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 
	<%
		String pname = request.getParameter("pname"); 
	%>
	--%>
	
	<p>
		해당 페이지 요청 시에 전달값은 내부적으로 param 영역에 저장되어있음<br>
	</p>
	<h2>주문내역</h2>
	<p>
		상품명 : ${ param.pname } <br>
		수량 : ${ param.pcount } <br>
		
		<!-- 값이 두개이상일 경우 param 내장객체를 통해서 접근하게 되면 오로지 첫번쨰 값만 가져오게됨 -->
		<!-- 옵션 : ${ param.option } -->
		
		옵션1:${paramValues.option[0] }<br>
		옵션2:${paramValues.option[1] }
	</p>
</body>
</html>