<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hotel panel</title>
</head>
<body>
    <p align="center"><a href="/main.jsp">Main menu</a>
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

    <b>Create hotel:</b><br>
    <form action="/createHotel" method="get">
        name = <input type="text" name="name">
        rate = <input type="text" name="rate" list="ratelist">
                  <datalist id="ratelist">
                     <option value="FIVE" selected>FIVE</option>
                     <option value="FOUR">FOUR</option>
                     <option value="THREE">THREE</option>
                     <option value="TWO">TWO</option>
                     <option value="ONE">ONE</option>
                  </datalist>
        country = <input type="text" name="country">
        region = <input type="text" name="region">
        <input type="submit" value="Create">
    </form><br>

      <b>Update hotel:</b><br>
        <form action="/updateHotel" method="get">
            id = <input type="text" name="id">
            name = <input type="text" name="name">
            rate = <input type="text" name="rate" list="ratelist">
                <datalist id="ratelist">
                    <option value="FIVE" selected>FIVE</option>
                    <option value="FOUR">FOUR</option>
                    <option value="THREE">THREE</option>
                    <option value="TWO">TWO</option>
                    <option value="ONE">ONE</option>
                </datalist>
            country = <input type="text" name="country">
            region = <input type="text" name="region">
        <input type="submit" value="Update">
        </form><br>

    <b>Delete hotel:</b><br>
    <form action="/deleteHotel" method="get">
        id = <input type="text" name="id">
        <input type="submit" value="Delete">
    </form><br>

    <b>Find hotels by country:</b><br>
    <form action="/getHotelsByCountry" method="get">
        country = <input type="text" name="country">
        <input type="submit" value="Find">
    </form><br>

    <b>Find hotels by region:</b><br>
    <form action="/getHotelsByRegion" method="get">
        country = <input type="text" name="region">
        <input type="submit" value="Find">
    </form><br>

  </body>
</html>