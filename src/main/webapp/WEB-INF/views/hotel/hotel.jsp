<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hotel panel</title>
</head>
<body>
    <p align="right">You are logged in as <b>${userLoggedIn}</b>
    <a href="/login?logout">logout</a></p>

    <b>Find hotel by id:</b><br>
    <form action="/getHotelById" method="get">
        id = <input type="text" name="id">
        <input type="submit" value="Find">
    </form><br>

    <b>Find hotel by name:</b><br>
    <form action="/getHotelByName" method="get">
        name = <input type="text" name="name">
        <input type="submit" value="Find">
    </form><br>

  </body>
</html>