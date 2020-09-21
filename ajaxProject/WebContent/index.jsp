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
			location.href="test2.do?input=" + document.getElementById("test").value; 
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

</body>
</html>