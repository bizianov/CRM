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
    <b>Find tours by id:</b><br>
    <form action="/getTourById" method="get">
       id = <input type="text" name="id">
       <input type="submit" value="Find">
    </form>

    <b>Find tour by tourist:</b><br>
    <form action="/getToursByTourist" method="get">
       id = <input type="text" name="id">
    <input type="submit" value="Find">
    </form>

    <b>Find all tours:</b><br>
    <form action="/getAllTours" method="get">
    <input type="submit" value="Find">
    <hr>