<%@page import="recom.vo.RecomVO"%>
<%@page import="boardReply.vo.BoardReplyVO"%>
<%@page import="board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
<link href="../images/cook.png" rel="shortcut icon" type="image/x-icon">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
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
#test {
	margin: 0 auto;
	width: 100%;
	max-width: 70%; /* 최대 너비값 */
	background-color: gray;
}

</style>
</head>
<body>
	<%@include file="/header.jsp"%>
	
	<%
	BoardVO bv = (BoardVO) request.getAttribute("bv");
	RecomVO rv = (RecomVO) request.getAttribute("rv");
	%>
	<!-- 게시글 상세 시작 -->
	
	<div class="table-wrapper">
	
		<table>
		<thead>
    <tr>
        <th colspan='2'>게시판</th>
        

    </tr>
    </thead>
			<tr>
				<td class="twidth">글번호</td>
				<td><%=bv.getbNo()%></td>
			</tr>
			<tr>
				<td class="twidth">작성자</td>
				<td><%=bv.getCusId()%></td>
			</tr>
			<tr>
				<td class="twidth">제목</td>
				<td><%=bv.getbTitle()%></td>
			</tr>
			<tr>
				<td class="twidth">작성일</td>
				<td><%=bv.getbDate()%></td>
			</tr>
			<tr>
				<td colspan="2"><%=bv.getbCon()%></td>
			</tr>
			<tr id="btn">
				<td colspan="2">
				<% 
 				if(loginId==null){
				%>
				<button type="button" class="btn btn-light" onclick="login()">좋아요</button>
				<%	 
		        } else {
			   if(rv.getcNo().equals("LIKE")){
                %>
				<button type="button" id="likeBtn" class="btn btn-primary" onclick="likeDo()">좋아요</button> 
		    	<% 
			    } else{
				%> 
				<button type="button" id="likeBtn" class="btn btn-light" onclick="likeDo()">좋아요</button> 
	         	<% 
				}
         		}
 				%>
 				<button type="button" class="btn btn-light" onclick="list()">L I S T</button> 

    			<%
				if (loginId != null && loginId.getcusId().equals(bv.getCusId())) { // 로그인 성공하고, 관리자 ID가 아닐 때
				 %>
				 <button type="button" class="btn btn-light"><a href="./update.do?bNo=<%=bv.getbNo()%>">U P D A T E</a></button> 
				 <button type="button" class="btn btn-light"><a href="./delete.do?bNo=<%=bv.getbNo()%>">D E L E T E</a></button> 
 <%
 	} else if (loginId != null && loginId.getcusId().equals("admin")) {
 %> 
<%--  <a href="./delete.do?bNo=<%=bv.getbNo()%>">[글 삭제]</a>  --%>
 <button type="button" class="btn btn-light"><a href="./delete.do?bNo=<%=bv.getbNo()%>">D E L E T E</a></button> 
 
 <%
} else { // 로그인하지 않은 경우
 // 아무 작업도 수행하지 않음
}
 %>
				</td>
			</tr>
		</table>
	</div>
	<!-- 게시글 상세 끝 -->
	<!-- 게시글 댓글 시작 -->
	<!-- 1. 댓글 등록 -->
	<form method="post">
		<div class="test">
		<br>	
			<table>
			<thead>
    <tr>
        <th colspan='2'>댓글</th>
        

    </tr>
    </thead>
				<%
					if (loginId == null) {
				%>
				<tr>
					<td>로그인 시 댓글 작성이 가능합니다.</td>
					<input type="hidden" id="commenter" name="commenter" value="" />
				</tr>
				<%
					} else {
				%>
				<tr>
				<td class="twidth"><label for="commenter">작성자</label></td>
						<td>
							<!-- <input type="text" id="commenter" name="commenter"> -->
							<%=loginId.getcusId()%>
						</td> 
					<input type="hidden" id="commenter" name="commenter"
						value=<%=loginId.getcusId()%>>
				</tr>
				<tr>
					<td class="twidth"><label for="content" >
<!-- 					작성할 댓글<br>  -->
					<button type="button" class="btn btn-light" onclick="subReply()" value="등록">댓글<br>등록</button></label></td>
					<td><textarea id="content" name="content" style="width: 100%" placeholder="댓글 내용을 입력해주세요."></textarea></td>
				</tr>

				<%
					}
				%>

			</table>
		</div>
	</form>

	<!-- 2. 댓글 목록 출력 -->
	<%
		List<BoardReplyVO> brList = (List<BoardReplyVO>) request.getAttribute("Replylist");
	%>
	<table>
		<tr class="txt-cen">
			<td colspan="2">댓글 목록</td>
		</tr>

		<!-- if & for start  -->
		<%
			if (brList == null || brList.size() == 0) {
		%>
		<tr>
			<td colspan="2">댓글이 존재하지 않습니다.</td>
		</tr>
		<%
			} else {
		for (int i = 0; i < brList.size(); i++) {
		%>

		<%
			if (loginId == null) { //로그인 안 했을 때
		%>
		<tr>
			<td class="txt-cen"><%=brList.get(i).getCusId()%></td>
			<td><%=brList.get(i).getbRCont()%></td>
		</tr>
		<%
			} else { //로그인 했을때 시작
		%>
		<tr>
			<td class="txt-cen"><%=brList.get(i).getCusId()%></td>
			<td><%=brList.get(i).getbRCont()%></td>
			<%
				if (loginId.getcusId().equals(brList.get(i).getCusId()) || loginId.getcusId().equals("admin")) {
			%>
			<td class="txt-cen"><a href="./deleteReply.do?bRNo=<%=brList.get(i).getbRNo()%>&bNo=<%=bv.getbNo()%>">댓글삭제</a></td>
			<%
				}
			%>
		</tr>
		<%
			} //로그인 했을때 끝
		%>

		<%
			} //for end
		} //else end
		%>
	</table>

	<script>

// 댓글 등록 및 출력 스크립트

function list(){
	location.href = "./list.do";
}

function login(){
	location.href = "/FoodRecipe/login.jsp";
}

function subReply() {
  // 서버에 보낼 데이터
  let data = {
	"bRCont": $("#content").val(),
	"cusId": $("#commenter").val(),
	"bNo": "<%=bv.getbNo()%>"
			};

			// ajax 요청 보내기
			$.ajax({
				type : "POST", //데이터를 보낼 방식
				url : "./Reply.do", //데이터를 보낼 url
				data : data, //보낼 데이터
				success : function(response) {
					location.reload(); // 성공적으로 요청 처리시 페이지 리로드
				},
				error : function(xhr) {
					alert("에러상태 >>> " + xhr.status); //에러코드 확인
				}
			});
		};

var cno="<%=rv.getcNo()%>";

function likeDo() {

	let data = {
		"bNo" : "<%=rv.getbNo()%>",
		
		"cusId": "<%=rv.getCusId()%>",
		
		"cNo": cno };
	$.ajax({
		type:"POST",
		url : "./like.do",
		data : data,
		dataType : "json",
		success : function(res){
// 			console.log(res);
if(res.cNo=="LIKE"){
	$('#likeBtn').attr('class','btn btn-primary');
	cno="LIKE";
	location.reload(); // 성공적으로 요청 처리시 페이지 리로드
}else{
	$('#likeBtn').attr('class','btn btn-light');
	cno="DISLIKE";
	location.reload(); // 성공적으로 요청 처리시 페이지 리로드
}
		},
		error: function(xhr){
			alert("에러상태>>>>"+xhr.status);
		}
		
	});
	
	
};
	</script>

</body>
</html>