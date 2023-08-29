<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">Product Register Form...</h2>
<form action="myProduct.do" method="post">
상품명 : <input type="text" name="name"><br><br>
제조사 : <input type="text" name="maker"><br><br>
가  격  : <input type="text" name="price"><br><br>

<input type="submit" value="상품등록">
</form>

+++++++++++++++++++++++++++++++++++++++++++++++++++
<br><br><br>
<h2>상품명 , 제조사별 검색하기</h2>
<form action="myProductSearch.do">
	<select name="command">
		<option value="">선택하기</option>
		<option value="findProductByName">상품명으로 검색</option>
		<option value="findProductByMaker">제조사별으로 검색</option>
		<option value="findProducts">모든 상품 검색</option>
	</select>
	
	<input type="text" name="word"><br><br>
	<input type="submit" value="상품검색">
</form>
</body>
</html>












