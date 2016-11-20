<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="include/header.jsp"/>

<link href="<%=request.getContextPath()%>/assets/pages/css/login.min.css" rel="stylesheet" type="text/css"/>

<body class="login">
<div class="logo">
    <a href="#"> <img src="<%=request.getContextPath()%>/assets/pages/img/logo-big.png" alt=""/> </a>
</div>
<div class="content">
    <form class="login-form" action="<%=request.getContextPath()%>/login" method="post">
        <h3 class="form-title font-green">请登录</h3>
        <div class="alert alert-danger display-hide">
            <button class="close" data-close="alert"></button>
            <span>请填写用户名和密码</span>
        </div>
        <div class="form-group">
            <label class="control-label visible-ie8 visible-ie9">Username</label>
            <input class="form-control form-control-solid placeholder-no-fix" type="text" autocomplete="off"
                   placeholder="请输入用户名" name="username"/>
        </div>

        <div class="form-group">
            <label class="control-label visible-ie8 visible-ie9">Password</label>
            <input class="form-control form-control-solid placeholder-no-fix" type="password" autocomplete="off"
                   placeholder="请输入密码" name="password"/>
        </div>

        <div class="form-group">
            <input type="text" class="form-control" placeholder="请输入验证码" name="code"/>
        </div>

        <div class="form-group">
            <div class="controls" style='margin-left: 27px;'>
                <div>
                    <img id="verify" width="150" height="25" src="<%=request.getContextPath()%>/login/getVerifyCode"/>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="javascript:;" name="refresh">看不清?</a>
                </div>

            </div>
        </div>

        <div class="form-actions">
            <button type="submit" class="btn green uppercase">登录</button>
            <label class="rememberme check mt-checkbox mt-checkbox-outline">
                <input type="checkbox" name="remember" value="1"/>Remember
                <span></span>
            </label>
            <a href="javascript:;" id="forget-password" class="forget-password">Forgot Password?</a>
        </div>
    </form>
    <div style="color: red">
        ${error}
    </div>

</div>
<div class="copyright"> 2016 © Metronic. Admin Dashboard Template.</div>

<script src="<%=request.getContextPath()%>/assets/global/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/assets/global/jquery-validation/js/additional-methods.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/assets/pages/scripts/login.min.js" type="text/javascript"></script>
<script>
    jQuery(document).ready(function () {
        //验证码刷新
        $('a[name="refresh"]').click(function () {
            $('#verify').prop('src', $('#verify').prop('src') + '?');
        });

    })
</script>
</body>