<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

${todoDTO.title }<br>
${todoDTO.dueDate }<br>
<fmt:formatDate value="${todoDTO.dueDate }" pattern="YYYY년 MM월 dd일 E요일 a h시 mm분 ss초"/><br>

</body>
</html>