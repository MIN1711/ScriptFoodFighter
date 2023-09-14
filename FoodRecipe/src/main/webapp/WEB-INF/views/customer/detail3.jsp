
<%@page import="customer.vo.CustomerVO"%>
<%-- <%@page import="recipe.vo.CusFileVo"%> --%>
<%-- <%@page import="customer.vo.CustomerVO"%> --%>
<%@page import="java.util.List"%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   
<%
   String src2 = "";
   CustomerVO cv = (CustomerVO) request.getAttribute("cv");
   if(cv.getcusImg() != null){
      String[] file = cv.getcusImg().split("/");
      src2 = "../images/" + file[6];
   } else{
      src2="../images/basic.jpg";
   }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 상세</title>
<link href="../images/cook.png" rel="shortcut icon" type="image/x-icon">
<%@include file="/header.jsp"%>
 <style> 



.list-group {
	padding-top: 60px;
	margin-left: 35px;
	width: 230px;
	heigth: 200px;
}

.list-group a{
display:inline-block;
height:70px;
}

#title {
	text-align: center;
	color: black;
	line-height : 52px;
}

.list-group > a {
	text-align: center;
	line-height : 52px;
	
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
  box-shadow: 0 2px 5px rgba(0,0,0,.25);
/*   width: 100%; */
  border-collapse: collapse;
  border-radius: 5px;
  overflow: hidden;
   margin-left:auto; 
}

th {
  text-align: center;
  width:150px;
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
    box-shadow: 0 0 10px rgba(0,0,0,.2);
    margin-left:auto; 
    margin-right:0;
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
  -webkit-box-shadow: 0 19px 38px rgba(0, 0, 0, 0.30), 0 15px 12px rgba(0, 0, 0, 0.22);
  -moz-box-shadow: 0 19px 38px rgba(0, 0, 0, 0.30), 0 15px 12px rgba(0, 0, 0, 0.22);
  -ms-box-shadow: 0 19px 38px rgba(0, 0, 0, 0.30), 0 15px 12px rgba(0, 0, 0, 0.22);
  -o-box-shadow: 0 19px 38px rgba(0, 0, 0, 0.30), 0 15px 12px rgba(0, 0, 0, 0.22);
  box-shadow: 0 19px 38px rgba(0, 0, 0, 0.30), 0 15px 12px rgba(0, 0, 0, 0.22);
  width: auto;
	
}

.MyPage_cell__title{
  margin-bottom:10px;
  font-size:1.1rem;
}

.gmd-5 > th {
width: 70px;

}
.custom-id {
 	text-align: center;
}

#update{
background-color: #f0d264;
 border-radius: 10px;
 border:none;
 box-shadow:0px 4px 0px #D1B757;
}
 </style> 
</head>
<body>
<div id="nav">

<div class="list-group">
  <a href="#" class="list-group-item list-group-item-action active" aria-current="true" id="title">
    <strong>M Y P A G E</strong>
  </a>
  <a href="/FoodRecipe/customer/mywirtelist.do?cusId=<%=loginId.getcusId()%>" class="list-group-item list-group-item-action">내가 쓴 글</a>
  <a href="/FoodRecipe/customer/wishListRecom.do?cusId=<%=loginId.getcusId()%>" class="list-group-item list-group-item-action">찜</a>
  <a href="/FoodRecipe/customer/myRecomlist.do?cusId=<%=loginId.getcusId() %>" class="list-group-item list-group-item-action">추천</a>
  <a href="/FoodRecipe/customer/mybuylist.do?cusId=<%=loginId.getcusId()%>" class="list-group-item list-group-item-action">주문 내역</a>
  <a href="/FoodRecipe/customer/detail.do?cusId=<%=loginId.getcusId()%>" class="list-group-item list-group-item-action">회원정보 수정</a>
</div>

<div class="upd">
<h2>Profile</h2>

<div class="gmd gmd-5">
 <table>
    <tbody>
    
   
    <tr>
    <th rowspan='2' id="img">
    <span><img alt="프로필사진" src="../images/<%=src2%>" 
 					style="width: 150px; height: 150px; border-radius: 90%;">
 					</span></th>
 				
    	 <th><font face="휴먼모음T"><br><br>이름</font></th>
        <td><font face="함초롬돋움"><br><br><%=cv.getcusName()%></font></td>
       </tr>
      <tr>
        <th style="padding: 50px;"><font face="휴먼모음T">전화번호</font></th>
	    <td><%=cv.getcusTel()%></td>
      </tr>
      
    <tr>

    	<td class="custom-id"><font face="휴먼모음T"><h4><%=cv.getcusId()%>님</font></h4></td>
    	
    	 <th><font face="휴먼모음T">주소</font></th>
    <td><%=cv.getcusAddr()%></td>
</tr>	
  
 	<tr>
 	
 	<td colspan="4"> 
 	<input type="button" value="수정" id="update"  style="float: right;">
 	
	</td> 
 	</tr>
    
    </tbody>
    </table>
</div>
<!--          <td colspan="2">  -->
<!--          <input type="button" value="수정" id="update"  style="float: right;"> -->
<%--          <input type="button" value="탈퇴"   id=onClick="location.href='./delete.do?cusId=<%=cv.getcusId() %>'" style="float: right;"> --%>
<!--           </td>  -->
<!-- </div> -->
    
     
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
	
	
	
	
	
	
</body>
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
</html>