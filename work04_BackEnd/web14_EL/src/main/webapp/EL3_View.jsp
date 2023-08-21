<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<b>정보 출력</b> <br>
${vo} <br>

ID: ${vo.id} <br> <!-- request.getAttribute("vo").getId() -->
Name: ${vo.name} <br> <!-- request.getAttribute("vo").getName() -->
Address: ${vo.address} <br> 

</body>
</html>