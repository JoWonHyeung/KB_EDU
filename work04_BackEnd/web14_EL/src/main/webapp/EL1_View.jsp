<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<b>1. JSP 기본 Element 로 받아오기(이전 방식)</b> <br>

<!-- ${RESULT1} :: request.getAttribute("RESULT1") -->
ServletRequest에 바인딩된 값 :: <%= request.getAttribute("RESULT1") %> <br>
<!-- 
${RESULT2} :: request.getAttribute("RESULT2") // 없으니까 session으로 넘어가서 찾는다!! 
${RESULT2} :: session.getAttribute("RESULT2") 
-->
HttpSession 바인딩된 값 :: <%= session.getAttribute("RESULT2") %> <br>

<hr>

<b>2. JSP EL로 받아오기 </b> <br>

ServletRequest에 바인딩된 값 :: ${RESULT1} <br>
HttpSession 바인딩된 값 :: ${RESULT2} <br>

연산 가능 :: ${RESULT2 + 100} <br>

</body>
</html>