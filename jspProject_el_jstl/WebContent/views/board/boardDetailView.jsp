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
					<a download="<%= at.getOriginName() %>" href="<%=contextPath %>/<%=at.getFilePath() + at.getChangeName() %>"><%=at.getOriginName() %></a>
				<%} %>
				</td>
			</tr>
		</table>

		<br />

		<!-- 로그인한 사용자가 게시글작성자일 경우-->
		<% if(loginUser != null && loginUser.getUserId().equals(b.getBoardWriter())) {%>
		<div align="center">
			<button onclick="location.href='<%=contextPath%>/updateForm.bo?bno=<%=b.getBoardNo()%>';">수정하기</button>
			<button>삭제하기</button>
		</div>
		<%} %>
		<br />
		<div id="replyArea">
			<table border="1" align="center">
				<thead>
					<tr>
						<th>댓글작성</th>
						<%if(loginUser == null){ // 로그인전 %>
						<td colspan="2">
							<textarea cols="60" row="3" style="resize: none" readonly>로그인 후 이용가능한 서비스입니다.</textarea>
						</td>
						<%}else{ // 로그인 후%>
						<td>
							<textarea id="replyContent" cols="50" row="3" style="resize: none"></textarea>
						</td>
						<td>
							<button onclick="addReply();">댓글등록</button>
						</td>
						<%} %>
					</tr>
				</thead>
				<tbody>
					<!--  <tr>
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
					</tr>-->
				</tbody>
			</table>
			<br />
			<br />
			<br />
			<script>
				$(function(){
					selectReplyList(); // 페이지 로딩 된 직후에 이 게시글에 딸려있는 댓글리스트 조회 
					
					setInterval(selectReplyList, 1000); // 실시간으로 댓글 달아 놓은걸 볼 수 있다. 
				});
				
				//해당 게시글에 댓글 작성용 ajax
				function addReply(){
					$.ajax({
						url:"<%=contextPath%>/rinsert.bo",
						type:"post",
						data:{
							content:$("#replyContent").val(),
							bno : <%=b.getBoardNo()%>
						},
						success:function(result){
							if(result>0){
								//console.log("댓글작성성공");
								//댓글 작성 성고후 화면에 refresh 하지않으면 보이지 않기 떄문에 , 밑에 select문을 만들어둔 function을 사용해서 작성 후 곧 바로 보이게 하는것
								selectReplyList();
								// 텍스트 창에 기입후 댓글 성공이후에도 작성한 글이 남아 있기 때문에 없애주기 위해서 실행. .val("");  빈공간으로 세팅 
								$("#replyContent").val(""); 
							}else{
								//console.log("댓글작성실패");
							}
							
							
						},
						error:function(){
							console.log("댓글 작성용 ajax 실패")
						}
						
					});
				}
				
				//해당 게시글에 딸려있는 뎃글리스트 조회용 ajax
				function selectReplyList(){
					$.ajax({
						url:"<%=contextPath%>/rlist.bo",
						type:"get",
						data:{
							bno:<%=b.getBoardNo()%>
						},
						success:function(list){
							//console.log(list); 
							
							var result = ""; 
							for(var i in list){
								result += "<tr>" + 
											"<td>" + list[i].replyWriter + "</td>" +
											"<td>" + list[i].replyContent + "</td>" +
											"<td>" + list[i].createDate + "</td>" +
										"</tr>";
							}
							$("#replyArea>table>tbody").html(result); 
						},
						error:function(){
							console.log("댓글 리스트 조회요 ajax통신 실패")
						}
						
					});
				}
				
			</script>
		</div>
	</div>
</body>
</html>