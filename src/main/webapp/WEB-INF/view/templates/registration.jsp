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
    <a href="/" class="navbar-brand">
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
<form action="/registration" method="post">
    <table align="center">
        <tr>
            <td>Surname : </td>
            <td><input type="text" class="form-control" name="surname"/></td>
        </tr>
        <tr>
            <td>Name : </td>
            <td><input type="text" class="form-control" name="name"/></td>
        </tr>
    <tr>
        <td>Patronymic : </td>
        <td><input type="text" class="form-control" name="patronymic"/></td>
    </tr>
        <tr>
            <td>Birth date : </td>
            <td><input type="date" class="form-control" name="birthDate"/></td>
        </tr>
        <tr>
            <td>Passport series : </td>
            <td><input type="text" class="form-control" name="passSeries"/></td>
        </tr>
        <tr>
            <td>User Passport number : </td>
            <td><input type="text" class="form-control" name="passNumber"/></td>
        </tr>
        <tr>
            <td>Identify code : </td>
            <td><input type="text" class="form-control" name="identCode"/></td>
        </tr>
        <tr>
            <td>Phone number : </td>
            <td><input type="text" class="form-control" name="phone"/></td>
        </tr>
        <tr>
            <td>Email : </td>
            <td><input type="email" class="form-control" name="email"/></td>
        </tr>
        <tr>
            <td>Enter your Login : </td>
            <td><input type="text" class="form-control" name="login"/></td>
        </tr>
        <tr>
            <td>Enter your Password : </td>
            <td><input type="password" class="form-control" name="password"/></td>
        </tr>
        <tr>
            <td>Your registration code : </td>
            <td><input type="text" class="form-control" name="code"/></td>
        </tr>
        <tr>
            <td> If you`re medical employee,
                please, choose your specialty</td>
            <td>
                <select title="speciality" name="speciality">
                    <option value="Лікар-акушер-гінеколог">Лікар-акушер-гінеколог</option>
                    <option value="Лікар-гастроентеролог">Лікар-гастроентеролог</option>
                    <option value="Лікар-дієтолог">Лікар-дієтолог</option>
                    <option value="Лікар-ендокринолог">Лікар-ендокринолог</option>
                    <option value="Лікар загальної практики - сімейний лікар">Лікар загальної практики - сімейний лікар</option>
                    <option value="Лікар-кардіолог">Лікар-кардіолог</option>
                    <option value="Лікар-лаборант">Лікар-лаборант</option>
                    <option value="Лікар-невропатолог">Лікар-невропатолог</option>
                    <option value="Лікар-нефролог">Лікар-нефролог</option>
                    <option value="Лікар-нейрохірург">Лікар-нейрохірург</option>
                    <option value="Лікар-отоларинголог">Лікар-отоларинголог</option>
                    <option value="Лікар-офтальмолог">Лікар-офтальмолог</option>
                    <option value="Лікар-педіатр">Лікар-педіатр</option>
                    <option value="Лікар з променевої терапії">Лікар з променевої терапії</option>
                    <option value="Лікар-психіатр">Лікар-психіатр</option>
                    <option value="Лікар-рентгенолог">Лікар-рентгенолог</option>
                    <option value="Лікар-стоматолог">Лікар-стоматолог</option>
                    <option value="Лікар-терапевт">Лікар-терапевт</option>
                    <option value="Лікар-уролог">Лікар-уролог</option>
                    <option value="Лікар-фтизіатр">Лікар-фтизіатр</option>
                    <option value="Лікар-хірург">Лікар-хірург</option>
                    <option value="Медсестра">Медсестра</option>
                </select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="submit" class="form-control button btn-success" value="Sign In" style="width: 230px"/></td>
        </tr>
    </table>
</form>
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