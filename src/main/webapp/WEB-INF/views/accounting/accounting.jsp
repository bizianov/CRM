<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Accounting panel</title>
</head>
<body>
<p align="center"><a href="/main.jsp">Main menu</a>
<p align="right">You are logged in as <b>${userLoggedIn}</b>
    <a href="/login?logout">logout</a></p>
<hr>

<b>Create accounting:</b><br>
<form action="/createAccounting" method="get">
    tour id = <input type="text" name="tourId"><br>
    tpa = <input type="text" name="tpaNumber">
    tpg = <input type="text" name="tpgNumber">
    to = <input type="text" name="tourOperatorNumber"><br>
    direct = <input type="text" name="isDirectPayment" list="isDirect"><br>
    <datalist id="isDirect">
        <option value="true">true</option>
        <option value="false">false</option>
    </datalist>
    electronic = <input type="text" name="electronicAct" list="electronic">
    <datalist id="electronic">
        <option value="true">true</option>
        <option value="false">false</option>
    </datalist>
    paper = <input type="text" name="paperAct" list="paper">
    <datalist id="paper">
        <option value="true">true</option>
        <option value="false">false</option>
    </datalist><br>
    <input type="submit" value="Create">
</form>

<hr>
<b>Find accounting by id:</b>
<form action="/getAccountingById" method="get">
    id = <input type="text" name="id">
    <input type="submit" value="Find">
</form>

<b>Find accounting by tour:</b>
<form action="/getAccountingByTour" method="get">
    id = <input type="text" name="id">
    <input type="submit" value="Find">
</form>

<b>Find accounting by tourist:</b>
<form action="/getAccountingByTourist" method="get">
    last name = <input type="text" name="lastName">
    <input type="submit" value="Find">
</form>
<hr>

</body>
</html>
