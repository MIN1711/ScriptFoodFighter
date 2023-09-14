<%@page import="notice.vo.NoticeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
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
	color: burlywood;
}
</style>
</head>
<body>
	<%@include file="/header.jsp"%>
	<%
	List<NoticeVO> list = (List<NoticeVO>) request.getAttribute("list");
	String menCod = null;
	if (loginId != null) {
		menCod = loginId.getcusId();
	}
	ManegerVO mng = new ManegerVO();
	mng.setmenCod(menCod);
	%>
	
	<!--보드게시판 -->
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
						onclick="location.href='/FoodRecipe/notice/list.do?'"
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
		<!--보드게시판 끝-->
				<%
		if (loginId != null && (mng.getmenCod().equals("admin"))) { //로그인 성공하고, 관리자id일 때
	%>
	<!-- 글쓰기 영역 -->
	<div id="writeArea">
			<button type="button" onclick="goWrite()">
				<img src="<%=request.getContextPath() %>/images/pencil.png"">
				</button>
	</div>
	<%
		}
	%>

	<div id=listArea></div>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>글번호</th>
				<th>내용</th>
				<th>관리자</th>
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
				<td><%=list.get(i).getnNo()%></td>
				<td style="text-align: left"><a
					href="./detail.do?nNo=<%=list.get(i).getnNo()%>"><%=list.get(i).getnCon()%></a></td>

				<td><%=list.get(i).getManCod()%></td>
				<td><%=list.get(i).getnDate()%></td>
				<%
					} //for end
				}
				%>
		</tbody>
	</table>
	<!-- 페이징 영역 -->
	<div id="pageArea">
		<ul class="pager btn btn-primary" style="width: 60px">
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

		<ul class="pager btn btn-primary" style="width: 60px">
			<li class="next"><a class="page-link" href="#">Next</a></li>
		</ul>
	</div>

	</div>
</body>
<script>
	function goWrite() {
		/* 게시글 작성  */
		location.href = "./insert.do";
	}

	// 	function getselect() {

	// 		var v_select= document.getElementById('select');
	// 		console.log(v_select.value);

	// 		$(#type).attr("name",v_select.value);

	// 	}

	$('.pagination li').on('click', function() {
		alert($(this).text());
		// Main서블릿으로 페이지정보 전달

		location.href = "?page=" + $(this).text();
	});

	// 페이지 번호 클릭 이벤트

	$('.pagination li').on('click', function() {
		alert($(this).text());
		// Main서블릿으로 페이지정보 전달

		location.href = "?page=" + $(this).text();
	});

	// prev/next버튼 클릭 이벤트
	$('.next').on(
			'click',
			function() {
				//alert($('.pagination').children().last().text());
				let currentPage = parseInt($('.pagination').children().last()
						.text()) + 1;

				//계산된 currentPage값이 totalPage의 값보다 클 경우 서블릿으로 페이지 정보를 넘기지 않음
				if (currentPage >
<%=request.getAttribute("tPage")%>
	)
					return;
				location.href = "?page=" + currentPage;
			});

	$('.prev').on(
			'click',
			function() {
				// 	alert($('.pagination').children().first().text());
				let currentPage = parseInt($('.pagination').children().first()
						.text()) - 2;

				//계산된 currentPage값이 totalPage의 값보다 클 경우 서블릿으로 페이지 정보를 넘기지 않음
				if (currentPage < 1)
					return;
				location.href = "?page=" + currentPage;

				// 	cuurentPage= parseInt($('.pagination').children().first().text()) - 2;
				// 	if (currentPage < 1) return;
				// 	location.href = "/site/Main?page=" + currentPage;
			});
</script>
</html>