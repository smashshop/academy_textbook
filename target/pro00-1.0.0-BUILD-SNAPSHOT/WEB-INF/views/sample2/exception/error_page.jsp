<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>
<h4><c:out value = "${exception.getMessage() }"/></h4>
<ul>
	<c:forEach items = "${exception.getStackTrace() }" var = "stack">
		<li><c:out value = "${stack }" /></li>
	</c:forEach>
</ul>

<!-- 직접 오류를 발생시키는 URL localhost:8080/pro00/sample/ex01?name=김상원&age=aa -->
</body>
</html>