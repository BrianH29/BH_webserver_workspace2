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
            width:800px;
            height:500px;
            margin:auto; 
            margin-top:50px; 
        }
        #enrollForm>table{
            border:1px solid white;
        }
        #enrollForm input, #enrollForm textarea{
            width:100%;
            box-sizing:border-box; 
        }
    </style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<div class="outer">
        <br>
        <h2 align="center">공지사항 작성하기</h2>

        <form id="enrollForm" action="<%=contextPath %>/insert.no" method="post">
        	<input type="hidden" name="userNo" value="<%= loginUser.getUserNo()%>">
            <table align="center">
                <tr>
                    <th>제목</th>
                    <td colspan="3" width="300px"><input type="text" name="title"></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td colspan="3"></td>
                </tr>

                <tr>
                    <td colspan="4">
                        <textarea name="content" style="resize:none" rows="10"></textarea>
                    </td>
                </tr>

                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </table>
            <br><br>
            <div align="center">
                <button type="submit">등록하기</button>
                <button type="button" onclick="history.back();">뒤로가기</button>
            </div>

        </form>
    </div>
</body>
</html>