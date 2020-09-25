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
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Подразделение</th>
                        <th>Дата заявки</th>
                        <th>Исполнитель</th>
                        <th>Приоритет</th>
                        <th>Категория</th>
                        <th>Статус</th>
                        <th>
                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-arrow-right"
                                 fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd"
                                      d="M1 8a.5.5 0 0 1 .5-.5h11.793l-3.147-3.146a.5.5 0 0 1 .708-.708l4 4a.5.5 0 0 1 0 .708l-4 4a.5.5 0 0 1-.708-.708L13.293 8.5H1.5A.5.5 0 0 1 1 8z"></path>
                            </svg>
                        </th>
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

