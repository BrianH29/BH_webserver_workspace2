<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.board.model.vo.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        .outer{
            width:1000px;
            height:550px;
            background:black;
            color:white; 
            margin:auto;
            margin-top:50px; 
        }
        .listArea{
            border:1px solid white;
            text-align:center;
        }
        .listArea>tbody>tr:hover{
            cursor:pointer; 
            background:grey;
        }
    </style>
</head>
<body>
	<!-- 메뉴추가-->
	<%-- <%@include file="../common/menubar.jsp" %> --%>
	<jsp:include page="../common/menubar.jsp">
	
    <div class="outer">
        <br>
        <h2 align="center">게시판</h2>
        <br>

        <!--로그인 했을떄만-->
        
        <c:if test="${empty loginUser }">
	        <div align="right" style="width:860px;">
	            <button onclick="location.href='${contextPath}/enrollForm.bo';">글작성</button>
	            <!-- <a href="<%=contextPath %>/enrollForm.bo" class="btn btn-secondary"></a>  -->
	            <br><br>
	        </div>
        </c:if>

        <table align="center" class="listArea">
            <thead>
                <tr>
                    <th width="70">글번호</th>
                    <th width="70">카테고리</th>
                    <th width="300">제목</th>
                    <th width="100">작성자</th>
                    <th width="50">조회수</th>
                    <th width="100">작성일</th>
                </tr>
            </thead>
            <tbody>
            	<c:choose>
	            	<c:when test="${empty list }">
	            		<tr>
	            			<td colspan="6">조회된 리스트가 없습니다.</td>
	            		</tr>
	            	</c:when>
	            	<c:otherwise>
	            		
		            		<c:forEach var="b" items="${list }">
		            		<tr>
			                    <td>${b.boardNo }</td>
			                    <td>${b.category }</td>
			                    <td>${b.boardTitle }</td>
			                    <td>${b.boardWrither }</td>
			                    <td>${b.count }</td>
			                    <td>${b.createDate }</td>
		                    </tr>
		                    </c:forEach>
	                   </c:otherwise>
            	</c:choose>
            </tbody>
        </table>
        <script>
        	$(function(){
        		$(".listArea>tbody>tr").click(function(){
        			location.href = "detail.bo?bno=" + $(this).children().eq(0).text(); 
        		});
        	});
        	
        </script>
        
        <br><br>

        <div class="pagingArea" align="center">
       	 	<c:if test="${pi.currentPage != 1 }">
	            <!-- 맨처음로(<<) -->
	            <button onclick="location.href='list.bo?currentPage=1';">&lt;&lt;</button>
	            <!--이전페이지(<)-->
	            <button onclick="location.href='${contextPath }/list.bo?currentPage=${pi.currentPage -1 }';">&lt;</button>
           	</c:if>

			<c:forEach var="p" begin="${pi.startPage }" end="${pi.endPage }">
				<c:choose>
					<c:when test="${p != pi.currentPage }">
	            		<button onclick="location.href='list.bo?currentPage=${p}';">${p }</button>
	            	</c:when>
	            	<c:otherwise>
	            		<button disabled>${p }</button>
	            	</c:otherwise>
            	</c:choose>
            </c:forEach>
	
			<c:if test="${pi.currentPage != pi.maxPage }">
	            <!--다음페이지로(>)-->
	            <button onclick="location.href='list.bo?currentPage=${pi.currentPage + 1}';">&gt;</button>
	            <!--맨끝으로(>>)-->
	            <button onclick="location.href='list.bo?currentPage=${pi.maxPage}';">&gt;&gt;</button>
            </c:if>
        </div>
    </div>
</body>
</html>