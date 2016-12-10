<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>

</head>
<body>
<p align="center"><a href="/feedback">Feedback menu</a></p>
<table border="1">
    <tr>
        <th bgcolor="#01DF3A"><b>ID</b></th>
        <th bgcolor="#01DF3A"><b>TOUR</b></th>
        <th bgcolor="#01DF3A"><b>MESSAGE</b></th>
    </tr>
    <tr>
        <td bgcolor="#E6E6E6">${feedback.id}</td>
        <td bgcolor="#E6E6E6">${feedback.tour.id}</td>
        <td bgcolor="#E6E6E6">${feedback.message}</td>
    </tr>
</table>
</body>
</html>