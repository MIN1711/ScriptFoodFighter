
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./images/cook.png" rel="shortcut icon" type="image/x-icon">
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
		<div class="recipeall">M Y P A G E</div>
		<br>
		<div class="d">
			<table class="cat">
				<tr id="type">
					<td class="typetd"><a href="/FoodRecipe/customer/mywirtelist.do?cusId=<%=loginId.getcusId()%>"
						class="typeb">
							<button type="button" class="btn btn-secondary">내가 쓴 글</button>
					</a></td>
					<td>&nbsp;&nbsp;</td>
					<td class="typetd"><a href="/FoodRecipe/customer/mylikelist.do?cusId=<%=loginId.getcusId()%>"
						class="typeb">
							<button type="button" class="btn btn-secondary">찜/추천</button>
					</a></td>
					<td>&nbsp;&nbsp;</td>
					<td class="typetd"><a href="/FoodRecipe/customer/mybuylist.do?cusId=<%=loginId.getcusId()%>"
						class="typeb">
							<button type="button" class="btn btn-secondary">주문 내역</button>
					</a></td>
					<td>&nbsp;&nbsp;</td>
					<td class="typetd"><a href="/FoodRecipe/customer/detail.do?cusId=<%=loginId.getcusId()%>"
						class="typeb">
							<button type="button" class="btn btn-secondary">회원정보</button>
					</a></td>
					
				</tr>
			</table>
		</div>

</div>
<%-- <div class="container-fluid text-center">
   <div class="row content">
      <div class="col-sm-2 sidenav">
         <table>
            <tr>
               <td></td>
               <p>My Page</p>
            </tr>
         </table>
         <p>
            <a href="/FoodRecipe/customer/mywirtelist.do?cusId=<%=loginId.getcusId()%>">내가 쓴 글</a>
         </p>
         <p>
            <a href="/FoodRecipe/customer/mylikelist.do?cusId=<%=loginId.getcusId()%>">찜 /추천</a>
         </p>
         <p>
            <a href="/FoodRecipe/customer/mylikelist.do?cusId=<%=loginId.getcusId()%>">주문 내역</a>
         </p>
         <p>
            <a href="/FoodRecipe/customer/detail.do?cusId=<%=loginId.getcusId()%>">회원정보 수정</a>
         </p>
      </div>
      </div> --%>
</body>
</html>