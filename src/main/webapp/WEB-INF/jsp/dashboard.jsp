<%@ page import="ru.kpp.incidentmanager.entity.Users" %>
<%@ page import="java.util.List" %>
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
            </div>
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr onclick=" location.href='/dashboard'">
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
<%
    List<Users> users = (List<Users>) request.getAttribute("user");
    if (users != null) {
        for (Users user : users) {
            if (user.getUsername().equals(request.getUserPrincipal().getName()))
                out.print("<input type=\"text\" id=\"userId\" value=\"" + user.getId() + "\" hidden/>\n" +
                        "<input type=\"text\" id=\"userName\" value=\"" + user.getName() + "\" hidden/>");
        }
    }
%>
<script>
    const userId = document.getElementById('userId').value;
    const userName = document.getElementById('userName').value;
    document.getElementById('principal').innerText = userName;
</script>
<jsp:include page="../template/_footer.jsp"/>
</body>
</html>

