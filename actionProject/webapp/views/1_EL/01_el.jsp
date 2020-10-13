<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.model.vo.Person" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>
		1. 기존에 하던 방식대로 스크립틀릿과 표현식(출력식)을 이용해서 
		   각 영역에 담겨있는 값 뽑아서 화면에 출력 
	</h3>
	
	<%-- 
	<%
		//requestScope 영역에 담긴 값 뽑기
		String classRoom = (String)request.getAttribute("classRoom"); 
		Person student = (Person)request.getAttribute("student"); 
		
		// sessionScope 영역에 담긴 값 뽑기
		String academy = (String)session.getAttribute("academy");
		Person teacher = (Person)session.getAttribute("teacher");
	%>
	<p>
		학원명: <%=academy %>
		강의장: <%=classRoom %>
		강사:  <%=teacher.getName() %>, <%=teacher.getAge() %>,<%=teacher.getGender() %>
		
		수가생정보
		<ul>
			<li>이름:<%=student.getName() %></li>
			<li>나이:<%=student.getAge() %></li>
			<li>성별:<%=student.getGender() %></li>
		</ul>
	</p>
	--%>
	
	<h3> 2. EL을 이용해서 보다 쉽게 request, session 객체에 저장된 값들 출력하기 </h3>
		<p>
			EL을 이용하게 되면 getXXX을 통해서 값을 배올 필요 없이 키값만 제시해서 벨류값에 바로 접근 가능<br>
			내부적으로 해당 객체들의 getATtribute을 자동적으로 활용하여 키에 저장된 벨류값을 읽을수 있음
			
			El은 request, session 등 JSP 내장 객체를 구분하지 않아도<br>
			자동으로 내가 제시한 키값을 검색해서 존배하는 걸 찾았을 경우 값을 가져옴 
		</p>
		
		<p>
			학원명 : ${ academy }<br>
			강의장 : ${ classRoom } <br>
			강사: ${ teacher.name }, ${ teacher.age }, ${ teacher.gender } <br><br>
			<!-- teacher에 접근하면 Person 객체임, 해당 Person객체의 각 필드에 접근하고자 할때  필드명으로 접근 (내부적으로 getter메소드가 실행됨 -->
			수강생정보
			<ul>
				<li>이름: ${student.name }</li>
				<li>나이: ${student.age }</li>
				<li>성별: ${student.gender }</li>			
			</ul>
		</p>
		
		<h3> 3. 단, EL 사용시 내장 객체에 저장된 키값이 동일할 경우 </h3>
		
		<p>
			scope 값 : ${ scope }
		</p>
		<!--
			 EL은 공유범위가 가장 작은 객체에서부터 해당 키값을 검색
			 pageScopr -> requestScope -> sessionScope -> applicationScope
			 
			 만일 모든 영역에 해당 키값을 찾지못했을 경우 오류x, 아무것도 출력이 되지 않음 
		 -->
		 
		 <h3>4.특정 내장 객체를 지정하면서 키값을 제시</h3>
		 <%
		 	// pageScope에 담기 
		 	pageContext.setAttribute("scope", "page"); 
		 %>
		 
		 <p>
		 	pageScope에 담긴 값 : ${ scope } 또는 ${ pageScope.scope }<br>
		 	requestScope에 담긴 값 : ${requestScope.scope }<br>
		 	sessionScope에 담긴 값 : ${sessionScope.scope }<br>
		 	applicationScope에 담긴 값 : ${applicationScope.scope }
		 </p>
		 
		 <!-- 
		 	여러 스코프에 동일한 키 값으로 기록했다면, 명시적으로 스코프를 지정하면서 접근하면됨
		  -->
</body>
</html>