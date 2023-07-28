<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

${sampleDTOList.sampleList[0].name }<br>
${sampleDTOList.sampleList[0].age }<br>
${sampleDTOList.sampleList[1].name }<br>
${sampleDTOList.sampleList[1].age }<br>

</body>
</html>