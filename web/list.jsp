
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        function deleteUser(userId) {
            if (confirm("您确定要删除此用户信息?")) {
                location.href = "${pageContext.request.contextPath}/deleteUserServlet?id=" + userId;
            }
        }

        window.onload = function () {
            // 删除选中按钮的点击事件
            document.getElementById("deleteSelectedButton").onclick = function () {
                if (confirm("您确定要删除所选用户?")) {
                    var flag = false;
                    var selectedUsers = document.getElementsByName("selectedUserId");
                    for (var i = 0; i < selectedUsers.length; i++) {
                        if(selectedUsers[i].checked){
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        document.getElementById("listForm").submit();
                    }
                }
            }

            document.getElementById("selectAll").onclick = function () {
                var allUsers = document.getElementsByName("selectedUserId");
                for (var i = 0; i < allUsers.length; i++) {
                    allUsers[i].checked = this.checked;
                }
            }

        }

    </script>

</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>

    <%--  这里是搜索区  --%>
    <div style="float: left">
        <form class="form-inline" action="${pageContext.request.contextPath}/findUsersByPageServlet" method="post">
            <div class="form-group">
                <label for="name">姓名</label>
                <input type="text" name="name" class="form-control" id="name">
            </div>
            <div class="form-group">
                <label for="address">籍贯</label>
                <input type="text" name="address" class="form-control" id="address">
            </div>
            <div class="form-group">
                <label for="email">邮箱</label>
                <input type="email" name="email" class="form-control" id="email">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <%--  这里操作区  --%>
    <div style="float: right; margin-bottom: 5px" >
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
        <a class="btn btn-primary" href="javascript:void(0);" id="deleteSelectedButton">删除选中</a>

    </div>
    <%--  这里是列表区  --%>
    <form id="listForm" action="${pageContext.request.contextPath}/deleteSelectedUsersServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th>
                    <input type="checkbox" id="selectAll">
                </th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
<%--            <c:forEach items="${allUsers}" var="user" varStatus="vs">--%>
            <c:forEach items="${pageBean.beanList}" var="user" varStatus="vs">
                <tr>
                    <th>
                        <input type="checkbox" name="selectedUserId" value="${user.id}">
                    </th>
                    <td>${vs.count}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.address}</td>
                    <td>${user.qq}</td>
                    <td>${user.email}</td>
                    <td>
                        <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findUserServlet?id=${user.id}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="javascript:deleteUser(${user.id})">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>

    <%--  这里是分页区  --%>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <c:if test="${pageBean.currentPage == 1}">
                <li class="disabled">
            </c:if>

            <c:if test="${pageBean.currentPage != 1}">
                <li>
            </c:if>
                <%-- 查询条件为姓名 籍贯 邮箱 起始位置 查询的条数 --%>
                <a href="${pageContext.request.contextPath}/findUsersByPageServlet?currentPage=${pageBean.currentPage - 1}&number=${pageBean.number}&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}"
                   aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach begin="1" end="${pageBean.totalPage}" var="i">
                <c:if test="${pageBean.currentPage == i}">
                    <li class="active">
                        <a href="${pageContext.request.contextPath}/findUsersByPageServlet?currentPage=${i}&number=${pageBean.number}&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">
                            ${i}
                        </a>
                    </li>
                </c:if>

                <c:if test="${pageBean.currentPage != i}">
                    <li>
                        <a href="${pageContext.request.contextPath}/findUsersByPageServlet?currentPage=${i}&number=${pageBean.number}&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">
                            ${i}
                        </a>
                    </li>
                </c:if>
            </c:forEach>
            <c:if test="${pageBean.currentPage == pageBean.totalPage}">
                <li class="disabled">
            </c:if>
            <c:if test="${pageBean.currentPage != pageBean.totalPage}">
                <li>
            </c:if>
                <a href="${pageContext.request.contextPath}/findUsersByPageServlet?currentPage=${pageBean.currentPage + 1}&number=${pageBean.number}&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}"
                   aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <span style="font-size: 25px; margin-left: 8px">
                共${pageBean.totalCount}条记录，共${pageBean.totalPage}页
            </span>
        </ul>
    </nav>
</div>
</body>
</html>
