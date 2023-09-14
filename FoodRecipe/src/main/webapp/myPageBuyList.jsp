<%@page import="java.text.DecimalFormat"%>
<%@page import="orders.vo.OrdersVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>

<link href="./images/cook.png" rel="shortcut icon" type="image/x-icon">
<link href="/FoodRecipe/images/cook.png" rel="shortcut icon" type="image/x-icon">

<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!-- <link href="./css/bootstrap.css" rel="stylesheet" type="text/css"> -->
<link rel="stylesheet" href="./css/style.css" />
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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

.list-group a{
display:inline-block;
height:70px;
}

.list-group > a {
	text-align: center;
	line-height : 52px;
}

#pageArea {
	display: flex;
	justify-content: center;

}

#nav {
display: flex;
text-align:center;
}

#context {
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
	color:brulywood;
}

</style>
</head>
<body>
	<%
		List<OrdersVO> myList = (List<OrdersVO>) request.getAttribute("list");
	%>
	<%@include file="/header.jsp"%>
	<%--  <%HttpSession session = request.getSession(); %>  --%>
	<%--  <%CustomerVO loginId = (CustomerVO)session.getAttribute("loginId"); %>  --%>
	<%--  <%System.out.println(loginId.getcusId()); %>   --%>

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
			<h1 id="headline"> 주문내역 </h1>
			<thead>
				<tr>
					<th>주문번호</th>
					<th>아이디 </th>
					<th>결제여부</th>
					<th>주문금액</th>
					<th>주문날짜</th>
					<th> </th>
				</tr>
			</thead>

				<tbody>
					<!-- for start  -->
					<%
						DecimalFormat addComma = new DecimalFormat("###,###");
					if (myList.size() == 0) {

				%>
				<tr>
					<td colspan="5">주문이 존재하지 않습니다.</td>
				</tr>
					<%
						} else {
					for (int i = 0; i < myList.size(); i++) {
					%>
					<tr>
						<td><a
							href="/FoodRecipe/orders/detail.do?oNo=<%=myList.get(i).getoNo()%>"><%=myList.get(i).getoNo()%></a></td>
						<td><%=myList.get(i).getCusId()%></td>
						<%
							if (myList.get(i).getoCode().equals("N")) {
						%>
						<td>진행중</td>
						<%
							} else if (myList.get(i).getoCode().equals("Y")) {
						%>
						<td>결제완료</td>
						<%
							} else if (myList.get(i).getoCode().equals("C")) {
						%>
						<td>주문취소</td>
						<%
							}
						%>
						<%
							int price = myList.get(i).getoMoney();
						%>
						<td><%=addComma.format(price)%></td>
						<td><%=myList.get(i).getoDate()%></td>
						<%
							if (myList.get(i).getoCode().equals("N")) {
						%>
						<td style="text-align: left">
						<a href="/FoodRecipe/orders/cart.do">장바구니</a> / 
						<a href="" onClick="f_winOpen()">결제</a> / 
						<a href="/FoodRecipe/orders/cancel.do?oNo=<%=myList.get(i).getoNo()%>">취소</a>
						</td>
						<%
							} else if (myList.get(i).getoCode().equals("Y")) {
						%>
						<td style="text-align: left">
						<a href="/FoodRecipe/orders/detail.do?oNo=<%=myList.get(i).getoNo()%>">상세</a> / 
						<a href="/FoodRecipe/orders/cancel.do?oNo=<%=myList.get(i).getoNo()%>">취소</a>
						</td>
						<%
							} else if (myList.get(i).getoCode().equals("C")) {
						%>
						<td style="text-align: left"><a
							href="/FoodRecipe/orders/detail.do?oNo=<%=myList.get(i).getoNo()%>">상세</a></td>
						<%
							}
						%>

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
<script>
        let v_window;
        function f_winOpen() {
            v_window = window.open("/FoodRecipe/orders/pay.do", "결제", "width=800 height=600 top=250 left=450");
        }
        
</script>
<script>

	$('.pagination li').on('click', function() {
		alert($(this).text());
		// Main서블릿으로 페이지정보 전달
		
		location.href = "?ctgNo=<%=request.getAttribute("ctgNo")%>&page="+ $(this).text();
		});
	
	// 페이지 번호 클릭 이벤트

	$('.pagination li').on('click', function() {
		alert($(this).text());
		// Main서블릿으로 페이지정보 전달
		
		location.href = "?ctgNo=<%=request.getAttribute("ctgNo")%>&page=" + $(this).text();});

	// prev/next버튼 클릭 이벤트
	$('.next').on(
			'click',
			function() {
				//alert($('.pagination').children().last().text());
				let currentPage = parseInt($('.pagination').children().last()
						.text()) + 1;

				//계산된 currentPage값이 totalPage의 값보다 클 경우 서블릿으로 페이지 정보를 넘기지 않음
				if (currentPage > <%=request.getAttribute("tPage")%>)
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