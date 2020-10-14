<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL이란?</h1>
	
	<p>
		JSP Standard Tag Library의 약자로 <br>
		JSP에서 사용되는 커스텀 태그로, 공통적으로 사용하는 코드의 집압을 사용하기 쉽게<br>
		태그화 해서 제공하고 있는 라이브러리
	</p>
	
	<h3>*라이브러리 등록 방법</h3>
	1) http://tomcat.apache.org/
	2) 다운로드 -> taglibs click
	3) 4개의 jar files 다운로드
	4) WEB-INF -> lib -> 추가
	
	<h3>* JSTL 선언 방법</h3>
	<p>
		JSTL을 사용하고자 하는 해당 jsp 페이지 상단에 <br>
		taglib 지시어를 이용해서 선언 해야됨
		
		&lt;%@ taglib prefix="접두어" uri="라이브러리 파일상의 uri 주소" %&gt;
	</p>
	
	<h4>1. JSTL core Library</h4>
	<p>변수와 제어문(조건문, 반복문) 등의 로직과 관련된 문법을 제공</p>
	
	<a href="01_core.jsp">core library</a>
	
	<br>
	
	<h4>2. JSTL formatting Library</h4>
	<p>숫자, 날짜 및 시간 데이터의 출력 형식을 지정할 때 사용하는 문법을 제공</p>
	
	<br>
	
	<h4>3. JSTL function Library</h4>
	<p>EL 안에서 사용할 수 있는 메소드를 제공</p>
	
	
</body>
</html>