<%@page import="java.util.List"%>
<%@page import="wish.vo.WishVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	CustomerVO cv = (CustomerVO)request.getAttribute("cv");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css" />
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Wish List</title>


<style>
</style>
</head>
<%@include file="/header.jsp"%>
<body>
					<!-- 사용? or 마이페이지에? -->

<%
	List<WishVO> list = (List<WishVO>) request.getAttribute("wishlist");
%>

	<h2>- <%=cv.getcusId()%>님의 Wish List -</h2>
	
	<table style="text-align: center">
		<!-- if & for start  -->
		<%
			if (list.size() == 0) {
		%>
		<tr>
			<td>위시리스트가 존재하지 않습니다.</td>
		</tr>
		<%
			} else {
				for (int i = 0; i < list.size(); i++) {
		%>
		<tr>
			<td><%=list.get(i).getrMenu()%></td>
		</tr>
		<%
			}
		}
		%>
	</table>
</body>
</html>
