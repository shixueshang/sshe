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
                <div class="col-md-12 page-404">
                    <div class="number font-green">404</div>
                    <div class="details">
                        <h3>Oops! You're lost.</h3>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../include/footer.jsp"/>