<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레시피 등록</title>
</head>
<body>
	<form action="./insert.do" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>메뉴명:</td>
				<td><input type="text" name="rNo" value=""></td>
			</tr>
			<tr>
				<td>카테고리:</td>
				<td><input type="text" name="rType" value=""></td>
			</tr>
			<tr>
				<td>칼로리:</td>
				<td><input type="text" name="rNo" value=""></td>
			</tr>
			<tr>
				<td>메뉴명:</td>
				<td><input type="text" name="rCal" value=""></td>
			</tr>
			<tr>
				<td>작은이미지:</td>
				<td><input type="file" name="rImgS" value=""></td>
			</tr>
			<tr>
				<td>큰이미지:</td>
				<td><input type="file" name="rImgL" value=""></td>
			</tr>
			<tr>
				<td>재료:</td>
				<td><input type="text" name="rDt" value=""></td>
			</tr>
			<tr>
				<td>조리법 1:</td>
				<td><input type="text" name="rM1" value=""></td>
			</tr>
			<tr>
				<td>조리과정 사진 1:</td>
				<td><input type="file" name="rMm1" value=""></td>
			</tr>
			<tr>
				<td>조리법 2:</td>
				<td><input type="text" name="rM2" value=""></td>
			</tr>
			<tr>
				<td>조리과정 사진 2:</td>
				<td><input type="file" name="rMm2" value=""></td>
			</tr>
			<tr>
				<td>조리법 3:</td>
				<td><input type="text" name="rM3" value=""></td>
			</tr>
			<tr>
				<td>조리과정 사진 3:</td>
				<td><input type="file" name="rMm3" value=""></td>
			</tr>
			<tr>
				<td>조리법 4:</td>
				<td><input type="text" name="rM4" value=""></td>
			</tr>
			<tr>
				<td>조리과정 사진 4:</td>
				<td><input type="file" name="rMm4" value=""></td>
			</tr>
			<tr>
				<td>조리법 5:</td>
				<td><input type="text" name="rM5" value=""></td>
			</tr>
			<tr>
				<td>조리과정 사진 5:</td>
				<td><input type="file" name="rMm5" value=""></td>
			</tr>
			<tr>
				<td>조리법 6:</td>
				<td><input type="text" name="rM6" value=""></td>
			</tr>
			<tr>
				<td>조리과정 사진 6:</td>
				<td><input type="file" name="rMm6" value=""></td>
			</tr>
			<tr>
				<td>레시피 팁:</td>
				<td><input type="text" name="rTip" value=""></td>
			</tr>
		</table>
		
		<input type="submit" value="레시피 등록">
	</form>
</body>
</html>