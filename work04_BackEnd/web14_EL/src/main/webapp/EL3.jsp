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
���� ���� ����
1. ���� �޾Ƽ�
2. ���� ������ vo ����... ����
3. dao ���Ϲް� �����Ͻ� ���� ȣ��
4. ��ȯ��... Attribute���ε�
5. ��������� �̵�... �׺���̼�
 -->
 
 <%
 	MemberVO vo = new MemberVO("1","1","1","1");
 	request.setAttribute("vo", vo);
 	request.getRequestDispatcher("EL3_View.jsp").forward(request, response);
 %>

</body>
</html>