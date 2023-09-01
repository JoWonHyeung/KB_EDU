<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 
파일 업로드 기술 사용 시 주의할 점
1. form태그 안에 input type="file"로 폼을 만든다.
2. method=post만 가능하다.
3. enctype="multipart/form-data"
4. pom.xml 에 fileupload 디펜던시 추가
5. 파일업로드한 정보를 저장하는 vo를 먼저 만들고 요청을 처리한다.(RequestMapping)
6. !!

 -->
</head>
<body>

<h2 align="center">File Upload Form</h2>
<form action="fileupload.do" method="post" enctype="multipart/form-data">
	사용자명 <input type="text" name="userName">
	<input type="file" name="uploadFile">
	<input type="submit" value="파일업로드">
</form>

</body>
</html>