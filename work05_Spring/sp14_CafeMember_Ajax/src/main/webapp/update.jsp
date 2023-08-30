<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h2{
		text-align: center;
		color: purple;
	}
	#wrap{
		margin-left: 220px;		
	}
</style>
<script type="text/javascript">
	function btnclick(){
		alert("button Click~~!!!");
	}
</script>
</head>
<body>
<h2>UPDATE MEMBER FORM</h2>
<div id="wrap">
	<form action="update.do" method="post">		
		ID <input type="text" name="id" value="${vo.id}" readonly="readonly"><br><br>
		PASS <input type="password" name="password" value="${vo.password}"><br><br>
		NAME <input type="text" name="name" value="${vo.name}"><br><br>
		ADDR <input type="text" name="address" value="${vo.address}"><br><br>
		<input type="submit" value="UPDATE">
		<input type="button" value="CLICK" onclick="btnclick()">
	</form>
</div>
</body>
</html>