<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>단순 회원 검색하기</h2>
<form action="find.do" method="post">	
	조회할 ID <input type="text" name="id" required="required">
	<input type="submit" name="회원조회">
</form>
</body>
</html>