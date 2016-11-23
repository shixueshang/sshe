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
                <li><a href="javascript:;">系统管理</a><i class="fa fa-angle-right"></i></li>
                <li><span class="active">角色列表</span></li>
            </ul>
            <div class="row">
                <div class="col-md-12">
                    <div class="portlet box green">
                        <div class="portlet-title">
                            <h4><i class="fa fa-comments"></i></h4>
                        </div>
                        <div class="portlet-body">
                            <table class="table table-bordered table-hover">
                                <thead>
                                <tr role="row">
                                    <th>角色代码</th>
                                    <th>角色名称</th>
                                    <th>描述</th>
                                    <th>状态</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${roles}" var="role">
                                    <tr>
                                        <td >${role.roleCode}</td>
                                        <td >${role.roleName}</td>
                                        <td>${role.description}</td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${role.valid == true}">
                                                    <label class="label label-success">正常</label>
                                                </c:when>
                                                <c:when test="${role.valid == false}">
                                                    <label class="label label-danger">禁用</label>
                                                </c:when>
                                            </c:choose>
                                        </td>
                                        <td>

                                            <a href="<%=request.getContextPath()%>/role/detail/${role.id}" class="btn green"><span class="glyphicon glyphicon-edit"></span>编辑</a>
                                            <a href="<%=request.getContextPath()%>/role/delete/${role.id}" class="btn green"><span class="glyphicon glyphicon-trash"></span>删除</a>

                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>



<jsp:include page="../../include/footer.jsp"/>