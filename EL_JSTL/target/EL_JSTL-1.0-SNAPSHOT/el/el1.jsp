<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        System.out.printf("111", page);
    %>
    ${3 > 4}

    \${3 > 4}
<hr>
<h1>
    ${3 + 4}<br>
    ${3 / 4}<br>
    ${3 div 4}<br>
    ${3 % 4}<br>
    ${3 mod 4}<br>
        <%
            int[] arr = {};

        %>
</h1>
<h3>empty运算符</h3>
<%
    String string = "";
    request.setAttribute("string",string);
%>
${not empty string}

<h3>el获取隐式对象</h3>
    <h4>在jsp页面动态获取虚拟目录</h4>
    ${pageContext.request.contextPath}
<%
    response.sendRedirect(request.getContextPath());
%>

</body>
</html>
