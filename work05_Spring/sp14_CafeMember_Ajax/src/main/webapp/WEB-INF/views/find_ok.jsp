
<%@page import="com.service.spring.domain.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	MemberVO vo = (MemberVO)request.getAttribute("vo");
%>
<h2>  회원 조회 결과 </h2>
${msg}
<br>

ID : ${vo.id} <br>
NAME: ${vo.name} <br>
ADDRESS: ${vo.address}<br>
</body>
</html>












