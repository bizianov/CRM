<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Feedback panel</title>
</head>
<body>
<p align="center"><a href="/main.jsp">Main menu</a>
<p align="right">You are logged in as <b>${userLoggedIn}</b>
    <a href="/login?logout">logout</a></p>

<hr>
<b>Leave feedback:</b><br><br>
<form action="/createFeedback" method="get">
    <c:choose>
        <c:when test="${tourId != null}">
            tour id = <input type="text" name="tourId" value="${tourId}"><br><br>
        </c:when>
        <c:otherwise>
            tour id = <input type="text" name="tourId"><br><br>
        </c:otherwise>
    </c:choose>
    <textarea name="message" rows="5" cols="90" placeholder="leave feedback.."></textarea><br><br>
    <input type="submit" value="Create">
</form>

<hr>
<b>Find feedback by id:</b>
<form action="/getFeedbackById" method="get">
    id = <input type="text" name="id">
    <input type="submit" value="Find">
</form>

<b>Find feedback by tourist:</b>
<form action="/getFeedbackByTourist" method="get">
    id = <input type="text" name="id">
    <input type="submit" value="Find">
</form>

<b>Find feedback by hotel:</b>
<form action="/getFeedbackByHotel" method="get">
    id = <input type="text" name="id">
    <input type="submit" value="Find">
</form>
<hr>


</body>
</html>