<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>500</title>
</head>
<body>
<p>服务器正忙。。。请稍后再试</p>
<%
    String message = exception.getMessage();
    System.out.println(message);
%>
</body>
</html>
