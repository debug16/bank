<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>个人网上银行系统</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<div class="container">
    <div class="row clearfix title">
        <div class="col-md-12 column">
            <h1 class="text-center display-3">
                欢迎使用个人网上银行系统
            </h1>
        </div>
    </div>
    <div class="row clearfix justify-content-center">
        <div class="col-sm-5 column ">
            <form class="form-horizontal login_form" action="user_login">
            <h1 class="text-center h2">
                登录
            </h1>
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">账号：</label>
                    <div class="col-sm-12">
                        <input type="text" name="name" class="form-control" id="inputEmail3" required/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">密码：</label>
                    <div class="col-sm-12">
                        <input type="password" name="password" class="form-control" id="inputPassword3" required/>
                    </div>
                </div>
                <div class="login_btn">
                    <button type="submit" class="btn btn-primary">登录</button>
                    <button type="reset" class="btn btn-secondary">重置</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>