<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="./images/cook.png" rel="shortcut icon" type="image/x-icon">
<meta charset="UTF-8">
<title>로그인</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<!-- <!-- 부트스트랩 사용을 위한 외부파일 -->
<!-- <link rel="stylesheet" -->
<!-- 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<!-- <script -->
<!-- 	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
<!-- 부트스트랩 사용을 위한 외부파일 -->
<script>
$(function(){
	$('#loginForm').on('click', function(){
			
	
	idvalue = $('#cusId').val();
	pwvalue= $('#cusPw').val();
	
	console.log(idvalue+"+"+pwvalue);
	
	$.ajax({
		url : '<%=request.getContextPath()%>/loginChk.do',		
		type : 'get',
		data : {
			"cusId" : idvalue,
			"cusPw" : pwvalue
		},
		success : function(res) {
			
			console.log("res"+res.rs)
			if(res.rs == "OK") {
				
			alert("로그인성공!")
			location.href = "<%=request.getContextPath()%>/mainpage.do?cusId="+ idvalue;
			}else{
			alert("로그인실패")
			}
		},
		error : function(xhr){
			alert("상태 : "+ xhr.status)	
		},
		dataType : 'json'
		})
	})	
});
</script>

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
  color:lightpink;
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
  font-size: calc(var(--font-size) / 1.65);
  font-weight: 700;
  text-transform: uppercase;
  letter-spacing: 0.065rem;
  background-color: gray;
  border-color: gray;
  color: black;
}
.btn--primary:focus {
  background-color: var(--color-secondary);
  border-color: var(--color-secondary);
}

.btn--text {
  font-size: calc(var(--font-size) / 1.5);
  padding: 0;
}
a {
	color: black;
	text-decoration: none;
}
</style>
</head>
<body>

	<form class="form" onsubmit="return false" autocomplete="off">
  <div class="form-inner">
    <h2>User Login</h2>

    <div class="input-wrapper">
      <label for="login-username" >Username</label>
      <div class="input-group">
        <span class="icon">
          <svg viewBox="0 0 24 24">

<!-- 	이미지 -->

          </svg>
        </span>
        <input type="text" id="cusId" name="cusId" data-lpignore="true">
      </div>
    </div>

    <div class="input-wrapper">
      <label for="login-password" >Password</label>
      <div class="input-group">
        <span class="icon">
          <svg viewBox="0 0 24 24"></svg>
          
<!--           이미지 -->
          
        </span>
        <input type="password" id="cusPw" name="cusPw" data-lpignore="true">
      </div>
    </div>
    	<div class="btn-group"> 
    	<a class="btn btn--text" href="./customer/idSearch.do">아이디 찾기</a>
    	<a class="btn btn--text" href="./customer/pwSearch.do">비밀번호 찾기</a>
    	</div>

    <div class="btn-group">
      <button class="btn btn--primary" id="loginForm">로그인</button>
      <button class="btn btn--primary" onClick=location.href="./customer/insert.do">회원가입</button>
      <button class="btn btn--primary" onClick=location.href="/FoodRecipe/mainpage.do">메인화면</button>
    </div>
  </div>
</form>


	

</body>
</html>