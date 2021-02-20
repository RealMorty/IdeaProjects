<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<style>
    p {
        text-align: center;
    }
    span {
        color: red;
    }
</style>
<head>
    <meta charset="utf-8">
    <title>注册成功</title>
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" href="css/register.css">
    <!--导入jquery-->
    <script src="js/jquery-3.3.1.js"></script>
</head>
<body>
<header>
    <%@include file="header.jsp"%>
</header>
<div class="rg_layout">
    <div class="rg_form clearfix">
        <p align="center" style="margin-top: 50px;font-size: 20px">${requestScope.msg}</p>
    </div>
</div>

<footer>
    <%@include file="footer.jsp"%>
</footer>
</body>
</html>
