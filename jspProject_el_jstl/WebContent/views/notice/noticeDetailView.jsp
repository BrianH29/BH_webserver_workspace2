<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.notice.model.vo.Notice" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        .outer{
            background:black;
            color:white;
            margin:auto;
            margin-top:50px;
            width:800px;
            height:500px;
        }

        #detailArea{
            border:1px solid white;
        }
        #detailArea p{height:150px;}	
        #detailArea th{text-align:center}
    </style>

</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	  <div class="outer">
        <br>
        <h2 align="center">공지사항 상세보기</h2>
        <br>
        <table align="center" border="1" id="detailArea">
            <tr>
                <th width="70">제목</th>
                <td colspan="3" width="300px">${n.noticeTitle }</td>
            </tr>
            <tr>
                <th>작성자</th>
                <td>${n.noticeWriter }</td>
                <th>작성일</th>
                <td>${n.createDate }</td>
            </tr>
            <tr>
                <th>내용</th>
                <td colspan="3">
                    <p>${n.noticeContent }</p>
                </td>
            </tr>
        </table>
        <br><br>
        <div align="center">
           <!--  <button onclick="location.href'';'">목록</button> --> 
           <a href="<%=contextPath %>/list.no" class="btn btn-secondary">목록</a>

            <!--현재 로그인 사용자가 해당 글을 작성한 작성자일 경우 -->
            <% if(loginUser != null && loginUser.getUserId().equals(n.getNoticeWriter())) {%>
            <a href="<%=contextPath %>/updateForm.no?nno=<%=n.getNoticeNo() %>" class="btn btn-info">수정</a>
            <a href="<%=contextPath %>/delete.no?nno=<%=n.getNoticeNo() %>" class="btn btn-warning">삭제</a>
            <%} %>
        </div>


    </div>
	
</body>
</html>