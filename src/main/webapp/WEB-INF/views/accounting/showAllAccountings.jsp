<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>All Accountings</title>
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
            <td bgcolor="#E6E6E6"><a href="/getTourById?id=${accounting.tour.id}">${accounting.tour.id}</a></td>
            <td bgcolor="#E6E6E6">${accounting.tpaNumber}</td>
            <td bgcolor="#E6E6E6">${accounting.tpgNumber}</td>
            <td bgcolor="#E6E6E6">${accounting.tourOperatorNumber}</td>
            <td bgcolor="#E6E6E6">${accounting.directPayment}</td>
            <td <c:choose>
                <c:when test="${accounting.electronicAct}">
                    bgcolor="#7fffd4"
                </c:when>
                <c:otherwise>
                    bgcolor="#F2F5A9"
                </c:otherwise>
            </c:choose>>${accounting.electronicAct}</td>
            <td <c:choose>
                <c:when test="${accounting.paperAct}">
                    bgcolor="#7fffd4"
                </c:when>
                <c:otherwise>
                    bgcolor="#F2F5A9"
                </c:otherwise>
            </c:choose>>${accounting.paperAct}</td>
            <td bgcolor="#E6E6E6"><a href="/receivedElectronicActs?id=${accounting.id}">electronic</a> | <a href="/receivedPaperActs?id=${accounting.id}">paper</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>