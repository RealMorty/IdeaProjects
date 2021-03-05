<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录页面</title>
    <style>
        .bs-example {
            width: 440px;
            position: relative;
            top: 15px;
            /*left: 500px;*/
            /*right: 500px;*/
            font-size: 12px;
            font-weight: 700;
            color: #959595;
            text-transform: uppercase;
            letter-spacing: 1px;
        }
        #checkCodeClass {
            width: 350px;
        }
        #before_checkImg {
            width: 10px;
        }
        #td_checkImg {
            vertical-align: auto;
        }
        #error1 {
            margin-top: 30px;
            color: red;
        }
        #error2 {
            margin-top: 10px;
            color: red;
        }

    </style>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script>
        window.onload = function(){
            //获取图片对象
            var img = document.getElementById("checkCodeImg");
            img.onclick=function () {
                //加时间戳永不重复
                var time = new Date().getTime();
                img.src = "CheckCodeServlet?"+time;
            }
        }
    </script>
</head>
<body>
    <div class = "col-md-offset-4 col-lg-offset-4col-xl-offset-4">
        <form class="bs-example bs-example-form" data-example-id="simple-input-groups"
          method="get" action="Check1">
        <div class="input-group" id="username">
            <span class="input-group-addon">用户名</span>
            <input type="text" class="form-control" placeholder="用户名" aria-describedby="basic-addon1" name="username">
        </div>
        <br>
        <div class="input-group" id="password">
            <span class="input-group-addon">密码</span>
            <input type="password" class="form-control" placeholder="密码" aria-describedby="basic-addon1" name="password">
        </div>
        <br>
        <table cellpadding="20px" cellspacing="10px">
            <tr>
                <td class="input-group" id="checkCodeClass">
                    <span class="input-group-addon">验证码</span>
                    <input type="text" class="form-control" placeholder="看不清？点击图片换一张"
                           aria-describedby="basic-addon1" name="checkcode">
                </td>
                <td id="before_checkImg"></td>
                <td id="td_checkImg">
                    <img id="checkCodeImg" src="CheckCodeServlet" />
                </td>
            </tr>
        </table>
        <br>
        <div class="btn-group" role="group" aria-label="...">
            <button type="submit" class="btn btn-default">立即登录</button>
        </div>

    </form>
        ${requestScope.errorReason1}
        ${requestScope.errorReason2}

<%--        <div id="error1"><%=request.getSession().getAttribute("errorReason1")==null?"":"验证码输入错误"%></div>--%>
<%--        <div id="error2"><%=request.getSession().getAttribute("errorReason2")==null?"":"用户名或密码输入错误"%></div>--%>
    </div>

</body>
</html>
