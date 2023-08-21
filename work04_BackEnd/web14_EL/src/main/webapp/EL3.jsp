<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="servlet.vo.MemberVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<!-- 
서블릿 로직 순서
1. 폼값 받아서
2. 받은 값으로 vo 생성... 생략
3. dao 리턴받고 비지니스 로직 호출
4. 반환값... Attribute바인딩
5. 결과페이지 이동... 네비게이션
 -->
 
 <%
 	MemberVO vo = new MemberVO("1","1","1","1");
 	request.setAttribute("vo", vo);
 	request.getRequestDispatcher("EL3_View.jsp").forward(request, response);
 %>

</body>
</html>