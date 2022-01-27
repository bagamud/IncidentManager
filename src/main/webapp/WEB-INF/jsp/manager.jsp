<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <div class="col-md-5 order-md-2 mb-4 ">
<%--                    <div class="card">--%>
<%--                        <div class="card-header bg-transparent text-center text-light text-uppercase"></div>--%>
<%--                        <div class="card-body"></div>--%>
<%--                    </div>--%>
                    <div id="carousel" class="carousel" data-interval="false">
                        <div class="carousel-inner">
                            <core:forEach items="${faq}" var="card">
                            <div class="carousel-item" id="categoryId${card.category.id}">
                                <div class="card">
                                    <div class="card-header bg-info text-center text-light text-uppercase">
                                        ${card.cardTitle}
                                    </div>
                                    <div class="card-body">
                                        ${card.cardText}
                                    </div>
                                </div>
                            </div>
                            </core:forEach>
                        </div>
                    </div>
                </div>

                <div class="col-md-7 order-md-1">
                    <form class="needs-validation" action="${pageContext.request.contextPath}/manager" method="post"
                          name="form" id="formId">
                        <div class="row">
                            <div class=" col-md-4 mb-3">
                                <label for="id">Номер</label>
                                <div class="input-group">
                                    <input class="form-control"
                                           id="id" type="number" min="0" pattern="^[0-9]+$" name="id"
                                           value="${incident.id}">
                                    <div class="invalid-feedback">
                                        Неправильный номер записи
                                    </div>
                                    <button class="btn-light" type="submit" formaction="/manager/get"
                                            formmethod="get" formnovalidate>Поиск
                                    </button>
                                </div>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label for="opendate">Дата открытия заявки</label>
                                <input class="form-control" id="opendate" type="text" name="opendate"
                                       value="${incident.opendate}" readonly>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label for="operator">Оператор</label>
                                <select class="form-control custom-select d-block w-100 form-control" id="operator"
                                        required
                                        type="text" name="operator">
                                    <option value="${incident.operator.id}">${incident.operator.name}</option>
                                    <core:forEach items="${users}" var="user">
                                        <option value="${user.id}">${user.name}</option>
                                    </core:forEach>
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
                                    <option value="${incident.requesterdepartment.code}">${incident.requesterdepartment.shortTitle}</option>
                                    <core:forEach items="${departments}" var="department">
                                        <option value="${department.code}">${department.shortTitle}</option>
                                    </core:forEach>
                                </select>
                                <div class="invalid-feedback">
                                    Пожалуйста выберите подразделение
                                </div>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="category">Категория инцидента</label>
                                <select class="form-control custom-select d-block w-100"
                                        id="category"
                                        name="category" required onchange="">
                                    <option value="${incident.category.id}">${incident.category.title}</option>
                                    <core:forEach items="${category}" var="category">
                                        <option value="${category.id}">${category.title}</option>
                                    </core:forEach> </select>
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
                                       type="text" pattern="\d{1,3}.\d{1,3}.\d{1,3}.\d{1,3}"
                                       value="${incident.ipaddress}">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 mb-3">
                                <label for="descriptionArea">Описание</label>
                                <textarea class="form-control<%-- is-invalid--%>" id="descriptionArea" name="descriptionrea"
                                          readonly>${incident.description}</textarea>
                                <div class="invalid-feedback">
                                    Введите описание заявки
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 mb-3">
                                <input class="form-control" id="description" name="description">
                                <div class="invalid-feedback">
                                    Введите описание заявки
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-2 mb-3">
                                <label for="priority">Приоритет</label>
                                <select class="form-control custom-select d-block w-100" id="priority" name="priority">
                                    <option value="${incident.priority.id}">${incident.priority.description}</option>
                                    <core:forEach items="${priority}" var="priority">
                                        <option value="${priority.id}">${priority.description}</option>
                                    </core:forEach> </select>
                            </div>
                            <div class="col-md-2 mb-3">
                                <label for="status">Статус заявки</label>
                                <select class="form-control custom-select d-block w-100" id="status" name="status"
                                        type="text">
                                    <option value="${incident.status.id}">${incident.status.title}</option>
                                    <core:forEach items="${status}" var="status">
                                        <option value="${status.id}">${status.title}</option>
                                    </core:forEach> </select>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label for="engineer">Инженер</label>
                                <select class="form-control custom-select d-block w-100" id="engineer"
                                        name="engineer"
                                        type="text">
                                    <option value="${incident.engineer.id}">${incident.engineer.name}</option>
                                    <core:forEach items="${users}" var="users">
                                        <option value="${users.id}">${users.name}</option>
                                    </core:forEach> </select>
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
                        <hr class="mb-5">
                        <div class="row">
                            <div class="col-auto btn-group-lg">
                                <input class="btn btn-primary" type="submit" value="Сохранить"
                                       formaction="/manager/add"/>
                                <input class="btn btn-primary" type="button" onclick="location.href='/manager'"
                                       value="Новый"/>
                                <input class="btn btn-primary" type="submit" formaction="/manager/done"
                                       value="Выполнено"/>
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
        if ('${faq}' !== '') {
            Array.from(document.getElementsByClassName('carousel-item'))
                .forEach((carouselelement) => carouselelement.setAttribute('class', 'carousel-item'));
            document.getElementById('categoryId' + this.value).setAttribute('class', 'carousel-item active');
        }
    }

</script>
<jsp:include page="../template/_footer.jsp"/>
</body>
</html>
