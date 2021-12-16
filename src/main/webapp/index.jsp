<%--
  Created by IntelliJ IDEA.
  User: debug16
  Date: 2021/12/15
  Time: 下午 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>网上银行</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/index.css">
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br>
<br>
<div class="container-fluid">
    <div class="alert alert-success alert-dismissible fade show">
        <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        <strong>欢迎用户${user.accountId}使用个人网上银行系统！！！</strong><a href="balance" class="alert-link">查看余额</a>
    </div>
</div>
</body>
</html>
