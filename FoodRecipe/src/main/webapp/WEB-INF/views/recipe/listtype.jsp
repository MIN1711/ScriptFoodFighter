<%@page import="recipe.vo.RecipeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String rType = (String)request.getAttribute("rType") == null ? "" : (String)request.getAttribute("rType");	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레시피 리스트</title>
<link href="../images/cook.png" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" href="/css/style.css" />
<style>
img {
	width: 150px;
	height: 150px;
}

.btn-outline-success {
	width: 150px;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}

#type {
	font-Size: 25px;
	width: 40px;
	list-style: none;
}

.typea {
	text-decoration: none;
}

button {
	font-Size: 25px;
	text-decoration: none;
	color: black;
}

td {
	border: 1px solid black;
}

tr {
	text-align: center;
}

#tb1 {
	width: 210px;
	height: 210px;
}

html, body {
	margin: 0;
	padding: 0;
}

* {
	box-sizing: border-box;
}

.recipelist {
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
	background-color: burlywood;
}

#asdie {
	position:fixed;
}
.up {
	width:40px;
	height: 40px;
	text-align: right;
}
</style>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<%
		List<RecipeVO> rt = (List<RecipeVO>) request.getAttribute("rt");
	%>  

	<%@include file="/header.jsp"%>
	<section>
		<div class="recipelist">
		<div class="recipeall">R E C I P E</div>
		<br>
		<div class="d">
			<table class="cat">
				<tr id="type">
					<td class="typetd"><a href='../recipe/listtype.do'
						class="typeb">
							<button type="button" class="btn btn-secondary">전체</button>
					</a></td>
					<td>&nbsp;&nbsp;</td>
					<td class="typetd"><a
						href="/FoodRecipe/recipe/listtype.do?rType=밥" class="typeb">
							<button type="button" class="btn btn-secondary">밥</button>
					</a></td>

					<td class="typetd"><a
						href="/FoodRecipe/recipe/listtype.do?rType=국&찌개" class="typeb">
							<button type="button" class="btn btn-secondary">국&찌개</button>
					</a></td>
					<td class="typetd"><a
						href="/FoodRecipe/recipe/listtype.do?rType=반찬" class="typeb">
							<button type="button" class="btn btn-secondary">반찬</button>
					</a></td>
					<td class="typetd"><a
						href="/FoodRecipe/recipe/listtype.do?rType=일품" class="typeb">
							<button type="button" class="btn btn-secondary">일품</button>
					</a></td>
					<td class="typetd"><a
						href="/FoodRecipe/recipe/listtype.do?rType=후식" class="typeb">
							<button type="button" class="btn btn-secondary">후식</button>
					</a></td>
					<td class="typetd"><a
						href="/FoodRecipe/recipe/listtype.do?rType=기타" class="typeb">
							<button type="button" class="btn btn-secondary">기타</button>
					</a></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
			</table>
		</div>
		
		<form class="d-flex" action="/FoodRecipe/recipe/listtype.do" method="get">
		<div class="form-group">
			<select class="form-select" name="rType" style="margin-left: 3rem; width: 8rem;">
				<option value="" <%if(rType.equals("")){ %>selected="selected" <%} %>>전체</option>
				<option value="밥" <%if(rType.equals("밥")){ %>selected="selected" <%} %>>밥</option>
				<option value="국" <%if(rType.equals("국")){ %>selected="selected" <%} %>>국/찌개</option>
				<option value="반찬" <%if(rType.equals("반찬")){ %>selected="selected" <%} %>>반찬</option>
				<option value="일품" <%if(rType.equals("일품")){ %>selected="selected" <%} %>>일품</option>
				<option value="후식" <%if(rType.equals("후식")){ %>selected="selected" <%} %>>후식</option>
				<option value="기타" <%if(rType.equals("기타")){ %>selected="selected" <%} %>>기타</option>
			</select>
		</div>
        <input name="rMenu" value="" class="form-control me-sm-2" type="search" placeholder="Search" style="width:10rem; margin-left: 20px;">
        <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
      </form>


		<%
			for (int i = 0; i < rt.size(); i++) {
		%>
		<table id="tb1" style="float: left">
			<tr>
				<td><a href="./detail.do?rNo=<%=rt.get(i).getrNo()%>"><img
						src="<%=rt.get(i).getrImgS()%>"></a></td>
			</tr>
			<tr>
				<td><button type="button" class="btn btn-outline-success"
						style="width: 150px;"
						onclick="location.href = './detail.do?rNo=<%=rt.get(i).getrNo()%>'">
						<%=rt.get(i).getrMenu()%>
					</button></td>
			</tr>
		</table>
		<%
			}
		%>
	</div>
	</section>
	<aside>
	<div>
	<a id="asdie" href="/FoodRecipe/recipe/listtype.do"><img class="up" src="/FoodRecipe/images/t3.png"></a>
	</div>
	</aside>

</body>
</html>