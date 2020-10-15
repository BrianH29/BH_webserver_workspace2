<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.notice.model.vo.Notice" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.outer {
	width: 800px;
	height: 500px;
	background: black;
	color: white;
	margin: auto;
	margin-top: 50px;
}

.listArea {
	border: 1px solid white;
	text-align: center;
}

.listArea>tbody>tr:hover {
	background: grey;
	cursor: pointer;
}
</style>
</head>
<body>
	<!--메뉴바 포함-->
	<%-- <%@include file="../common/menubar.jsp"%> --%>
	<jsp:include page="../common/menubar.jsp" />

	<div class="outer">

		<h2 align="center">공지사항</h2>
		<br>

		<!--로그인한 사람이 관리자일 경우 -->

		<c:if test="${loginUser != null and loginUser.userId eq 'admin' }" > 
			<div align="right" style="width: 700px">
				<button onclick="location.href='${contextPath}/enrollForm.no';">글작성</button>
				<br><br>
			</div>
		</c:if>


		<table class="listArea" align="center">

			<thead>
				<tr>
					<th>글번호</th>
					<th width="300">글제목</th>
					<th width="100">작성자</th>
					<th>조회수</th>
					<th width="100">작성일</th>
				</tr>
			</thead>

			<tbody>
			<!-- 리스타가 비어있을 경우 -->
				<c:choose>
					<c:when test="${empty list}" >
						<tr>
							<td colspan="5">존재하는 공지사항 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<!-- 리스타가 비어있지 않을 경우 -->
						<c:forEach var="n" items="${list }">
							<tr>
								<td>${n.noticeNo }</td>
								<td>${n.noticeTitle }</td>
								<td>${n.noticeWriter }</td>
								<td>${n.count }</td>
								<td>${n.createDate }</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
	
	<script>
		$(function(){
			
			$(".listArea>tbody>tr").click(function(){ //학습동영상 Server33_jspProject18 9월8일 
				//console.log("클릭클릭클릭");
				var nno = $(this).children().eq(0).text();
				
				//console.log(nno);
				// 쿼리스트링
				location.href = "${contextPath}/detail.no?nno=" + nno; 
			});
		
		});
	</script>
</body>
</html>