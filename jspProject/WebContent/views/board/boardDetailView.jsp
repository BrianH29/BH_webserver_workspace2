<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kh.board.model.vo.*" %>
<%
	Board b = (Board)request.getAttribute("b");
	Attachment at = (Attachment)request.getAttribute("at"); // null이거 아니거나
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
	height: auto;
	margin: auto;
	margin-top: 50px;
}

.outer table {
	border-color: white;
}

#detailArea p {
	height: 200px;
}
</style>
</head>
<body>
	<%@include file="../common/menubar.jsp"%>

	<div class="outer">
		<br />
		<h2 align="center">게시판 상세보기</h2>
		<br />

		<table id="detailArea" align="center" border="1">
			<tr>
				<th width="70">분야</th>
				<td width="70"><%= b.getCategory() %></td> <!--카테고리명-->
				<th width="70">제목</th>
				<td width="350"><%= b.getBoardTitle() %></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=b.getBoardWriter() %></td>
				<!--작성자아이디-->
				<th>작성일</th>
				<td><%=b.getCreateDate() %></td>
				<!--작성일-->
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3">
					<p><%=b.getBoardContent() %></p> <!--게시글내용-->
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td colspan="3">
				<!--첨부파일이 없을 경우--> 
				<%if(at == null){ %>
					첨부파일없습니다.
				<%}else{ %>				
				<!--첨부파일이 있을 경우--> 
					<a href="<%=contextPath %>/<%=at.getFilePath() + at.getChangeName() %>"><%=at.getOriginName() %></a>
				<%} %>
				</td>
			</tr>
		</table>

		<br />

		<!-- 로그인한 사용자가 게시글작성자일 경우-->
		<div align="center">
			<button>수정하기</button>
			<button>삭제하기</button>
		</div>
		<br />
		<div id="replyArea">
			<table border="1" align="center">
				<thead>
					<tr>
						<th>댓글작성</th>
						<td><textarea cols="50" row="3" style="resize: none"></textarea>
						</td>
						<td><button>댓글등록</button></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>admin</td>
						<td>댓글내용</td>
						<td>2020-09-15</td>
					</tr>
					<tr>
						<td>admin2</td>
						<td>댓글내용</td>
						<td>2020-08-15</td>
					</tr>
					<tr>
						<td>admin3</td>
						<td>댓글내용</td>
						<td>2020-04-15</td>
					</tr>
				</tbody>
			</table>
			<br />
			<br />
			<br />
		</div>
	</div>
</body>
</html>