<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en ru uk" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Main</title>
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

    <form id="locales" class="form-inline my-2">
        <img src="http://avtovyshyvanka.com/userfiles/shop/large/163_shilda-flag-ukrainy-krug.jpg"
             class="rounded-circle mr-sm-2" width="30" height="30">
        <img src="https://www.securitylab.ru/upload/iblock/b04/b047ed6071a0b6d03b59118742897f41.jpg"
             class="rounded-circle mr-sm-2" width="30" height="30">
    </form>
</nav>
<form method="post" action="${pageContext.request.contextPath}/account" >
        <table align="center">

            <tbody>

            <tr>
                <td><input type="text" class="form-control"  name="login" placeholder="login"/></td>
            </tr>
            <tr>
                <td><input type="password" class="form-control" name="password" placeholder="password"/></td>
            </tr>
            <tr>
                <td><input type="submit" class="form-control button btn-success" style="width: 230px" value="Sign in"/></td>

            </tr>
            </tbody>
        </table>
</form>


            <div class="card-footer">
                <div class="d-flex justify-content-center links">
                    Don't have an account? <a href="${pageContext.request.contextPath}/registration"> Sign Up</a>
                </div>
            </div>
<footer class="footer navbar-fixed-bottom footer-dark bg-dark" style="height: 45px">
    <div class="container my-2" align="center">
        <p>©MIRMEDIS 2019</p>
    </div>
</footer>
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