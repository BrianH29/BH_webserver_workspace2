<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kh.board.model.vo.*" %>
<%
	Board b = (Board)request.getAttribute("b");
	Attachment at = (Attachment)request.getAttribute("at");
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
	width: 900px;
	height: 500px;
	margin-top: 50px;
}

#updateForm>table {
	border: 1px solid white;
}

#iupdateForm>table input, #updateForm>table textarea {
	width: 100%;
	box-sizing: border-box;
}
</style>
</head>
<body>
	<%@include file="../common/menubar.jsp"%>

	<div class="outer">
		<br />
		<h2 align="center">게시판 수정하기</h2>
		<br />

		<form action="<%=contextPath %>/update.bo" id="updateForm" method="POST" enctype="multipart/form-data">
			<!-- 카테고리, 제목, 내용, 첨부파일-->
			<input type="hidden" name="bno" value="<%=b.getBoardNo()%>">

			<table align="center">
				<tr>
					<th width="70">분야</th>
					<td width="500">
					<select name="category">
							<option value="10">공통</option>
							<option value="20">운동</option>
							<option value="30">등산</option>
							<option value="40">게임</option>
							<option value="50">낚시</option>
							<option value="60">요리</option>
							<option value="70">기타</option>
					</select>
					<script>
						$(function(){
							$("#updateForm option").each(function(){ //순차적으로 접근
								if($(this).text() == "<%=b.getCategory()%>"){
									$(this).attr("selected", true);
								}
							
							});
						});
					</script>
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" value="<%=b.getBoardTitle() %>"
						required /></td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea name="content" rows="10" style="resize: none"><%=b.getBoardContent() %></textarea>
					</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<!--기존의 첨부파일이 있었을 경우--> 
						<%if(at != null) { %>
							<%=at.getOriginName() %><br /> 
							<input type="hidden" name="originFileNo" value="<%=at.getFileNo() %>">
							<input type="hidden" name="originFileName" value="<%=at.getChangeName() %>">
						<%} %>
						<input type="file" name="reUpfile"/>
					</td>
				</tr>
			</table>
			<br />
			<div align="center">
				<button type="submit">수정하기</button>
			</div>
		</form>
	</div>
</body>
</html>