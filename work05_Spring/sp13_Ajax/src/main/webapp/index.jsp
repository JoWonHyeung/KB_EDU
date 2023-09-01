<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function(){
		$('#asynchro').click(function(){
			$.ajax({
				type:'get',
				url:'asynch',
				success:function(data){//객체 단위로 데이터를 받아옴(Json)
					var jsonData = JSON.parse(data);
					$('#jsonView').html(
							"<h3><font color=tomato>" 
							+ jsonData.person.name + " " + jsonData.person.address + 
							"</font></h3>")
				}//success
			})//ajax
		});//click
	});
</script>
</head>
<body>
<h2>Index Page....</h2>
<h2>동기, 비동기 통신</h2>
<a href="synchro">Synchro 통신...</a>

<p></p>
<hr>
<p></p>

<input type="button" value="비동기통신 시작하기" id="asynchro">
<span id="jsonView"></span>

</body>
</html>