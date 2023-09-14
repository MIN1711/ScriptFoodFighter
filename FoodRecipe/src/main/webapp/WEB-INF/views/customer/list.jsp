
<%@page import="customer.vo.CustomerVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<CustomerVO> cusList = 
 		(List<CustomerVO>) request.getAttribute("cusList");
	
 	String msg = (String) session.getAttribute("msg");
 	session.removeAttribute("msg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../images/cook.png" rel="shortcut icon" type="image/x-icon">
<title>회원목록</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>주소</th>			
		</tr>
<%
	int size = cusList.size();
	
	if(size == 0) {
%>

	<tr>
		<td colspan="5">회원정보가 존재하지 않습니다.</td>
	</tr>

<%
	}else{
		for(CustomerVO cv : cusList){
%>
		<tr>
			<td><a href="./detail.do?cusId=<%=cv.getcusId() %>"><%=cv.getcusId() %></a></td>
			<td><%=cv.getcusName() %></td>
			<td><%=cv.getcusTel() %></td>
			<td><%=cv.getcusAddr() %></td>
			
		</tr>
<%			
		}
	}
%>



	<tr align="center">
		<td colspan="5"><a href="./insert.do">[회원 등록]</a></td>
	</tr>

	</table>
<%if(msg != null && msg.equals("성공")){ %>
<script>
	alert('정상적으로 처리되었습니다');
</script>
<%} %>
</body>
</html>