<%@page import="qnaReply.vo.QnAReplyVO"%>
<%@page import="qna.vo.QnAVO"%>
<%@page import="boardReply.vo.BoardReplyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	QnAVO qv = (QnAVO) request.getAttribute("qv");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../images/cook.png" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" href="./css/style.css" />
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Q&A</title>

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
	List<QnAReplyVO> list = (List<QnAReplyVO>) request.getAttribute("Replylist");

	String manCod = null;
		if (loginId != null) {
		    manCod = loginId.getcusId();
		}
	ManegerVO mng = new ManegerVO();
	mng.setmenCod(manCod); //참고_ManegerVO에 menCod로 되어있음
%>	
<div class="table-wrapper">
<table> 

    <thead>
    <tr>
        <th colspan='2'>Q & A</th>
        

    </tr>
    </thead>
    <tbody>
    <tr>
       <td class="twidth">글번호</td>
	   <td><%=qv.getqNo()%></td>
    </tr>
    
   
    <tr>
       <td class="twidth">작성자</td>
		<td><%=qv.getCusId()%></td>
	</tr>    
    
    <tr>
        <td class="twidth">제목</td>
		<td><%=qv.getqTitle()%></td>
        
    </tr>
    
    <tr>
        <td class="twidth">작성일</td>
		<td><%=qv.getqDate()%></td>
       
    </tr>
    
    <tr>
       <td class="twidth">내용</td>
		<td><%=qv.getqCon()%></td>
    </tr>
    <tr id="btn">
				<td colspan="2">
<!-- 					<a href="./list.do">[목록]</a>  -->
					<button type="button" class="btn btn-light"><a href="./list.do">L I S T</a></button>
					
				<%
				if (loginId != null && loginId.getcusId().equals(qv.getCusId())) { // 작성자일 때
				%>
<%-- 					<a href="./delete.do?qNo=<%=qv.getqNo()%>">[글 삭제]</a> --%>
						 <button type="button" class="btn btn-light"><a href="./delete.do?qNo=<%=qv.getqNo()%>">D E L E T E</a></button>
					
				<%
			 	} else if (loginId != null && loginId.getcusId().equals("admin")) { // 관리자일 때
			 	%> 
<%-- 			 		<a href="./delete.do?qNo=<%=qv.getqNo()%>">[글 삭제]</a> --%>
			 		<button type="button" class="btn btn-light"><a href="./delete.do?qNo=<%=qv.getqNo()%>">D E L E T E</a></button>
			 	<%
				} else { // 로그인하지 않은 경우, 아무 작업도 수행하지 않음
				}
				%>	
				</td>
			</tr>
    </tbody>
</table> 
</div>
	
<!-- 게시글 댓글(관리자 답변) 시작 -->
	<!-- 1. 답변 등록 -->
	<br>
	<form method="post">
		<div class="test">
			<table>
				<%
				if ( loginId != null && (loginId.getcusId().equals("admin"))){ // 로그인 했고, 관리자id일 때
				%>
					<tr>
						<input type="hidden" id="commenter" name="commenter" value=<%=loginId.getcusId()%>>
					</tr>
					
					<tr>
						<td class="twidth"><label for="content">Q&A
<!-- 						<button type="button" onclick="subReply()">답변 등록</button></label></td> -->
						<button type="button" class="btn btn-light" onclick="subReply()" value="등록">답변<br>등록</button></label></td>
						<td><textarea id="content" name="content" style="width: 100%"></textarea></td>
					
					</tr>
					
				<%
				} else { // 로그인 안 했을 때, 관리자 id가 아닐 때
				%>
					<tr> 
						<td style="text-align: center;">※ 관리자 로그인 시 답변 작성이 가능합니다 ※</td>
						<input type="hidden" id="commenter" name="commenter" value=""/>
					</tr>
				<% 
				}
				%>
			</table>
		</div>
	</form>
	
	<!-- 2. 답변 출력 -->
	<table>
		<tr class="txt-cen">
			<td colspan="2">관리자 답변</td>
		</tr>
		<!-- if & for start  -->
		<%
			if (list.size() == 0) {
		%>
		<tr>
			<td colspan="2" class="txt-cen" style="color:saddlebrown">아직 답변이 등록되지 않았습니다. </td>
		</tr>
		<%
			} else {
				for (int i = 0; i < list.size(); i++) {
		%>
		<tr>
			<td colspan="2"><%=list.get(i).getqRCon() %></td>
		</tr>	
		<% 
				}
			}
		%>
	</table>

<script>
// 댓글 등록 및 출력 스크립트
function subReply() {
  // 서버에 보낼 데이터
  let data = {
	"qRCon": $("#content").val(),
// 	"cusId": $("#commenter").val(),
	"manCod":"<%=manCod%>",
	"qNo": "<%=qv.getqNo()%>"
	};

		// ajax 요청 보내기
		$.ajax({
			type : "POST", 			//데이터를 보낼 방식
			url : "./reply.do", 	//데이터를 보낼 url
			data : data, 			//보낼 데이터
			success : function(response) {
				location.reload(); 	// 성공적으로 요청 처리시 페이지 리로드
			},
			error : function(xhr) {
				alert("에러상태 >>> " + xhr.status); //에러코드 확인
			}
		});
	}
</script>
<!-- 게시글 댓글(관리자 답변) 끝 -->

</body>
</html>