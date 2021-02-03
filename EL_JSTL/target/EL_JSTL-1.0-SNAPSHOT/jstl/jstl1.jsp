<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL - if</title>
</head>
<body>
    <!--c:if标签-->
    <!--test:接收Boolean表达式-->
    <!--true：显示标签体-->
    <!--false：不显示标签体-->

    <%
        List list = new ArrayList();
        list.add("a");
        request.setAttribute("list",list);
        request.setAttribute("number",4);
    %>
    <br>
<%--    <c:if test="${not empty list}">true</c:if>--%>

    <br>
    <c:if test="${number%2 != 0}">
        <h4>${number}为奇数</h4>
    </c:if>
    <c:if test="${number%2 == 0}">
        <h4>${number}为偶数</h4>
    </c:if>



</body>
</html>
