<%@ page contentType="text/html;charset=UTF-8" %>
<%--<%@ page session="true" %>--%>
<html lang="ru">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <title>Incident Manager</title>

    <link rel="icon" href="img/favicons/favicon.ico">

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

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
<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
    <img src="img/mvd.png" height="30" width="52" alt="Russian Federation"/>
    <a class="navbar-brand nav-link mr-lg-0" href="#">РОИО ГИБДД</a>
    <button class="navbar-toggler p-0 border-0" type="button" data-toggle="offcanvas">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Инциденты</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Отчеты</a>
            </li>
            <%--            <li class="nav-item">--%>
            <%--                <a class="nav-link" href="#">Профиль</a>--%>
            <%--            </li>--%>
            <li class="nav-item">
                <a class="nav-link" href="#">Выход</a>
            </li>
        </ul>
    </div>
    <div class="navbar-brand nav-link mr-lg-0" id="current_date_time_block2"></div>

</nav>

<div class="container">
    <div class="py-5 text-center">

        <h1>Карточка инцидента</h1>
        <hr>
        <p class="lead">"Самурай без меча подобен самураю с мечом, но без меча"</p>
        <p><i>Китайская народная мудрость</i></p>
    </div>

    <div class="row">
        <div class="col-md-4 order-md-2 mb-4">
            <h4 class="d-flex justify-content-between align-items-center mb-3">
                <span class="text-muted">База знаний</span>
                <span class="badge badge-secondary badge-pill">3</span>
            </h4>
            <form class="card p-2">
                <p>Порядок действий должен быть максимально удобен, вопросы должны быть конкретными, а советы точными.
                    От качества опроса пользователя об инциденте, зависит скорость решения</p>

                <img src="img/imgcall1.png" height="250"/>
            </form>
        </div>
        <div class="col-md-8 order-md-1">
            <h4 class="mb-3">Инцидент</h4>
            <form class="needs-validation" novalidate>
                <div class="row">
                    <div class="col-md-4 mb-3">
                        <label for="incidentNumber">Номер</label>
                        <input type="text" class="form-control" id="incidentNumber" placeholder="" value="" required
                               disabled>
                        <!--                        <div class="invalid-feedback">-->
                        <!--                            Неккоректное имя пользователя-->
                        <!--                        </div>-->
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="date">Дата открытия заявки</label>
                        <input type="text" class="form-control" id="date" disabled>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="operator">Оператор</label>
                        <select type="text" class="custom-select d-block w-100" id="operator" required>
                            <option></option>
                            <option>ФИО</option>
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
                        <select class="custom-select d-block w-100" id="department" required>
                            <option value="">...</option>
                            <option value="1">1 отдел УГИБДД</option>
                            <option value="2">2 отдел УГИБДД</option>
                            <option value="3">3 отдел УГИБДД</option>
                            <option value="4">4 отдел УГИБДД</option>
                            <option value="5">5 отдел УГИБДД</option>
                            <option value="6">6 отдел УГИБДД</option>
                            <option value="7">7 отдел УГИБДД</option>
                            <option value="8">8 отдел УГИБДД</option>
                            <option value="9">9 отдел УГИБДД</option>
                            <option value="10">10 отдел УГИБДД</option>
                            <option value="11">11 отдел УГИБДД</option>
                            <option value="12">ЦАФАП в ОДД ГИБДД</option>
                            <option value="13">ОМОО и ОРДЧ ЦТУДТ ГИБДД</option>
                            <option value="14">ОСиСТ ЦТУДТ ГИБДД</option>
                            <option value="15">ЦТУДТ ГИБДД</option>
                        </select>
                        <div class="invalid-feedback">
                            Пожалуйста выберите подразделение
                        </div>

                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="category">Категория инцидента</label>
                        <select class="custom-select d-block w-100" id="category" required>
                            <option></option>
                        </select>
                        <div class="invalid-feedback">
                            Пожалуйста выберите подразделение
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="requester">Пользователь</label>
                        <input type="text" class="form-control" id="requester" placeholder="" value="" required>
                        <div class="invalid-feedback">
                            Неккоректное имя пользователя
                        </div>
                    </div>

                    <div class="col-md-6 mb-3">
                        <label for="requesterContacts">Контакты</label>
                        <input type="text" class="form-control" id="requesterContacts" placeholder="" required>
                        <div class="invalid-feedback" style="width: 100%;">
                            Введите контакты пользователя
                        </div>
                    </div>
                </div>
                <div class="row">

                    <div class="col-md-6 mb-3">
                        <label for="ip">IP-адрес</label>
                        <input type="text" class="form-control" id="ip" placeholder="0.0.0.0">
                        <div class="invalid-feedback">
                            Введите корректный IP-адрес компьютера пользователя
                        </div>
                    </div>

                    <div class="col-md-6 mb-3">
                        <label for="duration">Продолжительность инцидента</label>
                        <input type="text" class="form-control" id="duration" placeholder="" required>
                        <!--                    <div class="invalid-feedback">-->
                        <!--                        Please enter your shipping address.-->
                        <!--                    </div>-->
                    </div>
                </div>
                <div class="mb-3">
                    <label for="description">Описание</label>
                    <input type="text" class="form-control" id="description" placeholder="" required>
                    <!--                    <div class="invalid-feedback">-->
                    <!--                        Please enter your shipping address.-->
                    <!--                    </div>-->
                </div>

                <div class="row">
                    <div class="col-md-4 mb-3">
                        <label for="influence">Влияние</label>
                        <select class="custom-select d-block w-100" id="influence" required>
                            <option value="1">Высокое</option>
                            <option value="2">Среднее</option>
                            <option value="3">Низкое</option>
                        </select>
                        <!--                        <div class="invalid-feedback">-->
                        <!--                            Please select a valid country.-->
                        <!--                        </div>-->
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="urgency">Срочность</label>
                        <select class="custom-select d-block w-100" id="urgency" required>
                            <option value="1">Высокая</option>
                            <option value="2">Средняя</option>
                            <option value="3">Низкая</option>
                        </select>
                        <!--                        <div class="invalid-feedback">-->
                        <!--                            Please provide a valid state.-->
                        <!--                        </div>-->
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="priority">Приоритет</label>
                        <input type="text" class="form-control" id="priority" placeholder="" required>
                        <!--                        <div class="invalid-feedback">-->
                        <!--                            Zip code required.-->
                        <!--                        </div>-->
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 mb-3">
                        <label for="status">Статус</label>
                        <select type="text" class="custom-select d-block w-100" id="status" required>
                            <option>В работе</option>

                        </select>
                    </div>

                    <div class="col-md-4 mb-3">
                        <label for="engineer">Инженер</label>
                        <select type="text" class="custom-select d-block w-100" id="engineer" required>
                            <option></option>
                            <option>ФИО</option>
                        </select>
                        <div class="invalid-feedback">
                            Неккоректное имя пользователя
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="close_date">Дата закрытия заявки</label>
                        <input type="date" class="form-control" id="close_date">
                    </div>
                </div>
                <hr class="mb-4">

                <button class="col-md-3 btn btn-primary btn-lg" type="submit">Сохранить</button>
                <button class="col-md-3 btn btn-primary btn-lg" type="reset">Очистить</button>
                <!--                    <input class="col-md-2 " type="text" id="search" value="">-->
                <button class="col-md-3 btn btn-primary btn-lg" type="button">Поиск</button>

            </form>
        </div>
    </div>
    <hr>
    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2020-2020 Региональный отдел информационного обеспечения ГИБДД</p>
        <!--        <ul class="list-inline">-->
        <!--            <li class="list-inline-item"><a href="#">Privacy</a></li>-->
        <!--            <li class="list-inline-item"><a href="#">Terms</a></li>-->
        <!--            <li class="list-inline-item"><a href="#">Support</a></li>-->
        <!--        </ul>-->
    </footer>
</div>
</body>
<script type="text/javascript">

    /* функция добавления ведущих нулей */
    /* (если число меньше десяти, перед числом добавляем ноль) */
    function zero_first_format(value) {
        if (value < 10) {
            value = '0' + value;
        }
        return value;
    }

    /* функция получения текущей даты и времени */
    function date_time() {
        var current_datetime = new Date();
        var day = zero_first_format(current_datetime.getDate());
        var month = zero_first_format(current_datetime.getMonth() + 1);
        var year = current_datetime.getFullYear();
        var hours = zero_first_format(current_datetime.getHours());
        var minutes = zero_first_format(current_datetime.getMinutes());
        var seconds = zero_first_format(current_datetime.getSeconds());

        return day + "." + month + "." + year + " " + hours + ":" + minutes + ":" + seconds;
    }

    function short_date_time() {
        var current_datetime = new Date();
        var day = zero_first_format(current_datetime.getDate());
        var month = zero_first_format(current_datetime.getMonth() + 1);
        var year = current_datetime.getFullYear();

        return day + "." + month + "." + year;
    }

    /* выводим текущую дату и время на сайт в блок с id "current_date_time_block" */
    document.getElementById('date').setAttribute('value', short_date_time().toString());


    setInterval(function () {
        document.getElementById('current_date_time_block2').innerHTML = date_time();
    }, 1000);
</script>
</html>
