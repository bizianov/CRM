<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tourist panel</title>
</head>
<body>
    <p align="center"><a href="/main.jsp">Main menu</a>
    <p align="right">You are logged in as <b>${userLoggedIn}</b>
    <a href="/login?logout">logout</a></p>
    <b>Find tourist by id:</b><br>
    <form action="/getTouristById" method="get">
        id = <input type="text" name="id">
        <input type="submit" value="Find">
    </form>

    <b>Find tourist by phone:</b><br>
        <form action="/getTouristByPhone" method="get">
        id = <input type="text" name="phone">
        <input type="submit" value="Find">
    </form>

    <b>Find tourist by email:</b><br>
        <form action="/getTouristByEmail" method="get">
        id = <input type="text" name="email">
        <input type="submit" value="Find">
    </form>

    <b>Find tourist by first name:</b><br>
        <form action="/getTouristByFirstName" method="get">
        id = <input type="text" name="firstName">
        <input type="submit" value="Find">
    </form>

    <b>Find tourist by last name:</b><br>
         <form action="/getTouristByLastName" method="get">
         id = <input type="text" name="lastName">
         <input type="submit" value="Find">
    </form>

    <b>Find tourist by birthday:</b><br>
         <form action="/getTouristByBirthday" method="get">
         id = <input type="text" name="birthday">
         <input type="submit" value="Find">
    </form>
   
  </body>
</html>