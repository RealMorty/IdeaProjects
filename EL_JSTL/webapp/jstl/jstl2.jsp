<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL - choose</title>
</head>
<body>
<%--    完成数字编号对应星期几--%>
    <%
        request.setAttribute("number",4);
    %>
    <c:choose>
        <c:when test="${number == 1}">星期一</c:when>
        <c:when test="${number == 2}">星期二</c:when>
        <c:when test="${number == 3}">星期三</c:when>
        <c:when test="${number == 4}">星期四</c:when>
        <c:when test="${number == 5}">星期五</c:when>
        <c:when test="${number == 6}">星期六</c:when>
        <c:when test="${number == 7}">星期天</c:when>

        <c:otherwise>数字输入有误</c:otherwise>
    </c:choose>

    <hr>
    <c:forEach begin="1" end="10" var="i" step="2" varStatus="s">
        ${i}-->${s.index}>-->${s.count}<br>
    </c:forEach>

    <hr>
    <%
        List list = new ArrayList();
        list.add("Morty1");
        list.add("Morty2");
        list.add("Morty3");
        list.add("Morty4");

        request.setAttribute("list",list);
    %>

    <c:forEach items="${list}" var="str" varStatus="s">
        ${s.index} ${s.count} ${str} <br>
    </c:forEach>



</body>
</html>
