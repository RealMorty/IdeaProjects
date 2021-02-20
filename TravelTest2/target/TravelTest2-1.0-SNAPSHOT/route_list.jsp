<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/index.css">
<script src="js/jquery-3.3.1.js"></script>
<script>
    $(function () {
       let search = location.search;
       let cid = search.split("=")[1];
       load(cid);
    });
    function load(cid,currentPage) {
        $.get("route/pageQuery",{cid:cid,currentPage:currentPage},function (pb) {
            $("#totalPage").html(pb.totalPage);
            $("#totalCount").html(pb.totalCount);
            let lis = "";
            let firstPage = '<li onclick="javascript:load('+cid+',1)"><a href="javascript:void(0)">首页</a></li>';
            let beforeNum = pb.currentPage - 1;
            if (beforeNum <= 0) {
                beforeNum = 1;
            }
            let beforePage = '<li onclick="javascript:load('+cid+','+beforeNum+')" class="threeword"><a href="javascript:void(0)">上一页</a></li>';
            lis += firstPage;
            lis += beforePage;

            let begin;
            let end;
            if (pb.totalPage < 10) {
                begin = 1;
                end = pb.totalPage;
            } else {
                begin = pb.currentPage - 5;
                end = pb.currentPage + 4;

                if (begin < 1){
                    begin = 1;
                    end = begin + 9;
                }
                if (end > pb.totalPage) {
                    end = pb.totalPage;
                    begin = end - 9;
                }
            }
            for (let i = begin; i <= end; i++) {
                let li;
                if (pb.currentPage === i) {
                    li = '<li class="curPage" onclick="javascript:load('+cid+','+i+')"><a href="javascript:void(0)">'+i+'</a></li>';
                } else {
                    li = '<li onclick="javascript:load('+cid+','+i+')"><a href="javascript:void(0)">'+i+'</a></li>';
                }
                lis += li;
            }
            let nextNum = pb.currentPage + 1;
            if (nextNum > pb.totalPage) {
                nextNum = pb.totalPage;
            }
            let lastPage = '<li onclick="javascript:load('+cid+','+pb.totalPage+')"><a href="javascript:void(0)">末页</a></li>';
            let nextPage = '<li onclick="javascript:load('+cid+','+nextNum+')" class="threeword"><a href="javascript:void(0)">下一页</a></li>';

            lis += nextPage;
            lis += lastPage;

            $("#pageNum").html(lis);

            var route_lis = "";
            for (let i = 0; i < pb.list.length; i++) {
                let route = pb.list[i];
                let li = '<li>\n' +
                    '                        <div class="img"><img src="'+route.rimage+'" style="width: 299px;"></div>\n' +
                    '                        <div class="text1">\n' +
                    '                            <p>'+route.rname+'</p>\n' +
                    '                            <br/>\n' +
                    '                            <p>'+route.routeIntroduce+'</p>\n' +
                    '                        </div>\n' +
                    '                        <div class="price">\n' +
                    '                            <p class="price_num">\n' +
                    '                                <span>&yen;</span>\n' +
                    '                                <span>'+route.price+'</span>\n' +
                    '                                <span>起</span>\n' +
                    '                            </p>\n' +
                    '                            <p><a href="route_detail.jsp">查看详情</a></p>\n' +
                    '                        </div>\n' +
                    '                    </li>';
                route_lis += li;
            }
            $("#route").html(route_lis);
            window.scrollTo(0,0);
        })
    }
</script>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>黑马旅游-搜索</title>
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" href="css/search.css">
    <script src="js/jquery-3.3.1.js"></script>
</head>
<body>
<!--引入头部-->
<div id="header"></div>
<div class="page_one">
    <div class="contant">
        <div class="crumbs">
            <img src="images/search.png" alt="">
            <p><a href="index.jsp">黑马旅行></a><span>搜索结果</span></p>
        </div>
        <div class="xinxi clearfix">
            <div class="left">
                <div class="header">
                    <span>商品信息</span>
                    <span class="jg">价格</span>
                </div>
                <ul id="route">
                </ul>
                <div class="page_num_inf">
                    <i></i> 共
                    <span id="totalPage"></span>页<span id="totalCount"></span>条
                </div>
                <div class="pageNum">
                    <ul id="pageNum"></ul>
                </div>
            </div>
            <div class="right">
                <div class="top">
                    <div class="hot">HOT</div>
                    <span>热门推荐</span>
                </div>
                <ul>
                    <li>
                        <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                        <div class="right">
                            <p>清远新银盏温泉度假村酒店/自由行套...</p>
                            <p>网付价<span>&yen;<span>899</span>起</span>
                            </p>
                        </div>
                    </li>
                    <li>
                        <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                        <div class="right">
                            <p>清远新银盏温泉度假村酒店/自由行套...</p>
                            <p>网付价<span>&yen;<span>899</span>起</span>
                            </p>
                        </div>
                    </li>
                    <li>
                        <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                        <div class="right">
                            <p>清远新银盏温泉度假村酒店/自由行套...</p>
                            <p>网付价<span>&yen;<span>899</span>起</span>
                            </p>
                        </div>
                    </li>
                    <li>
                        <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                        <div class="right">
                            <p>清远新银盏温泉度假村酒店/自由行套...</p>
                            <p>网付价<span>&yen;<span>899</span>起</span>
                            </p>
                        </div>
                    </li>
                    <li>
                        <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                        <div class="right">
                            <p>清远新银盏温泉度假村酒店/自由行套...</p>
                            <p>网付价<span>&yen;<span>899</span>起</span>
                            </p>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>

<!--引入头部-->
<div id="footer"></div>
<!--导入布局js，共享header和footer-->
<script type="text/javascript" src="js/include.js"></script>
</body>

</html>