<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
form>label {
	display: inline-block;
	width: 100px;
}

form>:input {
	display: inline-block;
	width: 100px;
}
</style>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	 <c:url value="/phone" var="phone" /> 
	<h1>휴대전화 목록</h1>
	<table border="1">
		<tr>
			<th>모델번호</th>
			<th>모델이름</th>
			<th>가격</th>
			<th>제조사명</th>
		</tr>
		<tbody id="list">
		</tbody>		
	</table>
	<div id="status"></div>
	<h1>휴대전화 정보</h1>
	<form id="phoneForm">
		<label for="num">모델번호</label>
		<input type="text" name="num" id="num">
		<br>
		<label for="model">모델명</label>
		<input type="text" name="model" id="model">
		<br>
		<label for="price">가격</label>
		<input type="number" name="price" id="price">
		원 <br>
		<label for="vcode">제조사</label>
		<select id="vcode" name="vcode">
			<option value="10">삼성
			<option value="20">엘지
			<option value="30">애플
		</select>
		<br>
		<input type="button" value="추가하기" id="btnInsert">
		<input type="button" value="수정하기" id="btnModify">
		<input type="button" value="삭제하기" id="btnDelete">

	</form>
	
</body>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>	
		function list() {		
			$.ajax({
				url:"${phone}",
				type:"get",
				success:function(resData){
					var str = "";
					$("#list").empty();
					if(resData!=null){						
						$.each(resData, function(idx, phone) {
							str+= "<tr>";
							str+= "<td class='num'>"+phone.num+"</td>";
							str+= "<td>"+phone.model+"</td>";
							str+= "<td>"+phone.price+"</td>";
							str+= "<td>"+phone.company.vendor+"</td>";
							str+= "</tr>";
						});
						$('#list').append(str);
						$("#status").html("<font color=red>조회 성공 :" + resData.length + "개</font>");
					}else{
						$("#status").html("조회 실패 ");
					}
				},
				error:function(){
					alert("조회 실패....시스템 오류발생...");
				}
			});//ajax
		}//list
		
		list();
		
		$("#list").on("click", ".num", function() {
			$("#status").html("");
			let num = $(this).text();
			$.ajax({
				url : "${phone}/" + num,
				type:"get",
				success : function(resData) {
					if (resData!=null) {						
						$("#num").val(resData.num);
						$("#model").val(resData.model);
						$("#price").val(resData.price);
						$("#vcode").val(resData.vcode);
						$("#status").html("조회 성공");
					} else {
						$("#status").html("조회 실패");
					}
				},
				error : function() {
					alert("조회 실패(시스템 오류)")
				}
			});
		});
		$("#btnInsert").on("click", function(){
			$("#status").html("");
			let phone = {num:$("#num").val(), model:$("#model").val(), price:$("#price").val(), vcode:$("#vcode").val() };
			//alert(phone) : [Object object]...이거는 받을때
			//넘길때는 JSON으로 넘겨야한다....이때 JSON.stringify(phone) 사용
			
			$.ajax({
				url : "${phone}",
				type: "post",				
				data: JSON.stringify(phone),
				contentType:"application/json",
				success : function(resData) {					
					if (resData!=null) {
						list();					
					} else {
						$("#status").html("추가 실패: " + resData.num+","+resData.model);
					}
					clearField();
				},
				error : function() {
					alert("실패 실패(시스템 오류)")
				}
			});
		});
		
		$("#btnModify").on("click", function(){
			$("#status").html("");
			let phone = {num:$("#num").val(), model:$("#model").val(), price:$("#price").val(), vcode:$("#vcode").val() };
			
			$.ajax({
				url : "${phone}",
				type: "put",
				data: JSON.stringify(phone),
				contentType:"application/json",
				success : function(resData) {
					if (resData!=null) {
						list();					
					} else {
						$("#status").html("수정 실패: " + resData.num+","+resData.model);
					}
					clearField();
				},
				error : function() {
					alert("실패 실패(시스템 오류)")
				}
			});
		});
		
		$("#btnDelete").on("click", function(){
			$("#status").html("");
			let num = $("#num").val();		
			$.ajax({
				url : "${phone}/"+num,
				type: "delete",
				success : function(resData) {
					if (resData!=null) {
						list();					
					} else {
						$("#status").html("삭제 실패: " + resData.num+","+resData.model);
					}
					clearField();
				},
				error : function() {
					alert("실패 실패(시스템 오류)")
				}
			});
		});
		
		function clearField(){
			$("#num").val("");
			$("#model").val("");
			$("#price").val("");
			$("#vcode").val("10");
		}
</script>
</html>






















