<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<style >
    .dropdown-toggle:hover{
        background-color: rgb(67,142,185) !important;
    }
    .dropdown-toggle{
        background-color: rgb(67,142,185) !important;
    }
    #side-menu a:hover{
        color: rgb(67,142,185);
    }
    #side-menu a{
        color: black;
    }
</style>

    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0;background-color: rgb(67,142,185)">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/"></a>
        </div>

        <ul class="nav navbar-top-links navbar-right">

            <li class="dropdown ">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#" style="height: 42px;">
                    <img alt=""  src="<%=request.getContextPath()%>/static/images/user.jpg" style="margin-top: -8px"/>
                    <span style=" color: white"><shiro:principal property="displayName"></shiro:principal></span>
                    <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="<%=request.getContextPath()%>/logout"><i class="fa fa-power-off fa-fw"></i> 退出</a>
                    </li>
                    <li><a href="<%=request.getContextPath()%>/password/modify"><i class="fa fa-key fa-fw"></i> 修改密码</a>
                    </li>
                </ul>
            </li>
        </ul>

        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">

                    <shiro:hasPermission name="/admin"><li class="menu_parent">
                        <a  href="#"><i class="fa fa-th-list fa-wrench"></i> 系统管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <shiro:hasPermission name="/admin/user/list"><li >
                                <a class="menu_child" href="<%=request.getContextPath()%>/admin/user/list"> 用户列表</a>
                            </li></shiro:hasPermission>
                            <shiro:hasPermission name="/admin"><li >
                                <a class="menu_child" href="<%=request.getContextPath()%>/admin/user/create"> 用户添加</a>
                            </li></shiro:hasPermission>
                        </ul>
                    </li></shiro:hasPermission>

                    <shiro:hasPermission name="/system"><li class="menu_parent">
                        <a href="#"><i class="fa fa-th-list fa-fw"></i> 系统工具<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <shiro:hasPermission name="/system/monitoring"><li >
                                <a href="<%=request.getContextPath()%>/system/monitoring"> 性能监控</a>
                            </li></shiro:hasPermission>
                        </ul>
                    </li></shiro:hasPermission>
                </ul>
            </div>
        </div>
    </nav>

<script>
    $(function(){
        $(".menu_child").click(function(){
            $('.menu_parent').removeClass('active');
            $(this).closest("li.menu_parent").addClass("active");

        })
    })
</script>