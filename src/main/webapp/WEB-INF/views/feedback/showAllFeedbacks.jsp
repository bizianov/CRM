<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>AllFeedbacks</title>
</head>
<body>
<p align="center"><a href="/feedback">Feedback menu</a></p>

<table border="1">
    <tr>
        <th bgcolor="#01DF3A"><b>ID</b></th>
        <th bgcolor="#01DF3A"><b>TOUR</b></th>
        <th bgcolor="#01DF3A"><b>MESSAGE</b></th>
    </tr>
    <c:forEach items="${allFeedbacks}" var="feedback">
        <tr>
            <td bgcolor="#E6E6E6">${feedback.id}</td>
            <td bgcolor="#E6E6E6"><a href="/getTourById?id=${feedback.tour.id}">${feedback.tour.id}</a></td>
            <td bgcolor="#E6E6E6">${feedback.message}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>