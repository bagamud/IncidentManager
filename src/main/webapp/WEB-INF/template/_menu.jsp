<%@ page contentType="text/html;charset=UTF-8" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <img alt="Russian Federation" height="30" src="../img/mvd.png" style="margin-left: 10px" width="52"/>
    <div class="nav-item px-2 mr-lg-auto text-white">ИЦ ГУ МВД России</div>
    <div class="navbar-collapse">
        <ul class="nav me-lg-auto">
            <li>
                <a class="nav-link px-2 text-white" href="${pageContext.request.contextPath}/dashboard">Панель
                    заявок</a>
            </li>
            <li>
                <a class="nav-link px-2 text-white" href="${pageContext.request.contextPath}/manager">Карточка
                    заявки</a>
            </li>
            <%--            <li>--%>
            <%--                <a class="nav-link px-2 text-white" href="${pageContext.request.contextPath}/reports">Отчеты</a>--%>
            <%--            </li>--%>
        </ul>
        <ul class="nav ml-auto">
            <li class="nav-item">
                <a class="nav-link px-2 text-white" id="principal">${user.name}</a>
            </li>
            <li class="nav-item">
                <button class="navbar-brand btn-lg btn-primary" onclick="location.href='/logout'">
                    <svg class="bi bi-power" fill="currentColor" height="1em" viewBox="0 0 16 16" width="1em"
                         xmlns="http://www.w3.org/2000/svg">
                        <path d="M5.578 4.437a5 5 0 1 0 4.922.044l.5-.866a6 6 0 1 1-5.908-.053l.486.875z"
                              fill-rule="evenodd"></path>
                        <path d="M7.5 8V1h1v7h-1z" fill-rule="evenodd"></path>
                    </svg>
                </button>
            </li>
        </ul>
    </div>
</nav>

