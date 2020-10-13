<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>EL 연산자</h2>
	
	<p>
		보통 EL은 주로 내장 객체에 담긴 값을 화면에 뿌리는 용도로 쓰이지만<br>
		산술연산 및 논리연산을 지원함. 간단 비교연산 또는 논리연산은 종종 쓰임
	</p>
	
	<h3>1.산술 연산</h3>
	스크립틀릿 : <%= (int)request.getAttribute("big") + (int)request.getAttribute("small") %><br>
	EL : ${ big + small}
	
	<p>
		10+3 = ${big+small }<br>
		10-3 = ${big-small }<br>
		10x3 = ${big*small }<br>
		10/3 = ${big/small } 또는 ${big div small }<br>
		10%3 = ${big % small } 또는 ${big mod small }<br>
 	</p>
 	
 	<h3>2. 숫자간의 대소 비교 연산</h3>
 	<p>
 		10 &gt; 3 = ${big>small} 또는 ${big gt small }<br> <!-- greater than -->
 		10 &lt; 3 = ${big<small } 또는 ${big lt small }<br> <!--less than -->
 		10 &gt;= 3 = ${big>=small } 또는 ${big ge small }<br> <!-- greater equal -->
 		10 &lt; = 3 ${big<=small } 또는 ${big le small }<br><!-- less equal -->
 	</p>
 	
 	<h3>3. 객체간 비교</h3>
 	<p>
 		<!-- el에서의 == 연산은 자바에서의 equals()와 같은 동작을 수행 -->
 		-sOne과 sTwo가 같습니까? : ${sOne == sTwo } 또는 ${sOne eq sTwo }<br>
 		-sOne과 sTwo가 틀립니까? : ${sOne != sTwo } 또는 ${sOne ne sTwo }<br> <!-- not equal -->
 		-pOne과 pTwo가 같습니까? : ${pOne == pTwo } 또는 ${pOne eq pTwo }<br>
 	</p>
 	
 	<h3>4.객체가 null인지 또는 비어있는지 체크(empty)</h3>
 	<p>
 		p가 null입니까? : ${p==null } 또는 ${empty p }<br>
 		p가 null이 아닙니까? : ${p!=null } 또는 ${!empty p }<br>
 		list가 비어있습니까? : ${empty list }<br>
 		list가 비어있지 않습니까? : ${!empty list }<br>
 	</p>
 	
 	<h3>5.논리연산자</h3>
 	
 	${true && true } 또는 ${true and true }<br>
 	${true || false } 또는 ${true or false }<br>
 	
</body>
</html>