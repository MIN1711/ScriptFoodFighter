<%@page import="qna.vo.QnAVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q&A 목록</title>
<link href="../images/cook.png" rel="shortcut icon" type="image/x-icon">
<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!-- <link href="./css/bootstrap.css" rel="stylesheet" type="text/css"> -->
<link rel="stylesheet" href="./css/style.css" />
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 450px
}

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>
<style>
.pager {
	float: left;
}

#pageArea {
	display: flex;
	justify-content: center;
}

.boardlist {
	width: 70%;
	margin: 100px auto;
}

.d {
	display: flex;
	justify-content: center;
	margin-bottom: 70px;
}

.recipeall {
	margin-left: auto;
	font-Size: 30px;
	text-align: center;
}
.custom-btn {
	color:burlywood;
}
</style>
</head>
<body>
<!-- 리스트 출력 영역 -->
<%
	List<QnAVO> list = (List<QnAVO>) request.getAttribute("list");
%>

	<%@include file="/header.jsp"%>

	<div class="boardlist">
		<div class="recipeall">B O A R D</div>
		<br>
		<div class="d">
			<table class="cat">
				<tr id="type">
					<td class="typetd"><a href='#'
						onclick="location.href='/FoodRecipe/board/list.do?ctgNo=1'"
						class="typeb">
							<button type="button" class="btn btn-secondary">R E C I
								P E</button>
					</a></td>
					<td>&nbsp;&nbsp;</td>
					<td class="typetd"><a href='#'
						onclick="location.href='/FoodRecipe/board/list.do?ctgNo=2'"
						class="typeb">
							<button type="button" class="btn btn-secondary">H O T P
								A L C E</button>
					</a></td>
					<td>&nbsp;&nbsp;</td>
					<td class="typetd"><a href='#'
						onclick="location.href='/FoodRecipe/board/list.do?ctgNo=3'"
						class="typeb">
							<button type="button" class="btn btn-secondary">F R E E
								B O A R D</button>
					</a></td>
					<td>&nbsp;&nbsp;</td>
					<td class="typetd"><a href='#'
						onclick="location.href='/FoodRecipe/notice/list.do'"
						class="typeb">
							<button type="button" class="btn btn-secondary">N O T I
								C E</button>
					</a></td>
					<td>&nbsp;&nbsp;</td>
					<td class="typetd"><a href='#'
						onclick="location.href='/FoodRecipe/qna/list.do'" class="typeb">
							<button type="button" class="btn btn-secondary">Q & A</button>
					</a></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
			</table>
		</div>

		<form action="/FoodRecipe/board/list.do" method="post">
			<div class="form-group">
				<select id="select" onChange="getselect()">
					<option value="qTitle">제목</option>
					<option value="cusId">작성자</option>
				</select> <input id="type1" type="text" name="qTitle" size="20"
					placeholder="검색 내용 입력 ">
					 	<button type="submit">
				<img src="<%=request.getContextPath() %>/images/find.png"">
				</button>
					
		<%
			if (loginId != null) { //로그인 했을 때
		%>
		<!-- 글쓰기 영역 -->
<!-- 		<div id="writeArea"> -->
<!-- 			<input type="button" value="글작성" class="btn-xs btn-primary"   -->
<!-- 			onclick="goWrite()"> -->
<!-- 		</div> -->
					<button type="button" onclick="goWrite()">
				<img src="<%=request.getContextPath() %>/images/pencil.png"">
				</button>
		<%
			}
		%>
			</div>
		</form>

		<div id=listArea></div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>

			<tbody>
				<!-- for start  -->
				<%
					if (list.size() == 0) {
				%>
				<tr>
					<td colspan="5">게시글이 존재하지 않습니다.</td>
				</tr>
				<%
					} else {
						for (int i = 0; i < list.size(); i++) {
				%>
				<tr>
					<td><%=list.get(i).getqNo()%></td>
					<td style="text-align: left"><a
						href="./detail.do?qNo=<%=list.get(i).getqNo()%>"><%=list.get(i).getqTitle()%></td>
					<td><%=list.get(i).getCusId()%></td>
					<td><%=list.get(i).getqDate()%></td>
				</tr>
				<%
					} //for end
				} // else end
				%>
			</tbody>
		</table>

		<!-- 페이징 영역 시작-->
		<div id="pageArea">
			<ul class="pager btn btn-secondary"style="width: 60px">
				<li class="prev"><a class="page-link" href="#">Prev</a></li>
			</ul>
			<ul class="pagination">
				<!--for start  -->
				<%
				int sPage = (int) request.getAttribute("sPage");
				int ePage = (int) request.getAttribute("ePage");
				int cPage = (int) request.getAttribute("cPage");

				for (int i = sPage; i <= ePage; i++) {

					if (cPage == i) {
				%>
				<li class="page-item"><a class="page-link" href="#"><%=i%></a></li>
				<%
					} else { //for end
				%>
				<li class="page-item"><a class="page-link" href="#"><%=i%></a></li>
				<%
					} // if else end
				%>
				<%
					} //for end
				%>
			</ul>

			<ul class="pager btn btn-secondary" style="width: 60px">
				<li class="next"><a class="page-link" href="#">Next</a></li>
			</ul>
		</div>
		<!-- 페이징 영역 끝 -->
	
	</div>

<%
cusId = (String) request.getAttribute("cusId");	
System.out.println(cusId);
if (cusId == null)
	cusId = "";
String qTitle = (String) request.getAttribute("qTitle");
if (qTitle == null)
	qTitle = "";
%>
</body>
<script>
	// 게시글 작성 페이지로
	function goWrite() {
		/* 게시글 작성  */
		location.href = "./insert.do";
	}
	
	// 페이징 기능 넣어야함
// 	// 페이지 번호 클릭 이벤트

	$('.pagination li').on('click', function() {
// 		alert($(this).text());
		// Main서블릿으로 페이지정보 전달
		
		location.href = "?ctgNo=cusId=<%=cusId%>&qTitle=<%=qTitle%>&page="+ $(this).text();
<%-- 		location.href = "/FoodRecipe/board/list.do?ctgNo=<%=request.getAttribute("ctgNo")%>&page=" + $(this).text(); --%>
	});

	// prev/next버튼 클릭 이벤트
	$('.next').on('click',function() {
			    //alert($('.pagination').children().last().text());
				let currentPage = parseInt($('.pagination').children().last().text()) + 1;

				//계산된 currentPage값이 totalPage의 값보다 클 경우 서블릿으로 페이지 정보를 넘기지 않음
				if (currentPage ><%=request.getAttribute("tPage")%>)return;
				location.href = "?page=" + currentPage;
				});

	$('.prev').on('click',function() {
				// 	alert($('.pagination').children().first().text());
				let currentPage = parseInt($('.pagination').children().first()
						.text()) - 2;

				//계산된 currentPage값이 totalPage의 값보다 클 경우 서블릿으로 페이지 정보를 넘기지 않음
				if (currentPage < 1)return;
				location.href = "?page=" + currentPage;

				// 	cuurentPage= parseInt($('.pagination').children().first().text()) - 2;
				// 	if (currentPage < 1) return;
				// 	location.href = "/site/Main?page=" + currentPage;
			});	 
</script>	
</html>



