<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
    <head>
<%--    	<base href="<%=basePath%>"/>--%>
        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>修改用户</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        
    </head>
    <body>
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">修改联系人</h3>
<%--        <form action=# method="get" autocomplete="on">--%>
        <form action="${pageContext.request.contextPath}/UserUpdateServlet" method="post" autocomplete="on">
          <div class="form-group">
            <label for="name">姓名（不可修改）：</label>
            <input type="text" class="form-control" id="name"
                   name="name"  readonly="readonly" value="${requestScope.queryUser.name}"/>
          </div>
<%--18171948796--%>

          <div class="form-group">
            <label>性别：</label>
              <input type="radio" name="gender" value="男"
                     <c:if test="${requestScope.queryUser.gender eq '男'}">checked</c:if>/>男
              <input type="radio" name="gender" value="女"
                     <c:if test="${requestScope.queryUser.gender eq '女'}" >checked</c:if>/>女
          </div>

          <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age"  name="age" value="${requestScope.queryUser.age}"/>
          </div>

            <div class="form-group">
                <label for="address">籍贯：</label>
                <select name="address" class="form-control" id="address">
                    <option value="广东"
                            <c:if test="${requestScope.queryUser.address eq '广东'}">selected</c:if>>广东
                    </option>
                    <option value="广西"
                            <c:if test="${requestScope.queryUser.address eq '广西'}">selected</c:if>>广西
                    </option>
                    <option value="湖南"
                            <c:if test="${requestScope.queryUser.address eq '湖南'}">selected</c:if>>湖南
                    </option>
                    <option value="湖北"
                            <c:if test="${requestScope.queryUser.address eq '湖北'}">selected</c:if>>湖北
                    </option>
                    <option value="江西"
                            <c:if test="${requestScope.queryUser.address eq '江西'}">selected</c:if>>江西
                    </option>
                    <option value="浙江"
                            <c:if test="${requestScope.queryUser.address eq '浙江'}">selected</c:if>>浙江
                    </option>
                    <option value="福建"
                            <c:if test="${requestScope.queryUser.address eq '福建'}">selected</c:if>>福建
                    </option>
                    <option value="江苏"
                            <c:if test="${requestScope.queryUser.address eq '江苏'}">selected</c:if>>江苏
                    </option>
                    <option value="海南"
                            <c:if test="${requestScope.queryUser.address eq '海南'}">selected</c:if>>海南
                    </option>
                    <option value="山东"
                            <c:if test="${requestScope.queryUser.address eq '山东'}">selected</c:if>>山东
                    </option>
                    <option value="云南"
                            <c:if test="${requestScope.queryUser.address eq '云南'}">selected</c:if>>云南
                    </option>
                    <option value="西藏"
                            <c:if test="${requestScope.queryUser.address eq '西藏'}">selected</c:if>>西藏
                    </option>
                    <option value="北京"
                            <c:if test="${requestScope.queryUser.address eq '北京'}">selected</c:if>>北京
                    </option>
                    <option value="青海"
                            <c:if test="${requestScope.queryUser.address eq '青海'}">selected</c:if>>青海
                    </option>
                    <option value="内蒙古"
                            <c:if test="${requestScope.queryUser.address eq '内蒙'}">selected</c:if>>内蒙
                    </option>
                    <option value="新疆"
                            <c:if test="${requestScope.queryUser.address eq '新疆'}">selected</c:if>>新疆
                    </option>
                    <option value="重庆"
                            <c:if test="${requestScope.queryUser.address eq '重庆'}">selected</c:if>>重庆
                    </option>
                    <option value="四川"
                            <c:if test="${requestScope.queryUser.address eq '四川'}">selected</c:if>>四川
                    </option>
                    <option value="贵州"
                            <c:if test="${requestScope.queryUser.address eq '贵州'}">selected</c:if>>贵州
                    </option>
                    <option value="辽宁"
                            <c:if test="${requestScope.queryUser.address eq '辽宁'}">selected</c:if>>辽宁
                    </option>
                    <option value="吉林"
                            <c:if test="${requestScope.queryUser.address eq '吉林'}">selected</c:if>>吉林
                    </option>
                    <option value="黑龙江"
                            <c:if test="${requestScope.queryUser.address eq '黑龙'}">selected</c:if>>黑龙
                    </option>
                    <option value="上海"
                            <c:if test="${requestScope.queryUser.address eq '上海'}">selected</c:if>>上海
                    </option>
                    <option value="宁夏"
                            <c:if test="${requestScope.queryUser.address eq '宁夏'}">selected</c:if>>宁夏
                    </option>
                    <option value="河北"
                            <c:if test="${requestScope.queryUser.address eq '河北'}">selected</c:if>>河北
                    </option>
                    <option value="河南"
                            <c:if test="${requestScope.queryUser.address eq '河南'}">selected</c:if>>河南
                    </option>
                    <option value="陕西"
                            <c:if test="${requestScope.queryUser.address eq '陕西'}">selected</c:if>>陕西
                    </option>
                    <option value="山西"
                            <c:if test="${requestScope.queryUser.address eq '山西'}">selected</c:if>>山西
                    </option>
                    <option value="香港"
                            <c:if test="${requestScope.queryUser.address eq '香港'}">selected</c:if>>香港
                    </option>
                    <option value="澳门"
                            <c:if test="${requestScope.queryUser.address eq '澳门'}">selected</c:if>>澳门
                    </option>
                    <option value="甘肃"
                            <c:if test="${requestScope.queryUser.address eq '甘肃'}">selected</c:if>>甘肃
                    </option>
                    <option value="台湾"
                            <c:if test="${requestScope.queryUser.address eq '台湾'}">selected</c:if>>台湾
                    </option>
                    <option value="天津"
                            <c:if test="${requestScope.queryUser.address eq '天津'}">selected</c:if>>天津
                    </option>
                </select>
            </div>

          <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" name="qq" id="qq" value="${requestScope.queryUser.qq}"/>
          </div>

          <div class="form-group">
            <label for="email">Email：</label>
            <input type="email" class="form-control" name="email" id="email" value="${requestScope.queryUser.email}"/>
          </div>

             <div class="form-group" style="text-align: center">
                <input class="btn btn-primary" type="submit" value="提交" />
                <input class="btn btn-default" type="reset" value="重置" />
                <input class="btn btn-default" type="button" value="返回"/>
             </div>
        </form>
        </div>
    </body>
</html>