<%@page import="notice.vo.NoticeVO"%>
<%@page import="board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작성글 수정</title>
<link href="../images/cook.png" rel="shortcut icon" type="image/x-icon">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script>
	$(document).ready(function() {
		$('#summernote').summernote();
	});
</script>

<script src="/summernote/summernote-lite.js"></script>
<script src="/summernote/lang/summernote-ko-KR.js"></script>
</head>
<body>
	<%@include file="/header.jsp"%>
	<%
		NoticeVO nv= (NoticeVO) request.getAttribute("nv");
	%>
	<form action="update.do" method="post">
		<table>
			<tr>
				<td>작성일</td>
				<td><%=nv.getnDate()%></td>
			</tr>
			<tr>
				<td>닉네임</td>
				<td><%=nv.getManCod()%></td>
			</tr>
		</table>
		<div>
			<input type="hidden" name="nNo" value="<%=nv.getnNo()%>"> 
			<input type="hidden" name="manCode" value="<%=nv.getManCod()%>">
		</div>
		<textarea rows="20" cols="20" id="summernote" name="nCon"><%=nv.getnCon()%></textarea>
		<div>
			<input type="submit" value="공지사항 수정">
		</div>
	</form>
</body>
</html>
