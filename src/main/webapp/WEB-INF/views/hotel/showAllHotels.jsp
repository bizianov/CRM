<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Hotel info</title>
</head>
<body>
<p align="center"><a href="/hotel">Hotel menu</a></p>

<table border="1">
    <tr>
        <th bgcolor="#01DF3A"><b>ID</b></th>
        <th bgcolor="#01DF3A"><b>NAME</b></th>
        <th bgcolor="#01DF3A"><b>RATE</b></th>
        <th bgcolor="#01DF3A"><b>COUNTRY</b></th>
        <th bgcolor="#01DF3A"><b>REGION</b></th>
    </tr>
    <c:forEach items="${allHotels}" var="hotel">
        <tr>
            <td bgcolor="#E6E6E6">${hotel.id}</td>
            <td bgcolor="#E6E6E6">${hotel.name}</td>
            <td bgcolor="#E6E6E6">${hotel.rate}</td>
            <td bgcolor="#E6E6E6"><a href="getHotelsByCountry?country=${hotel.country}">${hotel.country}</a></td>
            <td bgcolor="#E6E6E6"><a href="getHotelsByRegion?region=${hotel.region}">${hotel.region}</a></td>
        </tr>
    </c:forEach>
</table>


</body>
</html>