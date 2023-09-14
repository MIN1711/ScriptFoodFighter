
<%@page import="customer.vo.CustomerVO"%>
<%-- <%@page import="recipe.vo.CusFileVo"%> --%>
<%-- <%@page import="customer.vo.CustomerVO"%> --%>
<%@page import="java.util.List"%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String src2 = "";
CustomerVO cv = (CustomerVO) request.getAttribute("cv");
if (cv.getcusImg() != null) {
	String[] file = cv.getcusImg().split("/");
	src2 = "../images/" + file[6];
} else {
	src2 = "../images/basic.jpg";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 상세</title>
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
	padding-left: 60px;
	margin: auto;
}

td {
	width: 50px;
}

#profileimg {
	height: 180px;
	width: 180px;
}

tr {
	text-align: center;
	margin-bottom: 50px;
	height: 50px;
}

tr:nth-child(1) {
	height:;
	background-color: light
}

body {
	background: white;
}

table {
	/*   border: 1px lightgray solid; */
	font-size: 1.2em;
	box-shadow: 0 2px 5px rgba(0, 0, 0, .25);
	/*   width: 100%; */
	border-collapse: collapse;
	border-radius: 5px;
	overflow: hidden;
	margin-left: auto;
}

th {
	text-align: center;
	width: 150px;
}

thead {
	font-weight: bold;
	color: #fff;
	background: #73685d;
}

td, th {
	width: 200px;
	height: 100px;
	padding: 1em .5em;
	vertical-align: middle;
}

td {
	width: auto;
	background: #fff;
	text-align: left;
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
		border: none;
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
		/*     border-bottom: 1px solid #a39485; */
		
	}
	td {
		/*     border-bottom: 1px solid #e5e5e5; */
		
	}
}

.upd {
	font-weight: bold;
	padding: 50px;
	margin-left: auto;
	margin-right: auto;
}

#img {
	text-align: center;
}

.gmd-5 {
	-webkit-box-shadow: 0 19px 38px rgba(0, 0, 0, 0.30), 0 15px 12px
		rgba(0, 0, 0, 0.22);
	-moz-box-shadow: 0 19px 38px rgba(0, 0, 0, 0.30), 0 15px 12px
		rgba(0, 0, 0, 0.22);
	-ms-box-shadow: 0 19px 38px rgba(0, 0, 0, 0.30), 0 15px 12px
		rgba(0, 0, 0, 0.22);
	-o-box-shadow: 0 19px 38px rgba(0, 0, 0, 0.30), 0 15px 12px
		rgba(0, 0, 0, 0.22);
	box-shadow: 0 19px 38px rgba(0, 0, 0, 0.30), 0 15px 12px
		rgba(0, 0, 0, 0.22);
	width: auto;
}

.MyPage_cell__title {
	margin-bottom: 10px;
	font-size: 1.1rem;
}

.gmd-5>th {
	width: 70px;
}

.custom-id {
	text-align: center;
}

#update { 
width: 45px;
	height: 45px;
	background: linear-gradient(to right,  #f2b40c, #f5d682);
	border-radius: 10px; 
	border: none; 
	box-shadow: 0px 4px 0px #D1B757; 
	color:white;
} 
</style>
<style>
@import
	url('https://fonts.googleapis.com/css?family=Josefin+Sans&display=swap')
	;

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	list-style: none;
	font-family: 'Josefin Sans', sans-serif;
}

body {
	background-color: #f3f3f3;
}

.wrapper {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	width: 700px;
	display: flex;
	box-shadow: 0 1px 20px 0 rgba(69, 90, 100, .08);
}

.wrapper .left {
	width: 35%;
	background: linear-gradient(to right, #f2b40c, #f5d682);
	padding: 30px 25px;
	border-top-left-radius: 5px;
	border-bottom-left-radius: 5px;
	text-align: center;
	color: #fff;
}

.wrapper .left img {
	border-radius: 5px;
	margin-bottom: 10px;
	wi
}

.wrapper .left h4 {
	margin-bottom: 10px;
	font-size: 40px;
}

.wrapper .left p {
	font-size: 20px;
}

.wrapper .right {
	width: 65%;
	background: #fff;
	padding: 30px 25px;
	border-top-right-radius: 5px;
	border-bottom-right-radius: 5px;
}

.wrapper .right .info, .wrapper .right .projects {
	margin-bottom: 25px;
}

.wrapper .right .info h3, .wrapper .right .projects h3 {
	margin-bottom: 15px;
	padding-bottom: 5px;
	border-bottom: 1px solid #e0e0e0;
	color: #353c4e;
	text-transform: uppercase;
	letter-spacing: 5px;
}

.wrapper .right .info_data, .wrapper .right .projects_data {
	display: flex;
	justify-content: space-between;
}

.wrapper .right .info_data .data, .wrapper .right .projects_data .data {
	width: 45%;
}

.wrapper .right .info_data .data h4, .wrapper .right .projects_data .data h4
	{
	color: #353c4e;
	margin-bottom: 5px;
}

.wrapper .right .info_data .data p, .wrapper .right .projects_data .data p
	{
	font-size: 13px;
	margin-bottom: 10px;
	color: #919aa3;
}

.wrapper .social_media ul {
	display: flex;
}

.wrapper .social_media ul li {
	width: 45px;
	height: 45px;
	background: linear-gradient(to right,  #f2b40c, #f5d682);
	margin-right: 10px;
	border-radius: 5px;
	text-align: center;
	line-height: 45px;
}

.wrapper .social_media ul li a {
	color: #fff;
	display: block;
	font-size: 18px;
}
</style>
<script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
</head>

<body>
	<%@include file="/header.jsp"%>
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
				class="list-group-item list-group-item-action">회원 정보</a>
		</div>

		<div class="wrapper">
			<div class="left">
			<br><br><br><br><br>
				<img src="../images/<%=src2%>" alt="user" width="100">
				<h4><%=cv.getcusId()%>
					님
				</h4>
				<!--          <p>UI Developer</p> -->
			</div>
			<div class="right">
				<div class="info">
					<h3>Information</h3>
					<div class="info_data">
						<div class="data">
							<h4>Name</h4>
							<p><%=cv.getcusName()%></p>
						</div>


					</div>
				</div>

				<div class="info">
					<div class="info_data">
						<div class="data">
							<h4>Address</h4>
							<p><%=cv.getcusAddr()%></p>
						</div>
					</div>
				</div>

				<div class="info">
					<div class="data">
						<h4>Phone</h4>
						<p><%=cv.getcusTel()%></p>
					</div>

				</div>
				<div class="social_media">
					<ul>
<!-- 					<li><button type="button" value="수정" id="update">수정</button></li> -->
						<input type="button" value="수정" id="update" style="float: right;">
					</ul>
				</div>
			</div>

		</div>
	</div>
	     
	  <div class="modal" id="myModal">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">비밀번호 확인</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true"></span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <p>비밀번호를 입력해주세요. <input type="password" id="chk"></p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-primary" id="pwChk" onClick="location.href='./update.do?cusId=<%=cv.getcusId() %>'">확인</button>
	        <span id="disp"></span>
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id="close">취소</button>
	      </div>
	    </div>
	  </div>
	</div> 
	
	<div class="modal" id="myModal1">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">회원 탈퇴</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true"></span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <p>비밀번호를 입력해주세요. <input type="password" id="chk"></p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-primary" id="pwChk" onClick="location.href='./delete.do?cusId=<%=cv.getcusId() %>'">확인</button>
	        <span id="disp"></span>
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id="close">취소</button>
	      </div>
	    </div>
	  </div>
	</div> 
	
	
 <script> 
  //window.onload = function({
 	let v_modal = document.querySelector("#myModal");
 	
 	document.querySelector('#update').addEventListener('click', function(){
       
     v_modal.style.display = "block"; // 보이는 상태로 변경
    // 'backdrop':"false";
  });

 	document.querySelector('#close').addEventListener('click', function(){
      v_modal.style.display = "none"; // 안 보이는 상태로 변경


  });
  
  //});
 
 </script> 
 
 <script> 
  //window.onload = function({
 	let v_modal1 = document.querySelector("#myModal1");
 	
 	document.querySelector('#delete').addEventListener('click', function(){
       
     v_modal1.style.display = "block"; // 보이는 상태로 변경
    // 'backdrop':"false";
  });

 	document.querySelector('#close').addEventListener('click', function(){
      v_moda1l.style.display = "none"; // 안 보이는 상태로 변경


  });
  
  //});
 
 </script> 
 
<!--  비밀번호 확인 -->
 <script>
 $(function() {
	$('#pwChk').on('click', function(){
		$('#disp').text("");
		
		let pwvalue = $('#cusPw').val();
		
		$.ajax({
			url: '<%=request.getContextPath()%>/mypage/PwChk.do',
			type: 'get',
			data: { 'pw' : pwvalue},
			success: function(res) {
				console.log(res)
				if(res.code == "ok" ){
					$('#disp').text("");
				}else{
					$('#disp').text("");
				}
			},
			error : function(xhr) {
				alert("상태:" + xhr.status)
			},
			dataType: 'json'
		})
	});
	 
	 
	 
	 
 });
 
 
 
 </script>
	
</body>