<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>


    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        function deleteUser(id){
            //用户安全提示
            if (confirm("您确定要删除吗？")) {
                location.href = "${pageContext.request.contextPath}/UserDeleteServlet?id="+id;
            }
        }

        window.onload = function() {
            //获取firstCb
            document.getElementById("firstCb").onclick = function () {
                var checkBoxIds = document.getElementsByName("checkBoxId");
                for (var i = 0; i < checkBoxIds.length; i++) {
                    checkBoxIds[i].checked = this.checked;
                }
            }
            document.getElementById("delSelected").onclick = function () {
                //判断是否有选中条目
                var checkBoxIds = document.getElementsByName("checkBoxId");
                var flag = false;
                for (var i = 0; i < checkBoxIds.length; i++) {
                    if (checkBoxIds[i].checked) {
                        flag = true;
                        break;
                    }
                }
                // 表单提交
                if (flag) {
                    if (confirm("您确定要删除选中条目吗？")) {
                        document.getElementById("form").submit();
                    }
                }
                else {
                    alert("未选中任何条目！");
                }
            }
        }
    </script>


</head>
<body>

<div class="container">
    <h3 style="text-align: center;margin-bottom: 30px">用户信息列表</h3>
    <div style="float: left;margin-right: 10px;margin-top: 10px">
        <form class="form-inline" action="${pageContext.request.contextPath}/findUserByPageServlet" method="get">
            <div class="form-group" style="margin-right: 5px">
                <label for="name">姓名</label>
                <input type="text" class="form-control" id="name" name="name" value="${requestScope.condition.name[0]}">
            </div>
            <div class="form-group" style="margin-right: 5px">
                <label for="address">籍贯</label>
                <input type="text" class="form-control" id="address" name="address" value="${requestScope.condition.address[0]}">
            </div>
            <div class="form-group" style="margin-right: 5px">
                <label for="email">Email</label>
                <input type="text" class="form-control" id="email" name="email" value="${requestScope.condition.email[0]}">
            </div>
            <a style="margin-right: 5px">
                <button type="submit" class="btn btn-default">查询</button>
            </a>
            <a style="margin-right: 5px" href="${pageContext.request.contextPath}/resetUserServlet">
                <button type="button" class="btn btn-default">重置</button>
            </a>

        </form>





    </div>
    <div style="float: right;margin-left: 10px;margin-top: 10px">
        <a class="btn btn-primary" href="add.jsp">添加联系人</a>
        <a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选中</a>
    </div>
    <form action="${pageContext.request.contextPath}/DelSelectedServlet" method="get" id="form">
        <table border="1" class="table table-bordered table-hover" style="margin-top: 90px;">
            <tr class="success">
                <th><input type="checkbox" id="firstCb"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${pageBean.pageList}" var="user" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="checkBoxId" value="${user.id}"></td>
                    <td>${s.count+(requestScope.pageBean.currentPage-1)*requestScope.pageBean.rows}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.address}</td>
                    <td>${user.qq}</td>
                    <td>${user.email}</td>
                    <td><a class="btn btn-default btn-sm"
                           href="${pageContext.request.contextPath}/UserQueryByIdServlet?id=${user.id}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href=
                                "javascript:deleteUser(${user.id});">删除</a>
                    </td>
                        <%--                <td>${user.id}</td>--%>
                </tr>
            </c:forEach>

        </table>
    </form>

    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${requestScope.pageBean.currentPage eq 1}">
                    <li class="disabled">
                </c:if>
                <c:if test="${requestScope.pageBean.currentPage ne 1}">
                    <li>
                </c:if>
                        <a
        href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${requestScope.pageBean.currentPage-1}&name=${requestScope.condition.name[0]}&address=${requestScope.condition.address[0]}&email=${requestScope.condition.email[0]}"
                           aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>

                <c:forEach begin="1" end="${requestScope.pageBean.totalPages}" var="i">
                    <c:if test="${requestScope.pageBean.currentPage == i}">
                        <li class="active">
                            <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&name=${requestScope.condition.name[0]}&address=${requestScope.condition.address[0]}&email=${requestScope.condition.email[0]}">
                                ${i}
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${requestScope.pageBean.currentPage != i}">
                        <li>
                            <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&name=${requestScope.condition.name[0]}&address=${requestScope.condition.address[0]}&email=${requestScope.condition.email[0]}">
                                ${i}
                            </a>
                        </li>
                    </c:if>
                </c:forEach>

                <c:if test="${requestScope.pageBean.currentPage eq requestScope.pageBean.totalPages}">
                    <li class="disabled">
                </c:if>
                <c:if test="${requestScope.pageBean.currentPage ne requestScope.pageBean.totalPages}">
                    <li>
                </c:if>
                        <a
        href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${requestScope.pageBean.currentPage+1}&name=${requestScope.condition.name[0]}&address=${requestScope.condition.address[0]}&email=${requestScope.condition.email[0]}"
                           aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>

                <span style="font-size: 15px;margin-left: 34px;height: 34px;line-height: 34px">
                    第${requestScope.pageBean.currentPage}页/共${requestScope.pageBean.totalPages}页，
                    ${requestScope.pageBean.totalCount}条记录
                </span>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
