<%@page import="java.util.Formatter"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="milkit.vo.MilkitVO"%>
<%@page import="recipe.vo.RecipeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	RecipeVO rv = (RecipeVO) request.getAttribute("rv");
MilkitVO mkv = (MilkitVO) request.getAttribute("mkv");
%>
	<%
	DecimalFormat addComma = new DecimalFormat("###,###");
 	int price = mkv.getmPrice();
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=rv.getrMenu()%>의 밀키트</title>
<link href="../images/cook.png" rel="shortcut icon" type="image/x-icon">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<style type="text/css">
.recipedetail {
	width: 65%;
	margin: 100px auto;
}

.topimg {
	max-height: 470px;
	max-width: 388px;
}

.mimg {
	width: 15vw;
}
</style>
</head>
<%@include file="/header.jsp"%>
<body>
	<div class="recipedetail">
		<h1><%=rv.getrMenu()%>
			밀키트
		</h1>
		<table>
			<tr>
				<td rowspan='3'><img class="topimg" alt="음식완성사진" src="<%=rv.getrImgL()%>"></td>
				<td>&nbsp;&nbsp;&nbsp;</td>
				<td>
					<div class="card border-success mb-3">
						<div class="card-header">구성품</div>
						<div class="card-body">
							<p class="card-text"><%=rv.getrDt()%></p>
						</div>
					</div>
					</td>
					</tr>
					
							
					<tr>					
					<td></td>
					<td>
					<div class="card border-success mb-3">
						<div class="card-header">가격</div>
						<div class="card-body">
							<p class="card-text">
								<%=addComma.format(price)%>
							</p>

						</div>
					</div>
						</tr>
						<tr>
						<td></td>
						<td>
					<div class="card text-white bg-primary mb-3" style="max-width: 10rem;">
						
						<%
							if (loginId == null) {
						%>
						<button type="submit" class="btn btn-secondary" onclick = "location.href = '/FoodRecipe/login.jsp'">구매하기</button>
					
						<button type="button" class="btn btn-secondary" onclick = "location.href = '/FoodRecipe/login.jsp'">장바구니</button>
						<%
							} else {
						%>
						<button id="toorder" type="button" class="btn btn-secondary" >구매하기</button>
					
						<button id="addorder" type="button" class="btn btn-secondary">장바구니</button>
					</div>
				</td>
				</tr>
				
		</table>
	</div>

	<script type="text/javascript">
	$(document).ready(function() {
	$('#addorder').on('click',function() {
		
		let data = {
			"cusId": "<%=loginId.getcusId()%>",
			"rNo": "<%=rv.getrNo()%>",
			"mPrice": "<%=mkv.getmPrice()%>"
				};

				$.ajax({
					type : "POST",
					url : "../orders/orders.do",
					data : data,
					success : function(response) {
						alert("장바구니에 추가되었습니다.");
					},
					error : function(xhr) {
						alert("이미 추가된 상품 / 또는 없는 상품입니다.");
					}
				});
			});
		});
	
	$(document).ready(function() {
		$('#toorder').on('click',function() {
			
			let data = {
				"cusId": "<%=loginId.getcusId()%>",
				"rNo": "<%=rv.getrNo()%>",
				"mPrice": "<%=mkv.getmPrice()%>"
					};

					$.ajax({
						type : "POST",
						url : "../orders/orders.do" ,
						data : data,
						success : function(response) {
							//alert("이동할 주소를 안넣었습니다."); //장바구니나 결제 페이지로
							location.href='/FoodRecipe/orders/cart.do'; //장바구니 페이지
								
						},
						error : function(xhr) {
							alert("이미 추가된 상품 / 또는 없는 상품입니다."); 
						}
					});
				});
			});
	</script>
	<%
		}
	%>

</body>
</html>