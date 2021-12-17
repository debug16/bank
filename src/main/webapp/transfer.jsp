<%--
  Created by IntelliJ IDEA.
  User: debug16
  Date: 2021/12/16
  Time: 上午 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>网上银行</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/login.css">

    <script src="js/bootstrap.min.js"></script>
</head>
<body class="transfer">
<jsp:include page="header.jsp"></jsp:include>
<br>
<br>

<div class="container">
    <c:if test="${!empty msg }">
        <div class="alert alert-success alert-dismissible fade show">
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
            <strong>${msg }</strong><a href="balance" class="alert-link">查看余额</a>
        </div>
    </c:if>
    <c:if test="${!empty failMsg }">
        <div class="alert alert-danger alert-dismissible fade show">
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
            <strong>${failMsg }</strong><a href="balance" class="alert-link">查看余额</a>
        </div>
    </c:if>
    <div class="row clearfix justify-content-center">
        <div class="col-sm-6 column">
            <form class="form-horizontal login_form" action="transfer" method="post">
                <h1 class="text-center h    2 mb-4">
                    余额转账
                </h1>
                <div class="form-group">
                    <label for="inputAccount" class="col-sm-12 control-label">对方账号：</label>
                    <div class="col-sm-12">
                        <input type="text" name="toAccount" class="form-control" id="inputAccount" required/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputMoney" class="col-sm-12 control-label">金额：</label>
                    <div class="col-sm -12">
                        <input type="number" name="money" class="form-control" id="inputMoney" required/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword" class="col-sm-12 control-label">密码：</label>
                    <div class="col-sm-12">
                        <input type="password" name="password" class="form-control" id="inputPassword" required
                               maxlength="6"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputDigest" class="col-sm-2 control-label">交易摘要</label>
                    <div class="col-sm-12">
                        <textarea type="text" name="digest" class="form-control" id="inputDigest"
                                  maxlength="1024" rows="3"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <input type="hidden" name="type" class="form-control" value="3"/>
                </div>
                <div class="login_btn">
                    <button type="submit" class="btn btn-primary">确定操作</button>
                    <button type="reset" class="btn btn-danger">取消操作</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
