<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Feedback panel</title>
</head>
<body>
<p align="center"><a href="/main.jsp">Main menu</a>
<p align="right">You are logged in as <b>${userLoggedIn}</b>
    <a href="/login?logout">logout</a></p>
<hr>

<b>Create accounting:</b><br>
<form action="/createAccounting" method="get">
    tour id = <input type="text" name="tourId">
    tpa = <input type="text" name="tpaNumber">
    tpg = <input type="text" name="tpgNumber">
    to = <input type="text" name="tourOperatorNumber">
    direct = <input type="text" name="isDirectPayment" list="isDirect">
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
    </datalist>
    <input type="submit" value="Create">
</form>

</body>
</html>
