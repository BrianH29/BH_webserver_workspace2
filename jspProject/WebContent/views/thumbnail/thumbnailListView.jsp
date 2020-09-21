<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.board.model.vo.Board" %>
<%
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
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
	width: 900px;
	height: 800px;
	margin: auto;
	margin-top: 50px;
}

.listArea {
	width: 760px;
	margin: auto;
}

.thumbnail {
	border: 1px solid white;
	width: 220px;
	display: inline-block;
	margin: 14px;
}

.thumbnail:hover {
	cursor: pointer;
	opacity: 0.4;
}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp"%>

	<div class="outer">
		<br />
		<h2 align="center">사진게시판</h2>
		<br />

		<%if(loginUser != null){ %>
		<div align="right" style="width: 810px">
			<button onclick="location.href='<%=contextPath %>/enrollForm.th';" class="btn btn-primary">글작성</button>
			<br />
			<br />
		</div>
		<%} %>
	
		<div class="listArea">
		
		<% for(Board b : list){ %>
			<div class="thumbnail" align="center">
				<input type="hidden" value="<%=b.getBoardNo()%>">
				<img src="<%=contextPath %>/<%=b.getTitleImg() %>" width="200px" height="150px" /> <br />
				<p>
					No.<%= b.getBoardNo() %> <%=b.getBoardTitle() %> <br /> 
					조회수 : <%=b.getCount() %>
				</p>
			</div>
			<%} %>
		</div>
		<script>
			$(function(){
				$(".thumbnail").click(function(){
					location.href="<%=contextPath%>/detail.th?bno=" + $(this).children().eq(0).val();
				});
			});
		</script>
	</div>
</body>
</html>