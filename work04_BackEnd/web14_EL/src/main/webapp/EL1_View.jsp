<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<b>1. JSP �⺻ Element �� �޾ƿ���(���� ���)</b> <br>

<!-- ${RESULT1} :: request.getAttribute("RESULT1") -->
ServletRequest�� ���ε��� �� :: <%= request.getAttribute("RESULT1") %> <br>
<!-- 
${RESULT2} :: request.getAttribute("RESULT2") // �����ϱ� session���� �Ѿ�� ã�´�!! 
${RESULT2} :: session.getAttribute("RESULT2") 
-->
HttpSession ���ε��� �� :: <%= session.getAttribute("RESULT2") %> <br>

<hr>

<b>2. JSP EL�� �޾ƿ��� </b> <br>

ServletRequest�� ���ε��� �� :: ${RESULT1} <br>
HttpSession ���ε��� �� :: ${RESULT2} <br>

���� ���� :: ${RESULT2 + 100} <br>

</body>
</html>