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
            <td><sf:input path="operator"/></td>
        </tr>
        <tr>
            <th>Hotel Id:</th>
            <td><sf:input path="hotelId"/></td>
        </tr>
        <tr>
            <th>Country:</th>
            <td><sf:input path="country"/></td>
        </tr>
        <tr>
            <th>Region:</th>
            <td><sf:input path="region"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Search"/></td>
        </tr>
    </table>
</fieldset>
</sf:form>
