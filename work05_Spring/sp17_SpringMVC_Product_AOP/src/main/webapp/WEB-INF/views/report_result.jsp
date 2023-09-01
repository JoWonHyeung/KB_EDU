<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container  text-center">
	<div class="jumbotron">
		<h3>AOP 이용해서 검색어 통계보기</h3>
	</div>
</div>

<table class="table table-bordered">
	<thead>
		<tr>
			<th>랭 킹</th><th>검색한 단어</th><th>조회수</th>
		</tr>
	</thead>
	<c:forEach items="${list}" var="reportMap">
		<tr>
			<td>${reportMap.RAKING}</td>
			<td>${reportMap.WORD}</td>
			<td>${reportMap.CNT}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>



























