<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Weather panel</title>
</head>
<body>
<p align="center"><a href="/main.jsp">Main menu</a>
<p align="right">You are logged in as <b>${userLoggedIn}</b>
    <a href="/login?logout">logout</a></p>
<hr>
<form action="/currentWeather">
    Current weather in <input type="text" name="city"><br>
    <input type="submit" value="Find">
</form>
<hr>
<form action="/weatherForecast">
    Weather forecast in <input type="text" name="city"><br>
    <input type="submit" value="Find">
</form>
<hr>

</body>
</html>
