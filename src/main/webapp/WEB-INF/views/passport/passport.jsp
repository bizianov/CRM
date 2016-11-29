<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Passport panel</title>
</head>
<body>
    <p align="center"><a href="/main.jsp">Main menu</a>
    <p align="right">You are logged in as <b>${userLoggedIn}</b>
    <a href="/login?logout">logout</a></p>
    <b>Find passport by id:</b><br>
    <form action="/getPassportById" method="get">
        id = <input type="text" name="id">
        <input type="submit" value="Find">
    </form><br>

    <b>Create passport:</b><br>
    <form action="/createPassport" method="get">
        S/N = <input type="text" name="serialNumber">
        issue = <input type="text" name="issuer">
        issue date = <input type="text" name="issueDate">
        expire date = <input type="text" name="expireDate">
        <input type="submit" value="Create">
    </form><br>

    <b>Update passport:</b><br>
    <form action="/updatePassport" method="get">
        id = <input type="text" name="id">
        S/N = <input type="text" name="serialNumber">
        issue = <input type="text" name="issuer">
        issue date = <input type="text" name="issueDate">
        expire date = <input type="text" name="expireDate">
    <input type="submit" value="Update">
    </form><br>

    <b>Delete passport:</b><br>
    <form action="/deletePassport" method="get">
        id = <input type="text" name="id">
        <input type="submit" value="Delete">
    </form><br>
   
  </body>
</html>