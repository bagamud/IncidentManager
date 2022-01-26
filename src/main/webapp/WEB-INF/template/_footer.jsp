<%--<script src="${pageContext.request.contextPath}/webjars/jquery/3.5.1/jquery.slim.min.js"></script>--%>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<%--<script src="${pageContext.request.contextPath}/webjars/popper.js/1.16.0/popper.min.js"></script>--%>
<%--<script> alert("ALERT!!! Use Mozilla Firefox or Google Chrome")</script>--%>
<script>
    if ('${errors}' !== '' && '${errors}' !== '[]') {
        alert('${errors}');
    }
</script>