<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Formating Library Test Page</h1>
	
	<h3>1.fmt:formatNumber value="" [groupingUsed="" type="" currencySymboly=""]</h3>
	<p>
		- 숫자와 관련된 데이터 포멧 지정 <br>
		- 표현하고자 하는 숫자 데이터의 형식을 통화기호, %등 원하는 쓰임에 맞게 지정할 수 있는 태그 
	</p>
	
	<c:set var="num1" value="100000000" />
	
	그냥 출력 : ${num1 } <br>
	세자리마다 구분해서 출력 : <fmt:formatNumber value="${num1 }" groupingUsed="true"/><br><br><!-- groupingUsed -> 기본값이 true 생략가능 -->
	<!-- groupingUsed 속성: 숫자 단위의 구분자 (,) 표시여부 지정 (true일 경우 o, false일 경우 x) -->
	
	<c:set var="num2" value="0.75" />
	
	percent : ${num2 }<br>
	fmt 적용 : <fmt:formatNumber value="${num2 }" type="percent" /><br>
	currency : <fmt:formatNumber value="${num1 }" type="currency" /><br>
	currency : <fmt:formatNumber value="${num1 }" type="currency" currencySymbol="$" /><br><br>
	<!-- 
		type 속성: 백분율, 통화기호 지정
		currencySymbol 속성 : 통화기호문자 지정
	 -->
	
	<hr>
	
	<h3>2.fmt:formatDate value="" [type="" dateStyle="" timeStyle="" pattern=""]</h3>
	<p>
		- 날짜 및 시간과 관련된 데이터를 출력할 포맷 지정<br>
		- java.util.Date 객체를 사용해야됨<br>
	</p>
	
	<c:set var="current" value="<%= new java.util.Date() %>" /> <!-- 위에 import 하기 귀찮고 그리고 요기만 쓸거 이기 떄문에 새롭게 객체 생성 -->
	
	그냥 출력: ${current }<br>
	
	<ul>
		<li>현재날짜 : <fmt:formatDate value="${current }" type="date"/></li><!-- 기본갑이 날짜만 나옴 type=date 생략가능 -->
		<li>현재시간 : <fmt:formatDate value="${current }" type="time"/></li>
		<li>둘 다(날짜 시간) : <fmt:formatDate value="${current }" type="both"/></li>
		<li>full : <fmt:formatDate value="${current }" type="both" dateStyle="full" timeStyle="full"/></li>
		<li>long : <fmt:formatDate value="${current }" type="both" dateStyle="long" timeStyle="long"/></li>
		<li>medium : <fmt:formatDate value="${current }" type="both" dateStyle="medium" timeStyle="medium"/></li>
		<li>short : <fmt:formatDate value="${current }" type="both" dateStyle="short" timeStyle="short"/></li>
		<li>내 패턴 : <fmt:formatDate value="${current }" type="both" pattern="yyyy-MM-dd(E) HH:mm:ss(a)" /></li>
	</ul>
	
	
	<br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>