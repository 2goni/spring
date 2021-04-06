<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
행운의 번호는 :
	<c:forEach items="${lotto}" var="num">
	 ${num}
	</c:forEach>
	<br>
	<button onclick="location.href = 'main'" >메인으로</button>
</body>
</html>