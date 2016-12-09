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
<b>Find feedback by id:</b><br>
<form action="/getFeedbackById" method="get">
    id = <input type="text" name="id">
    <input type="submit" value="Find">
</form>


</body>
</html>