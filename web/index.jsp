<%--
  Created by IntelliJ IDEA.
  User: gouzi
  Date: 2020/2/19
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <meta name="viewport" content="width=device-width, initial-scale=1"/>
  <title>首页</title>

  <!-- 1. 导入CSS的全局样式 -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
  <script src="js/jquery-2.1.0.min.js"></script>
  <!-- 3. 导入bootstrap的js文件 -->
  <script src="js/bootstrap.min.js"></script>
  <script type="text/javascript">
  </script>
</head>
<body>

    <c:if test="${fn:length(userInfo.name) > 0}">
        <div>${userInfo.name}, 欢迎您...</div>
    </c:if>
    <c:if test="${fn:length(adminInfo.name) > 0}">
        <div>${adminInfo.name}, 欢迎您...</div>
    </c:if>
    <div align="center">
<%--      <a href="${pageContext.request.contextPath}/allUserListServlet" style="text-decoration:none;font-size:33px">查询所有用户信息 </a>--%>
        <a href="${pageContext.request.contextPath}/findUsersByPageServlet" style="text-decoration:none;font-size:33px">
            查询所有用户信息
        </a>
    </div>
</body>
</html>
