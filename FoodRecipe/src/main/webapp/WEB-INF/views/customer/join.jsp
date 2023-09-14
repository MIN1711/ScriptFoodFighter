<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>회원가입</title>
<link href="../images/cook.png" rel="shortcut icon" type="image/x-icon">
<style>

:root {
  --space-root: 1rem;
  --space-xs: calc(var(--space-root) / 2);
  --space-s: calc(var(--space-root) / 1.5);
  --space-m: var(--space-root);
  --space-l: calc(var(--space-root) * 1.5);
  --space-xl: calc(var(--space-root) * 2);
   --color-primary: lightblue; 
   --color-secondary: lightpink; 
   --color-tertiary: hotpink; 
  --base-border-radius: 0.25rem;
  --ease: cubic-bezier(0.075, 0.82, 0.165, 1);
  --duration: 350ms;
  --font-family: "Roboto", sans-serif;
  --font-size: 1.25rem;
}

* {
  box-sizing: border-box;
}

body {
  display: grid;
  place-items: center;
  margin: 0;
  height: 100vh;
  padding: var(--space-m);
  font-size: var(--font-size);
  font-family: var(--font-family);
  line-height: 1.2;
  background-color: lightgray;
}

a {
  color: var(--color-primary);
}
a:focus {
  color: var(--color-secondary);
}

h2 {
  font-weight: 700;
  font-size: calc(var(--font-size) * 1.5);
}

.form {
  position: relative;
  width: 100%;
  max-width: 450px;
  margin: 0 auto;
  transform: skewY(-5deg) translateY(10%) scale(0.94);
  transition: box-shadow var(--duration) var(--ease), transform var(--duration) var(--ease);
}
.form:before, .form:after {
  content: "";
  position: absolute;
  pointer-events: none;
  background-color: #ebebeb;
  width: 25%;
  height: 100%;
  transition: background-color var(--duration) var(--ease), transform var(--duration) var(--ease);
}
.form:before {
  top: 0;
  right: calc(100% - 1px);
  transform-origin: 100% 100%;
  transform: skewY(-35deg) scaleX(-1);
  z-index: -1;
}
.form:after {
  top: 0;
  left: calc(100% - 1px);
  transform-origin: 0 0;
  transform: skewY(-35deg) scaleX(-1);
  z-index: 2;
}
.form:hover, .form:focus-within {
  transform: scale(1.0001);
  box-shadow: 0 1rem 3rem rgba(0, 0, 0, 0.1);
}
.form:hover:before, .form:hover:after, .form:focus-within:before, .form:focus-within:after {
  background-color: white;
  transform: skewY(0);
}

.form-inner {
  padding: var(--space-xl);
  background-color: white;
  z-index: 1;
}
.form-inner > * + * {
  margin-top: var(--space-xl);
}

.input-wrapper:focus-within label {
  color: var(--color-secondary);
}
.input-wrapper:focus-within .icon {
  background-color: var(--color-secondary);
}
.input-wrapper:focus-within input {
  border-color: var(--color-secondary);
}
.input-wrapper + .input-wrapper {
  margin-top: var(--space-l);
}

.input-group {
  position: relative;
}
.input-group input {
  border-radius: var(--base-border-radius);
  padding-left: calc(var(--space-s) + 60px);
}
.input-group .icon {
  position: absolute;
  top: 0;
  left: 0;
  height: 100%;
  border-top-left-radius: var(--base-border-radius);
  border-bottom-left-radius: var(--base-border-radius);
  pointer-events: none;
}

label {
  font-size: calc(var(--font-size) / 1.65);
  font-weight: 700;
  text-transform: uppercase;
  letter-spacing: 0.065rem;
  display: block;
  margin-bottom: var(--space-xs);
  color: var(--color-primary);
}

.icon {
  display: flex;
  align-items: center;
  flex: 0 1 auto;
  padding: var(--space-m);
  background-color: var(--color-primary);
}
.icon svg {
  width: 1.25em;
  height: 1.25em;
  fill: white;
  pointer-events: none;
  user-select: none;
  transition: transform var(--duration) var(--ease);
}

input {
  flex: 1 1 0;
  width: 100%;
  outline: none;
  padding: var(--space-m);
  font-size: var(--font-size);
  font-family: var(--font-family);
  color: var(--color-secondary);
  border: 2px solid var(--color-primary);
}
input:focus {
  color: var(--color-primary);
}

.btn-group {
  display: flex;
  align-items: center;
  justify-content: space-between;
}
.btn-group > * + * {
  margin-left: var(--space-s);
}

.btn {
  position: relative;
  overflow: hidden;
  display: flex;
  align-items: center;
  justify-content: space-between;
  outline: none;
  padding: var(--space-m) var(--space-l);
  cursor: pointer;
  border: 2px solid transparent;
  border-radius: var(--base-border-radius);
}

.btn--primary {
  font-size: 17px;
  font-weight: 700;
  text-transform: uppercase;
  letter-spacing: 0.065rem;
  background-color: lightblue;
  border-color: lightblue;
  color: gray;

}
.btn--primary:focus {
  background-color: var(--color-secondary);
  border-color: var(--color-secondary);
}


.btn--text {
	font-size: calc(var(- -font-size)/1.5);
	padding: 0;
	color: gray;
}

a {
	text-decoration: none;
	color:gray;
}

.text {
	font-Size:20px
}
</style>
 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
 
 <!-- <!-- 부트스트랩 사용을 위한 외부파일 -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">  -->

<!-- 부트스트랩 사용을 위한 외부파일  -->

<!-- 	  <form class="form-horizontal" action="test.jsp" method="post"> -->
	<form class="form" onsubmit="return valid()" autocomplete="off" action="./insert.do" method="post" enctype="multipart/form-data">
		<div class="form-inner">
			<h2>회원가입</h2>
			<div class="input-wrapper">
			<label for="login-username" class="text">닉네임<span class="rq"> *</span></label>
			<div class="input-group">
				<span class="icon"> <svg viewBox="0 0 24 24"></svg>
						
				</span> 
				<input type="text" class="form-control" id="cusId" data-lpignore="true" 
				name="cusId" placeholder="닉네임을 입력해주세요." pattern="[가-힣]{2,8}|[a-zA-Z][a-zA-Z0-9]{3,7}" required>
				</div>
			</div>
			
			<div class="input-wrapper" style="text-align: left;">
            <button type="button" class="btn btn--primary" id="idChk" name="idChk"
            >중복검사</button>
            <span id="disp"></span>
       	</div>
       
			<div class="input-wrapper">
				<label for="login-pw" class="password">비밀번호<span class="rq"> *</span></label>
				<div class="input-group">
				<span class="icon"> <svg viewBox="0 0 24 24"></svg>
					</span>
				<input type="password" class="form-control" id="pw" data-lpignore="true" 
				name="cusPw" placeholder="대소문자/특수문자 포함"
				pattern="(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#$%^&*()_+|]).{8,12}" required>
				</div>
			</div>

			<div class="input-wrapper">
				<label for="login-pw" class="password">비밀번호 확인<span class="rq"> *</span></label>
				<div class="input-group">
					<span class="icon"> <svg viewBox="0 0 24 24"></svg> 
					</span> 
					<input type="password" class="form-control" id="pw" data-lpignore="true" 
				name="cusPw" placeholder="대소문자/특수문자 포함"
				pattern="(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#$%^&*()_+|]).{8,12}" required>
				</div>
			</div>
			
				<div class="input-wrapper">
					<label for="login-name" class="text">이름<span class="rq"> *</span> </label>
					<div class="input-group">
						<span class="icon"> <svg viewBox="0 0 24 24"></svg></span> 
						<input type="text" class="form-control" id="name" name="cusName"
           					pattern="[가-힣]{2,5}" required>
					</div>
				</div>
				
				<div class="input-wrapper">
					<label for="login-tel" class="text">전화번호 <span class="rq"> *</span></label>
					<div class="input-group">
						<span class="icon"> <svg viewBox="0 0 24 24"></svg> 
	
						</span> 
				<input type="text" class="form-control" id="tel" name="cusTel" 
				placeholder="000-000(0)-0000" pattern="[0-9]{3}-[0-9]{3}{4}-[0-9]{4}" required>
        		 </div>
				</div>
			
				
				<div class="input-wrapper">
					<label for="login-addr" class="text">우편번호<span class="rq"> *</span> </label>
					<div class="input-group">
						<span class="icon"> <svg viewBox="0 0 24 24"></svg> 
						</span> 
						<input type="text" class="form-control" id="addr" name="cusAddr">
					</div>
					</div>
					
					<div class="col-sm-2">
           			<button type="button" id="addrBtn" class="btn btn--primary">주소검색</button>
        			 </div>
				
				
				<div class="input-wrapper">
					<label for="login-addr" class="text">주소<span class="rq"> *</span></label>
					<div class="input-group">
						<span class="icon"> <svg viewBox="0 0 24 24"></svg> <!--           이미지 -->
						</span> 
						  <input type="text" class="form-control" id="addr" name="cusAddr" required>
					</div>
				</div>
				
				<div class="input-wrapper">
					<label for="login-img" class="text">프로필 사진<span class="rq"> *</span></label>
					<div class="input-group">
						<span class="icon"> <svg viewBox="0 0 24 24"></svg> <!--           이미지 -->
						</span>
					 <input type="file" id="img" name="cusImg" accept="images/*"  >
					</div>
				</div>
			
				 <div class="btn-group">
       		    <button class="btn btn--primary" onClick="return CheckPw()">가입하기</button>
       	    	<span id="joinspan"></span>
       	    	<button class="btn btn--primary" onclick=location.href="/FoodRecipe/login.jsp">로그인화면</button>
       	  </div>       	  
     	</div>
</form>


<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>

// 비밀번호 일치 확인
function CheckPw() {
	var pw = document.getElementsByName('cusPw')[0].value;
	var pwc = document.getElementsByName('cusPw')[1].value;
	if (pw != pwc) {
		alert("비밀번호 불일치.");
		return false;
	}
	return true;
}
</script>


<script>
	$(function() {
          $('#idChk').on('click', function(){
              
        	  $('#disp').text("");
        	  
        	  let idvalue = $('#cusId').val();
              
              //console.log("idvalue" + idvalue);
              
            $.ajax({
              url: '<%=request.getContextPath()%>/customer/IdChk.do',
              type: 'get',
              data: { 'id' : idvalue},
              success: function(res){
                 console.log(res)
               if(res.code == "fail"){            	   
               $('#disp').text("사용불가").css('color','red');
               }else{
            	   $('#disp').text("사용가능").css('color','green');
               }
              },
              error : function(xhr) {
                    alert("상태 :" + xhr.status) 
                    },
                dataType: 'json',
          
          })
       });
	});
	
    </script>
    
<script>


 	//주소 찾기
 $('#addrBtn').on('click', function(){
 	//daum 주소 api로 검색하여 긁어온 코드
	
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
               
                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수
               
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
//                 document.getElementById('addr').value = data.zonecode;
                document.getElementById("addr").value =  data.zonecode + " " + roadAddr;
                //document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
             }
         }).open();
 });
</script>






