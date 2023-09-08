<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 
session에 정보를 무조건 바인딩해야하는 로직
1) 로그인 ---- rvo
2) 수정된 정보 --- pvo
   :: 로그인된 상태....MemberVO vo = session.getAttribute()
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Update Member Form</h2>
<form action="update.do" method="post">
  ID : <input type="text" name="id" value="${vo.id}" readonly="readonly"> <br/> <!--  session.getAttribute("vo").getId();-->
  PASSWORD : <input type="password" name="password" value="${vo.password}"><br/>
  NAME : <input type="text" name="name" value="${vo.name}"><br/>
  ADDRESS : <input type="text" name="address" value="${vo.address}"><br/>
  <input type="submit" value="정보수정">
</form>
</body>
</html>










