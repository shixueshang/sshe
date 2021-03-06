<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<%
    String uri = (String) request.getAttribute("uri");
%>


<div class="page-sidebar-wrapper">
    <div class="page-sidebar navbar-collapse collapse">
        <ul class="page-sidebar-menu">

            <shiro:hasPermission name="/admin"><li class="nav-item">
                <a href="javascript:;" class="nav-link nav-toggle"><i class="icon-settings"></i><span class="title"> 系统管理</span><span class="arrow"></span></a>
                <ul class="sub-menu">
                    <shiro:hasPermission name="/admin/user/list"><li class="nav-item">
                        <a class="nav-link" href="<%=request.getContextPath()%>/admin/user/list"><span class="title">用户列表</span></a>
                    </li></shiro:hasPermission>
                    <shiro:hasPermission name="/admin/user/create"><li>
                        <a class="nav-link" href="<%=request.getContextPath()%>/admin/user/create"><span class="title">新增用户</span></a>
                    </li></shiro:hasPermission>
                    <shiro:hasPermission name="/admin/role/list"><li class="nav-item">
                        <a class="nav-link" href="<%=request.getContextPath()%>/admin/role/list"><span class="title">角色列表</span></a>
                    </li></shiro:hasPermission>
                    <shiro:hasPermission name="/admin/role/create"><li>
                        <a class="nav-link" href="<%=request.getContextPath()%>/admin/role/create"><span class="title">新增角色</span></a>
                    </li></shiro:hasPermission>
                </ul>
            </li></shiro:hasPermission>

            <shiro:hasPermission name="/system"><li class="nav-item">
                <a href="javascript:;" class="nav-link nav-toggle"><i class="icon-wrench"></i><span class="title"></span> 系统工具<span class="arrow"></span></a>
                <ul class="sub-menu">
                    <shiro:hasPermission name="/system/monitoring"><li class="nav-item">
                        <a class="nav-link" href="<%=request.getContextPath()%>/system/monitoring"><span class="title"> 性能监控</span></a>
                    </li></shiro:hasPermission>
                </ul>
            </li></shiro:hasPermission>
        </ul>

    </div>
</div>


<script>

    var url = '${uri}';
    var obj = $('a[href*="'+url+'"]');
    $.each(obj, function(i, v){
        var _this = $(v), _parent = _this.closest('ul'), _p_parent = _parent.closest('li');
        _p_parent.addClass('active').addClass('open');
        _this.closest('li').addClass('active').addClass('open');
        _parent.prev('a').find('span').addClass('open');
        _parent.show();

        return false;
    });

</script>

