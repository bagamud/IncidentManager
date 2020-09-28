<%@ page import="ru.kpp.incidentmanager.entity.Incident" %>
<%@ page import="ru.kpp.incidentmanager.entity.Priority" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %>
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
            </div>
            <div class="table-responsive">
                <table class="table table-hover table-active">
                    <thead>
                    <tr onclick="location.href='/dashboard'">
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
                    ${incidentsInService}
                    </tbody>
                </table>
            </div>
        </main>
    </div>
</div>
<jsp:include page="../template/_footer.jsp"/>
</body>
</html>

