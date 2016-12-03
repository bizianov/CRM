<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User panel</title>
</head>
<body>
    <p align="center"><a href="/main.jsp">Main menu</a>
    <p align="right">You are logged in as <b>${userLoggedIn}</b>
    <a href="/login?logout">logout</a></p>

    <hr>
    <table>
    <tr>
    <td>
    <b>Find user by id:</b><br>
    <form action="/getUserById" method="get">
        id = <input type="text" name="id">
        <input type="submit" value="Find">
    </form></td>

    <td>
    <b>Find user by name:</b><br>
    <form action="/getUserByName" method="get">
        name = <input type="text" name="username">
        <input type="submit" value="Find">
    </form></td></tr>
    </table>

    <b>Find all users</b>
       <form action="/getAllUsers" method="get">
       <input type="submit" value="Find">
    </form>
    <hr>

    <b>Create user:</b><br>
    <form action="/createUser" method="get">
        username = <input type="text" name="name">
        roles = <input type="checkbox" name="role" value="manager">manager
                <input type="checkbox" name="role" value="admin">admin
        <input type="submit" value="Create">
    </form>

    <b>Update user:</b><br>
    <form action="/updateUser" method="get">
        id = <input type="text" name="id"><br>
        name = <input type="text" name="username"><br>
        enabled = <input type="text" name="enabled" list="enabled"><br>
                  <datalist id="enabled">
                      <option value="true" selected>true</option>
                      <option value="false">false</option>
                  </datalist>
        password = <input type="password" name="password"><br>
        <input type="submit" value="Update">
    </form><hr>

    <b>Delete user:</b><br>
        <form action="/deleteUser" method="get">
            id = <input type="text" name="id">
            <input type="submit" value="Delete">
    </form><hr>

</body>
</html>