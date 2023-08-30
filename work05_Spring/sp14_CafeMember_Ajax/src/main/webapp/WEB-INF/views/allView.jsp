
<%@page import="com.service.spring.domain.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	ArrayList<MemberVO> list = (ArrayList)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
 <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h2>Member List</h2>
	<p>.The member class state...table tag...</p>
	<table  class="table table-dark">
	<%
		for(MemberVO v:list){
	%>
		<tr>
			<td><%= v.getId() %></td>
			<td><%= v.getName() %></td>
			<td><%= v.getAddress() %></td>
		</tr>
	<%
		}
	%>
	</table>
	<h4 align="right"><a href="index.jsp">INDEX</a></h4>
</div>
</body>
</html>










