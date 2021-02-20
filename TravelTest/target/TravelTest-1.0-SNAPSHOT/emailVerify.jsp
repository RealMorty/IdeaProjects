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
    <%@include file="header.jsp" %>
</header>
<div class="rg_layout">
    <div class="rg_form clearfix">
        <h1 align="center" style="margin-top: 50px; font-size: 20px">恭喜您，${sessionScope.CurrentUser.username}，注册成功！</h1>
        <p align="center" style="margin-top: 30px">我们将发送一封邮件到您的邮箱，请按邮件中的说明尽快确认，以完成邮箱注册</p>
        <p style="margin-top: 30px">
            <span id="time">5</span>秒后自动跳转至首页...或<a href="index.jsp">点此</a>立刻返回首页
        </p>
    </div>
</div>
<footer>
    <%@include file="footer.jsp" %>
</footer>
</body>
<script>
    var timeId = document.getElementById("time");
    var time = 5;

    function sec() {
        time--;
        if (time <= 0) {
            location.href = "${pageContext.request.contextPath}/index.jsp";
            clearInterval();
        }
        timeId.innerHTML = time;
    }

    setInterval(sec, 1000);
</script>
</html>
