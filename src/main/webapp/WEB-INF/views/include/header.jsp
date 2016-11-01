<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String contextPath = request.getContextPath();
%>

<html>
<head>
	<meta charset="utf-8">
	<title>sshe</title>
    <link href="<%=request.getContextPath()%>/static/images/favicon.ico" rel="shortcut icon" type="image/x-icon" media="screen"/>
    <link href="<%=request.getContextPath()%>/static/images/favicon.ico" rel="bookmark" type="image/x-icon" media="screen"/>

    <!-- css -->
	<link rel="stylesheet" href="<%=contextPath%>/static/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="<%=contextPath%>/static/css/bootstrap/bootstrap-fileupload.css">
    <link rel="stylesheet" href="<%=contextPath%>/static/css/smart/timeline.css" rel="stylesheet">
    <link rel="stylesheet" href="<%=contextPath%>/static/css/smart/sb-admin-2.css" rel="stylesheet">
	<link rel="stylesheet" href="<%=contextPath%>/static/css/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=contextPath%>/static/css/jqueryui/jquery-ui-1.9.2.custom.css" />
	<link rel="stylesheet" href="<%=contextPath%>/static/js/metisMenu/dist/metisMenu.min.css" >

	<!-- js-core -->
	<script src="<%=contextPath%>/static/js/jquery/jquery-2.1.1.min.js"></script>
    <script src="<%=contextPath%>/static/js/jqueryui/jquery-ui-1.9.2.custom.min.js"></script>
    <script src="<%=contextPath%>/static/js/jquery/jquery.form.js"></script>
	<script src="<%=contextPath%>/static/js/bootstrap/bootstrap.min.js"></script>
    <script src="<%=contextPath%>/static/js/bootstrap/bootstrap-fileupload.js"></script>
    <script src="<%=contextPath%>/static/js/bootstrap/bootstrap-dialog.js"></script>
    <script src="<%=contextPath%>/static/js/jquery/jquery.validate.min.js"></script>
    <script src="<%=contextPath%>/static/js/jquery/jquery.validate.messages_zh.js"></script>

	<script src="<%=contextPath%>/static/js/metisMenu/dist/metisMenu.min.js"></script>
    <script src="<%=contextPath%>/static/js/smart/sb-admin-2.js"></script>
</head>