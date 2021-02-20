<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h2>Hello World!</h2>
<form action="${pageContext.request.contextPath}/ServletDemo1" method="get">
    <a href="${pageContext.request.contextPath}/ServletDemo1">${pageContext.request.contextPath}</a>
    <input type="submit" value="提交">
</form>
</body>
</html>
