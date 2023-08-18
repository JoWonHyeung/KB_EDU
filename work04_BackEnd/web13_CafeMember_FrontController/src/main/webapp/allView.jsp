<%@page import="servlet.model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<MemberVO> list = (ArrayList)request.getAttribute("list");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>


<!-- 나중에 이부분은 Bootstrap 클래스 속성 연결해서 완전한 디자인으로 직접 만들어주세요 -->
<div class="container">
	<div class="jumbotron bg-dark">
		<h2 class="text-white" style="text-align: center;">회원 전체 명단 보기</h4>
	</div>
	<table class="table table-dark table-striped">
	<%
		for(MemberVO vo : list){
	%>
		<tr>
			<td><%= vo.getId() %></td>
			<td><%= vo.getName() %></td>
			<td><%= vo.getAddress() %></td>
		</tr>
	<% 
		}
	%>
	</table>
	
	<a href="index.html">홈으로</a>
</div>

</body>
</html>