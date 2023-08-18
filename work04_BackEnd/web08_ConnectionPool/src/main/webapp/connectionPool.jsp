<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Connection Pooling Test.... Using JNDI Service</h2>
<%
	Context ic = new InitialContext();
	DataSource ds = (DataSource)ic.lookup("java:comp/env/jdbc/oracleDB"); // Resource Factory 를 반환받음...

	out.println("<b>1. DataSource Lookup.....</b><br>");
	
	Connection conn = ds.getConnection(); //이미 연결되어 있기 때문에 가져다가 쓰면된다...
	out.println("<b>2. Connection Rent Success!!....</b><br>");
%>

</body>
</html>