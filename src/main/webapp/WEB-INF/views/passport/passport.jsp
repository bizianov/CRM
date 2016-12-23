<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Passport panel</title>
</head>
<body>
<p align="center"><a href="/main.jsp">Main menu</a>
<p align="right">You are logged in as <b>${userLoggedIn}</b>
    <a href="/logout">logout</a></p>

<hr>
<b>Find passport by id:</b><br>
<form action="/getPassportById" method="get">
    id = <input type="text" name="id">
    <input type="submit" value="Find">
</form>

<b>Passports due to expire</b>
<form action="/getExpirePassports" method="get">
    <input type="submit" value="Find">
</form>
<hr>

<table>
    <tr>
        <td>
            <b>Create passport:</b><br>
            <form action="/createPassport" method="get">
                S/N = <input type="text" name="serialNumber"><br>
                issue = <input type="text" name="issuer"><br>
                issue date = <input type="text" name="issueDate" placeholder="2016-05-16"><br>
                expire date = <input type="text" name="expireDate" placeholder="2016-05-16"><br>
                tourist id = <input type="text" name="tourist_id"><br>
                <input type="submit" value="Create">
            </form>
        </td>

        <td>
            <b>Update passport:</b><br>
            <form action="/updatePassport" method="get">
                id = <input type="text" name="id"><br>
                S/N = <input type="text" name="serialNumber"><br>
                issue = <input type="text" name="issuer"><br>
                issue date = <input type="text" name="issueDate" placeholder="2016-05-16"><br>
                expire date = <input type="text" name="expireDate" placeholder="2016-05-16"><br>
                tourist id = <input type="text" name="tourist_id"><br>
                <input type="submit" value="Update">
            </form>
        </td>
    </tr>
</table>

<hr>
<b>Delete passport:</b><br>
<form action="/deletePassport" method="get">
    id = <input type="text" name="id">
    <input type="submit" value="Delete">
</form>
<hr>

</body>
</html>