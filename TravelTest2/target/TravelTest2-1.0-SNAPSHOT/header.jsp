<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="js/jquery-3.3.1.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/index.css">
<script>
    $(function (){
        let search = location.search;
        let cid = search.split("=")[1];
        $.get("category/findAll",{},function (data) {
            var lis = '<li class="nav-active"><a href="index.jsp">首页</a></li>';
            for (let i = 0; i < data.length; i++) {
                let li = '<li><a href="route_list.jsp?cid='+data[i].cid+'">'+data[i].cname+'</a></li>';
                // alert(li);
                lis += li;
            }
            lis += '<li><a href="favoriterank.jsp">收藏排行榜</a></li>';
            $("#category").html(lis);
        });
    });
</script>
<!-- 头部 start -->
<header id="header">
    <div class="top_banner">
        <img src="images/top_banner.jpg" alt="">
    </div>
    <div class="shortcut">
        <c:if test="${sessionScope.active eq false}">
            <!-- 未登录状态 -->
            <div class="login_out">
                <a href="login.jsp">登录</a>
                <a href="register.jsp">注册</a>
            </div>
        </c:if>
        <c:if test="${sessionScope.active eq null}">
            <!-- 未登录状态 -->
            <div class="login_out">
                <a href="login.jsp">登录</a>
                <a href="register.jsp">注册</a>
            </div>
        </c:if>
        <c:if test="${sessionScope.active}">
            <!-- 登录状态 -->
            <div class="login">
                <span>欢迎回来，${sessionScope.CurrentUser.username}</span>
                <a href="myfavorite.jsp" class="collection">我的收藏</a>
                <a href="javascript:location.href='user/Exit';">退出</a>
            </div>
        </c:if>
    </div>
    <div class="header_wrap">
        <div class="topbar">
            <div class="logo">
                <a href="index.jsp"><img src="images/logo.jpg" alt=""></a>
            </div>
            <div class="search">
                <input name="" type="text" placeholder="请输入路线名称" class="search_input" autocomplete="off">
                <a href="javascript:;" class="search-button">搜索</a>
            </div>
            <div class="hottel">
                <div class="hot_pic">
                    <img src="images/hot_tel.jpg" alt="">
                </div>
                <div class="hot_tel">
                    <p class="hot_time">客服热线(9:00-6:00)</p>
                    <p class="hot_num">400-618-9090</p>
                </div>
            </div>
        </div>
    </div>
</header>
<!-- 头部 end -->
<!-- 首页导航 -->
<div class="navitem">
    <ul class="nav" id="category">
<%--        <li class="nav-active"><a href="index.jsp">首页</a></li>--%>
<%--        <li><a href="route_list.jsp">门票</a></li>--%>
<%--        <li><a href="route_list.jsp">酒店</a></li>--%>
<%--        <li><a href="route_list.jsp">香港车票</a></li>--%>
<%--        <li><a href="route_list.jsp">出境游</a></li>--%>
<%--        <li><a href="route_list.jsp">国内游</a></li>--%>
<%--        <li><a href="route_list.jsp">港澳游</a></li>--%>
<%--        <li><a href="route_list.jsp">抱团定制</a></li>--%>
<%--        <li><a href="route_list.jsp">全球自由行</a></li>--%>
<%--        <li><a href="favoriterank.jsp">收藏排行榜</a></li>--%>
    </ul>
</div>
    