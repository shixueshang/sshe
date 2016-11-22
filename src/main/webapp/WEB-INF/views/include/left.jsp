<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<div class="page-sidebar-wrapper">
    <div class="page-sidebar navbar-collapse collapse">
        <ul class="page-sidebar-menu">

            <shiro:hasPermission name="/admin"><li class="nav-item menu_parent">
                <a href="javascript:;" class="nav-link nav-toggle"><i class="icon-settings"></i><span class="title"> 系统管理</span><span class="arrow"></span></a>
                <ul class="sub-menu">
                    <shiro:hasPermission name="/admin/user/list"><li class="nav-item">
                        <a class="nav-link menu_child" href="<%=request.getContextPath()%>/admin/user/list"><span class="title">用户列表</span></a>
                    </li></shiro:hasPermission>
                    <shiro:hasPermission name="/business/product/pub"><li>
                        <a class="nav-link menu_child" href="<%=request.getContextPath()%>/admin/user/create"><span class="title">新增用户</span></a>
                    </li></shiro:hasPermission>
                </ul>
            </li></shiro:hasPermission>

            <shiro:hasPermission name="/system"><li class="nav-item menu_parent">
                <a href="javascript:;" class="nav-link nav-toggle"><i class="icon-wrench"></i><span class="title"></span> 系统工具<span class="arrow"></span></a>
                <ul class="sub-menu">
                    <shiro:hasPermission name="/system/monitoring"><li class="nav-item">
                        <a class="nav-link menu_child" href="<%=request.getContextPath()%>/system/monitoring"><span class="title"> 性能监控</span></a>
                    </li></shiro:hasPermission>
                </ul>
            </li></shiro:hasPermission>
        </ul>

        <%--<script>
            $(function(){
                $(".menu_child").click(function(){
                    $('.menu_parent').removeClass('active');
                    $(this).closest("li.menu_parent").addClass("active");

                })
            })
        </script>--%>
    </div>
</div>

