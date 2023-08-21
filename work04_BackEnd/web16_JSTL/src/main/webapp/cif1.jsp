<!-- 
JSTL 하기 위한 사전 작업
1. jstl.jar / standard.jar 파일을 추가
2. taglib 옵션을 jsp 선언부에 등록 
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제어문 :: c:if</title>
</head>
<body>
<h2>JSTL if 사용하기</h2> 
<form action="cif1_view.jsp">
NUM <input type="text" name="NUM">
<input type="submit" value="전송">
</form>
</body>
</html>
























