<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>自动跳转首页</title>
    <style>
        p {
            text-align: center;
        }
        span {
            color: red;
        }
    </style>
</head>
<body>
<%
    HttpSession session1 = request.getSession();
    Object errorReason = session1.getAttribute("errorReason");
    Boolean flag = false;
    if ("checkcode".equals(errorReason)) {
        flag = false;
    } else if ("user_pass".equals(errorReason)) {
        flag = true;
    }
    if (flag) {
        %><p><%="用户名或密码错误，"%></p><%
    } else {
        %><p><%="验证码输入错误，"%></p><%
    }
%>
    <p>
        <span id="time">5</span>秒后自动跳转至首页...
    </p>

</body>
<script>
    var timeId = document.getElementById("time");
    var time = 5;
    function sec() {
        time--;
        if (time <= 0) {
            location.href = "http://localhost:8080/CheckCodeCase/Login.html";
            clearInterval();
        }
        timeId.innerHTML = time;
    }
    setInterval(sec,1000);
</script>
</html>
