<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../include/header.jsp"/>
<jsp:include page="../include/left.jsp"/>


<div id="page-wrapper" >
    <iframe width="100%" height="100%" frameborder="0" src="<%=request.getContextPath()%>/druid/index.html"></iframe>
</div>

<jsp:include page="../include/footer.jsp"/>