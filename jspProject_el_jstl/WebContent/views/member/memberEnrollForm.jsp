<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
        .outer{
            background:black; 
            color:white; 
            width:600px;
            margin:auto; 
            margin-top:50px;
        }

        #enrollForm table{margin:auto;}
        #enrollForm input{margin:5px;}
    </style>
</head>
<body>
	<!--메뉴바 포함시킬것-->
	<%@ include file="../common/menubar.jsp" %>

    <div class="outer">
        <br>

        <h2 align="center">회원가입</h2>

        <form action="<%=request.getContextPath() %>/insert.me" id="enrollForm" method="post">
            <table>
                <tr>
                    <td>* 아이디</td>
                    <td><input type="text" name="userId" maxlength="12" required></td>
                    <td><button type="button" onclick="idCheck();">중복확인</button></td>
                </tr>
                <tr>
                    <td>*비밀번호</td>
                    <td><input type="password" name="userPwd" maxlength="15" required></td>
                    <td></td>
                </tr>
                <tr>
                    <td>* 비밀번호 확인</td>
                    <td><input type="password" maxlength="15" required></td>
                    <td></td>
                </tr>
                <tr>
                    <td>* 이름</td>
                    <td><input type="text" name="userName" maxlength="5" required></td>
                    <td></td>
                </tr>
                <tr>
                    <td>&nbsp;&nbsp;전화번호</td>
                    <td><input type="tel" name="phone" placeholder="(-포함)"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>&nbsp;&nbsp;이메일</td>
                    <td><input type="email" name="email"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>&nbsp;&nbsp;주소</td>
                    <td><input type="text" name="address"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>&nbsp;&nbsp;관심분야</td>
                    <td colspan="2">
                        <input type="checkbox" id="sports" name="interest" value="운동"><label for="sports">운동</label>
                        <input type="checkbox" id="climbing" name="interest" value="등산"><label for="climbing">등산</label>
                        <input type="checkbox" id="fishing" name="interest" value="낚시"><label for="fishing">낚시</label>
                        <br>
                        <input type="checkbox" id="cooking" name="interest" value="낚시"><label for="cooking">요리</label>
                        <input type="checkbox" id="game" name="interest" value="게임"><label for="game">게임</label>
                        <input type="checkbox" id="etc" name="interest" value="기타"><label for="etc">기타</label>
                    </td>
                   
                </tr>
            </table>

            <br><br>
            <div align="center">
                <button type="submit" disabled id="joinBtn">회원가입</button>
                <button type="reset">초기화</button>
            </div>
        </form>
        <br><br>
    </div>
    <script>
    	function idCheck(){
    		//console.log("click"); --> 기능이 잘 되고 있는지 확인(중간중간 하는게 좋음) 
    		
    		//회원가입폼 안에 사용자가 아이디를 입력하는 input요소 객체 => jQuery 방식으로 선택
    		var $userId = $("#enrollForm input[name=userId]");
    		//console.log($userId.val());
    		
    		$.ajax({
    			url:"<%=contextPath%>/idCheck.me",
    			data:{
    				checkId:$userId.val()
    			},
    			type:"get",
    			success:function(result){
    				//console.log("success loading");
    				console.log(result); 
    				
    				if(result == "fail"){//이미존재 사용불가능
    					//alert로 문구 출력
    					alert("이미 존재하거나 탈퇴한 회원의 아이디입니다.");
    					// 다시 입력 할 수 있게 유도 
    					$userId.focus(); 
    				}else{//존재x 사용가능
    					//사용가능한 아이디입니다. 사용하시겠습니까?
    					//true
    						//더 이상 아이디값 수정가능하게끔
    						//회원가입 버튼 활성화(disabled 속성 없앨것)
    					//false
    						//다시 재입력할 수 있게 유도
    					
    					if(confirm("사용가능한 아이디입니다. 사용하시겠습니까?")){
    						$userId.attr("readonly",true); //더이상 변경 불가
    						$("#joinBtn").removeAttr("disabled");
    						
    					}else{
    						$userId.focus(); 
    					}
    				
    				}
    				
    			},
    			error:function(){
    				console.log("fail loading");
    			}
    			
    		});
    	}
    </script>
</body>
</html>