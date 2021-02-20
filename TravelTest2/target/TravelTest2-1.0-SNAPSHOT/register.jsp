<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" href="css/register.css">
    <!--导入jquery-->
    <script src="js/jquery-3.3.1.js"></script>
    <script>
        function checkPassword() {
            let password = $("#password").val();
            let reg_password = /^\w{8,20}$/;
            let flag = reg_password.test(password);
            if (password == null || password === "") {
                $("#s_password").empty();
            }
            if (password != null && password !== "" && flag) {
                $("#s_password").html("✔");
            } else if (password != null && password !== "" && !flag) {
                $("#s_password").html("❌");
            }
            return flag;
        }

        function checkEmail() {
            let email = $("#email").val();
            let reg_email = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
            let flag = reg_email.test(email);
            if (email == null || email === "") {
                $("#s_email").empty();
            }
            if (email !== "" && email != null && flag) {
                $("#s_email").html("✔");
            } else if (email !== "" && email != null && !flag) {
                $("#s_email").html("❌");
            }
            return flag;
        }

        function checkRealName() {
            let realName = $("#name").val();
            let reg_name = /^([\u4e00-\u9fa5]{1,20}|[a-zA-Z\.\s]{1,20})$/;
            let flag = reg_name.test(realName);
            if (realName == null || realName === "") {
                $("#s_name").empty();
            }
            if (realName !== "" && realName != null && flag) {
                $("#s_name").html("✔");
            } else if (realName !== "" && realName != null && !flag) {
                $("#s_name").html("❌");
            }
            return flag;
        }

        function checkPhone() {
            let phone = $("#telephone").val();
            let reg_phone = /^1[345678]\d{9}$/;
            let flag = reg_phone.test(phone);
            if (phone == null || phone === "") {
                $("#s_phone").empty();
            }
            if (phone !== "" && phone != null && flag) {
                $("#s_phone").html("✔");
            } else if (phone !== "" && phone != null && !flag) {
                $("#s_phone").html("❌");
            }
            return flag;
        }


        let flag_username;
        let flag_checkcode;
        $(function () {
            $("#username").blur(function () {
                let username = $(this).val();
                let span = $("#s_username");
                let reg_username = /^[(a-zA-Z0-9\u4e00-\u9fa5){1}_#]{1,10}$/;
                flag_username = reg_username.test(username);
                if (username == null || username === "") {
                    // span.empty();
                    span.html("❌");
                    flag_username = false;
                } else if (username != null && username !== "" && !flag_username) {
                    span.html("❌");
                } else {
                    $.get("user/CheckUsername", {username: username}, function (data) {
                            span.html(data.msg_username);
                            flag_username = data.msg_flag;
                        }
                    );
                }
            });

            $("#check").blur(function () {
                //检查验证码是否正确
                let checkcode = $(this).val();
                let span = $("#s_check");
                $.get("user/VerifyCheckCode", {check: checkcode}, function (data) {
                        flag_checkcode = data.msg_flag;
                        span.html(data.msg_check);
                    }
                );
            });
            $("#registerForm").submit(function () {
                if (checkEmail() && checkPassword() && checkPhone() && checkRealName() && flag_username && flag_checkcode) {
                    $("#msg").empty();
                    return true;
                } else {
                    $("#msg").html("请注意是否漏填/错填");
                    return false;
                }
            });
        });
    </script>
</head>
<body>
<!--引入头部-->
<div id="header">
    <%@include file="header.jsp" %>
</div>
<!-- 头部 end -->
<div class="rg_layout">
    <div class="rg_form clearfix">
        <div class="rg_form_left">
            <p>新用户注册</p>
            <p>USER REGISTER</p>
        </div>
        <div class="rg_form_center">

            <!--注册表单-->
            <form id="registerForm" action="user/Register"
                  method="post">
                <!--提交处理请求的标识符-->
                <input type="hidden" name="action" value="register">
                <table style="margin-top: 25px;">
                    <tr>
                        <td class="td_left">
                            <label for="username">用户名</label>
                        </td>
                        <td class="td_right">
                            <input type="text" id="username" name="username" placeholder="请输入账号">
                        </td>
                        <td><span id="s_username"></span></td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="password">密码</label>
                        </td>
                        <td class="td_right">
                            <%--                            TODO 密码等输入框更改type格式问题--%>
                            <input type="text" id="password" name="password" placeholder="请输入密码"
                                   onblur="checkPassword();">
                        </td>
                        <td><span id="s_password"></span></td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="email">Email</label>
                        </td>
                        <td class="td_right">
                            <input type="text" id="email" name="email" placeholder="请输入Email" onblur="checkEmail();">
                        </td>
                        <td><span id="s_email"></span></td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="name">姓名</label>
                        </td>
                        <td class="td_right">
                            <input type="text" id="name" name="name" placeholder="请输入真实姓名" onblur="checkRealName();">
                        </td>
                        <td><span id="s_name"></span></td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="telephone">手机号</label>
                        </td>
                        <td class="td_right">
                            <input type="text" id="telephone" name="telephone" placeholder="请输入您的手机号"
                                   onblur="checkPhone();">
                        </td>
                        <td><span id="s_phone"></span></td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="sex">性别</label>
                        </td>
                        <td class="td_right gender">
                            <input type="radio" id="sex" name="sex" value="男" checked> 男
                            <input type="radio" name="sex" value="女"> 女
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="birthday">出生日期</label>
                        </td>
                        <td class="td_right">
                            <input type="date" id="birthday" name="birthday" placeholder="年/月/日">
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="check">验证码</label>
                        </td>
                        <td class="td_right check">
                            <input type="text" id="check" name="check" class="check">
                            <img src="user/CreateCheckCode" height="32px" alt="" onclick="changeCheckCode(this)">
                            <script type="text/javascript">
                                //图片点击事件
                                function changeCheckCode(img) {
                                    img.src = "user/CreateCheckCode?" + new Date().getTime();
                                }
                            </script>
                        </td>
                        <td><span id="s_check"></span></td>
                    </tr>
                    <tr>
                        <td class="td_left">
                        </td>
                        <td class="td_right check">
                            <input type="submit" class="submit" value="注册" onclick="">
                            <span id="msg" style="color: red;font-size: 3px"></span>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div class="rg_form_right">
            <p>
                已有账号？
                <a href="login.jsp">立即登录</a>
            </p>
        </div>
    </div>
</div>
<!--引入尾部-->
<div id="footer">
    <%@include file="footer.jsp" %>
</div>
</body>
</html>