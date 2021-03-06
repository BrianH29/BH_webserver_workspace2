<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.kh.board.model.vo.*" %>
<%
	Board b = (Board)request.getAttribute("b");
	ArrayList<Attachment> list = (ArrayList<Attachment>)request.getAttribute("list");
	//0번 : 대표이미지에대한 / 1번~ : 상세이미지에대한 
	
	Attachment titleImg = list.get(0); // 대표이미지 객체만 우선 뽑아놓기
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.outer {
	background: black;
	color: white;
	margin: auto;
	margin-top: 50px;
	width: 900px;
	height: 800px;
}

.detailArea td {
	text-align: center;
	border: 1px solid white;
}
</style>
</head>
<body>
	<%@include file="../common/menubar.jsp"%>

	<div class="outer">
		<br />
		<h2 align="center">사진게시파 상세보기</h2>
		<br />

		<table class="detailArea" align="center">
			<tr>
				<td width="70">제목</td>
				<td colspan="3" width="600"><%=b.getBoardTitle() %></td>
			</tr>
			<tr>
				<td>작성</td>
				<td><%=b.getBoardWriter() %></td>
				<td>작성일</td>
				<td><%=b.getCreateDate() %></td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3">
					<p style="height: 70px"><%=b.getBoardContent() %></p>
				</td>
			</tr>
			<tr>
				<td>대표사진</td>
				<td colspan="3">
					<div id="titleImgArea" align="center">
						<img src="<%=contextPath %>/<%= titleImg.getFilePath() + titleImg.getChangeName() %>" width="500" height="300" />
					</div>
				</td>
			</tr>
			<tr>
				<td>상세사진</td>
				<td colspan="3">
					<div id="detailImgArea" align="center">
					<% for(int i=1; i<list.size(); i++){ %>
						<img src="<%=contextPath %>/<%=list.get(i).getFilePath() + list.get(i).getChangeName() %>" width="200" height="150" /> 
					<%} %>
					</div>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>