<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Object list=request.getAttribute("list");
out.println(list); %>

  <c:forEach var="value">  
   <c:out value="${value}"/><p>  
</c:forEach>  

</body>
</html>