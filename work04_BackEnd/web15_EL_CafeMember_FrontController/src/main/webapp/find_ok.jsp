<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>회원 검색 결과</h2>

<p>ID : ${vo.id}</p>
<p>Name : ${vo.name}</p>
<p>ADDRESS : ${vo.address}</p> 
</body>

</html>