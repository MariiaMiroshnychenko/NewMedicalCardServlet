<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>

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

    <title><fmt:message key="title.appointment"/></title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <img src="https://rat.in.ua/wp-content/uploads/2012/10/1114_burenka_podorognik.png"
             alt="logo" width="35" height="35">
    <button class="navbar-toggler mr-auto" type="button" data-toggle="collapse"
            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
            aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <form action="/logout" method="post">
                    <input type="submit" value="<fmt:message key="button.logout"/>"/>
                </form>
            </li>
            <li class="nav-item active">
                <a href="${pageContext.request.contextPath}/doctor-appointment" class="nav-link"><fmt:message key="navbar.appointments"/>  </a>
            </li>

            <li class="nav-item active">
                <a href="/procedures" class="nav-link"><fmt:message key="navbar.designated.procedures"/></a>
            </li>
        </ul>
    </div>
    <form method="get" action="${pageContext.request.contextPath}/change-lang/mirmedis/doctor-appointment">
        <label for="language"></label>
        <select id="language" name="language"
                onchange="submit()" style="font-size: 11pt">
            <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
            <option value="uk" ${language == 'uk' ? 'selected' : ''}>Українська</option>
        </select>
    </form>
</nav>
<div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
    <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-visit" role="tab"
       aria-controls="v-pills-home" aria-selected="true"><fmt:message key="treatment"/></a>
</div>
<div class="tab-content" id="v-pills-tabContent">
    <div class="tab-pane fade show active" id="v-pills-visit" role="tabpanel"
         aria-labelledby="v-pills-home-tab">
        <form method="post" action="${pageContext.request.contextPath}/doctorPage/doctor-appointment">
            <table>
                <tbody>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <td><fmt:message key="choose.patient.from.list"/></td>
                    <td><select id="patients" name="patients">
                        <c:forEach var="patient" items="${requestScope.localPatients}">
                            <option value="${patient.userData.id}">${patient.surname} ${patient.name} ${patient.patronymic}</option>
                        </c:forEach>
                    </select></td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <td><fmt:message key="appointment.type.en"/></td>
                    <td><select id="appTypeEn" name="appTypeEn">
                        <option value="Procedure">Procedure</option>
                        <option value="Pills">Pills</option>
                        <option value="Special treatment">Special treatment</option>
                    </select>
                    </td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <td><fmt:message key="appointment.type.uk"/></td>
                    <td><select id="appTypeUk" name="appTypeUk">
                        <option value="Процедура">Процедура</option>
                        <option value="Таблетки">Таблетки</option>
                        <option value="Спеціальне лікування">Спеціальне лікування</option>
                    </select>
                    </td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <button style="width: 230px" type="submit"><fmt:message key="treatment.add"/></button>
                    </td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>
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