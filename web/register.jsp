<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册管理员</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery3.4.1.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>

    <script>
        $(function () {
            $("#userId").blur(function () {
                var userName = $(this).val();
                // 去获取
                $.post(
                    "/findAdminServlet",
                    {userId: userName},
                    function (data) {


                    }
                );
            })
        })


    </script>
</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">管理员注册</h3>
    <form action="${pageContext.request.contextPath}/registerServlet" name="loginFrom" method="post">
        <div class="form-group">
            <label for="userId">用户名：</label>
            <input type="text" name="userId" class="form-control" id="userId" placeholder="请输入用户名"/>
        </div>

        <div class="form-group">
            <label for="name">真实姓名：</label>
            <input type="text" name="name" class="form-control" id="name" placeholder="请输入真实姓名"/>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="gender" value="男" />男
            <input type="radio" name="gender" value="女"/>女
        </div>

        <div class="form-group">
            <label for="idCard">身份证号码：</label>
            <input type="text" name="idCard" class="form-control" id="idCard" placeholder="请输入身份证号码"/>
        </div>

        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
        </div>

        <div class="form-group">
            <label for="checkPassword">确认密码：</label>
            <input type="password" name="checkPassword" class="form-control" id="checkPassword" placeholder="请确认密码"/>
        </div>

        <div class="form-inline">
            <label for="verifycode">验证码：</label>
            <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码" style="width: 120px;"/>
            <a href="javascript:refreshCode()">
                <img src="${pageContext.request.contextPath}/newCheckCodeServlet" title="看不清点击刷新" id="vcode"/>
            </a>
        </div>
        <hr/>
        <div class="form-group" style="text-align: center;">
            <button class="btn btn btn-default">注册</button>
        </div>
    </form>
    <!-- 出错显示的信息框 -->
    <c:if test="${fn:length(loginError)>'0'}" >
        <div class="alert alert-warning alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" >
                <span>x</span>
            </button>
            <strong>${loginError}</strong>
        </div>
    </c:if>
</div>
</body>
</html>
