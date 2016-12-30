<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Find tour panel</title>
</head>
<body>
<p align="center"><a href="/tour">Tour menu</a>
<p align="right">You are logged in as <b>${userLoggedIn}</b>
    <a href="/logout">logout</a></p>

<hr>
<b>Find tours:</b>
<p>
    <sf:form method="GET" modelAttribute="tourSearch" action="/findTours">
<fieldset>
    <table>
        <tr>
            <th>Tourist Id:</th>
            <td><sf:input path="touristId"/></td>
        </tr>
        <tr>
            <th>Operator:</th>
            <td><sf:input path="operatorPattern"/></td>
        </tr>
        <tr>
            <th>Hotel:</th>
            <td><sf:input path="hotelNamePattern"/></td>
        </tr>
        <tr>
            <th>Country:</th>
            <td><sf:input path="countryPattern"/></td>
        </tr>
        <tr>
            <th>Region:</th>
            <td><sf:input path="regionPattern"/></td>
        </tr>
        <tr>
            <th>Start date:</th>
            <td><sf:input path="fromStartDate"/></td>
            <td> - </td>
            <td><sf:input path="toStartDate"/></td>
        </tr>
        <tr>
            <th>End date:</th>
            <td><sf:input path="fromEndDate"/></td>
            <td> - </td>
            <td><sf:input path="toEndDate"/></td>
        </tr>
        <tr>
            <th>Closure date:</th>
            <td><sf:input path="fromClosureDate"/></td>
            <td> - </td>
            <td><sf:input path="toClosureDate"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Search"/></td>
        </tr>
    </table>
</fieldset>
</sf:form>
