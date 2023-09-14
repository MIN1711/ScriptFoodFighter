<%@page import="notice.vo.NoticeVO"%>
<%@page import="boardReply.vo.BoardReplyVO"%>
<%@page import="board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	NoticeVO nv = (NoticeVO) request.getAttribute("nv");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>게시글</title>
<link href="../images/cook.png" rel="shortcut icon" type="image/x-icon">
<style>
.table-wrapper {
	margin-top: 40px;
}

table {
	margin: 0 auto;
	width: 100%;
	max-width: 80%; /* 최대 너비값 */
}

table tr, table td {
	border: 1px solid gray;
	padding: 5px;
}

.twidth {
	width: 100px;
	text-align: center;
}

#btn {
	text-align: right;
}
.txt-cen {
	text-align: center;
}

#test {
	margin: 0 auto;
	width: 100%;
	max-width: 70%; /* 최대 너비값 */
	background-color: gray;
}

body {
  padding:1.5em;
  background: #f5f5f5
}

table {
  border: 1px #a39485 solid;
  font-size: .9em;
  box-shadow: 0 2px 5px rgba(0,0,0,.25);
  width: 100%;
  border-collapse: collapse;
  border-radius: 5px;
  overflow: hidden;
}

th {
  text-align: left;
}
  
thead {
  font-weight: bold;
  color: white;
  background-color: burlywood;
}
  
 td, th {
  padding: 1em .5em;
  vertical-align: middle;
}
  
 td {
  border-bottom: 1px solid rgba(0,0,0,.1);
  background: #fff;
}

a {
  color: #73685d;
}
</style>
</head>
<body>
	<%@include file="/header.jsp"%>
	<%
	String menCod = null;
	if (loginId != null) {
		menCod = loginId.getcusId();
	}
	ManegerVO mng = new ManegerVO();
	mng.setmenCod(menCod);
	%>
	<!-- 게시글 상세 시작 -->
	<div class="table-wrapper">
		<table>
	
	<thead>
    <tr>
        <th colspan='2'>공지사항</th>
    </tr>
    </thead>
    <tbody>
    <tr>
       <td class="twidth">글번호</td>
	   <td><%=nv.getnNo()%></td>
    </tr>
    <tr>
       <td class="twidth">작성자</td>
		<td><%=nv.getManCod()%></td>
	</tr>    
    <tr>
        <td class="twidth">작성일</td>
		<td><%=nv.getnDate()%></td>
    </tr>
    <tr>
       <td class="twidth">내용</td>
		<td><%=nv.getnCon()%></td>
    </tr>
			<tr id="btn">
				<td colspan="2">
					</form>
<!-- 					 <a href="./list.do">[목록]</a>  -->
					<button type="button" class="btn btn-light"> <a href="list.do">L I S T</a></button> 
					
<%
 	if (loginId != null && (mng.getmenCod().equals("admin"))) { //로그인 성공하고, 관리자id일 때
%> 
<%--  <a href="./update.do?nNo=<%=nv.getnNo()%>">[글수정]</a> --%>
<%--   <a href="./delete.do?nNo=<%=nv.getnNo()%>">[글 삭제]</a>  --%>
  	 <button type="button" class="btn btn-light"> <a href="./update.do?nNo=<%=nv.getnNo()%>">U P D A T E</a></button> 
				 <button type="button" class="btn btn-light"> <a href="./delete.do?nNo=<%=nv.getnNo()%>">D E L E T E</a></button> 
<%
 	}
%>
				</td>
			</tr>
		</table>
	</div>

</body>
</html>