<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>* EL(Expression Language 표현 언어)</h1>
	
	<p>
		기존에 사용했던 표현식(출력시) &lt;%= name %&gt;와 같이 <br>
		JSP에서 표현하고자 하는 코드를 \${ name } 와 형식으로 표현하여 작성하는 것 
	</p>
	
	<h3>1. EL 기본 구문에 대해서 먼저 배워보자!</h3>
	<a href="el.do">01_EL</a>
	
	<br>
	
	<h3>2. EL에서의 Param이라는 거에 대해서 배워보자!</h3>
	<p>
		JSP에서 서블릿 거쳐서 항상 JSP로 넘어갓을 것!<br>
		하지만 JSP에서 또다른 JSP를 바로 요청도 가능(권장X, 디렉토리 구조가 노출) <br>
		그 떄 값들도 전달가능!!
	</p>
	
	<!-- <a href="views/1_EL/02_elParam.jsp">02_EL(Param)</a>-->
	
	<form action="views/1_EL/02_elParam.jsp">
		<fieldset>
			<input type="text" name="pname" placeholder="제품명 입력하세요"><br>
			<input type="number" name="pcount" placeholder="수량을 입력하세요"><br>
			<input type="text" name="option" placeholder="옵션1"><br>
			<input type="text" name="option" placeholder="옵션2"><br>
			<button type="submit">02_EL(Param)</button>
		</fieldset>
	</form>
	
	<br>
	
	<h3>3. EL에서의 연산자에 대해서 배워보자!</h3>
	<a href="operation.do">03_EL(연산자)</a>
	
	<br>
	<hr>
	
	<!-- 
		*JSP를 이루는 구성인자
		1. 스크립팅 원소 : JSP페이지에서 자바 코드를 직접 기술할 수 있게 하는 기능
					  ex) 스크립틀릿, 표현식(출력시) 등등....
					  
		2. 지시어 : JSP페이지 정보에 대한 내용을 표현한다거나 또다른 jsp페이지를 포함할 때 사용 
				  아직 써보진 않았지만 JSP의 기능을 확장시키는 라이브러리를 등록할 때도 사용 
				  ex) page 지시어, include 지시어, taglib 지시어 
				  
		3. JSP 액션 태그 : xml기술을 이용하여 기존의 jsp문법을 확장하는 기술을 제공하는 태그 
		   >> 표준 액션 태그 (Standard Action) : JS페이지에서 바로 사용 가능(별도의 연동 없이) 
		   									표준액션 태근느 모든 태귿르의 이름 앞에 jsp :  접두어 붙음
		   									
		   >> 커스텀 액션 태그(Custom Action) : JSP페이지에서 바로 사용 불가능
		   									(사용하고자 하는 jsp 페이지에 별도의 라이브러리 설치해서 연동해야만함)
		   									커스텀액션 태그는 모든 태그들의 이름 앞에 jsp:외의 접두어가 붙음(종류가 다양함)
		   									제공되고 있는 가장 대표적인 유용한 라이브러리가 JSTL임 
	 -->
	 
	 <h1>JSP Action Tag</h1>
	 <p>JSP Action Tag는 XML 기술을 이용하여 기존의 JSP 문법을 확장하는 기술을 제공하는 태그</p>
	 
	 <h3>1.표준 액션 태그(Standard Action)</h3>
	 <p>JSP페이지에서 별도의 라이브러리 연동 없이 바로 사용가능 / 태그앞에 JSP: 접두어 붙음</p>
	 
	 <a href="views/2_StandardAction/01_include.jsp">01_JSP:include</a>
	 
	 <a href="forward.do">02_jsp:forward</a>
	 
	 <hr>
	 
	 <h3>2.커스텀 액션 태그(Custom Action)</h3>
	 <p>JSP페이지에서 별도의 라이브러리 연동 해야만 사용가능 / 태그 앞에 jsp:외의 다른 접두어 붙음</p>
	 
	 <a href="views/3_CustomAction/jstl.jsp">JSTL</a>
	 
</body>
</html>