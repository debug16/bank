<%--
  Created by IntelliJ IDEA.
  User: debug16
  Date: 2021/12/16
  Time: 上午 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <c:if test="${!empty balance }">
        <div class="alert alert-success">
            <strong>你的账户余额为：</strong><strong class="text-danger">${balance}</strong>
        </div>
    </c:if>
    <c:if test="${empty balance and !empty failMsg}">
        <div class="alert alert-danger">${failMsg}</div>
    </c:if>
</div>
</body>
</html>