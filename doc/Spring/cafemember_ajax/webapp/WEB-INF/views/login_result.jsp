
<%@page import="com.service.spring.domain.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	MemberVO vo=(MemberVO)session.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>Login Information</h2>
ID <%= vo.getId() %><br>
NAME <%=  vo.getName() %><br>
ADDRESS <%= vo.getAddress() %><br>
<p></p><hr><p></p>
<a href="logout.jsp">LOG OUT</a>
<a href="index.jsp">INDEX</a>
</body>
</html>


















