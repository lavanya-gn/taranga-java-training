<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forTokens items="Ramya-Shivani-Mangala-Sneha-Abdul-Neha" delims="-" var="name">  
   <c:out value="${name}"/><p>  
</c:forTokens>  
</body>
</html>