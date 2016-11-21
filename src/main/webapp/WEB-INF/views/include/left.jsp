<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<div class="page-sidebar-wrapper page-sidebar nav-collapse collapse">
    <ul class="page-slide-menu page-header-fixed" style="padding-top: 20px">

        <shiro:hasPermission name="/admin"><li class="nav-item menu_parent">
            <a href="javascript:;"><i class="icon-reorder"></i><span class="title"> 系统管理</span></a>
            <ul class="sub">
                <shiro:hasPermission name="/admin/user/list"><li class="active">
                    <a class="menu_child" href="<%=request.getContextPath()%>/admin/user/list">用户列表</a>
                </li></shiro:hasPermission>
                <shiro:hasPermission name="/business/product/pub"><li>
                    <a class="menu_child" href="<%=request.getContextPath()%>/admin/user/create">新增用户</a>
                </li></shiro:hasPermission>
            </ul>
        </li></shiro:hasPermission>

        <shiro:hasPermission name="/system"><li class="nav-item menu_parent">
            <a href="javascript:;"><i class="icon-wrench"></i><span class="title"></span> 系统工具</a>
            <ul class="sub">
                <shiro:hasPermission name="/system/monitoring"><li >
                    <a class="menu_child" href="<%=request.getContextPath()%>/system/monitoring"> 性能监控</a>
                </li></shiro:hasPermission>
            </ul>
        </li></shiro:hasPermission>
    </ul>

</div>

<script>
    $(function(){
        $(".menu_child").click(function(){
            $('.menu_parent').removeClass('active');
            $(this).closest("li.menu_parent").addClass("active");

        })
    })
</script>