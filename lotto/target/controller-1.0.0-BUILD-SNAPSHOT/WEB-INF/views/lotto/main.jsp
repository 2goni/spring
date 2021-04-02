<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	로또 생성기
	<form action="/lotto/cal" method="post">
	생년: <input name="year" placeholder="ex)1994" required> <br>
	생월: <input name="month" required> <br>
	생일: <input name="day" required> <br>
	<button type="submit">로또번호 확인</button>
	</form>
</body>
</html>