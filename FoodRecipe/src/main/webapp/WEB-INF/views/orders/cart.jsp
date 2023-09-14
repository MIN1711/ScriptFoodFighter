<%@page import="orders.vo.OrdersVO"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="orders.vo.CartVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<CartVO> cartList = (List<CartVO>) request.getAttribute("cList");
DecimalFormat addComma = new DecimalFormat("#,###,###");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<link href="../images/cook.png" rel="shortcut icon" type="image/x-icon">
<link href="/FoodRecipe/images/cook.png" rel="shortcut icon"
	type="image/x-icon">
<link rel="stylesheet" href="./css/style.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<%@include file="/header.jsp"%>
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
	line-height: 52px;
}

.list-group a {
	display: inline-block;
	height: 70px;
}

.list-group>a {
	text-align: center;
	line-height: 52px;
}

#pageArea {
	display: flex;
	justify-content: center;
}

#nav {
	display: flex;
	text-align: center;
}

#context {
	padding-left: 60px;
	text-align: center;
	margin: auto;
}

thead th {
	width: 300px;
	text-align: center !important
}

h1 {
	text-align: left;
	padding-top: 60px;
	padding-bottom: 60px;
}

.custom-btn {
	color: brulywood;
}

body {
	background: white;
}

table {
	border: 1px #a39485 solid;
	font-size: .9em;
	box-shadow: 0 2px 5px rgba(0, 0, 0, .25);
	/*   width: 100%; */
	border-collapse: collapse;
	border-radius: 5px;
	overflow: hidden;
}

th {
	text-align: left;
}

thead {
	font-weight: bold;
	color: #141313;
	background: #deb887;
}

td, th {
	padding: 1em .5em;
	vertical-align: middle;
}

td {
	border-bottom: 1px solid rgba(0, 0, 0, .1);
	background: #fff;
	color: black;
}

a {
	color: #73685d;
}

@media all and (max-width: 768px) {
	table, thead, tbody, th, td, tr {
		display: block;
	}
	th {
		text-align: right;
	}
	table {
		position: relative;
		padding-bottom: 0;
		border: none;
		box-shadow: 0 0 10px rgba(0, 0, 0, .2);
		margin-left: auto;
		margin-right: 0;
	}
	thead {
		float: left;
		white-space: nowrap;
	}
	tbody {
		/*     overflow-x: auto; */
		overflow-y: hidden;
		position: relative;
		white-space: nowrap;
	}
	tr {
		display: inline-block;
		vertical-align: top;
	}
	th {
		border-bottom: 1px solid #a39485;
	}
	td {
		border-bottom: 1px solid #e5e5e5;
	}
	.upd {
		font-weight: bold;
		padding: 50px;
		margin-top: 2%;
		margin-left: 8%;
		padding-right: 8%;
	}
	button {
	background-color: yellow;
	}
</style>

</head>
<body>
	<%
		List<OrdersVO> myList = (List<OrdersVO>) request.getAttribute("list");
	%>

	<%--  <%HttpSession session = request.getSession(); %>  --%>
	<%--  <%CustomerVO loginId = (CustomerVO)session.getAttribute("loginId"); %>  --%>
	<%--  <%System.out.println(loginId.getcusId()); %>   --%>

	<div id="nav">
		<div class="list-group">
			<a href="#" class="list-group-item list-group-item-action active"
				aria-current="true" id="title"> <strong>M Y P A G E</strong>
			</a> <a
				href="/FoodRecipe/customer/mywirtelist.do?cusId=<%=loginId.getcusId()%>"
				class="list-group-item list-group-item-action">내가 쓴 글</a> <a
				href="/FoodRecipe/customer/wishListRecom.do?cusId=<%=loginId.getcusId()%>"
				class="list-group-item list-group-item-action">찜</a> <a
				href="/FoodRecipe/customer/myRecomlist.do?cusId=<%=loginId.getcusId()%>"
				class="list-group-item list-group-item-action">추천</a> <a
				href="/FoodRecipe/customer/mybuylist.do?cusId=<%=loginId.getcusId()%>"
				class="list-group-item list-group-item-action">주문 내역</a> <a
				href="/FoodRecipe/customer/detail.do?cusId=<%=loginId.getcusId()%>"
				class="list-group-item list-group-item-action">회원정보 수정</a>
			<!--   <a href="#" class="list-group-item list-group-item-action disabled" tabindex="-1" aria-disabled="true">A disabled link item</a> -->
		</div>
		<%
			List<CartVO> cList = (List<CartVO>) request.getAttribute("cList");
		%>



		<div class="upd" style="margin-top: 2%; margin-left: 8%; padding-right: 8%;">
			<h1>장 바 구 니</h1>
			<table style="text-align: center;">
				<thead>
					<tr>
						<th>주문번호</th>
						<th>레시피번호</th>
						<th>밀키트명</th>
						<th>가격</th>
						<th>수량</th>
						<th></th>
					</tr>
					<%
						if (cList.size() == 0) {
					%>
					<tr>
						<td colspan="5">장바구니에 상품이 존재하지 않습니다.</td>
					</tr>
					<%
						} else {
					int suma = 0;
					for (int i = 0; i < cList.size(); i++) {
					%>
					<tr>
						<td data-th="주문번호"><%=cartList.get(i).getoNo()%></td>
						<td data-th="레시피번호"><%=cartList.get(i).getrNo()%></td>
						<td data-th="밀키트명"><%=cartList.get(i).getrMenu()%></td>
						<td data-th="가격"><%=addComma.format(cartList.get(i).getmPrice())%></td>
						<td data-th="수량">
							<form action="/FoodRecipe/orders/update.do" method="get">
								<input type="hidden" name="rNo"
									value="<%=cartList.get(i).getrNo()%>"> <input
									name="cNo" type="number" min="1"
									value="<%=cartList.get(i).getCartNo()%>" style="width: 50px">
								<button type="submit" class="btn btn-outline-success">변경</button>
							</form>
						</td>
						<%
							int sum = (cartList.get(i).getCartNo()) * (cartList.get(i).getmPrice());
						suma += sum;
						%>

						<td>
							<form action="/FoodRecipe/orders/dropcart.do" method="get">
								<input type="hidden" name="rNo"
									value="<%=cartList.get(i).getrNo()%>">
								<button type="submit" class="btn btn-outline-success">삭제</button>
							</form>
						</td>
					</tr>

					<%
						} //for end
					%>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td>총액</td>
						<td><%=addComma.format(suma)%></td>
						<td><button type="button"  class="btn btn-outline-success" onclick="f_winOpen()">결제</button></td>
					</tr>
					<%
						}
					%>
				
				</tbody>
			</table>
		</div>

		<script>
			let v_window;
			function f_winOpen() {
				v_window = window.open("/FoodRecipe/orders/pay.do", "결제",
						"width=800 height=600 top=250 left=450");
			}
		</script>
</body>
</html>