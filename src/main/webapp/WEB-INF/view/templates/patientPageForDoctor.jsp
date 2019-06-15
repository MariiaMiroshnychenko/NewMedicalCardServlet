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
<link rel="stylesheet" href="http://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css"/>
<link rel="stylesheet" href="http://bootstraptema.ru/plugins/font-awesome/4-4-0/font-awesome.min.css"/>
<script src="http://bootstraptema.ru/plugins/jquery/jquery-1.11.3.min.js"></script>
<script src="http://bootstraptema.ru/plugins/2015/b-v3-3-6/bootstrap.min.js"></script>

<br><br><br>

<style>
    body {
        background: url(http://bootstraptema.ru/images/bg/bg-1.png)
    }

    #main {
        background-color: #f2f2f2;
        padding: 20px;
        -webkit-border-radius: 4px;
        -moz-border-radius: 4px;
        -ms-border-radius: 4px;
        -o-border-radius: 4px;
        border-radius: 4px;
        border-bottom: 4px solid #ddd;
    }

    #real-estates-detail #author img {
        -webkit-border-radius: 100%;
        -moz-border-radius: 100%;
        -ms-border-radius: 100%;
        -o-border-radius: 100%;
        border-radius: 100%;
        border: 5px solid #ecf0f1;
        margin-bottom: 10px;
    }

    #real-estates-detail .sosmed-author i.fa {
        width: 30px;
        height: 30px;
        border: 2px solid #bdc3c7;
        color: #bdc3c7;
        padding-top: 6px;
        margin-top: 10px;
    }

    .panel-default .panel-heading {
        background-color: #fff;
    }

    #real-estates-detail .slides li img {
        height: 450px;
    }
</style>

<div class="container">
    <div id="main">
        <div class="row" id="real-estates-detail">
            <div class="col-lg-4 col-md-4 col-xs-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <header class="panel-title">
                            <div class="text-center">
                                <strong>Пацієнт</strong>
                            </div>
                        </header>
                    </div>
                    <div class="panel-body">
                        <div class="text-center" id="author">
                            <img src="${patientData.photo}" width="300" height="300">
                            <h3>${patientSurname} ${patientName} ${patientPatronymic}</h3>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-8 col-md-8 col-xs-12">
                <div class="panel">
                    <div class="panel-body">
                        <ul id="myTab" class="nav nav-pills">
                            <li class="active"><a href="#detail" data-toggle="tab">About patient</a></li>
                        </ul>
                        <div id="myTabContent" class="tab-content">
                            <hr>
                            <div class="tab-pane fade active in" id="detail">
                                <table class="table table-th-block">
                                    <tbody>
                                    <tr>
                                        <td class="active">Birth date:</td>
                                        <td>${patientData.birthDate}</td>
                                    </tr>
                                    <tr>
                                        <td class="active">Phone number:</td>
                                        <td>${patientData.phone}</td>
                                    </tr>
                                    <tr>
                                        <td class="active">Email:</td>
                                        <td>${patientData.email}</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
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