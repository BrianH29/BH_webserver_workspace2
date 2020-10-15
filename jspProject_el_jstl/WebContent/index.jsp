<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		* 회원서비스		|  C(Insert)  |  R(Select)  |  U(Update)  |  D(Delete)
		=========================================================================
		    로그인			|             |      O      |             |
		   회원가입			|      O      |             |             |
		 마이페이지		|			  |      O		|			  |
		  정보변경			|			  |				|      O      |
		 [아이디중복체크]  |             |      O      |             |
		 회원탈퇴                  |   		  |   		    |	    O     |
		 
		 
		* 공지사항서비스 - 공지사항리스트조회(R)/상세조회(R)/공지사항작성(C)/공지사항수정(U)/공지사항삭제(U)
		
		* 일반게시판서비스 - 게시판리스트조회(R)/상세조회(R)/게시판작성(C)/게시판수정(U)/게시판삭제(U)/[댓글리스트조회(R)/댓글작성(C)]
		* 사진게시판서비스 - 썸네일리스트조회(R)/상세조회(R)/게시판작성,첨부파일업로드(C)
		
	-->
	
	<!-- 
		* DB 구축하고 오기
	
		* 제일 먼저 셋팅 할 것들 
		1. 이클립스 환경 Java EE 환경으로 셋팅하기
		
		2. 보여지는 UI 탭들 셋팅하기  [Window - Show View]
		   Project Explorer, Navigator, Servers, Problems, Console
		   
		3. [Window - Preferences]
			1) 인코딩 관련 한 것들 UTF-8로 바꿔주기
				>> Window - Preferences - General - Workspace 
				>> General - Editors - Text Editors - Spelling 
				>> Web - CSS Files, HTML Files, JSP Files
				>> JSON - JSON Files 
				>> XML - XML Files
				
			2) Server - Runtime Environment - Add  톰캣 설치경로 잡아주기
			
		4. [Window - Perspective - Customize Perspective  =>  Shortcuts 탭]
		   New 할 때 보여지는 부분 자주 사용되는 것들 지정하기
		   >> General - File, Folder
		   >> Java - Class, Interface, Package
		   >> Web - CSS File, JSP File, Dynamic Web Project, HTML File, Filter, Listener, Servlet
		   
		5. Dynamic Web Project 생성하기
		   1) New - Dynamic Web Project
		   2) 프로젝트명 신중하게 작성 후 Next
		   3) 하단의 default output folder 경로 수정 : WebContent\WEB-INF\classes로 변경 (직접 입력) 후 Next
		       
		       ** classes 폴더 위치를 바꾸는 이유 **
			   >> Dynamic Web Project에 src폴더에서 작성된 자바코드는 자동으로 컴파일 되어  위에서 지정된 Default output folder 내부에 저장되는데
				    톰캣을 이용하여 자바웹 어플리케이션 실행 시 톰캣이 직접적으로 사용하는 파일들은  프로젝트 전체가 아닌 WEB-INF폴더 하위 만을 읽는다!
				    그래서 컴파일된 자바코드의 모음인 classes 폴더의 위치를 WEB-INF하위로 옮겨 자동으로 인식시킨다.(web.xml도 WEB-INF 아래에 있다!)
			   >> 웹 어플리케이션의 실행 파일들을 배포를 위한 war 형식의 파일이 요구하는 구성으로 정리.
					
			   ** 경로 재설정 안하고 바로 프로젝트 그냥 생성 후
			      Properties > Java Build Path > Source 탭 > Default output folder 변경할 수 있지만 해당 방법은 추천하지 않음!!
				     왜? => 변경한다고 해서   프로젝트폴더/.settings/org.eclipse.wst.common.component 파일 내부에 저장되는 java-output-path 의 값이 변경되지 않는다!	
				     
		   4) Context root : 웹 서버 실행시 최상위 경로(root)명의 이름을 지정해줌 (자동으로 contextPath명으로 됨)
		                                              기본값으로 프로젝트명으로 되어있음 (간단하게 변경해도됨 단!! 고유하게)
		   5) Content directory : 배포되는 폴더의 최상위 폴더명 지정 (기본값 WebContent)
		   6) Generate web.xml deployment descriptor 체크하기 (안그러면 web.xml 안생김..)
		   	    왜만들어야되? => web.xml이란 파일은 컴포넌트들을 설명하고, 각종 초기화 파라미터들과 서버 기능을 활용하기 위한 컨테이너가 관리하는 보안 제한 구역을 지정하는 파일이다.
				                        톰캣이 실행되면 이 파일을 제일 먼저 읽어 초기화를 진행한다.
				         
		   7) index.jsp 페이지 만들기 (WebContent/  경로에 만들어줘야됨 그래야만 제대로 찾음) 
		
		5. Server 생성하기
		   1) 서버 생성후 더블클릭하여 수정하기
		      >> 왼쪽 아래 Server modules without publishing 체크박스 꼭 체크해주기 
		      	  왜? ==> 내가 지정한 output folder에 제대로 동기화가 돼야되는데 안할 시 이상한 경로로 동기화됨
		      >> 포트번호 바꾸기 
		                    왜? ==> 오라클 포트번호(8080)와 충돌 안나게 
		   2) 생성된 서버에 구동하고자 하는 프로젝트 올리기
		      >> Add and Remove 를 통해서
		
		6. Server Start 후 해당 웹 애플리케이션 index.jsp 페이지 잘 열리는지 체크
		   
	 
	   * 위쪽의 전반적인 세팅 다 끝났으면 프로젝트 내에 해야되는 세팅 과정 
	 	
	 	=> 프로젝트 내에 필요한 폴더 및 패키지 미리 만들어 놓기
	 	
	 	   >> 폴더 생성 (WebContent/)
	 	       외부 문서들 관리하기 위한 폴더들 : WebContent/resources/css,js,images
	 	       각 화면들 관리하기 위한 폴더들    : WebContent/views/common,member,board,notice
	 	   
	 	   >> 패키지 생성 (src/com.kh.)
	 	   common
	 	   member.controller / member.model.vo / member.model.service / member.model.dao
	 	   notice.controller / notice.model.vo / notice.model.service / notice.model.dao
	 	   board.controller / board.model.vo / board.model.service / board.model.dao
	 	   
	 	   >> 각종 driver 정보들, 쿼리문들 저장할 properties 파일들 담아줄 폴더 생성  (src/sql)
	 	   >> 각 폴더에 .properties 파일까지 만들기
	 	   sql/driver/driver.properties
	 	   sql/member/member-mapper.properties
	 	   sql/notice/
	 	   sql/board/
	 	   
	    3. com.kh.common 패키지에 JDBCTemplate 완성시키기
	    
	    4. ojdbc6 라이브러리 WebContent/WEB-INF/lib 폴더에 추가하기
	 	   
	  -->
	  
	  <%-- <%@include file="views/common/menubar.jsp" %> --%>
	  <jsp:include page="views/common/menubar.jsp" />
</body>
</html>