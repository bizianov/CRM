<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>

</head>
<body>
<p align="center"><a href="/accounting">Accounting menu</a></p>
<table border="1">
    <tr>
        <th bgcolor="#01DF3A"><b>ID</b></th>
        <th bgcolor="#01DF3A"><b>TOUR</b></th>
        <th bgcolor="#01DF3A"><b>TPA NUMBER</b></th>
        <th bgcolor="#01DF3A"><b>TPG NUMBER</b></th>
        <th bgcolor="#01DF3A"><b>TO NUMBER</b></th>
        <th bgcolor="#01DF3A"><b>IS DIRECT</b></th>
        <th bgcolor="#01DF3A"><b>ELECTRONIC ACT</b></th>
        <th bgcolor="#01DF3A"><b>PAPER ACT</b></th>
    </tr>
    <c:forEach items="${allAccountings}" var="accounting">
    <tr>
        <td bgcolor="#E6E6E6">${accounting.id}</td>
        <td bgcolor="#E6E6E6">${accounting.tour.id}</td>
        <td bgcolor="#E6E6E6">${accounting.tpaNumber}</td>
        <td bgcolor="#E6E6E6">${accounting.tpgNumber}</td>
        <td bgcolor="#E6E6E6">${accounting.tourOperatorNumber}</td>
        <td bgcolor="#E6E6E6">${accounting.directPayment}</td>
        <td bgcolor="#E6E6E6">${accounting.electronicAct}</td>
        <td bgcolor="#E6E6E6">${accounting.paperAct}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>