<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt' %>

<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : 'en'}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="message"/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title><fmt:message key="title.authorization"/></title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a href="${pageContext.request.contextPath}/" class="navbar-brand">
        <img src="https://rat.in.ua/wp-content/uploads/2012/10/1114_burenka_podorognik.png"
             alt="logo" width="35" height="35">
    </a>
    <button class="navbar-toggler mr-auto" type="button" data-toggle="collapse"
            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
            aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <form method="get" action="${pageContext.request.contextPath}/change-lang/login">
        <label for="language"></label>
        <select id="language" name="language"
                onchange="submit()" style="font-size: 11pt">
            <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
            <option value="uk" ${language == 'uk' ? 'selected' : ''}>Українська</option>
        </select>
    </form>
</nav>
<br/>
<br/>
<br/>
<form method="post" action="${pageContext.request.contextPath}/mirmedis/account">
    <table align="center">

        <tbody>

        <tr>
            <td><input type="text" class="form-control" name="login" placeholder="<fmt:message key="title.login"/>"/>
            </td>
        </tr>
        <tr>
            <td><input type="password" class="form-control" name="password"
                       placeholder="<fmt:message key="title.password"/>"/></td>
        </tr>
        <tr>
            <td>
                <button class="btn btn-success" style="width: 230px"><fmt:message key="button.sign-in"/></button>
            </td>
        </tr>
        </tbody>
    </table>
</form>
<div class="d-flex justify-content-center links">
    <fmt:message key="message.sign-up.propose"/>
    <a href="${pageContext.request.contextPath}/registration"><fmt:message key="button.sign-up"/> </a>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>