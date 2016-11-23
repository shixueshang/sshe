<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="../../include/header.jsp"/>
<jsp:include page="../../include/top.jsp"/>

<div class="page-container">
    <jsp:include page="../../include/left.jsp"/>
    <div class="page-content-wrapper">
        <div class="page-content">
            <ul class="page-breadcrumb breadcrumb">
                <li><span class="font-dark">系统管理</span><i class="fa fa-angle-right font-dark"></i></li>
                <li><span class="font-dark">新增角色</span></li>
            </ul>
            <div class="row">
                <div class="col-md-12">
                    <div class="portlet box green">
                        <div class="portlet-title">
                            <h4><i class="fa fa-comments"></i></h4>
                        </div>
                        <div class="portlet-body form">
                            <form class="form-horizontal" role="form" id="user_form" action="<%=request.getContextPath()%>/admin/role/save" method="POST" >
                                <div class="form-body">
                                    <div class="alert alert-danger display-hide">
                                        <button class="close" data-close="alert"></button>
                                        您的表单有未完成的必填项,请检查.
                                    </div>
                                    <div class="alert alert-success display-hide">
                                        <button class="close" data-dismiss="alert"></button>
                                        表单内容验证成功!
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-md-3 control-label">角色代码<span class="required" aria-required="true">*</span></label>
                                        <div class="col-md-3">
                                            <input type="text" name="roleCode" data-required="1" maxlength="40"  class="form-control" value="${role.roleCode}" >
                                            <span class="help-inline"></span>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label  class="col-md-3 control-label">角色名称</label>
                                        <div class="col-md-3">
                                            <input type="text" name="roleName" maxlength="40"  class="form-control" value="${role.roleName}" >
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label  class="col-md-3 control-label">描述</label>
                                        <div class="col-md-3">
                                            <textarea name="description" maxlength="200"  class="form-control">${role.description}</textarea>
                                        </div>
                                    </div>

                                </div>

                                <div class="form-actions">
                                    <div class="row">
                                        <div class="col-md-offset-3 col-md-9">
                                            <input type="hidden" name="id" value="${role.id}">
                                            <button type="submit" class="btn green">确定</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $(function(){
        var user_form = $('#user_form');
        var error = $('.alert-danger', user_form);
        var success = $('.alert-success', user_form);

        user_form.validate({
            errorElement: 'span',
            errorClass: 'help-inline',
            focusInvalid: false,
            ignore: "",
            messages: {
                loginName:{required:"登录名不能为空！"}
            },
            rules :{
                loginName : {
                    required : true
                },
                displayName : {
                    required : true
                }
            },
            invalidHandler: function (event, validator) {
                success.hide();
                error.show();
                App.scrollTo(error, -200);
            },
            highlight: function (element) {
                $(element).closest('.help-inline').removeClass('ok');
                $(element).closest('.form-group').removeClass('success').addClass('has-error');
            },
            unhighlight: function (element) {
                $(element).closest('.form-group').removeClass('has-error');
            },
            success: function (label) {
                label.addClass('valid').addClass('help-inline ok').closest('.form-group').removeClass('has-error').addClass('success');
            },
            submitHandler: function (form) {
                success.show();
                error.hide();
                form.submit();
            }
        });
    });
</script>
<jsp:include page="../../include/footer.jsp"/>