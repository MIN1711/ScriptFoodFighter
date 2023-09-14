<%@page import="wish.vo.WishVO"%>
<%@page import="recipeReply.vo.RecipeReplyVO"%>
<%@page import="java.util.List"%>
<%@page import="recipe.vo.RecipeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	RecipeVO rv = (RecipeVO) request.getAttribute("rv");
	WishVO wv = (WishVO) request.getAttribute("wv");

String[] m = {rv.getrM1(), rv.getrM2(), rv.getrM3(), rv.getrM4(), rv.getrM5(), rv.getrM6()};
String[] mm = {rv.getrMm1(), rv.getrMm2(), rv.getrMm3(), rv.getrMm4(), rv.getrMm5(), rv.getrMm6()};
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css" />
<link href="../images/cook.png" rel="shortcut icon" type="image/x-icon">
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<title><%=rv.getrMenu()%>의 상세페이지</title>
<style type="text/css">
.recipedetail {
	width: 65%;
	margin: 100px auto;
}

.topimg {
	max-height: 470px;
	max-width: 388px;
}

.table-wrapper {
	margin-top: 40px;
}

table {
	margin: 0 auto;
	width: 100%;
	max-width: 80%; /* 최대 너비값 */
}

.mimg {
	width: 15vw;
}

.rep {
	background-Color: white; 
	border: 1px solid gray;
	padding: 5px;
}

.twidth {
	width: 150px;
	text-align: center;
}

#btn {
	text-align: right;
}

.txt-cen {
	text-align: center;
}

#test {
	margin: auto;
	width: 100%;
	/* 	max-width: 70%; /* 최대 너비값 */ */
	background-color: gray;
}

table {
	border-spacing: 1;
	border-collapse: collapse;
	background: white;
	border-radius: 6px;
	overflow: hidden;
	max-width: none;
	width: 100%;
	margin: 0 auto;
	position: relative;
}

table * {
	position: relative;
}

table td, table th {
	padding-left: 8px;
}

table thead tr {
	height: 60px;
	background: #FFED86;
	font-size: 16px;
}

table tbody tr {
	height: 48px;
	border-bottom: 1px solid #E3F1D5;
}

table tbody tr:last-child {
	border: 0;
}

table td, table th {
	text-align: left;
}

table td.l, table th.l {
	text-align: right;
}

table td.c, table th.c {
	text-align: center;
}

table td.r, table th.r {
	text-align: center;
}

@media screen and (max-width: 35.5em) {
	table {
		display: block;
	}
	table>*, table tr, table td, table th {
		display: block;
	}
	table thead {
		display: none;
	}
	table tbody tr {
		height: auto;
		padding: 8px 0;
	}
	table tbody tr td {
		padding-left: 45%;
		margin-bottom: 12px;
	}
	table tbody tr td:last-child {
		margin-bottom: 0;
	}
	table tbody tr td:before {
		position: absolute;
		font-weight: 700;
		width: 40%;
		left: 10px;
		top: 0;
	}
	table tbody tr td:nth-child(1):before {
		content: "Code";
	}
	table tbody tr td:nth-child(2):before {
		content: "Stock";
	}
	table tbody tr td:nth-child(3):before {
		content: "Cap";
	}
	table tbody tr td:nth-child(4):before {
		content: "Inch";
	}
	table tbody tr td:nth-child(5):before {	
		content: "Box Type";
	}
}

body {
	background: #9BC86A;
	font: 400 14px "Calibri", "Arial";
	padding: 20px;
}

blockquote {
	color: white;
	text-align: center;
}
.wish-img {
	width:38px;
	height: 38px;
}
.reply-color {
	background-color: burlywood;
	text-align: center;
}
</style>
</head>
<%@include file="/header.jsp"%>



<body>
	<div class="recipedetail">
		<h1><%=rv.getrMenu()%></h1>
			<table>
		<tr>
			<td rowspan='3'><img class="topimg" alt="음식완성사진" src="<%=rv.getrImgL()%>"></td>
			<td><div class="card border-success mb-3"
						style="max-width: 10rem;">
						<div class="card-header"><%=rv.getrType()%></div>
						<div class="card-body">                                            
							<p class="card-text"><%=rv.getrCal()%>(칼로리)</p>
					</div>
				</div>
			</td>
			<td>
			<div class="card border-primary mb-3">
			<%
			if (loginId == null) { // 로그인x
		%>

		<button type="button" class="btn btn-light" onclick="login()">찜</button>

		<%
			} else {
		if (wv.getcNo().equals("LIKE")) {
		%>
		<button type="button" class="btn btn-primary" onclick="wish()">찜</button>
		<%
			} else {
		%>
		<button type="button" class="btn btn-light" onclick="wish()">찜</button>
		<%
			}
		}
		%>
			</div>
		</td>
		<td>
		<div class="card border-primary mb-3">
		<button type="button" id="<%=rv.getrNo()%>" class="btn btn-danger"
			onclick="location.href='./milkit.do?rNo=<%=rv.getrNo()%>'">
			밀키트</button>
			</div></td>
		</tr>
		<tr>
		<td colspan='3'>
		<div class="card border-success mb-3">
			<div class="card-header">재료</div>
			<div class="card-body">
				<p class="card-text"><%=rv.getrDt()%></p>
				</div>
			</div>
		</td>
		</tr>
		
		<tr>
		<td colspan='3'>
		 <div class="card border-success mb-3">
			<div class="card-header">★Tip★</div>
				<div class="card-body">
					<p class="card-text"><%=rv.getrTip()%></p>
				</div>
			</div>
		</td>
		</tr>
	
		</table>
		<%
			for (int i = 0; i < 6; i++) {
			if (mm[i] == null || mm[i].equals("")) {
				break;
			} else {
		%>
		<div class="card border-secondary mb-3" style="max-width:;">
			<div class="card-header">
				<table>
					<tr>
						<td><img class="mimg" alt="조리사진" src="<%=mm[i]%>"></td>
						<td>
							<div class="card-body">
								<p class="card-text"><%=m[i]%></p>
							</div>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<br>
		<%
			}
		}
		%>
		<div class="card border-secondary mb-3" style="max-width:;">
			<div class="card-header">
				<table>
					<tr>
						<td><img class="mimg" alt="완성사진" src="<%=rv.getrImgS()%>">
						</td>
						<td>
							<div class="card-body">
								<p class="card-text">★★완성★ ★</p>
							</div>
						</td>
					</tr>
				</table>
			</div>
		</div>



		<form method="post">
			<div class="test">
				<table class="rep">
					<thead>
						<%
							if (loginId == null) {
						%>

						<tr>
							<td class="reply-color">로그인 시 댓글 작성이 가능합니다.</td>
							<input type="hidden" id="commenter" name="commenter" value="" />
						</tr>
						<%
							} else {
						%>
						<tr>
							<input type="hidden" id="commenter" name="commenter" value=<%=loginId.getcusId()%>>
						</tr>
						<tr>
							<td class="twidth" colspan="2"><label for="content">
							<h5>작성할 댓글</h5></label> 
							<button type="button" onclick="subReply()">댓글등록</button></td>
							</tr>

						<tr>
							<td colspan="2"><textarea id="content" name="content"
									style="width: 100%"></textarea></td>
						</tr>
						<%
							}
						%>
					</thead>
				</table>
			</div>
		</form>


		<%
			List<RecipeReplyVO> reList = (List<RecipeReplyVO>) request.getAttribute("replylist");
		%>
		<table class="rep">
			<tbody>
				<tr class="txt-cen">
					<td class="txt-cen" colspan="1">작성자</td>
					<td class="txt-cen" colspan="1">내용</td>
					<td class="txt-cen" colspan="1">삭제</td>
				</tr>
				<%
					if (reList.size() == 0) {
				%>
				<tr>
					<td colspan="2">댓글이 존재하지 않습니다.</td>
				</tr>
				<%
					} else {
				for (int i = 0; i < reList.size(); i++) {
				%>

				<%
					if (loginId == null) { //로그인 안 했을 때
				%>
				<tr>
					<td class="txt-cen"><%=reList.get(i).getCusId()%></td>
					<td class="txt-cen"><%=reList.get(i).getrRCon()%></td>
				</tr>
				<%
					} else { //로그인 했을때 시작
				%>
				<tr>
					<td class="txt-cen"><%=reList.get(i).getCusId()%></td>
					<td class="txt-cen"><%=reList.get(i).getrRCon()%></td>
					<%
						if (loginId.getcusId().equals(reList.get(i).getCusId())) {
					%>
					<td class="txt-cen"><a
						href="./deleteReply.do?rRNo=<%=reList.get(i).getrRNo()%>&rNo=<%=rv.getrNo()%>">댓글 삭제</a></td>
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
			</tbody>
		</table>
	</div>

	<script>
	function login(){
		location.href = "/FoodRecipe/login.jsp";
	}

function subReply() {
	  // 서버에 보낼 데이터
	  let data = {
		"rRCon": $("#content").val(),
		"cusId": $("#commenter").val(),
		"rNo": "<%=rv.getrNo()%>"
				};

				// ajax 요청 보내기
				$.ajax({
					type : "POST", //데이터를 보낼 방식
					url : "./reply.do", //데이터를 보낼 url
					data : data, //보낼 데이터
					success : function(response) {
						location.reload(); // 성공적으로 요청 처리시 페이지 리로드
					},
					error : function(xhr) {
						alert("에러상태 >>> " + xhr.status); //에러코드 확인
					}
				});
			}
<%
if (loginId != null) { // 로그인x
%>
var cno="<%=wv.getcNo()%>";

function wish() {
	
	let data = {
		"rNo" : "<%=wv.getrNo()%>",
		"cusId" : "<%=wv.getCusId()%>",
		"cNo" : cno
			};

			$.ajax({
				type : "POST",
				url : "/FoodRecipe/wish/wish.do",
				data : data,
				dataType : "json",
				success : function(res) {
					// console.log(res);
					if (res.cNo == "LIKE") {
						$('#likeBtn').attr('class', 'btn btn-primary');
						cno = "LIKE";
						location.reload(); // 성공적으로 요청 처리시 페이지 리로드
					} else {
						$('#likeBtn').attr('class', 'btn btn-light');
						cno = "DISLIKE";
						location.reload(); // 성공적으로 요청 처리시 페이지 리로드
					}
				},
				error : function(xhr) {
					alert("에러상태>>>>" + xhr.status);
				}
			});
		};
<%
}
%>
	</script>
</body>
</html>