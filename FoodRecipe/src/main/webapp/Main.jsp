<%@page import="java.util.List"%>
<%@page import="recipe.vo.RecipeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	List<RecipeVO> recipeList = (List<RecipeVO>) request.getAttribute("reList");
%>
<!DOCTYPE html>
<html>
<head>

  <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<meta charset="UTF-8">
<title>메인 페이지</title>
<link rel="stylesheet" type="text/css" href="./slick/slick.css">
<link rel="stylesheet" type="text/css" href="./slick/slick-theme.css">
<link rel="stylesheet" href="./css/style.css" />
<link href="./images/cook.png" rel="shortcut icon" type="image/x-icon">

<%
	String joinCd = (String)request.getAttribute("joinCode");
%>

</head>
<body>
	<%@include file="./header.jsp"%>

	<section class="vertical-center slider">
		<div>
			<a href="https://guide.michelin.com/kr/ko/restaurants" target="_blank">
			<img src="./images/food01.jpg">
			</a>
		</div>
		<div>
			<a href="https://www.pizzahut.co.kr/" target="_blank">
			<img src="./images/food02.jpg">
			</a>
		</div>
		<div>
			<a href="http://localhost:8888/FoodRecipe/recipe/detail.do?rNo=736" target="_blank">
			<img src="./images/food03.jpg">
			</a>
		</div>
		<div>
			<a href="https://montbeer.modoo.at/" target="_blank">
			<img src="./images/food05.jpg">
			</a>
		</div>
		<div>
			<a href="http://localhost:8888/FoodRecipe/recipe/listtype.do?rType=&rMenu=%EA%BC%AC%EC%B9%98" target="_blank">
			<img src="./images/food06.jpg">
			</a>
		</div>
		<div>
			<a href="http://localhost:8888/FoodRecipe/recipe/detail.do?rNo=15" target="_blank">
			<img src="./images/food07.jpg">
			</a>
		</div>
		<div>
			<a href="http://www.qooqoo.co.kr/" target="_blank">
			<img src="./images/food08.jpg">
			</a>
		</div>

	</section>
	
	<section class="center slider">

		<%
			int r = 0;
		for (int i = 0; i < 9; i++) {
			r = (int) ((Math.random() * 1000) + 1);
		%>
	
		
		<div class="showbox">
			<img class="showimg" src="<%=recipeList.get(r).getrImgS()%>">
			<input type="button" class="btn btn-outline-primary" value="<%=recipeList.get(r).getrMenu()%>" style=border-color:burlywood;
			onclick = "location.href = '/FoodRecipe/recipe/detail.do?rNo=<%=recipeList.get(r).getrNo()%>'">
		</div>
		<%
		}
		%>
	</section>


	<script src="https://code.jquery.com/jquery-2.2.0.min.js"
		type="text/javascript"></script>
	<script src="./slick/slick.js" type="text/javascript" charset="utf-8"></script>

	<script type="text/javascript">
		$(document).on('ready', function() {
			$(".vertical-center").slick({
				dots : false,
				vertical : true,
				centerMode : false,
				autoplay : true,
				autoplaySpeed : 2000,
				arrows : false
			});

			$(".center").slick({
				dots : true,
				infinite : true,
				centerMode : true,
				slidesToShow : 5,
				slidesToScroll : 3
			});
		});
	</script>


	<%@include file="./footer.jsp"%>
</body>
</html>