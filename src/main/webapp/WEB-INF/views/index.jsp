<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="include/header.jsp"/>

<div class="container">
    <div class="row" style="margin-top: 2%">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">请登录</h3>
                </div>
                <div class="panel-body">
                    <form role="form" action="<%=request.getContextPath()%>/login" method="post">
                        <fieldset>

                            <div class="form-group">
                                <input type="text"  class="form-control" placeholder="请输入用户名" name="username" autofocus>
                            </div>

                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="请输入密码" name="password"  />
                            </div>

                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="请输入验证码" name="code" />
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

                            <button type="submit" class="btn btn-lg btn-success btn-block">登录</button>
                        </fieldset>
                    </form>
                    <div style="color: red">
                        ${error}
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>

    jQuery(document).ready(function () {
        //验证码刷新
        $('a[name="refresh"]').click(function(){
            $('#verify').prop('src', $('#verify').prop('src') + '?');
        });

    })
</script>
