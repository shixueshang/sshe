<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<div class="page-header navbar navbar-fixed-top">
    <div class="page-header-inner ">
        <div class="page-logo">
            <a href="index.html">
                <img src="<%=request.getContextPath()%>/assets/global/layouts/layout/img/logo.png" alt="logo" class="logo-default" /> </a>
            <div class="menu-toggler sidebar-toggler">
                <span></span>
            </div>
        </div>
        <a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse">
            <span></span>
        </a>
        <div class="top-menu">
            <ul class="nav navbar-nav pull-right">
                <li class="dropdown dropdown-user">
                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                        <img alt="" class="img-circle" src="<%=request.getContextPath()%>/assets/global/layouts/layout/img/avatar3_small.jpg" />
                        <span class="username username-hide-on-mobile"><shiro:principal property="displayName"></shiro:principal> </span>
                        <i class="fa fa-angle-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-default">
                        <li>
                            <a href="<%=request.getContextPath()%>/password/modify">
                                <i class="icon-user"></i> 修改密码</a>
                        </li>
                        <li>
                            <a href="<%=request.getContextPath()%>/logout">
                                <i class="icon-key"></i> 退出</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>