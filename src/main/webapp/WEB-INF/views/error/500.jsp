<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<jsp:include page="../include/header.jsp"/>
<jsp:include page="../include/top.jsp"/>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/pages/css/error.min.css" />


<div class="page-container">
    <jsp:include page="../include/left.jsp"/>
    <div class="page-content-wrapper">
        <div class="page-content">
            <div class="row">
                <div class="col-md-12 page-500">
                    <div class="number font-red">500</div>
                    <div class="details">
                        <h3>Oops! Something went wrong.</h3>
                    </div>
                    <div class="col-md-12">
                        <div class="portlet box green">
                            <div class="portlet-title">
                                <div class="caption"><i class="fa fa-comments">错误信息</i></div>
                            </div>
                            <div class="portlet-body font-lg font-red">
                                ${message}
                            </div>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="portlet box green">
                            <div class="portlet-title">
                                <div class="caption"><i class="fa fa-comments">原因</i></div>
                            </div>
                            <div class="portlet-body font-lg font-red">
                                ${cause}
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../include/footer.jsp"/>