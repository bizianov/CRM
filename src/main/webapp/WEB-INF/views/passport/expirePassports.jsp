<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>User info</title>
</head>
<body>
<p align="center"><a href="/passport">Passport menu</a></p>

The following passports are due to expire:<br><br>

<table border="1">
    <tr>
        <th bgcolor="#01DF3A">ID</th>
        <th bgcolor="#01DF3A">SERIAL NUMBER</th>
        <th bgcolor="#01DF3A">ISSUER</th>
        <th bgcolor="#01DF3A">ISSUE DATE</th>
        <th bgcolor="#01DF3A">EXPIRE DATE</th>
        <th bgcolor="#01DF3A">TOURIST</th>
    </tr>
    <c:forEach items="${passportsDueToExpire}" var="passport">
        <tr>
            <td bgcolor="#E6E6E6">${passport.id}</td>
            <td bgcolor="#E6E6E6">${passport.serialNumber}</td>
            <td bgcolor="#E6E6E6">${passport.issuer}</td>
            <td bgcolor="#E6E6E6">${passport.issueDate}</td>
            <td bgcolor="#E6E6E6">${passport.expireDate}</td>
            <td bgcolor="#E6E6E6"><a href="/getTouristById?id=${passport.tourist.id}">${passport.tourist.id}</a></td>
        </tr>
    </c:forEach>
</table>


</body>
</html>