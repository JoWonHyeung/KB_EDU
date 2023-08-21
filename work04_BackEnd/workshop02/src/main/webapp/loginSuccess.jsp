<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>
<html>
<head></head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div{
	    border: 1px solid black;
	    text-align: center;
	}
</style>
<body>

<div>
	<h2> <%= request.getParameter("id") %> 님이 로그인 되었습니다.!!</h2>
	<p><a href="">도서 등록</a></p>
	<p><a href="">로그아웃</a></p>
</div>
</body>
</html>