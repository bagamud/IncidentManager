<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
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
<jsp:useBean id="voc" class="main.java.jb.Vocabulary">
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
        <div class="py-3 row">
            <nav class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse" id="sidebarMenu">
                <div class="sidebar-sticky pt-3">
                    <ul class="py-3 nav flex-column">
                        <li class="nav-item">
                            <a class="nav-link" href="dashboard.jsp">
                                <svg class="bi bi-grid-1x2-fill" fill="currentColor" height="1em" viewBox="0 0 16 16"
                                     width="1em" xmlns="http://www.w3.org/2000/svg">
                                    <path d="M0 1a1 1 0 0 1 1-1h5a1 1 0 0 1 1 1v14a1 1 0 0 1-1 1H1a1 1 0 0 1-1-1V1zm9 0a1 1 0 0 1 1-1h5a1 1 0 0 1 1 1v5a1 1 0 0 1-1 1h-5a1 1 0 0 1-1-1V1zm0 9a1 1 0 0 1 1-1h5a1 1 0 0 1 1 1v5a1 1 0 0 1-1 1h-5a1 1 0 0 1-1-1v-5z"></path>
                                </svg>
                                Панель мониторинга <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="#">
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
                    <h1 class="h2">Инцидент</h1>
                </div>
                <div class="row">
                    <div class="col-md-5 order-md-2 mb-4">
                        <h4 class="d-flex justify-content-between align-items-center mb-3">
                            <span class="text-muted">База знаний</span>
                            <span class="badge badge-secondary badge-pill">3</span>
                        </h4>
                        <form class="card p-3"
                              style="text-align: justify; text-indent: 1.3cm; margin-bottom: 0; line-height: 100%; background: transparent">
                            <p>Порядок действий должен быть максимально
                                удобен, вопросы
                                должны быть конкретными, а советы точными. От качества опроса пользователя об инциденте,
                                зависит скорость решения</p>
                            <p style="text-align: center">&diam;&diam;&diam;</p>
                            Сама концепция упорядочивания хаоса должна походить на принцип создания корабликов в бутылке
                            — засыпаешь детальки, заливаешь клей, трясешь, и иногда получается кораблик.
                            <p style="text-align: center">&diam;&diam;&diam;</p>
                            <p>Самурай без меча, подобен самураю с мечем, но без меча.</p>
                        </form>
                    </div>
                    <div class="col-md-7 order-md-1">
                        <form class="needs-validation" action="manager" method="post" novalidate>
                            <div class="row">
                                <div class="col-md-4 mb-3">
                                    <label for="incidentNumber">Номер</label>
                                    <input class="form-control" id="incidentNumber" placeholder="" required
                                           type="search"
                                           value="">
                                </div>
                                <div class="col-md-4 mb-3">
                                    <label for="date">Дата открытия заявки</label>
                                    <input class="form-control" disabled id="date" type="text" name="date">
                                </div>
                                <div class="col-md-4 mb-3">
                                    <label for="operator">Оператор</label>
                                    <select class="form-control custom-select d-block w-100 form-control" id="operator"
                                            required
                                            type="text" name="operator">
                                        <option value="">...</option>
                                        <jsp:getProperty name="voc" property="userSelect"/>
                                    </select>
                                    <div class="invalid-feedback">
                                        Неккоректное имя пользователя
                                    </div>
                                </div>
                                <hr>
                            </div>
                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label for="department">Подразделение</label>
                                    <select class="form-control custom-select d-block w-100" id="department"
                                            name="department" required>
                                        <option value="">...</option>
                                        <jsp:getProperty name="voc" property="departmentSelect"/>
                                    </select>
                                    <div class="invalid-feedback">
                                        Пожалуйста выберите подразделение
                                    </div>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label for="category">Категория инцидента</label>
                                    <select class="form-control custom-select d-block w-100" id="category"
                                            name="category" required>
                                        <option value="">...</option>
                                        <jsp:getProperty name="voc" property="categorySelect"/>
                                    </select>
                                    <div class="invalid-feedback">
                                        Пожалуйста выберите подразделение
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label for="requester">Пользователь</label>
                                    <input class="form-control" id="requester" name="requester" placeholder="" required
                                           type="text"
                                           value="">
                                    <div class="invalid-feedback">
                                        Неккоректное имя пользователя
                                    </div>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label for="requesterContacts">Контакты</label>
                                    <input class="form-control" id="requesterContacts" name="requesterContacts"
                                           placeholder="" required
                                           type="tel">
                                    <div class="invalid-feedback" style="width: 100%;">
                                        Введите контакты пользователя
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label for="ip">IP-адрес</label>
                                    <input class="form-control" id="ip" name="ip" placeholder="0.0.0.0" type="text">
                                    <div class="invalid-feedback">
                                        Введите корректный IP-адрес компьютера пользователя
                                    </div>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label for="duration">Продолжительность инцидента</label>
                                    <input class="form-control" id="duration" name="duration" placeholder="" required
                                           type="text">
                                </div>
                            </div>
                            <div class="mb-3">
                                <label for="description">Описание</label>
                                <textarea class="form-control" id="description" name="description" required></textarea>
                            </div>
                            <div class="row">
                                <div class="col-md-4 mb-3">
                                    <label for="influence">Влияние</label>
                                    <select class="form-control custom-select d-block w-100" id="influence"
                                            name="influence" required>
                                        <option value="1">Высокое</option>
                                        <option value="2">Среднее</option>
                                        <option value="3">Низкое</option>
                                    </select>
                                </div>
                                <div class="col-md-4 mb-3">
                                    <label for="urgency">Срочность</label>
                                    <select class="form-control custom-select d-block w-100" id="urgency" name="urgency"
                                            required>
                                        <option value="1">Высокая</option>
                                        <option value="2">Средняя</option>
                                        <option value="3">Низкая</option>
                                    </select>
                                </div>
                                <div class="col-md-4 mb-3">
                                    <label for="priority">Приоритет</label>
                                    <input class="form-control" disabled id="priority" name="priority" placeholder=""
                                           required
                                           type="text">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4 mb-3">
                                    <label for="status">Статус</label>
                                    <select class="form-control custom-select d-block w-100" id="status" name="status"
                                            required
                                            type="text">
                                        <option value="">...</option>
                                        <jsp:getProperty name="voc" property="statusSelect"/>
                                    </select>
                                </div>
                                <div class="col-md-4 mb-3">
                                    <label for="engineer">Инженер</label>
                                    <select class="form-control custom-select d-block w-100" id="engineer"
                                            name="engineer" required
                                            type="text">
                                        <option value="">...</option>
                                        <jsp:getProperty name="voc" property="userSelect"/>
                                    </select>
                                    <div class="invalid-feedback">
                                        Неккоректное имя пользователя
                                    </div>
                                </div>
                                <div class="col-md-4 mb-3">
                                    <label for="close_date">Дата закрытия заявки</label>
                                    <input class="form-control" id="close_date" name="close_date" type="date">
                                </div>
                            </div>
                            <hr class="mb-4">
                            <button class="btn btn-primary btn-lg" type="submit" formmethod="post">Сохранить</button>
                            <button class="btn btn-primary btn-lg" type="reset">Очистить</button>
                            <button class="btn btn-primary btn-lg" type="submit" formmethod="get">Поиск</button>
                        </form>
                    </div>
                </div>
            </main>
        </div>
    </div>
</jsp:useBean>
</body>
<script src="./js/currentDateTime.js"></script>
</html>
