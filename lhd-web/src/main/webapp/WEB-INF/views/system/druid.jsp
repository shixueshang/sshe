<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../include/header.jsp"/>
<jsp:include page="../include/top.jsp"/>


<div class="page-container">
    <jsp:include page="../include/left.jsp"/>
    <div class="page-content-wrapper">
        <div class="page-content">
            <iframe width="100%" height="800px" frameborder="0"
                    src="<%=request.getContextPath()%>/druid/index.html"></iframe>
        </div>
    </div>
</div>

<jsp:include page="../include/footer.jsp"/>