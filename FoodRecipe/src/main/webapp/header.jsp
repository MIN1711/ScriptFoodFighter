<%@page import="maneger.vo.ManegerVO"%>
<%@page import="customer.vo.CustomerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/FoodRecipe/images/cook.png" rel="shortcut icon" type="image/x-icon">
<link href="/FoodRecipe/css/bootstrap.css" rel="stylesheet"
	type="text/css">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/FoodRecipe/css/style.css" />

</head>

<style>
nav 
.img {
	padding: 0px;
	margin: 0px;
}

#cart {
	width: 50px;
	height: 50px;
	margin-right: 20px;
	margin-left: 20px;
	padding-top: 15px;
}

#profile {
	width: 80px;
	height: 80px !important;
	margin-top: 10px;
	margin-bottom: -10px;
	border-radius: 50%;
}

a {
	text-decoration: none;
}

#loginimg {
	width: 25px;
	height: 25px;
}

#out {
	width: 25px;
	height: 25px;
}

.custom-bg {
	background-color: saddlebrown;
	height: 75px;
}

.nav-link {
	color: white;
	letter-spacing: 3.5px;
	display: flex;
	
}

#logo {
	height: 80px;
	width: 200px;
}

#d-flex {
	display: flex;
}

.d-flex {
	align-items: center;
}

.d-flex p:nth-child(3) {
	margin-top: 18px;
}

d-flex.p {
	
}



.container-fluid {
	justify-content: normal !important;
	margin-left: 45px;
}

.login_wrap {
	display: flex;
	justify-content: end;
	width: 100%;
}

.logo_wrap {
	width: 100%;
	display: flex;
	justify-content: end;
	margin-left: 100px;
}


</style>
<body>
	<%
		HttpSession session1 = request.getSession();
	CustomerVO loginId = (CustomerVO) session1.getAttribute("loginId");
	String cusId = request.getParameter("cusId");
	System.out.println(cusId);
	%>
	<%
		if (loginId == null) {
	%>
	<div id="ncustomerhead" name="ncustomer">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">

				<div class="logo_wrap">
					<a class="navbar-brand" href="/FoodRecipe/mainpage.do"><img
						id="logo" src="/FoodRecipe/images/로고5.png"
						style="display: block; text-align: center; padding-left:50px"></a>
				</div>


				<div class="login_wrap">
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarColor03"
						aria-controls="navbarColor03" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<form class="d-flex">

						<a href="/FoodRecipe/login.jsp"> <img id="loginimg"
							src="/FoodRecipe/projectImg/login.png"> LOGIN
						</a>
				</div>




				</form>
			</div>
		</nav>

		<nav class="navbar navbar-expand-lg navbar-dark custom-bg">
			<div class="container-fluid">
				<div class="collapse navbar-collapse" id="navbarColor01">
					<ul class="navbar-nav me-auto">
						<li class="nav-item"><a class="nav-link"
							href="/FoodRecipe/recipe/listtype.do">RECIPE/MEALKIT</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/FoodRecipe//restaurant.do">RESTAURANT</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/FoodRecipe/board/list.do">BOARD</a></li>

					</ul>
				</div>
			</div>
		</nav>
	</div>
	<%
		} else if (loginId.getcusId() == "admin" || loginId.getcusId().equals("admin")) {
	%>
	<div id="customerhead" name="customerhead">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">
			
				<div class="logo_wrap">
				<a class="navbar-brand" href="/FoodRecipe/mainpage.do"><img
					id="logo" src="/FoodRecipe/images/로고5.png"
					style="display: block; text-align: center;"></a>
					</div>
					
				<div class="login_wrap">	
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarColor03"
					aria-controls="navbarColor03" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<form class="d-flex">
					<a href="/FoodRecipe/logout.do"> <img id="out"
						src="/FoodRecipe/projectImg/out.png"> LOGOUT
					</a>
				</form>
			</div>
		</nav>
		</div>

		<nav class="navbar navbar-expand-lg navbar-dark custom-bg">
			<div class="container-fluid">
				<div class="collapse navbar-collapse" id="navbarColor01">
					<ul class="navbar-nav me-auto">
						<li class="nav-item"><a class="nav-link"
							href="/FoodRecipe/recipe/listtype.do" style="padding-left:15px; padding-right:60px;">RECIPE/MEAL KIT</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/FoodRecipe//restaurant.do">RESTAURANT</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/FoodRecipe/board/list.do">BOARD</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/FoodRecipe/maneger/customerlist.do">MANAGER</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<%
		} else {

	String src = "";
	if (loginId.getcusImg() != null) {
		String[] file = loginId.getcusImg().split("/");
		src = "/images/" + file[6];
	} else {
		src = "/images/basic.jpg";
	}
	%>

	<div id="customerhead" name="customerhead">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">

				<div class="logo_wrap">
					<a class="navbar-brand" href="/FoodRecipe/mainpage.do"><img
						id="logo" src="/FoodRecipe/images/로고5.png"
						style="display: block; text-align: center;"></a>
				</div>


				<div class="login_wrap">
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarColor03"
						aria-controls="navbarColor03" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<form class="d-flex">
						<p>
							<a
								href="/FoodRecipe/customer/detail.do?cusId=<%=loginId.getcusId()%>"><img
								id="profile" src="<%=request.getContextPath()%><%=src%>"
								alt="프로필사진"></a>
						</p>
						<p>
							<a href="/FoodRecipe/orders/cart.do"><img id=cart
								src=<%="/FoodRecipe/images/cart1.png"%> alt="장바구니"></a>
						</p>
						<p>
							<a href="/FoodRecipe/logout.do"> <img id="out"
								src="/FoodRecipe/projectImg/out.png"> LOGOUT
							</a>
						</p>
				</div>





				</form>
			</div>
		</nav>

		<nav class="navbar navbar-expand-lg navbar-dark custom-bg">
			<div class="container-fluid">
				<div class="collapse navbar-collapse" id="navbarColor01">
					<ul class="navbar-nav me-auto">
						<li class="nav-item"><a class="nav-link"
							href="/FoodRecipe/recipe/listtype.do">RECIPE/MEAL KIT</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/FoodRecipe//restaurant.do">RESTAURANT</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/FoodRecipe/board/list.do">BOARD</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<%
		}
	%>
</body>
</html>