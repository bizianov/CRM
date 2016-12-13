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
    TO = <input type="text" name="tourOperatorNumber"><br>
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

<b>Find accounting by date:</b>
<form action="/getAccountingsByDate" method="get">
    month = <input type="text" name="month" list="monthList">
    <datalist id="monthList">
        <option value="1">January</option>
        <option value="2">February</option>
        <option value="3">March</option>
        <option value="4">April</option>
        <option value="5">May</option>
        <option value="6">June</option>
        <option value="7">July</option>
        <option value="8">August</option>
        <option value="9">September</option>
        <option value="10">October</option>
        <option value="11">November</option>
        <option value="12">December</option>
    </datalist>
    year = <input type="text" name="year" list="yearList">
    <datalist id="yearList">
        <option value="2017">2017</option>
        <option value="2016">2016</option>
        <option value="2015">2015</option>
        <option value="2014">2014</option>
    </datalist><br>
    <input type="submit" value="Find">
</form>

<b>Find opened accounting:</b>
<form action="/getOpenedAccountings" method="get">
    <input type="submit" value="Find">
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
