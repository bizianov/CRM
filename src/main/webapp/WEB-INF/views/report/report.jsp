<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Report panel</title>
</head>
<body>

<p align="center"><a href="/main.jsp">Main menu</a>
<p align="right">You are logged in as <b>${userLoggedIn}</b>
    <a href="/logout">logout</a></p>

<sec:authorize access="hasRole('ROLE_ADMIN')">
<hr>
<a href="/generateDailyReport">Generate daily report</a><br>
<a href="/generateWeeklyReport">Generate weekly report</a><br>
<a href="/generateMonthlyReport">Generate monthly report</a><br>
<hr>
Generate custom dates report<br>
<form action="/generateCustomReport">
    start = <input type="text" name="startDate" placeholder="2016-05-16">
    end = <input type="text" name="endDate" placeholder="2016-05-20"><br><br>
            <input type="submit" value="Generate">
</form>
<hr>
<a href="/exportContacts">Export contacts</a><br>
<hr>
</sec:authorize>

</body>
</html>
