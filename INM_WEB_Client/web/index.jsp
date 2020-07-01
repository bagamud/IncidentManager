<%--
  Created by IntelliJ IDEA.
  User: K
  Date: 28.06.2020
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <title>Авторизация</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Favicons -->
    <link rel="icon" href="img/favicons/favicon.ico">
    <meta name="msapplication-config" content="/docs/4.5/assets/img/favicons/browserconfig.xml">
    <meta name="theme-color" content="#563d7c">
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
    <link href="css/signin.css" rel="stylesheet">
</head>
<body class="text-center">
<form class="form-signin" action="auth" method="GET">
    <img class="mb-4" src="img/icon120.png" alt="">
    <h1 class="h3 mb-3 font-weight-normal">Авторизация</h1>
    <label for="inputLogin" class="sr-only">Логин</label>
    <input type="text" name="login" id="inputLogin" class="form-control" placeholder="Логин" required autofocus>
    <label for="inputPassword" class="sr-only">Пароль</label>
    <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Пароль" required>
    <div class="checkbox mb-3">
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
    <%
        if (request.getAttribute("msg") != null) out.print(request.getAttribute("msg"));
    %>
    <p class="mt-5 mb-3 text-muted">&copy; 2020-2020</p>
</form>
</body>
</html>