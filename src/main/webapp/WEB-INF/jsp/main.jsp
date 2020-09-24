<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <jsp:include page="../template/_metaStyle.jsp"/>
    <title>Incident Manager</title>
    <link href="../css/signin.css" rel="stylesheet">
</head>
<body class="text-center">
<form class="container-xl" action="${pageContext.request.contextPath}/dashboard">
    <img class="mb-4" src="../img/gibdd.png" alt="">
    <p>Выпускная квалификационная работа</p>
    <h1>Тема: Разработка серверного приложения, автоматизирующего процесс управления инцидентами в ИТ-подразделении</h1>
    <button class="btn btn-lg btn-primary <%--btn-block--%>" type="submit">Войти</button>
    <p class="mt-5 mb-3 text-muted">&copy; 2020-2020</p>
</form>
</body>
</html>