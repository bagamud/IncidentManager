<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ru">
<head>
    <jsp:include page="../template/_metaStyle.jsp"/>
    <title>Incident Manager</title>

</head>
<body class="bg-light">
<jsp:include page="../template/_menu.jsp"/>
<div class="container-fluid">
    <div class="py-3 row">
        <main class="col-md-9 m-auto col-lg-10 px-md-4" role="main">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">Инцидент</h1>
            </div>
            <div class="row">
                <div class="col-md-5 order-md-2 mb-4">
                    <div id="carousel" class="carousel" data-interval="false">
                        <div class="carousel-inner">
                            <div class="carousel-item">
                                <div class="card">
                                    <div class="card-header">
                                        Справочник
                                    </div>
                                    <div class="card-body">
                                        Здесь будет краткое описание темы категории для подсказки
                                    </div>
                                </div>
                            </div>
                            ${faq}
                        </div>
                    </div>
                </div>

                <div class="col-md-7 order-md-1">
                    <form class="needs-validation" action="${pageContext.request.contextPath}/manager" method="post"
                          name="form" id="formId" novalidate>
                        <div class="row">
                            <div class="col-md-4 mb-3">
                                <label for="id">Номер</label>
                                <input class="form-control <%if (request.getAttribute("error") != null) out.print("is-invalid");%>"
                                       id="id" type="text" name="id"
                                       value="${incident.id}" disabled>
                                <div class="invalid-feedback">
                                    Неправильный номер записи
                                </div>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label for="opendate">Дата открытия заявки</label>
                                <input class="form-control" id="opendate" type="datetime-local" name="opendate"
                                       value="${incident.opendate}" disabled required min="0">
                            </div>
                            <div class="col-md-4 mb-3">
                                <label for="operator">Оператор</label>
                                <select class="form-control custom-select d-block w-100 form-control" id="operator"
                                        required onchange=""
                                        type="text" name="operator">
                                    <option value="${incident.operator}">${incident.operatorName}</option>
                                    ${users}
                                </select>
                                <div class="invalid-feedback">
                                    Неккоректное имя пользователя
                                </div>
                            </div>
                            <hr>
                        </div>
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label for="requesterdepartment">Подразделение</label>
                                <select class="form-control custom-select d-block w-100"
                                        id="requesterdepartment"
                                        name="requesterdepartment" required>
                                    <option value="${incident.requesterdepartment}">${incident.requesterdepartmentTitle}</option>
                                    ${departments}
                                </select>
                                <div class="invalid-feedback">
                                    Пожалуйста выберите подразделение
                                </div>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="category">Категория инцидента</label>
                                <select class="form-control custom-select d-block w-100<%-- is-invalid--%>"
                                        id="category"
                                        name="category" required onchange="">
                                    <option value="${incident.category}">${incident.categoryTitle}</option>
                                    ${categories}
                                </select>
                                <div class="invalid-feedback">
                                    Пожалуйста выберите категорию
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label for="requester">Пользователь</label>
                                <input class="form-control" id="requester" name="requester" placeholder=""
                                       type="text" required
                                       value="${incident.requester}">
                            </div>
                            <div class="col-md-3 mb-3">
                                <label for="requestercontacts">Контакты</label>
                                <input class="form-control" id="requestercontacts" name="requestercontacts"
                                       placeholder="" required
                                       type="tel" value="${incident.requestercontacts}">
                                <div class="invalid-feedback" style="width: 100%;">
                                    Введите контакты пользователя
                                </div>
                            </div>
                            <div class="col-md-3 mb-3">
                                <label for="ipaddress">IP-адрес</label>
                                <input class="form-control" id="ipaddress" name="ipaddress" placeholder="0.0.0.0"
                                       type="text"
                                       value="${incident.ipaddress}">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 mb-3">
                                <label for="description">Описание</label>
                                <textarea class="form-control<%-- is-invalid--%>" id="description" name="description"
                                          required>${incident.description}</textarea>
                                <div class="invalid-feedback">
                                    Введите описание заявки
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-2 mb-3">
                                <label for="priority">Приоритет</label>
                                <select class="form-control custom-select d-block w-100" id="priority" name="priority"
                                        required>
                                    <option value="${incident.priority}">${incident.priorityDescription}</option>
                                    ${priority}
                                </select>
                            </div>
                            <div class="col-md-2 mb-3">
                                <label for="status">Статус заявки</label>
                                <select class="form-control custom-select d-block w-100" id="status" name="status"
                                        required
                                        type="text">
                                    <option value="${incident.status}">${incident.statusTitle}</option>
                                    ${status}
                                </select>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label for="engineer">Инженер</label>
                                <select class="form-control custom-select d-block w-100" id="engineer"
                                        name="engineer" required
                                        type="text">
                                    <option value="${incident.engineer}"
                                            label="${incident.engineerName}">${incident}</option>
                                    ${users}
                                </select>
                                <div class="invalid-feedback">
                                    Неккоректное имя пользователя
                                </div>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label for="close_date">Дата закрытия заявки</label>
                                <input class="form-control" id="close_date" name="close_date" type="text"
                                       value="${incident.closedate}" disabled>
                            </div>
                        </div>
                        <hr class="mb-4">
                        <div class="row">
                            <div class="btn-group-lg">
                                <input class="btn btn-primary" type="submit" value="Сохранить"
                                       formaction="/manager/add"/>
                                <input class="btn btn-primary" type="button" onclick="location.href='/manager'"
                                       value="Очистить"/>
                                <input class="btn btn-primary" type="submit" formaction="/manager/done"
                                       value="Выполнено"/>
                            </div>
                        </div>
                    </form>
                    <form action="${pageContext.request.contextPath}/manager/get" method="get">
                        <div class="input-group col-md-3 mb-3">
                            <label for="search"></label>
                            <input class="form-control-lg <%if (request.getAttribute("error") != null) out.print("is-invalid");%>"
                                   id="search" type="text" name="id">
                            <div class="invalid-feedback">
                                Неправильный номер записи
                            </div>
                            <div class="input-group-append">
                                <button class="btn btn-primary btn-lg" type="submit"
                                        formaction="/manager/get"
                                        formmethod="get">Поиск
                                </button>
                            </div>
                        </div>
                    </form>

                </div>
            </div>
        </main>
    </div>
</div>
<script>
    document.getElementById('category').onchange = function () {
        Array.from(document.getElementsByClassName('carousel-item active'))
            .forEach((carouselelement) => carouselelement.setAttribute('class', 'carousel-item'));
        document.getElementById(this.value).setAttribute('class', 'carousel-item active');
    }
</script>
<jsp:include page="../template/_footer.jsp"/>
</body>
</html>
