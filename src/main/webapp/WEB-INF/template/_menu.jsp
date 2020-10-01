<%@ page contentType="text/html;charset=UTF-8" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <img alt="Russian Federation" height="30" src="../img/mvd.png" style="margin-left: 10px" width="52"/>
    <a class="navbar-brand nav-link mr-lg-auto" href="${pageContext.request.contextPath}/">РОИО ГИБДД</a>
    <div class="navbar-collapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/dashboard">Панель мониторинга</a>
            </li>
            <li class="nav-item active">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/manager">Инциденты</a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
                <a class="navbar-brand" id="principal"></a>
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

