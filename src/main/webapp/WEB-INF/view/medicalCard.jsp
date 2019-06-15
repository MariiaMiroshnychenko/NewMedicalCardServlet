<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Медичні картки</title>
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

<h1>Медичні картки</h1>

<table style="border: 1px solid grey">
    <thead>
    <th>Медична карта</th>

    <th colspan="3">Пацієнт</th>
    <th colspan="3">Лікар</th>
    <th colspan="2">Дані візитів</th>

    <tr>
        <th>№</th>

        <th>Прізвище</th>
        <th>Ім'я</th>
        <th>По-батькові</th>

        <th>Прізвище</th>
        <th>Ім'я</th>
        <th>По-батькові</th>

        <th>Дата візиту</th>
        <th>Діагноз</th>
    </tr>

    </thead>

    <c:forEach var="medcard" items="${requestScope.medcards}">
        <tbody>
        <tr>
            <td><c:out value="${medcard.patient.medCardId}"/></td>

            <td><c:out value="${medcard.patient.surname}"/></td>
            <td><c:out value="${medcard.patient.firstName}"/></td>
            <td><c:out value="${medcard.patient.secondName}"/></td>

            <td><c:out value="${medcard.doctor.doctorSurname}"/></td>
            <td><c:out value="${medcard.doctor.doctorFirstName}"/></td>
            <td><c:out value="${medcard.doctor.doctorSecondName}"/></td>

            <td>
                <c:forEach var="visit" items="${medcard.visits}">
                    <c:out value="${visit.visitDate}"/><br/>
                </c:forEach>
            </td>

            <td>
                <c:forEach var="visit" items="${medcard.visits}">
                    <c:out value="${visit.diagnosis}"/><br/>
                </c:forEach>
            </td>
        </tbody>
    </c:forEach>
</table>
</body>
</html>
