<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	MemberVO vo=(MemberVO)session.getAttribute("vo");
	if(vo==null){ //�α��� �ȵȻ��¶��...�α��� �ϱ��
%>
	<h2><a href="login.jsp">�α��� �ϱ�</a></h2>

<%
	}else{  //�α��� �� ���¶��....�α׾ƿ� ����(������ Death)
		session.invalidate();
	}
%>
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
<b>�α׾ƿ� �Ǽ̽��ϴ�...</b><br>
<a href="index.html">INDEX</a>
</body>
</html>




