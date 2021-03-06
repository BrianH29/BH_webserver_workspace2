<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.board.model.vo.*" %>
<%
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage(); 
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage(); 
	
%>
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
	<%@include file="../common/menubar.jsp" %>
	
    <div class="outer">
        <br>
        <h2 align="center">게시판</h2>
        <br>

        <!--로그인 했을떄만-->
        <%if(loginUser != null){ %>
        <div align="right" style="width:860px;">
            <button onclick="location.href='<%=contextPath%>/enrollForm.bo';">글작성</button>
            <!-- <a href="<%=contextPath %>/enrollForm.bo" class="btn btn-secondary"></a>  -->
            <br><br>
        </div>
        <%} %>

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
            	<% if(list.isEmpty()) { %>
            		<tr>
            			<td colspan="6">조회된 리스트가 없습니다.</td>
            		</tr>
            	<%}else { %>
            		<%for(Board b : list) { %>
            		<tr>
	                    <td><%=b.getBoardNo() %></td>
	                    <td><%=b.getCategory() %></td>
	                    <td><%=b.getBoardTitle() %></td>
	                    <td><%=b.getBoardWriter() %></td>
	                    <td><%=b.getCount() %></td>
	                    <td><%=b.getCreateDate() %></td>
                    </tr>
                    <%} %>
            	<%} %>
            </tbody>
        </table>
        <script>
        	$(function(){
        		$(".listArea>tbody>tr").click(function(){
        			location.href = "<%=contextPath%>/detail.bo?bno=" + $(this).children().eq(0).text(); 
        		});
        	});
        	
        </script>
        
        <br><br>

        <div class="pagingArea" align="center">
       	 	<%if(currentPage != 1){ %>
	            <!-- 맨처음로(<<) -->
	            <button onclick="location.href='<%=contextPath%>/list.bo?currentPage=1';">&lt;&lt;</button>
	            <!--이전페이지(<)-->
	            <button onclick="location.href='<%=contextPath%>/list.bo?currentPage=<%=currentPage-1%>';">&lt;</button>
           	<%} %>

			<% for(int p=startPage; p<=endPage; p++) {%>
				<%if(p != currentPage) {%>
            	<button onclick="location.href='<%=contextPath%>/list.bo?currentPage=<%=p%>';"><%=p %></button>
            	<%}else { %>
            	<button disabled><%=p %></button>
            	<%} %>
            <%} %>
	
			<%if(currentPage != maxPage){ %>
	            <!--다음페이지로(>)-->
	            <button onclick="location.href='<%=contextPath%>/list.bo?currentPage=<%=currentPage+1%>';">&gt;</button>
	            <!--맨끝으로(>>)-->
	            <button onclick="location.href='<%=contextPath%>/list.bo?currentPage=<%=maxPage%>';">&gt;&gt;</button>
            <%} %>
        </div>
    </div>
</body>
</html>