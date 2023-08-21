<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>c:if ... 태그 사용...EL 과 함께 사용</h2>
<br><br>
<c:if test="${param.NUM==100}">
	<b>오늘은 100만원 입금되었습니다.</b> <br>
</c:if>
<c:if test="${param.NUM==200}">
	<b>오늘은 200만원 입금되었습니다.</b> <br>
</c:if>

</body>
</html>