<%--
  Created by IntelliJ IDEA.
  User: k
  Date: 01.07.2020
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1, shrink-to-fit=no" name="viewport">
    <title>Incident Manager. Incident card</title>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <!-- Favicons -->
    <link href="img/favicons/favicon.ico" rel="icon">
    <%--    <style>--%>
    <%--        .bd-placeholder-img {--%>
    <%--            font-size: 1.125rem;--%>
    <%--            text-anchor: middle;--%>
    <%--            -webkit-user-select: none;--%>
    <%--            -moz-user-select: none;--%>
    <%--            -ms-user-select: none;--%>
    <%--            user-select: none;--%>
    <%--        }--%>

    <%--        @media (min-width: 768px) {--%>
    <%--            .bd-placeholder-img-lg {--%>
    <%--                font-size: 3.5rem;--%>
    <%--            }--%>
    <%--        }--%>
    <%--    </style>--%>
    <!-- Custom styles for this template -->
    <link href="css/form-validation.css" rel="stylesheet">
</head>
<body class="bg-light">
<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
    <img alt="Russian Federation" height="30" src="img/mvd.png" style="margin-left: 10px" width="52"/>
    <a class="navbar-brand nav-link mr-lg-auto" href="#">РОИО ГИБДД</a>
    <div class="navbar-brand nav-link mr-lg-auto" id="current_date_time_block2"></div>
    <ul class="navbar-nav mr-lg-0">
        <li class="nav-item active">
            <a class="navbar-brand">Иванов И.В.</a>
        </li>
        <li class="nav-item">
            <a class="navbar-brand" href="#">
                <svg class="bi bi-power" fill="currentColor" height="1em" viewBox="0 0 16 16" width="1em"
                     xmlns="http://www.w3.org/2000/svg">
                    <path d="M5.578 4.437a5 5 0 1 0 4.922.044l.5-.866a6 6 0 1 1-5.908-.053l.486.875z"
                          fill-rule="evenodd"></path>
                    <path d="M7.5 8V1h1v7h-1z" fill-rule="evenodd"></path>
                </svg>
            </a>
        </li>
    </ul>
</nav>

<div class="py-5 container-fluid">
    <div class="row">
        <nav class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse" id="sidebarMenu">
            <div class="sidebar-sticky pt-3">
                <ul class="py-3 nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" href="#">
                            <svg class="bi bi-grid-1x2-fill" fill="currentColor" height="1em" viewBox="0 0 16 16"
                                 width="1em" xmlns="http://www.w3.org/2000/svg">
                                <path d="M0 1a1 1 0 0 1 1-1h5a1 1 0 0 1 1 1v14a1 1 0 0 1-1 1H1a1 1 0 0 1-1-1V1zm9 0a1 1 0 0 1 1-1h5a1 1 0 0 1 1 1v5a1 1 0 0 1-1 1h-5a1 1 0 0 1-1-1V1zm0 9a1 1 0 0 1 1-1h5a1 1 0 0 1 1 1v5a1 1 0 0 1-1 1h-5a1 1 0 0 1-1-1v-5z"></path>
                            </svg>
                            Панель мониторинга <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="manager.jsp">
                            <svg class="bi bi-bug-fill" fill="currentColor" height="1em" viewBox="0 0 16 16"
                                 width="1em"
                                 xmlns="http://www.w3.org/2000/svg">
                                <path d="M4.978.855a.5.5 0 1 0-.956.29l.41 1.352A4.985 4.985 0 0 0 3 6h10a4.985 4.985 0 0 0-1.432-3.503l.41-1.352a.5.5 0 1 0-.956-.29l-.291.956A4.978 4.978 0 0 0 8 1a4.979 4.979 0 0 0-2.731.811l-.29-.956zM13 6v1H8.5v8.975A5 5 0 0 0 13 11h.5a.5.5 0 0 1 .5.5v.5a.5.5 0 1 0 1 0v-.5a1.5 1.5 0 0 0-1.5-1.5H13V9h1.5a.5.5 0 0 0 0-1H13V7h.5A1.5 1.5 0 0 0 15 5.5V5a.5.5 0 0 0-1 0v.5a.5.5 0 0 1-.5.5H13zm-5.5 9.975V7H3V6h-.5a.5.5 0 0 1-.5-.5V5a.5.5 0 0 0-1 0v.5A1.5 1.5 0 0 0 2.5 7H3v1H1.5a.5.5 0 0 0 0 1H3v1h-.5A1.5 1.5 0 0 0 1 11.5v.5a.5.5 0 1 0 1 0v-.5a.5.5 0 0 1 .5-.5H3a5 5 0 0 0 4.5 4.975z"
                                      fill-rule="evenodd"></path>
                            </svg>
                            Инциденты
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <svg class="bi bi-file-text-fill" fill="currentColor" height="1em" viewBox="0 0 16 16"
                                 width="1em" xmlns="http://www.w3.org/2000/svg">
                                <path d="M12 1H4a2 2 0 0 0-2 2v10a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V3a2 2 0 0 0-2-2zM5 4a.5.5 0 0 0 0 1h6a.5.5 0 0 0 0-1H5zm-.5 2.5A.5.5 0 0 1 5 6h6a.5.5 0 0 1 0 1H5a.5.5 0 0 1-.5-.5zM5 8a.5.5 0 0 0 0 1h6a.5.5 0 0 0 0-1H5zm0 2a.5.5 0 0 0 0 1h3a.5.5 0 0 0 0-1H5z"
                                      fill-rule="evenodd"></path>
                            </svg>
                            Отчеты
                        </a>
                    </li>
                </ul>
            </div>
        </nav>

        <main class="col-md-9 ml-sm-auto col-lg-10 px-md-4" role="main">

            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">Панель мониторинга</h1>
                <div class="btn-toolbar mb-2 mb-md-0">
                    <!--                    <div class="btn-group mr-2">-->
                    <!--                        <button class="btn btn-sm btn-outline-secondary" type="button">Share</button>-->
                    <!--                        <button class="btn btn-sm btn-outline-secondary" type="button">Export</button>-->
                    <!--                    </div>-->
                    <button class="btn btn-sm btn-outline-secondary dropdown-toggle" type="button">
                        <svg class="bi bi-calendar3-fill" fill="currentColor" height="1em" viewBox="0 0 16 16"
                             width="1em" xmlns="http://www.w3.org/2000/svg">
                            <path d="M0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2H0z"></path>
                            <path d="M0 3h16v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3zm6.5 4a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm4-1a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm2 1a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm-8 2a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm2 1a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm4-1a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm2 1a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm-8 2a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm2 1a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm4-1a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"
                                  fill-rule="evenodd"></path>
                        </svg>
                        This week
                    </button>
                </div>
            </div>


            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Подразделение</th>
                        <th>Дата заявки</th>
                        <th>Исполнитель</th>
                        <th>Категория</th>
                        <th>Статус</th>
                    </tr>
                    </thead>
                    <tbody>
                    <jsp:useBean id="dashboardData" class="main.java.jb.DashboardBean">
                        <jsp:getProperty name="dashboardData" property="allIncidentData"/>
                    </jsp:useBean>
                    </tbody>
                </table>
            </div>
        </main>
    </div>
</div>
<script src="./js/currentDateTime.js"></script>
</body>
</html>

