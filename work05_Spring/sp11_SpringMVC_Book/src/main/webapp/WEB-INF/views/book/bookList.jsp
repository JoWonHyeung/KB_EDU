<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 정보</title>
<style type="text/css">
h1, h4 {
	text-align: center;
}

#bookTable {
	margin: auto auto;
}

body, p {
	text-align: center;
}

#bookTable th{
	text-align: right;
}

#bookTable td {
	border: 1px solid black;
	padding: 10px 0px;
}

#bookTable tr:nth-child(2) {
	text-align: center;
	background-color: lightgray;
}

#bookTable td {
	width: 100px;
}

#bookTable td:nth-child(2) {
	width: 250px;
}
#bookTable td:nth-child(1) {
	width: 150px;
}
#bookTable td:nth-child(4) {
	width: 150px;
}
#bookTable td:nth-child(3) {
	width: 200px;
}
</style>

</head>
<body>
	<h1>도서 목록 화면</h1>
	
	<c:if test="${not empty user}">
		<h4>${user.name} 님 로그인 되었습니다. <a href="memberLogout.do">로그아웃</a></h4>
	</c:if>
	<c:choose>
		<c:when test="${empty list}"><!-- 도서목록이 없다 -->
			<h4>등록된 도서 목록이 없습니다.</h4>
		</c:when>
		<c:otherwise>
			<table id="bookTable">
				<tr>
					<th  colspan="4">
						<form action="bookSearch.do" method="get">				
							<select name="searchField" id="searchField">
								<option value="LIST">전체</option>
								<option value="TITLE">도서명</option>
								<option value="PUBLISHER">출판사</option>
								<option value="PRICE">가격</option>
							</select> 
							<input type="text" id="searchText" name="searchText"> 
							<input type="submit" value="검색">
						</form>
					</th>
				</tr>
				<tr>
					<td>도서번호</td>
					<td>도서명</td>
					<td>도서분류</td>
					<td>저자</td>
				</tr>
				<c:forEach items="${list}" var="book">
					<tr>
						<td>${book.isbn}</td>
						<td class="subject" id="${book.isbn}"><a href="bookView.do?isbn=${book.isbn}">${book.title}</a></td>
						<td>${book.catalogue}</td>
						<td>${book.author}</td>
					</tr>
				</c:forEach>		
			</table>
		</c:otherwise>
	</c:choose>
	<div id="result"></div>
	<p>
		<a href='bookForm.jsp'>도서 등록</a> <a href='index.jsp'>메인페이지</a> 
	</p>
</body>
</html>















