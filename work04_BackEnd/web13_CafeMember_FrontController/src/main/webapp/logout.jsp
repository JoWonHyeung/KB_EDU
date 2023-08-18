<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function logout() {
		alert("Log Out~~")
	}
</script>
</head>
<body onload="return logout()">

	<%
		MemberVO vo=(MemberVO)session.getAttribute("vo");
		if(vo==null){ //로그인 안된상태라면...로그인 하기로
	%>
		<h2>로그인부터 하세요</h2><br>
		<h2><a href="login.jsp">로그인 하기</a></h2>		
	<%
		}else{  //로그인 된 상태라면....로그아웃 진행(세션을 Death)
			
			session.invalidate();
	%>
		<b>로그아웃 되셨습니다...</b><br>
		<a href="index.html">홈으로</a>
	<% 	
		}
	%>

</body>
</html>




