<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<button>글작성</button>
			<br />
			<br />
		</div>
		<%} %>
	
		<div class="listArea">
			<div class="thumbnail" align="center">
				<img src="river2.PNG" width="200px" height="150px" /> <br />
				<p>
					No.20 제목입니다. <br /> 조회수 : 100
				</p>
			</div>
			<div class="thumbnail" align="center">
				<img src="river2.PNG" width="200px" height="150px" /> <br />
				<p>
					No.20 제목입니다. <br /> 조회수 : 100
				</p>
			</div>
			<div class="thumbnail" align="center">
				<img src="river2.PNG" width="200px" height="150px" /> <br />
				<p>
					No.20 제목입니다. <br /> 조회수 : 100
				</p>
			</div>
			<div class="thumbnail" align="center">
				<img src="river2.PNG" width="200px" height="150px" /> <br />
				<p>
					No.20 제목입니다. <br /> 조회수 : 100
				</p>
			</div>
			<div class="thumbnail" align="center">
				<img src="river2.PNG" width="200px" height="150px" /> <br />
				<p>
					No.20 제목입니다. <br /> 조회수 : 100
				</p>
			</div>
			<div class="thumbnail" align="center">
				<img src="river2.PNG" width="200px" height="150px" /> <br />
				<p>
					No.20 제목입니다. <br /> 조회수 : 100
				</p>
			</div>
		</div>
	</div>
</body>
</html>