<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>SummerNoteExample</title>
<link href="../images/cook.png" rel="shortcut icon" type="image/x-icon">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"rel="stylesheet"> -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script src="/summernote/summernote-lite.js"></script>
<script src="/summernote/lang/summernote-ko-KR.js"></script>
<style>
form label {
	width: 70px;
}
form input[type="text"]{
	width: 200px;
}
form input[type="submit"] {
	width: 50px;
}

</style>
<style>
.pager {
	float: left;
}

#pageArea {
	display: flex;
	justify-content: center;
}

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
		<!--보드게시판 -->
	<div class="boardlist">
		<div class="recipeall">B O A R D</div>
		<br>
		<div class="d">
			<table class="cat">
				<tr id="type">
					<td class="typetd"><a href='#'
						onclick="location.href='/FoodRecipe/board/list.do?ctgNo=1'"
						class="typeb">
							<button type="button" class="btn btn-secondary">R E C I
								P E</button>
					</a></td>
					<td>&nbsp;&nbsp;</td>
					<td class="typetd"><a href='#'
						onclick="location.href='/FoodRecipe/board/list.do?ctgNo=2'"
						class="typeb">
							<button type="button" class="btn btn-secondary">H O T P
								A L C E</button>
					</a></td>
					<td>&nbsp;&nbsp;</td>
					<td class="typetd"><a href='#'
						onclick="location.href='/FoodRecipe/board/list.do?ctgNo=3'"
						class="typeb">
							<button type="button" class="btn btn-secondary">F R E E
								B O A R D</button>
					</a></td>
					<td>&nbsp;&nbsp;</td>
					<td class="typetd"><a href='#'
						onclick="location.href='/FoodRecipe/notice/list.do?'"
						class="typeb">
							<button type="button" class="btn btn-secondary">N O T I
								C E</button>
					</a></td>
					<td>&nbsp;&nbsp;</td>
					<td class="typetd"><a href='#'
						onclick="location.href='/FoodRecipe/qna/list.do'" class="typeb">
							<button type="button" class="btn btn-secondary">Q & A</button>
					</a></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
			</table>
		</div>
		<!--보드게시판 끝-->

	<form action="insert.do" method="post">
	
<!-- 		<div> -->
<%-- 			<label>닉네임</label> <input type="text" name="cusId" value="<%=loginId.getcusId()%>" readonly> --%>
<!-- 		</div> -->
			<input type="hidden" name="cusId" value="<%=loginId.getcusId()%>">
		<div>
			<label>제목</label> <input type="text" name="bTitle">
		</div>
		<div>
		 <p></p>
			<label>카테고리</label> 
			<select name="ctgNo">
				<option value="1">레시피</option>
				<option value="2">맛집</option>
				<option value="3">자유</option>
			</select>
		</div>
		 <p></p>
		<textarea rows="300" cols="300" id="summernote" name="bCon"></textarea>

		<div>
		 <p></p>
<!-- 			<input type="submit" value="등록" /> -->
			<button type="submit" class="btn btn-primary" >S U B M I T</button> 
		</div>
	</form>

</div>


	<script>
		$(document).ready(function() {
			$('#summernote').summernote();
		});
	</script>


	<script>
		$(document).ready(function() {
			init();
		});

		var init = function() {
			$('#summernote').summernote({
				height : 500,
				focus : true,
				callbacks : {
					onImageUpload : function(files) {
						console.log("gd");
						for (let i = 0; i < files.length; i++) {
							sendFile(files[i]);
						}
					}
				}
			});
		};

		function sendFile(file) {
			let filedata = new FormData();
			filedata.append("file", file);
			console.log(filedata.get("file"));
			$.ajax({
				url : './upload.do',
				type : "post",
				data : filedata,
				contentType : false,
				processData : false,
				success : function(url) {
					console.log(url);
					$('#summernote').summernote("insertImage", url);
				},
				error : function(xhr) {
					console.log(xhr.status);
				}
			})
		};
	</script>
	

</body>
</html>