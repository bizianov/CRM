<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>

</head>
<body>
<p align="center"><a href="/tourist">Tourist menu</a></p>
Tourist has been deleted:<br><br>
<table border="1">
    <tr>
        <th bgcolor="#01DF3A"><b>ID</b></th>
        <th bgcolor="#01DF3A"><b>FIRST NAME</b></th>
        <th bgcolor="#01DF3A"><b>LAST NAME</b></th>
        <th bgcolor="#01DF3A"><b>PHONE</b></th>
        <th bgcolor="#01DF3A"><b>EMAIL</b></th>
        <th bgcolor="#01DF3A"><b>BIRTHDAY</b></th>
        <th bgcolor="#01DF3A"><b>SOURCE</b></th>
    </tr>
    <tr>
        <td bgcolor="#E6E6E6">${tourist.id}</td>
        <td bgcolor="#E6E6E6">${tourist.firstName}</td>
        <td bgcolor="#E6E6E6">${tourist.lastName}</td>
        <td bgcolor="#E6E6E6">${tourist.phone}</td>
        <td bgcolor="#E6E6E6">${tourist.email}</td>
        <td bgcolor="#E6E6E6">${tourist.birthday}</td>
        <td bgcolor="#E6E6E6">${tourist.source}</td>
    </tr>
</table>
</body>
</html>