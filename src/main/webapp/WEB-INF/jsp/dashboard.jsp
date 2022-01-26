<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

    <jsp:include page="../template/_metaStyle.jsp"/>
    <title>Incident Manager</title>
</head>
<body class="bg-light">

<jsp:include page="../template/_menu.jsp"/>

<div class="container-fluid">
    <div class="py-3 row">
        <main class="col-md-9 m-auto px-md-4" role="main">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">Панель мониторинга</h1>
                <input class="btn btn-primary" type="button" name="switchFilter" id="filterAll" value="In service/All"
                       onclick="location.href='${pageContext.request.contextPath}/dashboard?status=${switchfilter}'">
            </div>
            <div class="table-responsive">
                <table class="table table-hover text-center">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Подразделение</th>
                        <th>Дата заявки</th>
                        <th>Исполнитель</th>
                        <th>Приоритет</th>
                        <th>Категория</th>
                        <th>Статус</th>
                    </tr>
                    </thead>
                    <tbody>
                    <core:forEach items="${incidents}" var="incident">
                        <tr onclick="location.href='${pageContext.request.contextPath}/manager/get?id=${incident.id}'" cl>
                            <td>${incident.id}</td>
                            <td>${incident.requesterdepartment.shortTitle}</td>
                            <td>${incident.opendate}</td>
                            <td>${incident.engineer.name}</td>
                            <td>${incident.priority.description}</td>
                            <td>${incident.category.title}</td>
                            <td>${incident.status.title}</td>
                        </tr>
                    </core:forEach>
                    </tbody>
                </table>
            </div>
        </main>
    </div>
</div>
<jsp:include page="../template/_footer.jsp"/>
</body>
</html>
