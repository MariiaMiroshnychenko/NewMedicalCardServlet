<#import "parts/form-action.ftl" as fa>
    <!DOCTYPE html>
<html lang="en ru uk" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Main</title>
    <style type="text/css">
        #footer {
            position: fixed; /* Фиксированное положение */
            padding: 10px; /* Поля вокруг текста */
            width: 100%; /* Ширина слоя */
        }
    </style>
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
            <li class="nav-item">
                <form action="/logout" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Sign Out"/>
                </form>
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
                            <h3>${patientData.surname} ${patientData.name} ${patientData.patronymic}</h3>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-8 col-md-8 col-xs-12">
                <div class="panel">
                    <div class="panel-body">
                        <ul id="myTab" class="nav nav-pills">
                            <li class="active"><a href="#detail" data-toggle="tab">About patient</a></li>
                            <#--<li><a href="#confidentiality" data-toggle="tab">Confidentiality</a></li>-->
                            <li><a href="#medicalCard" data-toggle="tab">MedicalCard</a></li>
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
                                    <tr>
                                        <td class="active">Attending doctor:</td>
                                        <td><a target="_blank"
                                               href="/doctorPageForPatient?attendingDoctorSurname=${patientData.patient.attendingDoctor.person.surname}
                                               &attendingDoctorName=${patientData.patient.attendingDoctor.person.name}
                                               &attendingDoctorPatronymic=${patientData.patient.attendingDoctor.person.patronymic}">
                                            ${patientData.patient.attendingDoctor.person.surname}
                                            ${patientData.patient.attendingDoctor.person.name}
                                            ${patientData.patient.attendingDoctor.person.patronymic}</a>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-pane fade" id="medicalCard">
                                <label>Medical card num: ${patientData.patient.medicalCard.mcId}</label>
                                <div class="col-lg-8 col-md-8 col-xs-12">
                                    <div class="panel">
                                        <div class="panel-body">
                                            <ul id="myTab" class="nav nav-pills">
                                                <li class="active"><a href="#visits" data-toggle="tab">Visits</a></li>
                                                <li><a href="#examResults" data-toggle="tab">Exam results</a></li>
                                                <#--<li><a href="#discharges" data-toggle="tab">Discharges</a></li>-->
                                            </ul>
                                            <div id="myTabContent" class="tab-content">
                                                <hr>
                                                <div class="tab-pane fade active in" id="visits">
                                                    <table class="table table-th-block">
                                                        <thead>
                                                        <tr>
                                                            <th>Visit date</th>
                                                            <th>Referral num</th>
                                                            <th>Doctor speciality</th>
                                                            <th>Diagnosis</th>
                                                            <th>Appointment</th>
                                                            <th>Doctor full name</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <tr>
                                                                <#list patientVisits as pVisit>
                                                                    <td>${pVisit.visitDate}</td>
                                                                    <td>${pVisit.idReferralToDoctor.id}</td>
                                                                    <td>${pVisit.doctorId.speciality}</td>
                                                                    <td>${pVisit.diagnosis}</td>
                                                                    <td>${pVisit.appointment}</td>
                                                                    <td>${pVisit.doctorId.person.surname} ${pVisit.doctorId.person.name} ${pVisit.doctorId.person.patronymic}</td>
                                                                     </tr>
                                                                </#list>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <div class="tab-pane fade active in" id="examResults">
                                                    <table class="table table-th-block">
                                                        <thead>
                                                        <tr>
                                                            <th>Referral num</th>
                                                            <th>Result</th>
                                                            <th>Date</th>
                                                            <th>Doctor full name</th>
                                                            <th>Doctor speciality</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <tr>
                                                                <#list referralResults as refResult>
                                                                   <td>${refResult.id}</td>
                                                                   <td>${refResult.resultText}</td>
                                                                   <td>${refResult.resDate}</td>
                                                                   <td>${refResult.respDoctorId.person.surname}
                                                                       ${refResult.respDoctorId.person.name}
                                                                       ${refResult.respDoctorId.person.patronymic}</td>
                                                                    <td>${refResult.respDoctorId.speciality}</td>
                                                                     </tr>
                                                                </#list>
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
                </div>
            </div>
        </div>
    </div>
    <footer class="footer fixed-bottom footer-dark bg-dark " style="height: 45px">
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