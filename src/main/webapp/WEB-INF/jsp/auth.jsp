<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <jsp:include page="../template/_metaStyle.jsp"/>
    <title>Incident Manager</title>
    <link href="${pageContext.request.contextPath}/css/signin.css" rel="stylesheet">
</head>
<body class="text-center">
<form class="form-signin" action="${pageContext.request.contextPath}/login" method="POST">
    <img alt="Russian Federation" height="155px" src="${pageContext.request.contextPath}/img/gerb_mvdi-300x174.png"/>
    <h1 class="h3 mb-3 font-weight-normal">Авторизация</h1>

    <label for="username" class="sr-only">Логин</label>
    <input type="text" name="username" id="username" class="form-control" placeholder="Логин" required autofocus>

    <label for="password" class="sr-only">Пароль</label>
    <input type="password" name="password" id="password" class="form-control" placeholder="Пароль" required>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
</form>
</body>
</html>