<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- 이 코드는 원래 서블릿이라고 생각해주세요. -->
<%
	int sum = 0;
	for(int cnt = 0; cnt < 50; cnt++){
		sum += cnt; //5050
	}
	
	request.setAttribute("RESULT1", sum); //ServletRequest
	session.setAttribute("RESULT2", sum); // HttpSession
	application.setAttribute("NAME", sum); // ServletContext
	
	request.getRequestDispatcher("EL1_View.jsp").forward(request, response);
%>
</body>
</html>