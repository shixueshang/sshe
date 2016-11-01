<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="../../include/header.jsp"/>
<jsp:include page="../../include/left.jsp"/>


<div id="page-wrapper">

    <div class="col-lg-12" style="margin: 20px"></div>

    <form class="form-horizontal" id="user_form" action="<%=request.getContextPath()%>/admin/user/add" method="POST" >

        <div class="form-group">
            <label  class="col-sm-3 control-label">登录名</label>
            <div class="col-sm-3">
                <input type="text" name="loginName" maxlength="40"  class="form-control" value="${user.loginName}" >
            </div>
        </div>

        <div class="form-group">
            <label  class="col-sm-3 control-label">用户名</label>
            <div class="col-sm-3">
                <input type="text" name="displayName" maxlength="40"  class="form-control" value="${user.displayName}" >
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-9">
                <input type="hidden" name="id" value="${user.id}">
                <button type="submit" class="btn btn-primary">确定</button>
            </div>
        </div>

    </form>


</div>

<script>

    $(function(){

        var form = $('#user_form');
        form.validate({
            rules :{
                loginName : {
                    required : true
                },
                displayName : {
                    required : true
                }
            }
        })
    });

</script>


<jsp:include page="../../include/footer.jsp"/>