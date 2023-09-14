<%@page import="mypage.vo.MypageVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!-- <link href="./css/bootstrap.css" rel="stylesheet" type="text/css"> -->
<link rel="stylesheet" href="./css/style.css" />
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link href="/FoodRecipe/images/cook.png" rel="shortcut icon" type="image/x-icon">
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
.list-group {
	padding-top: 60px;
	margin-left: 35px;
	width: 230px;
	heigth: 200px;
}


#title {
	text-align: center;
	color: black;
	line-height : 52px;
}

.list-group > a {
	text-align: center;
	line-height : 52px;
}

#pageArea {
	display: flex;
	justify-content: center;;

}

#nav {
display: flex;
text-align:center;
}

#context {
/* padding-left: 60px; */
text-align:center;
text-align:center;
margin-top: 2%; 
margin-left: 8%; 
padding-right: 8%;
}

thead th {
  width: 300px; 
}

h1{
text-align : left;
padding-top: 60px;
padding-bottom : 60px;
}
.custom-btn {
color: burlywood;
}
</style>
</head>
<body>
<%
		List<MypageVO> myList = (List<MypageVO>) request.getAttribute("list");
	%>
<%@include file="/header.jsp"%>

	<div id="nav">
	<div class="list-group">
  <a href="#" class="list-group-item list-group-item-action active" aria-current="true" id="title">
    <strong>M Y P A G E</strong>
  </a>
  <a href="/FoodRecipe/customer/mywirtelist.do?cusId=<%=loginId.getcusId()%>" class="list-group-item list-group-item-action">내가 쓴 글</a>
  <a href="/FoodRecipe/customer/wishListRecom.do?cusId=<%=loginId.getcusId()%>" class="list-group-item list-group-item-action">찜</a>
   <a href="/FoodRecipe/customer/myRecomlist.do?cusId=<%=loginId.getcusId() %>" class="list-group-item list-group-item-action">추천</a>
  <a href="/FoodRecipe/customer/mybuylist.do?cusId=<%=loginId.getcusId()%>" class="list-group-item list-group-item-action">주문 내역</a>
  <a href="/FoodRecipe/customer/detail.do?cusId=<%=loginId.getcusId()%>" class="list-group-item list-group-item-action">회원정보 수정</a>
<!--   <a href="#" class="list-group-item list-group-item-action disabled" tabindex="-1" aria-disabled="true">A disabled link item</a> -->
</div>
		<div id="context">
		<div id=listArea></div>
		<table class="table table-hover">
			<h1 id="headline"> 내가 쓴 글 </h1>
			<thead>
				<tr>
					<th>글번호</th>
					<th>카테고리</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>

			<tbody>
				<!-- for start  -->
				<%
					if (myList.size() == 0) {
				%>
				<tr>
					<td colspan="5">게시글이 존재하지 않습니다.</td>
				</tr>
				<%
					} else {
				for (int i = 0; i < myList.size(); i++) {
				%>
				<tr>
					<td><%=myList.get(i).getbNo()%></td>
					<td><%=myList.get(i).getCtgNo()%></td>
					<td style="text-align: left"> <a href="/FoodRecipe/board/detail.do?bNo=<%=myList.get(i).getbNo()%>"><%=myList.get(i).getbTitle()%></a></td>
					<td><%=myList.get(i).getCusId()%></td>
					<td><%=myList.get(i).getbDate()%></td>
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
	</div>

</body>
</html>