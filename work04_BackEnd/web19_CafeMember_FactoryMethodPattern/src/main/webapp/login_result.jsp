<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>Login Information</h2>
ID  ${vo.id} <br>
NAME ${vo.name} <br>
ADDRESS ${vo.address} <br>
<p></p><hr><p></p>
<a href="front.do?command=logout">LOG OUT</a>
<a href="index.jsp">INDEX</a>
</body>
</html>


















