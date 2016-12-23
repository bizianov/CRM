<%--
  Created by IntelliJ IDEA.
  User: slava23
  Date: 12/19/2016
  Time: 8:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Weather forecast</title>
</head>
<body>
<p align="center"><a href="/weather">Weather menu</a></p>

Weather forecast for <b>${city}:</b><br><br>

    <table border="1">
        <tr>
            <th bgcolor="#a9a9a9">Date/time</th>
            <th bgcolor="#a9a9a9">Temperature</th>
            <th bgcolor="#a9a9a9">Falls</th>
        </tr>
        <c:forEach items="${forecast}" var="list">
            <tr>
                <td>${list[0]}</td>
                <td>${list[1]}</td>
                <td>${list[2]}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
