<%--
  Created by IntelliJ IDEA.
  User: marie
  Date: 14.05.2019
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Дані пацієнта</title>
    <style type="text/css">
        TABLE {
            border-collapse: collapse;
        }

        TD, TH {
            padding: 3px;
            border: 1px solid black;
        }
    </style>

</head>
<body>
<h2 align="center">Список пацієнтів</h2>
<table align="center" style="border: 1px solid grey">
    <thead>
    <tr>
        <th>ID пацієнта</th>
        <th>Прізвище</th>
        <th>Ім'я</th>
        <th>По-батькові</th>
        <th>ID мед карти</th>
        <th>ID лікаря</th>
    </tr>
    </thead>
    <c:forEach var="patient" items="${requestScope.patients}">
        <tbody>
        <tr>
            <td><c:out value="${patient.patientId}"/></td>
            <td><c:out value="${patient.surname}"/></td>
            <td><c:out value="${patient.firstName}"/></td>
            <td><c:out value="${patient.secondName}"/></td>
            <td><c:out value="${patient.medCardId}"/></td>
            <td><c:out value="${patient.doctorId}"/></td>
        </tr>
        </tbody>
    </c:forEach>
</table>
<hr/><h2 align="center">Список лікарів</h2>
<table align="center" style="border: 1px solid grey">
    <thead>
    <tr>
        <th>ID лікаря</th>
        <th>Прізвище</th>
        <th>Ім'я</th>
        <th>По-батькові</th>
    </tr>
    </thead>
    <c:forEach var="doctors" items="${requestScope.doctors}">
        <tbody>
        <tr>
            <td><c:out value="${doctors.doctorId}"/></td>
            <td><c:out value="${doctors.doctorSurname}"/></td>
            <td><c:out value="${doctors.doctorFirstName}"/></td>
            <td><c:out value="${doctors.doctorSecondName}"/></td>
        </tr>
        </tbody>
    </c:forEach>
</table>
<hr/>
<h2 align="center">Візити</h2>
<table align="center" style="border: 1px solid grey">
    <thead>
    <tr>
        <th>№</th>
        <th>Дата візиту</th>
        <th>ID медичної карти</th>
        <th>Діагноз</th>
    </tr>
    </thead>
    <c:forEach var="visits" items="${requestScope.visits}">
        <tbody>
        <tr>
            <td><c:out value="${visits.visitId}"/></td>
            <td><c:out value="${visits.visitDate}"/></td>
            <td><c:out value="${visits.medicalCardId}"/></td>
            <td><c:out value="${visits.diagnosis}"/></td>
        </tr>
        </tbody>
    </c:forEach>
</table>
<hr/>
<div align="center" >
    <form action="medcards" target="_blank">
        <button type="submit">Сформувати медичні карти</button>
    </form>
</div>
</body>
</html>
