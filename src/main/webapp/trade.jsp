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
    <link rel="stylesheet" href="css/login.css">
    <script src="js/bootstrap.min.js"></script>
    <style>
        .tradeRow {
            height: 45px;
        }

        .tradeRow td {
            line-height: 45px;
        }
    </style>
</head>
<body class="trade">
<jsp:include page="header.jsp"></jsp:include>
<br>
<div class="container-fluid">
    <div class="d-flex justify-content-end">
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal">
            查询交易记录
        </button>
    </div>
    <!-- 模态框 -->
    <div class="modal" id="myModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <!-- 模态框头部 -->
                <div class="modal-header">
                    <h4 class="modal-title">交易记录查询</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                <!-- 模态框内容 -->
                <div class="modal-body">
                    <div class="col-sm-12 column">
                        <form class="form-horizontal trade_form login_form" action="tradeList_byTime">
                            <div class="form-group">
                                <label for="startTime" class="col-sm-4 control-label">开始时间:</label>
                                <div class="col-sm-12">
                                    <input type="date" name="startTime" class="form-control" id="startTime" required/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="endTime" class="col-sm-4 control-label">结束时间:</label>
                                <div class="col-sm-12">
                                    <input type="date" name="endTime" class="form-control" id="endTime" required/>
                                </div>
                            </div>
                            <div class="login_btn">
                                <button type="submit" class="btn btn-primary">交易查询</button>
                                <button type="reset" class="btn btn-secondary">取消操作</button>
                            </div>
                        </form>
                    </div>
                </div>

                <!-- 模态框底部 -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">关闭</button>
                </div>

            </div>
        </div>
    </div>

    <div class="container">
        <div class="d-flex justify-content-center">
            <h1 class="h2">
                交易记录查询
            </h1>
        </div>
        <table class="table table-hover">
            <thead class="table-responsive">
            <tr>
                <th width="5%">流水号</th>
                <th width="5%">交易类型</th>
                <th width="5%">交易金额</th>
                <th width="10%">交易时间</th>
                <th width="20%">交易摘要</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${p.list}" var="t">
                <tr class="tradeRow">
                    <td>${t.id}</td>
                    <td>
                        <c:if test="${t.tradeType == 1}"><span class="text-success">存款</span></c:if>
                        <c:if test="${t.tradeType == 2}"><span class="text-danger">取款</span></c:if>
                        <c:if test="${t.tradeType == 3}"><span class="text-warning">转账</span></c:if>
                    </td>
                    <td>
                        <c:if test="${t.tradeType == 1}"><span class="text-success">+${t.tradeMoney}</span></c:if>
                        <c:if test="${t.tradeType == 2}"><span class="text-danger">-${t.tradeMoney}</span></c:if>
                        <c:if test="${t.tradeType == 3}"><span class="text-warning">-${t.tradeMoney}</span></c:if>
                    </td>
                    <td>${t.tradeTime.toLocaleString()}</td>
                    <td>${t.tradeDigest}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <c:if test="${type == 0}">
        <jsp:include page="/page.jsp">
            <jsp:param value="/trade_list" name="url"/>
        </jsp:include>
    </c:if>
    <c:if test="${type == 1}">
        <jsp:include page="/page.jsp">
            <jsp:param value="/tradeList_byTime" name="url"/>
            <jsp:param value="&startTime=${startTime}&endTime=${endTime}" name="param"/>
        </jsp:include>
    </c:if>
</div>
</body>
</html>
