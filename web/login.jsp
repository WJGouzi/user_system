<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>管理员登录</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery3.4.1.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script>
	 	function refreshCode() {
	 		var checkCode = document.getElementById("vcode");
	 		checkCode.src = "${pageContext.request.contextPath}/newCheckCodeServlet?time=" + new Date().getTime();
		}

		function login() {
			document.loginFrom.action = "${pageContext.request.contextPath}/loginServlet";
			document.loginFrom.submit();
		}
		function register() {
			document.loginFrom.action = "${pageContext.request.contextPath}/register.jsp";
			document.loginFrom.submit();
		}
	</script>

  </head>
  <body>
  	<div class="container" style="width: 400px;">
  		<h3 style="text-align: center;">管理员登录</h3>
        <form id="submitForm" action="" name="loginFrom" method="post" enctype="multipart/form-data">
	      <div class="form-group">
	        <label for="userId">用户名：</label>
	        <input type="text" name="userId" class="form-control" id="userId" placeholder="请输入用户名"/>
	      </div>
	      
	      <div class="form-group">
	        <label for="password">密码：</label>
	        <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
	      </div>
			
	      <div class="form-inline">
	        <label for="vcode">验证码：</label>
	        <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码" style="width: 120px;"/>
	        <a href="javascript:refreshCode()">
				<img src="${pageContext.request.contextPath}/newCheckCodeServlet" title="看不清点击刷新" id="vcode"/>
			</a>
	      </div>
	      <hr/>
	      <div class="form-group" style="text-align: center;">
			  <button class="btn btn btn-primary" onclick="login();">登录</button>
			  <button class="btn btn btn-default" onclick="register();">注册</button>
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
