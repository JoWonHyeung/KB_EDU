<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="EL2_view.jsp" method="post">
    ID <input type="text" name="myId"><br><br>
    <strong>좋아하는 메뉴를 선택...</strong><br><br>
    <input type="checkbox" name="menu" value="spagetii">spagetii
    <input type="checkbox" name="menu" value="curry">curry
    <input type="checkbox" name="menu" value="noodle">noodle
    <input type="checkbox" name="menu" value="coffee">coffee

    <input type="submit" value="DataSend">
</form>
</body>
</html>