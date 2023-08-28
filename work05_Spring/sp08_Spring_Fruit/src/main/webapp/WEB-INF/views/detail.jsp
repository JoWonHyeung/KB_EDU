<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="css/shopping3-2.css">
<html>
<head>
<title>상품 상세 화면</title>
</head>
<body>
<div align="center" class="body">
<h2>상품 상세 화면</h2>
<table>
	<tr>
		<td><img src="${item.url}"></td>
		<td align="center">
		<table>
			<tr height="50">
				<td width="80">상품명</td>
				<td width="160">${item.name}</td>
			</tr>
			<tr height="50">
				<td width="80">가격</td>
				<td width="160">${item.price}원</td>
			</tr>
			<tr height="50">
				<td width="80">비고</td>
				<td width="160">${item.description}</td>
			</tr>
			<tr>
				<td colspan="2" align="center" width="240"><a href="list.do">■ 목록으로 돌아가기</a></td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</div>
</body>
</html>