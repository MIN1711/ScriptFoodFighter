<%@page import="java.text.DecimalFormat"%>
<%@page import="orders.vo.CartVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<CartVO> cartList = (List<CartVO>) request.getAttribute("cList");
CustomerVO cus = (CustomerVO) request.getAttribute("cus");
DecimalFormat addComma = new DecimalFormat("#,###,###");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문상세</title>
<link href="../images/cook.png" rel="shortcut icon" type="image/x-icon">
<%@include file="/header.jsp"%>
<style>
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
	color: #fff;
	background: #73685d;
}

td, th {
	padding: 1em .5em;
	vertical-align: middle;
}

td {
	border-bottom: 1px solid rgba(0, 0, 0, .1);
	background: #fff;
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
}

.upd {
	font-weight: bold;
	height: 100vh;
	padding: 50px;
	display: flex;
	justify-content: center;
	
}
.c {
	text-align: center;
}

table {
	width: 600px;
}
</style>

</head>
<body>
	<%
		List<CartVO> cList = (List<CartVO>) request.getAttribute("cList");
	%>


	<div class="upd">
		<div class="c">
			<h3>주 문 상 세</h3>
<!-- 		</div> -->
<!-- 		<div class="c"> -->
			<table>
				<tbody>
					<tr>
						<th>배송정보</th>
						<th>주문자</th>
						<td><%=cus.getcusId()%></td>
						<th>성함</th>
						<td><%=cus.getcusName()%></td>
					</tr>
					<tr>
						<th>Tel.</th>
						<td colspan="4"><%=cus.getcusTel()%></td>
					</tr>
					<tr>
						<th>주소</th>
						<td colspan="4"><%=cus.getcusAddr()%></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		<br>
			<table>
				<tbody>
					<tr>
						<th>주문번호</th>
						<th>밀키트명</th>
						<th>가격</th>
						<th>수량</th>
						<th>합계</th>
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
						<td data-th="밀키트명"><a
							href="/FoodRecipe/recipe/detail.do?rNo=<%=cartList.get(i).getrNo()%>"><%=cartList.get(i).getrMenu()%></a></td>
						<td data-th="가격"><%=addComma.format(cartList.get(i).getmPrice())%></td>
						<td data-th="수량"><%=cartList.get(i).getCartNo()%></td>
						<%
							int sum = (cartList.get(i).getCartNo()) * (cartList.get(i).getmPrice());
						suma += sum;
						%>
						<td data-th="합"><%=addComma.format(sum)%></td>
					</tr>
					<%
						} //for end
					%>
					<tr>
						<td colspan="3"></td>
						<td>총액</td>
						<td><%=addComma.format(suma)%></td>
					</tr>

					<%
						}
					%>

				</tbody>
			</table>
			<input type="button" value="BACK" onClick="history.go(-1)">
		</div>
		</div>

</body>
</html>