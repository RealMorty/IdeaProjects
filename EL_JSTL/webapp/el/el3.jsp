<%@ page import="domain.User" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取数据</title>
</head>
<body>

<%
    User user = new User();
    user.setName("Morty");
    user.setAge(23);
    Date date = new Date();
    user.setBirthDate(date);

    request.setAttribute("u",user);

    List list = new ArrayList();
    list.add("Morty1");
    list.add("Morty2");
    list.add("Morty3");
    list.add("Morty4");
    list.add(user);

    request.setAttribute("list",list);

    Map map = new HashMap();
    map.put("name","Morty");
    map.put("gender","male");

    request.setAttribute("map",map);
%>
    <h3>el获取对象的值</h3>
    ${requestScope.u}<br>
    ${u.name}
    ${u.age}
    ${u.birthDate.month+1}
    ${u.birStr}

    <h3>el获取List的值</h3>
    ${list}<br>
    ${list[0]}<br>
    ${list[1]}<br>
    ${list[4].name}<br>

    <h3>el获取Map的值</h3>
    ${map.name}<br>
    ${map.gender}<br>
    ${map["gender"]}<br>




</body>
</html>
