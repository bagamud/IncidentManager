<%@ page import="ru.kpp.incidentmanager.entity.Category" %>
<%@ page import="java.util.Objects" %>
<%@ page import="ru.kpp.incidentmanager.entity.Department" %>
<%@ page import="ru.kpp.incidentmanager.entity.Users" %>
<%@ page import="ru.kpp.incidentmanager.entity.Status" %>
<%@ page import="java.util.List" %>
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
                    <h4 class="d-flex justify-content-between align-items-center mb-3">
                        <span class="text-muted">База знаний</span>
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
                    <form class="needs-validation" action="${pageContext.request.contextPath}/manager" method="get"
                          novalidate>
                        <div class="row">
                            <div class="col-md-4 mb-3">
                                <label for="id">Номер</label>
                                <input class="form-control <%if (request.getAttribute("error") != null) out.print("is-invalid");%>"
                                       id="id" placeholder="" required
                                       type="text" name="id"
                                       value="${incident.id}">
                                <div class="invalid-feedback">
                                    Неправильный номер записи
                                </div>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label for="date">Дата открытия заявки</label>
                                <input class="form-control" id="date" type="search" name="date"
                                       value="${incident.date}" disabled>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label for="operator">Оператор</label>
                                <select class="form-control custom-select d-block w-100 form-control" id="operator"
                                        required
                                        type="text" name="operator">
                                    <option value="${incident.operator}">${incident.operatorName}</option>
                                    <%
                                        for (Users users : (List<Users>) request.getAttribute("users")) {
                                            out.print("<option value=\"" + users.getId() + "\">" + users.getName() + "</option>");
                                        }
                                    %>
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
                                <select class="form-control custom-select d-block w-100"
                                        id="department"
                                        name="department" required>
                                    <option value="${incident.requesterdepartment}">${incident.requesterdepartmentTitle}</option>
                                    <%
                                        for (Department department : (List<Department>) request.getAttribute("departments")) {
                                            out.print("<option value=\"" + department.getId() + "\">" + department.getTitle() + "</option>");
                                        }
                                    %>
                                </select>
                                <div class="invalid-feedback">
                                    Пожалуйста выберите подразделение
                                </div>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="category">Категория инцидента</label>
                                <select class="form-control custom-select d-block w-100<%-- is-invalid--%>"
                                        id="category"
                                        name="category" required>
                                    <option value="${incident.category}">${incident.categoryTitle}</option>
                                    <%
                                        List<Category> categories = Objects.requireNonNull((List<Category>) request.getAttribute("categories"));
                                        for (Category category : Objects.requireNonNull(categories)) {
                                            out.print("<option value=\"" + category.getId() + "\">" + category.getTitle() + "</option>");
                                        }
                                    %>
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
                            <div class="col-md-6 mb-3">
                                <label for="requesterContacts">Контакты</label>
                                <input class="form-control" id="requesterContacts" name="requesterContacts"
                                       placeholder="" required
                                       type="tel" value="${incident.requestercontacts}">
                                <div class="invalid-feedback" style="width: 100%;">
                                    Введите контакты пользователя
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label for="ip">IP-адрес</label>
                                <input class="form-control" id="ip" name="ip" placeholder="0.0.0.0" type="text"
                                       value="${incident.ipaddress}">
                            </div>
                            <%--                            <div class="col-md-6 mb-3">--%>
                            <%--                                <label for="duration">Продолжительность инцидента</label>--%>
                            <%--                                <input class="form-control" id="duration" name="duration" placeholder="" required--%>
                            <%--                                       type="text" value="${incidentForm.duration}">--%>
                            <%--                            </div>--%>
                        </div>
                        <div class="mb-3">
                            <label for="description">Описание</label>
                            <textarea class="form-control<%-- is-invalid--%>" id="description" name="description"
                                      required>${incident.description}</textarea>
                            <div class="invalid-feedback">
                                Введите описание заявки
                            </div>
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
                                       type="text" value="${incident.priorityDescription}">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 mb-3">
                                <label for="status">Статус заявки</label>
                                <select class="form-control custom-select d-block w-100" id="status" name="status"
                                        required
                                        type="text">
                                    <option value="${incident.status}">${incident.statusTitle}</option>
                                    <%
                                        for (Status status : Objects.requireNonNull((List<Status>) request.getAttribute("status"))) {
                                            out.print("<option value=\"" + status.getId() + "\">" + status.getTitle() + "</option>");
                                        }
                                    %>
                                </select>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label for="engineer">Инженер</label>
                                <select class="form-control custom-select d-block w-100" id="engineer"
                                        name="engineer" required
                                        type="text">
                                    <option value="${incident.engineer}">${incident.engineerName}</option>
                                    <%
                                        for (Users users : Objects.requireNonNull((List<Users>) request.getAttribute("users"))) {
                                            out.print("<option value=\"" + users.getId() + "\">" + users.getName() + "</option>");
                                        }
                                    %>
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
                        <input class="btn btn-primary btn-lg" type="submit" formaction="/manager/add"
                               value="Сохранить"/>
                        <input class="btn btn-primary btn-lg" type="button" onclick="location.href='/manager'"
                               value="Очистить"/>
                        <input class="btn btn-primary btn-lg" type="submit" value="Поиск"
                               formaction="/manager/"
                               formmethod="get">
                        <input class="btn btn-primary btn-lg" type="submit" formaction="/manager/done/${id}"
                               value="Выполнено"/>
                    </form>
                </div>
            </div>
        </main>
    </div>
</div>
<jsp:include page="../template/_footer.jsp"/>
</body>
</html>
