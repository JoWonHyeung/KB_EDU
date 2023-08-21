<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>EL Result Page</h2>
<b>1. JSP 기본 Element(이전 방식)</b> <br>
ID : <%= request.getParameter("myId") %> <br>

<b>2. JSP EL </b><br>
<!-- request.getAttribute("myId") -->
ID : ${myId} <br>
<!-- request.getParameter("myId") -->
ID : ${param.myId} <br>

<b>3. JSP Menu(Checkbox)기본 Element(이전 방식)</b> <br>
<%
	String[] menus = request.getParameterValues("menu");
	for(String menu : menus){

%>
	<%= menu %>
<%
	}
%>

<br>

<b>4. JSP Menu(Checkbox) EL</b> <br>
선택한 메뉴 <br>
${paramValues.menu[0]}
${paramValues.menu[1]}
${paramValues.menu[2]}
${paramValues.menu[3]}

</body>
</html>