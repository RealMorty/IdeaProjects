<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="500.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="">Hello Servlet</a>
<%
    int i = 3 / 0;
%>

</body>
</html>