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
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
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
		BoardVO bv = (BoardVO) request.getAttribute("bv");
	%>

	<form action="update.do" method="post">
		<div>
			<input type="hidden" name="bNo" value="<%=bv.getbNo()%>"> 
			<input type="hidden" name="cusId" value="<%=bv.getCusId()%>">
			<label>Title</label>
			<input type="text" name="bTitle">
		</div>
		<div>
			<label>Ctg_No</label> 
			<select name="ctgNo">
				<option value="1">레시피</option>
				<option value="2">맛집</option>
				<option value="3">자유</option>
			</select>
		</div>
		<textarea rows="20" cols="20" id="summernote" name="bCon"><%=bv.getbCon()%></textarea>
		<div>
			<input type="submit" value="게시글 수정">
		</div>
	</form>
</body>
</html>
