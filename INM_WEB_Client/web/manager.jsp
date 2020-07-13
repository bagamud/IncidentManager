<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1, shrink-to-fit=no" name="viewport">
    <meta content="" name="description">
    <title>Incident Manager. Incident card</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Favicons -->
    <link href="img/favicons/favicon.ico" rel="icon">

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
    <!-- Custom styles for this template -->
    <link href="css/form-validation.css" rel="stylesheet">
</head>
<body class="bg-light">
<jsp:useBean id="voc" class="main.java.entity.Vocabulary">
    <nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
        <img alt="Russian Federation" height="30" src="img/mvd.png" width="52"/>
        <a class="navbar-brand nav-link mr-lg-0" href="#">РОИО ГИБДД</a><nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
        <img style="margin-left: 10px" alt="Russian Federation" height="30" src="img/mvd.png" width="52"/>
        <a class="navbar-brand nav-link mr-lg-auto" href="#">РОИО ГИБДД</a>
        <div class="navbar-brand nav-link mr-lg-auto" id="current_date_time_block2"></div>

        <ul class="navbar-nav mr-lg-0">
            <li class="nav-item active">
                <a class="navbar-brand">Иванов И.В.</a>
            </li>

        <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="manager.html">Инцидент</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="dashboard.html">Мониторинг</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Выход</a>
                </li>
            </ul>
        </div>
        <div class="navbar-brand nav-link mr-lg-0" id="current_date_time_block2">
        </div>

    </nav>

    <div class="container">
        <div class="py-5 text-center">

        </div>

        <div class="row">
            <div class="col-md-4 order-md-2 mb-4">
                <h4 class="d-flex justify-content-between align-items-center mb-3">
                    <span class="text-muted">База знаний</span>
                    <span class="badge badge-secondary badge-pill">3</span>
                </h4>
                <form class="card p-2">
                    <p><b>АИУС</b> - автоматизировансПорядок действий должен быть максимально удобен, вопросы должны
                        быть
                        конкретными, а советы точными.
                        От качества опроса пользователя об инциденте, зависит скорость решения</p>

                </form>
            </div>
            <div class="col-md-8 order-md-1">
                <h4 class="mb-3">Инцидент</h4>
                <form class="needs-validation" novalidate>
                    <div class="row">
                        <div class="col-md-4 mb-3">
                            <label for="incidentNumber">Номер</label>
                            <input class="form-control" id="incidentNumber" placeholder="" required type="search"
                                   value="">
                        </div>

                        <div class="col-md-4 mb-3">
                            <label for="date">Дата открытия заявки</label>
                            <input class="form-control" disabled id="date" type="text">
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="operator">Оператор</label>
                            <select class="form-control custom-select d-block w-100 form-control" id="operator" required
                                    type="text">
                                <option value="">...</option>
                                <jsp:getProperty name="voc" property="users"/>
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
                            <select class="form-control custom-select d-block w-100" id="department" required>
                                <option value="">...</option>
                                <jsp:getProperty name="voc" property="departments"/>
                            </select>
                            <div class="invalid-feedback">
                                Пожалуйста выберите подразделение
                            </div>

                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="category">Категория инцидента</label>
                            <select class="form-control custom-select d-block w-100" id="category" required>
                                <option value="">...</option>
                                <jsp:getProperty name="voc" property="categories"/>
                            </select>
                            <div class="invalid-feedback">
                                Пожалуйста выберите подразделение
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="requester">Пользователь</label>
                            <input class="form-control" id="requester" placeholder="" required type="text" value="">
                            <div class="invalid-feedback">
                                Неккоректное имя пользователя
                            </div>
                        </div>

                        <div class="col-md-6 mb-3">
                            <label for="requesterContacts">Контакты</label>
                            <input class="form-control" id="requesterContacts" placeholder="" required type="tel">
                            <div class="invalid-feedback" style="width: 100%;">
                                Введите контакты пользователя
                            </div>
                        </div>
                    </div>
                    <div class="row">

                        <div class="col-md-6 mb-3">
                            <label for="ip">IP-адрес</label>
                            <input class="form-control" id="ip" placeholder="0.0.0.0" type="text">
                            <div class="invalid-feedback">
                                Введите корректный IP-адрес компьютера пользователя
                            </div>
                        </div>

                        <div class="col-md-6 mb-3">
                            <label for="duration">Продолжительность инцидента</label>
                            <input class="form-control" id="duration" placeholder="" required type="text">
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="description">Описание</label>
                        <textarea class="form-control" id="description" required></textarea>
                    </div>

                    <div class="row">
                        <div class="col-md-4 mb-3">
                            <label for="influence">Влияние</label>
                            <select class="form-control custom-select d-block w-100" id="influence" required>
                                <option value="1">Высокое</option>
                                <option value="2">Среднее</option>
                                <option value="3">Низкое</option>
                            </select>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="urgency">Срочность</label>
                            <select class="form-control custom-select d-block w-100" id="urgency" required>
                                <option value="1">Высокая</option>
                                <option value="2">Средняя</option>
                                <option value="3">Низкая</option>
                            </select>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="priority">Приоритет</label>
                            <input class="form-control" disabled id="priority" placeholder="" required type="text">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4 mb-3">
                            <label for="status">Статус</label>
                            <select class="form-control custom-select d-block w-100" id="status" required type="text">
                                <option value="" disabled>...</option>
                                    <%--                                <jsp:getProperty name="voc" property=""/>--%>
                            </select>
                        </div>

                        <div class="col-md-4 mb-3">
                            <label for="engineer">Инженер</label>
                            <select class="form-control custom-select d-block w-100" id="engineer" required type="text">
                                <option value="">...</option>
                                <jsp:getProperty name="voc" property="users"/>
                            </select>
                            <div class="invalid-feedback">
                                Неккоректное имя пользователя
                            </div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="close_date">Дата закрытия заявки</label>
                            <input class="form-control" id="close_date" type="date">
                        </div>
                    </div>
                    <hr class="mb-4">

                    <button class=" btn btn-primary btn-lg" type="submit">Сохранить</button>
                    <button class=" btn btn-primary btn-lg" type="reset">Очистить</button>


                </form>
                <form action="manager" method="get">
                    <div class="col-md-4 mb-3">
                        <label for="id">Номер</label>
                        <input class="form-control" id="id" placeholder="" required type="search" name="id" value="">
                    </div>
                    <button class="btn btn-primary btn-lg" type="submit"></button>
                </form>
                    <%--            </form>--%>
                    <%--            <form action="manager" method="get"><div class="col-md-4 mb-3">--%>
                    <%--        </div><input class="btn btn-primary btn-lg" type="submit"></form>--%>
                    <%--            <%--%>
                    <%--                out.print(request.getAttribute("msg"));--%>
                    <%--            %>--%>
            </div>
        </div>
        <hr>
        <footer class="text-muted text-center text-small">
            <p>Региональный отдел информационного обеспечения ГИБДД</p>
            <p class="mb-1">&copy; 2020-2020 </p>
        </footer>
    </div>
</jsp:useBean>
</body>
<script src="./js/currentDateTime.js"></script>
</html>
