<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>sshe</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <link href="<%=request.getContextPath()%>/static/images/favicon.ico" rel="shortcut icon" type="image/x-icon" media="screen"/>
    <link href="<%=request.getContextPath()%>/static/images/favicon.ico" rel="bookmark" type="image/x-icon" media="screen"/>

    <!-- BEGIN GLOBAL MANDATORY STYLES -->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/global/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/global/simple-line-icons/simple-line-icons.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/global/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/global/bootstrap-switch/css/bootstrap-switch.min.css" >
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/global/bootstrap-select/css/bootstrap-select.min.css" >

    <!-- BEGIN THEME GLOBAL STYLES -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/global/css/components.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/global/css/plugins.min.css"  />

    <!-- BEGIN THEME LAYOUT STYLES -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/global/layouts/layout/css/layout.min.css"  />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/global/layouts/layout/css/themes/default.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/global/layouts/layout/css/custom.min.css" />

	<!-- JS-CORE -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/global/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/assets/global/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/assets/global/bootstrap/js/bootstrap-dialog.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/assets/global/js/js.cookie.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/assets/global/jquery-slimscroll/jquery.slimscroll.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/assets/global/jquery/jquery.blockui.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/assets/global/bootstrap-switch/js/bootstrap-switch.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/assets/global/jquery-validation/js/jquery.validate.min.js" ></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/assets/global/jquery-validation/js/additional-methods.min.js" ></script>

    <!-- BEGIN THEME GLOBAL SCRIPTS -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/assets/global/scripts/app.min.js"></script>

    <!-- BEGIN THEME LAYOUT SCRIPTS -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/assets/global/layouts/layout/scripts/layout.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/assets/global/layouts/layout/scripts/demo.min.js"></script>
</head>

<body class="page-container-bg-solid page-header-fixed page-sidebar-closed-hide-logo">