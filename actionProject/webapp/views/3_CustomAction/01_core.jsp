<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList, com.kh.model.vo.Person" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Core Library Test Page</h1>
	
	<h3>1. 변수</h3>
	<p>
		* 변수 선언 및 초기화 (c:set var="변수명" value="담고자하는값" [scope="page/request/session/application"])<br>
		- 변수 선언하고 초기값을 대입하는 기능을 제공 <br> 
		- 변수 선언시 scope 지정가능 (지정안할 시 기본 scope는 page)<br> 
		- 즉, 해당 scope에 setAttribute를 통해 key-value 형태로 값을 담아놓는 거라고 생각하면됨! <br><br>
		
		-주의사항<br>
		- 변수 타입은 별도 선언하지 않음<br>
		- 초기값은 반드시 지정해야됨 <br> 
		- c:set을 이용해서 선언된 변수는 EL을 통해 접근 가능(\${ 변수명 })하나, 스크립팅 원소에서는 접근 불가능
	</p>
	
	<c:set var="num1" value="10"/>
	<c:set var="num2" value="20" scope="request"/>
	<!-- request.setAttribute("num2",20) -->
	
	num1 변수값 : ${num1 }<br>
	num2 변수값 : ${num2 }	<br>
	
	<c:set var="result" value="${num1+num2 }" scope="session"/>
	<!-- session.setAttribute("result", 10+20 -->
	
	${num1 } + ${num2 } = ${result } <br><br>
	
	${pageScope.num1 }<br>
	${requestScope.num2 }<br>
	${requestScope.result }<br><!-- 아예 어떠한것도 출력이 안되는것뿐(오류발생안함) -->
	${sessionScope.result }<br><br>
	
	<c:set var="colors" scope="request">
		red,blue,yellow,pink,green
	</c:set>
	
	colors변수값 : ${ colors }<br>
	
	<hr> 
	
	<p>
		* 변수 삭제 (c:remove var="삭제하고자하는변수명" [scope="page/request/session/application"])
		- 지정한 변수를 scope에서 찾아서 삭제하는 태그<br>
		- scope지정하지 않을 시 모든 영역에서 다 찾아서 삭제 됨.
		- 즉, 해당 scope에 removeAttribute를 통해 삭제하는거라고 생각하면됨!!  
	</p>	
	
	<c:set var="result" value="9999" scope="request" />
	<!-- request영역에 result=99999  session영역에 result =30 -->
	
	삭제전 result : ${result } <br><br>
	
	1) 특정 scope 지정해서 삭제 <br>
	<c:remove var="result" scope="request" />
	request에 삭제 후 result : ${ result }<br>
	
	2)모든 scope에 삭제<br>
	<c:remove var="result" />
	모두 삭제 후 result : ${result }<br>
	
	<p>
		* 변수 출력(c:out value="출력하고자하는 값" [escapeXml="true/false" default="기본값"]) <br>
		- 데이터를 출력하고자 할 떄 사용하는 태그
	</p>
	
	<c:set var="outTest" value="<b>출력테스트</b>" />
	
	<c:out value=" ${outTest}" escapeXml="false" /><br>
	<c:out value="${outTest}" escapeXml="true" /><br> <!-- 기본값이 true임 -->
	
	result : ${result } <br> 
	result : <c:out value="${result }" default="없음" /> 
	
	<hr>
	<h3>2. 조건문 - 단일 IF문(c:if test="\${조건식 }")</h3>
	<p>
		-JAVA의 단일 if문과 동일한 역할을 수행해주는 태그<br>
		-조건식을 Test 속성에 작성(단,EL형식으로 기술해야됨)
	</p>
	
	<%-- 
	기존에 스크립틀릿으로 했던 조건식
	<%if(num1>num2) {%>
	
	<%} %>
	--%>
	
	<c:if test="${num1>num2 }">
		<b>num1이 더 큽니다.</b>
	</c:if>
	
	<c:if test="${num1 lt num2 }">
		<b>num2가 더 큽니다.</b>
	</c:if>
	
	<br>
	
	<c:set var="str" value="안녕" />
	<%-- 
	<% if(str.equals("안녕")){ %>
	
	<%} %>
	--%>
	
	<c:if test="${str eq '안녕' }">
		<b>Hello World</b>
	</c:if>
	
	<c:if test="${str ne '안녕' }">
		<b>Bye World</b>
	</c:if>
	
	<br>
	
	<h3>3.조건문 - IF-ELSE IF, switch(c:choose, c:when, c:otherwise)</h3>
	<p>
		- JAVA의 if-else, if-else if, switch문과 비슷한 역할을 수행해주는 태그 <br>
		- 각 조건들을 c:choose의 하위요소로 c:when을 통해서 작성 <br>
		- else문 또는 default문 같은건 c:otherwise로 작성
	</p>
	
	<!-- num1:10 -->
	
	<c:choose>
		<c:when test="${num1 == 20 }">
			<b>First meeting</b>
		</c:when>
		<c:when test="${num1 == 10 }">
			<b>Great Meeting you again</b>
		</c:when>
		<c:otherwise>
			<b>Hello</b>
		</c:otherwise>
	</c:choose>
	
	<br><br><hr>
	<h3>4. 반복문 - For (c:forEach)</h3>
	<p>
		- JAVA의 for문에 해당하는 기능 제공<br>
		(c:forEach var="변수명" begin="초기값" end="끝값" [step="반복시증가값"])<br>
		(c:forEach var="변수명" items="순차적으로 접근할 객체(배열 또는 리스트)") <!-- 향상된 for문 -->
		(c:forEach var="변수명" items="순차적으로 접근할 객체(배열 또는 리스트)" [varStatus="현재접근된요소의 상태값을 보관할 변수명"])
	</p>
	<c:forEach var="i" begin="1" end="10" step="2">
		<b>반복확인 : ${ i }</b><br>
	</c:forEach>
	
	<c:forEach var="i" begin="1" end="6">
		<h${i }>태그안에서도 EL 적용 가능</h${i }>
	</c:forEach>
	
	<!-- colors:red,blue,yellow,pink,green -->
	<c:forEach var="c" items="${colors }">
		<!--<b>${c }</b><br />-->
		<font color="${c }">${c }</font><br/>
	</c:forEach>
	
	<ul>
		<c:forEach var="c" items="${colors }">
			<li style="background:${c}">목록</li>
		</c:forEach>
	</ul>
	<br><br>
	<ul>
		<c:forEach var="c" items="${colors }" varStatus="status">
			<li style="background:${c}">목록${status.count }</li><!-- count 1부터 시작 -->
		</c:forEach>
	</ul>
	<br><br>
	
	<ul>
		<c:forEach var="c" items="${colors }" varStatus="status">
			<li style="background:${c}">목록${status.index }</li> <!-- index 0부터 시작 -->
		</c:forEach>
	</ul>
	
	<%
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("홍길동",20,'남'));
		list.add(new Person("Brian",40,'남'));
		list.add(new Person("Maria",25,'여'));
		
		request.setAttribute("list", list); 
	%>
	
	<table border="1">
		<thead>
			<tr>
				<th>이름</th>
				<th>나이</th>
				<th>성별</th>
			</tr>
		</thead>
		<tbody>
		<%-- 기존에 스크립트 사용 했던 방법
			<%for(Person p : list) {%>
				<tr>
					<td><%=p.getName() %></td>
					<td><%=p.getAge() %></td>
					<td><%=p.getGender() %></td>
				</tr>
			<%} %>
		--%>
		<c:forEach var="p" items="${list }"> <!-- items="요기에 EL을 사용하지 하고 적으면 그냥 문자로 취급한다." -->
			<tr>
				<th>${p.name }</th>
				<th>${p.age }</th>
				<th>${p.gender }</th>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<hr>
	
	<h3>4. 반복문 - forTokens (c:forTokens var="변수명" items="문자열" delims="구분자")</h3>
	<p>
		- 문자열에 포함된 구분자를 통해 각각의 토큰으로 분리 후 반복 처리 <br>
		- JAVA의 split("구분자") 또는 StringTokenizer와 같은 기능 수행 <br> 
		- items 속성에는 구분자를 포함하고 있는 문자열을 지정하고, 
		  delims  속성에는 토큰을 분리하는데 사용할 구분자를 기술
	</p>
	
	<c:set var="device" value="컴퓨터,핸드폰.TV/에어컨,냉장고.세탁기" />
	
	<ul>
		<c:forTokens var="d" items="${device }" delims=",./" >
			<li>${d }</li>
		</c:forTokens>
	</ul>
	
	
	<hr>
	
	<h3>6. 쿼리스트링 (c:url, c:param)</h3>
	<p>
		- url 경로를 생성하고, 해당 url로 요청시 전달할 값을 생성 할 수 있는 태그(쿼리스트링을 정의할 수 있는 태그)<br>
		
		c:url var="변수명" value="요처할 url" </br>
			c:param name="키값" value="전달할값" / <br>
			c:param name="키값" value="전달할값" / <br>
		/c:url
		
		변수명 = "요청할url?키값=전달값&키값=전달값"
	</p>
	
	<a href="list.do?cPage=2&num=10">기본방식</a> <br>
	
	<c:url var="url" value="list.do">
		<c:param name="cPage" value="2" />
		<c:param name="num" value="10" /> 
	</c:url>
	<!-- url= "list.do?cPage=2&num=10" -->
	
	<a href="${url }">c:url 사용한방식</a>
	
	
	<br><br><br><br><br><br><br><br><br><br>
</body>
</html>
	
	