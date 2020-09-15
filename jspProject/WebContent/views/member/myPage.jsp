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
	width: 600px;
	margin: auto;
	margin-top: 50px;
}

#myPageForm table {
	margin: auto;
}

#myPageForm input {
	margin: 5px;
}
</style>
</head>
<body>
	<%@include file="../common/menubar.jsp"%>

	<%
		String userId = loginUser.getUserId();
		String userName = loginUser.getUserName();
		String phone = (loginUser.getPhone() == null) ? "" : loginUser.getPhone();
		String email = (loginUser.getEmail() == null) ? "" : loginUser.getEmail();
		String address = (loginUser.getAddress() == null) ? "" : loginUser.getAddress();
		String interest = (loginUser.getInterest() == null) ? "" : loginUser.getInterest();
		// "운동,요리"
	%>
	<div class="outer">
		<br>

		<h2 align="center">마이페이지</h2>

		<form action="<%=contextPath%>/update.me" id="myPageForm"
			method="post">
			<table>
				<tr>
					<td>* 아이디</td>
					<td><input type="text" name="userId" maxlength="12" required
						value="<%=userId%>"></td>
				</tr>

				<tr>
					<td>* 이름</td>
					<td><input type="text" name="userName" maxlength="5" required
						value="<%=userName%>" readonly></td>
					<td></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;전화번호</td>
					<td><input type="tel" name="phone" placeholder="(-포함)"
						value="<%=phone%>"></td>
					<td></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;이메일</td>
					<td><input type="email" name="email" value="<%=email%>"></td>
					<td></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;주소</td>
					<td><input type="text" name="address" value="<%=address%>"></td>
					<td></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;관심분야</td>
					<td colspan="2"><input type="checkbox" id="sports"
						name="interest" value="운동"><label for="sports">운동</label>
						<input type="checkbox" id="climbing" name="interest" value="등산"><label
						for="climbing">등산</label> <input type="checkbox" id="fishing"
						name="interest" value="낚시"><label for="fishing">낚시</label>
						<br> <input type="checkbox" id="cooking" name="interest"
						value="낚시"><label for="cooking">요리</label> <input
						type="checkbox" id="game" name="interest" value="게임"><label
						for="game">게임</label> <input type="checkbox" id="etc"
						name="interest" value="기타"><label for="etc">기타</label></td>

				</tr>
			</table>

			<script>
            	$(function(){
            		
            		var interest = "<%=interest%>
				";
					// "운동, 등산, 요리" 

					$("input[type=checkbox]").each(function() {

						//순차적으로 접근한 input요소의 value 값이 interest에 포함되어있을 경우
						//=> 해당 input요소에 checked 속성 부여
						if (interest.search($(this).val()) != -1) {
							$(this).attr("checked", true);
						}

					});

				});
			</script>

			<br> <br>
			<div align="center">
				<button type="submit">정보변경</button>
				<button type="button" data-toggle="modal"
					data-target="#updatePwdForm">PWD변경</button>
				<button type="button" data-toggle="modal" data-target="#deleteForm">회원탈퇴</button>
			</div>
		</form>
		<br> <br>

		<!-- 회원탈퇴시 보여질 모달 화면 -->
		<div class="modal" id="deleteForm" style="color: black">
			<div class="modal-dialog">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">회원탈퇴</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body" align="center">

						<b>탈퇴 후 복구가 불가능합니다. <br> 정말로 탈퇴 하시겠습니까?
						</b> <br>
						<form action="<%=contextPath%>/delete.me" method="POST">
							비밀번호 : <input type="password" name="userPwd" required> <input
								type="hidden" name="userId" value="<%=loginUser.getUserId()%>">
							<br>
							<br>
							<button type="submit" class="btn btn-danger">탈퇴하기</button>
						</form>
					</div>

				</div>
			</div>
		</div>

		<!-- 비밀번호 변경 보여질 모달 화면 -->
		<div class="modal" id="updatePwdForm" style="color: black">
			<div class="modal-dialog">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">비밀번호변경</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body" align="center">

						<form action="<%=contextPath%>/updatePwd.me" method="POST">
							<input type="hidden" name="userId"
								value="<%=loginUser.getUserId()%>">

							<table>
								<tr>
									<th>현재 비밀번호:</th>
									<td><input type="password" name="userPwd" required><br></td>
								</tr>
								<tr>
									<th>변경 비밀번호:</th>
									<td><input type="password" name="updatePwd" required></td>
								</tr>
								<tr>
									<th>변경 비밀번호 재입력</th>
									<td><input type="password" name="checkPwd" required></td>
								</tr>
							</table>
							<br>
							<button type="submit" class="btn btn-primary"
								onclick="return validatePwd();">비밀번호변경</button>
						</form>

						<script>
							function validatePwd() {
								if ($("input[name=updatePwd]").val() != $(
										"input[name=checkPwd]").val()) {
									alert("비밀번호가 일치하지 않습니다.");
									return false;
								}

							}
						</script>



					</div>

				</div>
			</div>
		</div>
	</div>

</body>
</html>
