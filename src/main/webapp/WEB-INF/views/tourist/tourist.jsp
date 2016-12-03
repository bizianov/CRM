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

    <hr>
    <table>
    <tr>
    <td>
    <b>Find tourist by id:</b><br>
    <form action="/getTouristById" method="get">
        id = <input type="text" name="id">
        <input type="submit" value="Find">
    </form>
    </td>

    <td>
    <b>Find tourist by phone:</b><br>
        <form action="/getTouristByPhone" method="get">
        id = <input type="text" name="phone">
        <input type="submit" value="Find">
    </form>
    </td>

    <td>
    <b>Find tourist by email:</b><br>
        <form action="/getTouristByEmail" method="get">
        id = <input type="text" name="email">
        <input type="submit" value="Find">
    </form>
    </td>
    </table>

    <table>
    <rt>
    <td>
    <b>Find tourist by first name:</b><br>
        <form action="/getTouristByFirstName" method="get">
        id = <input type="text" name="firstName">
        <input type="submit" value="Find">
    </form>
    </td>

    <td>
    <b>Find tourist by last name:</b><br>
         <form action="/getTouristByLastName" method="get">
         id = <input type="text" name="lastName">
         <input type="submit" value="Find">
    </form>
    </td>
    </tr>
    </table>

    <b>Find birthday today</b><br>
         <form action="/getTouristsByBirthday" method="get">
         <input type="submit" value="Find">
    </form>
    <hr>

    <b>Create tourist:</b><br>
        <form action="/createTourist" method="get">
        name = <input type="text" name="firstName">
        surname = <input type="text" name="lastName"><br>
        phone = <input type="text" name="phone">
        email = <input type="text" name="email"><br>
        birthday = <input type="text" name="birthday">
        source = <input type="text" name="source" list="sourcelist"><br>
               <datalist id="sourcelist">
                   <option value="REGULAR" selected>REGULAR</option>
                   <option value="WEBSITE">WEBSITE</option>
                   <option value="REFERRAL">REFERRAL</option>
                   <option value="CASUAL">CASUAL</option>
                   <option value="OTHER">OTHER</option>
               </datalist>
        <input type="submit" value="Create">
    </form>
    <hr>

    <b>Delete tourist:<b><br>
    <form action="/deleteTourist" method="get">
        id = <input type="text" name="id">
        <input type="submit" value="Delete">
    </form>
    <hr>

  </body>
</html>