<!DOCTYPE html>
<html lang="en ru uk" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Account</title>
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

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
        <#--<li class="nav-item active">-->
        <#--<a href="/" class="nav-link">Main</a>-->
        <#--</li>-->
            <li class="nav-item">
                <form action="/logout" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Sign Out"/>
                </form>
            </li>
            <li class="nav-item active">
                <a href="/doctor-appointment" class="nav-link">Appointments  </a>
            </li>

            <li class="nav-item active">
                <a href="/procedures" class="nav-link">  Designated procedures</a>
            </li>
        </ul>
    </div>
    <form id="locales" class="form-inline my-2">
        <img src="http://avtovyshyvanka.com/userfiles/shop/large/163_shilda-flag-ukrainy-krug.jpg"
             class="rounded-circle mr-sm-2" width="30" height="30">
        <img src="https://www.securitylab.ru/upload/iblock/b04/b047ed6071a0b6d03b59118742897f41.jpg"
             class="rounded-circle mr-sm-2" width="30" height="30">
    </form>
</nav>
<div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
    <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-visit" role="tab"
       aria-controls="v-pills-home" aria-selected="true">Visit</a>
    <a class="nav-link" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-referral" role="tab"
       aria-controls="v-pills-profile" aria-selected="false">Referral</a>
</div>
<div class="tab-content" id="v-pills-tabContent">
    <div class="tab-pane fade show active" id="v-pills-visit" role="tabpanel"
         aria-labelledby="v-pills-home-tab">
        <form method="post" action="/doctor-appointment">
            <table>
                <tbody>
                <tr>
                    <td>${enterValue}</td>
                    <td><input type="text" name="number"></td>
                </tr>
                <tr>
                    <td>Enter diagnosis</td>
                    <td><input type="text" name="diagnosis"></td>
                </tr>
                <tr>
                    <td>Choose appointment type</td>
                    <td><select name="appType">
                        <option value="Лікування">Лікування</option>
                        <option value="Спеціальне лікування">Спеціальне лікування</option>
                        <option value="Процедура">Процедура</option>
                    </select>
                    </td>
                </tr>
                <tr>
                    <td>Enter appointments</td>
                    <td><input type="text" name="appointment"></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <button style="width: 230px">Add visit</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>

    <div class="tab-pane fade" id="v-pills-referral" role="tabpanel"
         aria-labelledby="v-pills-profile-tab">
        <form method="post" action="doctor-appointment/referral">
            <table>
                <tbody>
                <tr>
                    <td>Patient id</td>
                    <td><input type="text" name="pId" value="${patientId}"></td>
                </tr>
                <tr>
                    <td>Referral type</td>
                    <td>
                        <select name="refType">
                            <option value="">--------------------------------------</option>
                            <option value="Направлення до лікаря за спеціальністю">
                                Направлення до лікаря за спеціальністю
                            </option>
                            <option value="Направлення на дослідження">Направлення на дослідження</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Act title</td>
                    <td><input type="text" name="actTitle"></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <button style="width: 350px">Issue referral</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>
</div>
<footer id="footer" class="footer navbar-fixed-bottom footer-dark bg-dark" style="height: 45px">
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