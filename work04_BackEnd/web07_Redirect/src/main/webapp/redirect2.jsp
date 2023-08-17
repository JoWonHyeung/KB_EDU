<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String city = request.getParameter("city");

%>

<h2>당신이 선택한 도시는 <%= city %> 입니다.</h2>

</body>
</html>