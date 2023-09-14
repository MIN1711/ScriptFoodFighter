<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<!-- divinectorweb.com -->
<head>
<meta charset="UTF-8">
<style>
footer {
	background: gray;
	padding: 86px 0;
	text-align: center;
}

.single-content {
	text-align: center;
	padding: 50px 0;
}

.single-box p {
	color: #fff;
	line-height: 1.9;
	margin-right: 10px;
}

.single-box h3 {
	font-size: 16px;
	font-weight: 700;
	color: #fff;
}

.single-box .card-area i {
	color: #ffffff;
	font-size: 20px;
	margin-right: 10px;
}

.single-box ul {
	list-style: none;
	padding: 0;
}

.single-box ul li a {
	text-decoration: none;
	color: #fff;
	line-height: 2.5;
	font-weight: 100;
}

.single-box ul li {
	text-decoration: none;
	color: #fff;
	line-height: 1.5;
	font-weight: 90;
}

.single-box h2 {
	color: #fff;
	font-size: 20px;
	font-weight: 700;
}

#basic-addon2 {
	background: #fe1e4f;
	color: #fff;
}

.socials i {
	font-size: 18px;
	margin-right: 15px;
}

.socials {
	width: 40px;
}

.socials img {
	width: 100%;
}

/* @media ( max-width : 767px) { */
/* 	.single-box { */
/* 		margin-bottom: 50px; */
/* 	} */
/* } */

/* @media ( min-width : 768px) and (max-width: 991px) { */
/* 	.single-box { */
/* 		margin-bottom: 50px; */
/* 	} */
/* } */

#l1 {
	margin-left: 20px;
}

.socials2 img {
	width: 60px; 
	height: 40px;
}

.footer_wrap {
	display: flex;
	justify-content: center;
	}
	.box1{
	margin-left: 300px;
	}

</style>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.2.0/js/bootstrap.min.js">
</head>
<body>

	<footer>
		<div class="row">

			<div id="l1" class="col-lg-4 col-sm-3">

				<div class="single-box">
				<div class="box1">
					<h2>고객센터</h2>
					<button>1888-8000</button>
					<button>1:1문의</button>
					<p>운영시간</p>
					<p>전화문의 - 10:00 ~ 12:00, 13:00 ~ 17:00 / 주말·공휴일 휴무</p>
					<p>1:1 문의 - 09:00 ~ 12:00, 13:00 ~ 17:30 / 주말·공휴일 휴무</p>
					</div>
				</div>

			</div>

			<div class="col-lg-3 col-sm-3">

				<div class="single-box">
					<h2>(주) 먹 먹 또 먹</h2>
					<ul>
						<li>상호 : (주) 먹 먹 또 먹</li>
						<li>대표자 : 김형준</li>
						<li>개인정보관리책임자 : 이민호</li>
						<li>사업자 등록번호 : 112-81-12345</li>
						<li>통신판매업 신고 : 제 2023-대전중구-1940 호</li>
						<li>전화 : 1888-8000</li>
						<li>팩스 : 042-222-8201</li>
						<li>주소 : 대전광역시 중구 계룡로 846</li>
						<li>광고/제휴 문의: banana300won@naver.com</li>
					</ul>

				</div>
			</div>

			<div class="col-lg-1 col-sm-3">

				<div class="single-box">
					<h2>안 내</h2>
					<ul>
						<li><a href="#">이용시간</a></li>
						<li><a href="#">개인정보처리방침</a></li>
						<li><a href="#">공지사항</a></li>
						<li><a href="#">자주묻는질문</a></li>
					</ul>
				</div>

			</div>

			<div class="col-lg-2 col-sm-3">

				<div class="single-box">
				<h2>결 제 수 단</h2>
					<div class="footer_wrap">
						<p class="socials2">
							<img src="<%=request.getContextPath() %>/images/kakaoPay.png"">
						</p>

						<p class="socials2">
							<img src="<%=request.getContextPath() %>/images/kg.png"">
						</p>

					</div>
					<p></p>
					<p></p>
					<p></p>
					<h2>Follow us on</h2>

					<div class="footer_wrap">
						<p class="socials">
							<img src="<%=request.getContextPath() %>/images/kakao.png"">
						</p>

						<p class="socials">
							<img src="<%=request.getContextPath() %>/images/face.png"">
						</p>

						<p class="socials">
							<img src="<%=request.getContextPath() %>/images/insta.png"">
						</p>

						<p class="socials">
							<img src="<%=request.getContextPath() %>/images/nutube.png"">
						</p>
					</div>
				</div>
			</div>
		</div>

	</footer>

</body>
</html>
