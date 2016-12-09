<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Find tour panel</title>
</head>
<body>
<p align="center"><a href="/tour">Tour menu</a>
<p align="right">You are logged in as <b>${userLoggedIn}</b>
    <a href="/login?logout">logout</a></p>

<hr>
<b>Find tours:</b><br><br>
<form action="/getToursByParameters" method="get">
    <input type="checkbox" name="byTourist">byTourist
    <input type="text" name="touristId"><br>
    <input type="checkbox" name="byTourOperator">byOperator
    <input type="text" name="tourOperator" list="tourOperatorList">
    <datalist id="tourOperatorList">
        <option value="TPG" selected>TPG</option>
        <option value="Anex">Anex</option>
        <option value="TUI">TUI</option>
        <option value="TEZTour">TEZTour</option>
        <option value="Coral">Coral</option>
        <option value="JoinUp">JoinUp</option>
        <option value="Akkord">Akkord</option>
    </datalist>
    <br>
    <input type="checkbox" name="byHotel">byHotel
    <input type="text" name="hotelId"><br>
    <input type="checkbox" name="byCountry">byCountry
    <input type="text" name="country"><br>
    <input type="checkbox" name="byRegion">byRegion
    <input type="text" name="region"><br>
    <input type="checkbox" name="byStartDate">byStart
    <input type="text" name="startDate" placeholder="2016-05-16"><br>
    <input type="checkbox" name="byEndDate">byEnd
    <input type="text" name="endDate" placeholder="2016-05-16"><br>
    <input type="checkbox" name="byClosureDate">byClosure
    <input type="text" name="closureDateStart" placeholder="2016-05-16"> -
    <input type="text" name="closureDateEnd" placeholder="2016-05-16"><br><br>
    <input type="submit" value="Find tours">
    <hr>
</form>
