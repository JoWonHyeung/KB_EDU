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
	String url = "https://search.naver.com/search.naver?";
	String word = request.getParameter("word");
	
	url += "query=" + word;
	
	response.sendRedirect(url);
%>
</body>
</html>