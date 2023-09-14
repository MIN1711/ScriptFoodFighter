<%@page import="orders.vo.OrdersVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	List<OrdersVO> ordeList = (List<OrdersVO>) request.getAttribute("ordeList");
int revenue = 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 내역</title>
<link href="../images/cook.png" rel="shortcut icon" type="image/x-icon">
<style>
.list-group {
	padding-top: 60px;
	margin-left: 35px;
	width: 230px;
	heigth: 200px;
}

.list-group a {
	display: inline-block;
	height: 70px;
}

#title {
	text-align: center;
	color: black;
	line-height: 52px;
}

.list-group>a {
	text-align: center;
	line-height: 52px;
}

#nav {
	display: flex;
}

#context {
	padding-left: 280px;
	/*     margin: auto; */
	padding-top: 60px;
}

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
.or-list {
	text-align: center;
}
.man-list{
	background-color: burlywood;
}
.cus-list {
	text-align: center;
}
h5 {
	text-align: right;
	}
</style>
</head>
<body>

	<%@include file="/header.jsp"%>

	<div id="nav">

		<div class="list-group">
			<a href="#" class="list-group-item list-group-item-action active"
				aria-current="true" id="title"> <strong>M A N A G E R</strong>
			</a> <a href="/FoodRecipe/maneger/customerlist.do"
				class="list-group-item list-group-item-action">전체 회원 조회</a> <a
				href="/FoodRecipe/maneger/orderslist.do"
				class="list-group-item list-group-item-action">전체 주문 조회</a>
			<!--   <a href="/FoodRecipe/board/list.do" class="list-group-item list-group-item-action">회원 게시물</a> -->
		</div>

		<div id=context>
			<div id=listArea></div>
			<table class="table table-hover" border='1'>
				<thead>
					<tr class="man-list">
						<th class="or-list">주문번호</th>
						<th class="or-list">고객 닉네임</th>
						<th class="or-list">주문결제여부</th>
						<th class="or-list">주문일</th>
						<th class="or-list">주문금액</th>
						<th> </th>
					</tr>
				</thead>

				<tbody>
					<%
						int size = ordeList.size();
					if (size == 0) {
					%>

					<tr>
						<td colspan="5">회원정보가 존재하지 않습니다.</td>
					</tr>

					<%
						} else {
					for (OrdersVO ov : ordeList) {
					%>
					<tr>
						<td  class="cus-list"><a href="/FoodRecipe/orders/detail.do?oNo=<%=ov.getoNo()%>"><%=ov.getoNo()%></a></td>
						<td><%=ov.getCusId()%></td>
						<%
							if (ov.getoCode().equals("N")) {
						%>
						<td class="cus-list">진행중</td>
						<td class="cus-list"><%=ov.getoDate()%></td>
						<td class="cus-list"><%=ov.getoMoney()%></td>
						<td><a href="/FoodRecipe/maneger/cancel.do?oNo=<%=ov.getoNo()%>">취소</a></td>
						<%
							} else if (ov.getoCode().equals("Y")) {
								revenue = revenue + ov.getoMoney();
						%>
						<td class="cus-list">결제완료</td>
						<td class="cus-list"><%=ov.getoDate()%></td>
						<td class="cus-list"><%=ov.getoMoney()%></td>
						<td><a href="/FoodRecipe/maneger/cancel.do?oNo=<%=ov.getoNo()%>">취소</a></td>
						<%
							} else if (ov.getoCode().equals("C")) {
						%>
						<td class="cus-list">결제취소</td>
						<td class="cus-list"><%=ov.getoDate()%></td>
						<td class="cus-list"><%=ov.getoMoney()%></td>
						<td></td>
						<%
							}
						%>
					</tr>

					<%
						}
					}
					%>
				</tbody>
			</table>
			<h5>수익 : <%=revenue%> 원</h5>
		</div>
	</div>
</body>

</html>