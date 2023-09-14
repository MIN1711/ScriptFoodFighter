<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/FoodRecipe/images/cook.png" rel="shortcut icon" type="image/x-icon">
<title>Insert title here</title>
<style>

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
</style>
</head>
<body>
<%@include file="/header.jsp"%>

<div class="boardlist">
		<div class="recipeall">관리자</div>
		<br>
		<div class="d">
			<table class="cat">
				<tr id="type">
					<td class="typetd"><a href="/FoodRecipe/maneger/customerlist.do"
						class="typeb">
							<button type="button" class="btn btn-secondary">전체 회원 조회</button>
					</a></td>
					<td>&nbsp;&nbsp;</td>
					<td class="typetd"><a href="/FoodRecipe/maneger/customerlist.do?cusId=<%=loginId.getcusId()%>"
						class="typeb">
							<button type="button" class="btn btn-secondary">전체 주문 조회</button>
					</a></td>
					<td>&nbsp;&nbsp;</td>
					<td class="typetd"><a href="/FoodRecipe/board/list.do"
						class="typeb">
							<button type="button" class="btn btn-secondary">회원 게시물 조회</button>
					</a></td>
					
					
				</tr>
			</table>
		</div>

</div>
</body>
</html>