<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    
  </head>
  <body>
    <p align="center"><a href="/user">User menu</a></p>
    User has been deleted:<br><br>
    <table border="1">
            <tr>
                <th><b>ID</b></th>
                <th><b>USERNAME</b></th>
                <th><b>ENABLED</b></th>
                <th><b>ROLES</b></th>
            </tr>
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.enabled}</td>
                <td>${user.roles}</td>
            </tr>
        </table>

  </body>
</html>