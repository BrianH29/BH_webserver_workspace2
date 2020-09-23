<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>

	
	
	<h1>AJAX 개요</h1>
	
	<p>
		Asynchronous JavaScript And Xml 의 약자로 <br>
		
		서버로부터 데이터를 가져와 전체 페이지를 새로 고치치 않고 일부만 로드할 수 있게 하는 기법!<br>
		
		우리가 기존에 a로 요청 및 form의 submit을 통해 요청했던 방식은 동기식 요청이였음<br>
		=> 응답페이지가 돌아와야만 볼수 있음(페이지 깜박거림) <br>
		페이지 깜박거림 없이 요청(비동기식 요청)을 하기 위해서는 AJAX 라는 기술이 필요함 <br><br>
		
		* 동기식 / 비동기식 <br>
		
		-동기식 <br>
		요청 처리 후 그에 해당하는 응답페이지가 돌아와야만 그 다음 작업 가능함<br>
		만약 서버에서 호출된 결과까지의 시간이 지연되면 무작정 계속 기다려야만 함(흰페이지로 보여질꺼임..)<br>
		전체 페이지가 리도드됨(즉, 페이지가 기본적으로 깜박거림)<br><br>
		
		*비동기식<br>
		현재 페이지를 유지하면서 중간중간마다 추가적으로 필요한 요청을 보내줄 수 있음<br>
		요청을 한다고 해서 페이지가 넘어가지 않음(현재 페이지 그대로임)<br>
		요청 보내놓고 그에 해당하는 응답이 돌아올떄까지 현재 페이지에서 다른 작업을 할 수 있음(즉, 페이지가 까박거리지 않음)<br>
		ex) 실시간 검색어 로딩, top-N 분석, 아이디 중복체크, 찜하기/해제하기, 댓글작성, 추천하기 등등.... <br><br>
		
		*비동식의 단점<br>
		- 현재 페이지에 지속적으로 리소스가 쌓임 -> 페이지가 현저히 느려질 수 잇음<br>
		- 페이지 내 복잡도가 기하 급수적으로 증가 -> 에러 발생시 디버깅이 어려움<br><br>
		
		* AJAX 구현방식 -> JavaScript방식/jQuery방식 (코드가 간결하고 사용하기 쉬움)
	
	</p>
	
	<h2>기존의 동기식 요청방식</h2>
	<form action="test1.do">
		입력 : 
		<input type="text" name="input">
		<input type="submit"> 
	</form>
	
	<h2>기존의 동기식 요청방식(href요청방식)</h2>
	입력:
	<input type="text" id="test">
	<button onclick="requestTest();">제출</button>
	
	<script>
		function requestTest(){
			//location.href="test2.do?input=" + $("#test").val(); 
			location.href="test2.do?input=" + document.getElementById("#test").value; 
		}
	</script>
	
	<hr>
	<h2>jQuery 방식에서의 AJAX 통신으로 비동기식 요청</h2>
	<!-- 
		$.ajax({
			속성: 속성값;
			속성: 속성값,
			....
		});

	 -->
	<h3>1. 버튼 클릭시 GET방식으로 서버에 데이터 전송 및 응답</h3>
	입력: 
	<input type="text" id="input">
	<button id="btn1">전송</button>
	<br>
	
	응답: <label id="output1">현재 응답결과 없음</label>
	<script>
		$(function(){
			$("#btn1").click(function(){
				
				//동기식요청
				//location.href="test3.do?input=" + $("#input1").val();
				
				//ajax 요청(비동기식 통식)
				$.ajax({
					url:"jqAjax1.do",				//url : 요청할 url(필수속성!!)
					data:{input:$("#input").val()},	// data: 요청시 전달할 데이터(key:value 값들의 객체형태)
					type:"get",						// type: 정송방식(get/post)
					success:function(result){		// success :ajax통신 성공시 실행할 함수 지정
						
						//result 매개변수 :  서버에서 응답이 왔을 떄 그 응답데이터가 저장될 변수 
						console.log("ajax success");
						$("#output1").text(result); 
					},
					error:function(){				// error : ajax통신 실패시 실행할 함수 지정
						console.log("ajax fail");
					},
					complete:function(){			// complete : ajax통신 성공여부와 상관없이 무조건 실행
						console.log("ajax ultimate");
					}
				});
			});
		});
	</script>
	<br>
	<h3>2. 버튼 클릭시 post방식으로 여러개의 데이터 전송 및 응답</h3>
	이름: <input type="text" id="input2_1"><br>
	나이: <input type="number" id="input2_2"><br>
	<button onclick="test2();">전송</button>
	
	<br> 
	응답:<label id="output2">현재 응답결과 없음</label>
	
	<script>
		function test2(){
			//동기식 요청
			//location.href = "jqAjax2.do?name=" + $("input2_1").val() + "&age=" +$("input2_2").val(); 
			
			$.ajax({
				url: "jqAjax2.do",
				data: {
					name:$("#input2_1").val(),
					age:$("#input2_2").val()
				},
				type: "post",
				success:function(data){
					console.log("aja 통신 성공 했습니다.");
					console.log(data);
					
					$("#output2").text(data);
				},
				error:function(){
					console.log("ajax 통신 실패 햿습니다.");
				}
			});
		};
	</script>

<br>
	<h3>3. 서버로 데이터 전송 후, 응답데이터를 vo객체로 받아보고자 할 떄</h3>
	<p>
		회원번호를 입력하여 조회하고자 하는 사용자 번호를 전달 한 후 그에 대한 응답결과(vo) 받기, <br>
		조회된 사용자가 없을 경우 "사용자 정보가 없습니다." 출력
	</p>
	
	검색할 회원번호 입력 : 
	<input type="number" id="userNo">
	<button onclick="test3();">조회</button>
	
	<div id="output3"></div>
	
	<script>
		function test3(){
			$.ajax({
				url:"jqAjax3.do",
				data:{
					userNo:$("#userNo").val()
				},
				type:"get",
				success:function(obj){
					//console.log(obj); 
					
					var result = "회원번호:" + obj.userNo + "<br>"
								+ "회원명: " + obj.userName + "<br>"
								+ "나이: " + obj.age + "<br>"
								+ "성별: " + obj.gender;
					
					$("#output3").html(result);
								
				},
				error:function(){
					console.log("ajax fail");
				}
			});
		}
	</script>
	
	<br>
	
	<h3> 4. 응답페이지로 여러개의 객체들이 담겨있는 ArrayList로 응답</h3>
	
	<button onclick="test4();">회원 전체조회</button>
	
	<br><br>
	
	<table id="memberList" border="1" style="text-align:center">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
				<th>성별</th>
			</tr>
		</thead>
		<tbody>
		
		</tbody>
	
	</table>
	
	<script>
		function test4(){
			$.ajax({
				url:"jqAjax4.do",
				type:"get",
				success:function(list){
					
					var result = "";
				
					for(var i=0; i<list.length; i++){
						//console.log(list[i].userName);
						result += "<tr>"+
									"<td>" + list[i].userNo + "</td>"+
									"<td>" + list[i].userName + "</td>"+
									"<td>" + list[i].age + "</td>"+
									"<td>" + list[i].gem + "</td>"
								  "</tr>";
					}
					$("#memberList tbody").html(result); 
				},
				error:function(){
					console.log("ajax 통신 실패");
				}
			});
		}
	</script>
	
	<h3>5. Gso을 이요한 ArrayList 가져와보기</h3>
	<button onclick="test5();">회원 전체조회</button>
	
	<br><br>
	
	<table id="memberList2" border="1" style="text-align:center">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
				<th>성별</th>
			</tr>
		</thead>
		<tbody>
			
		</tbody>
	</table>
	<script>
		function test5(){
			$.ajax({
				url:"jqAjax5.do",
				type:"get",
				success:function(list){
					console.log(list);
					
					var result = "";
					//for(var i=0; i<list.length; i++){
					for(var i in list){
						result += "<tr>" +
									"<td>" + list[i].userNo + "</td>" +
									"<td>" + list[i].userName + "</td>" +
									"<td>" + list[i].age + "</td>" +
									"<td>" + list[i].gender + "</td>" 
								"</tr>";
					}
					$("#memberList2 tbody").html(result); 
				},
				error:function(){
					console.log("fail")
				}
				
			});
		}
	</script>
	
	
	<br><br><br><br><br><br><br><br>
</body>
</html>