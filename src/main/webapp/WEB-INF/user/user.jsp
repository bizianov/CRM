<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User panel</title>
</head>
<body>
    <b>Find user by id:</b><br>
    <form action="/getUserById" method="get">
        id = <input type="text" name="id">
        <input type="submit" value="Find">
    </form><br>

    <b>Find user by name:</b><br>
    <form action="/getUserByName" method="get">
        name = <input type="text" name="username">
        <input type="submit" value="Find">
    </form><br>

    <b>Create user:</b><br>
    <form action="/createUser" method="get">
        username = <input type="text" name="name">
        roles = <input type="checkbox" name="role" value="manager">manager
                <input type="checkbox" name="role" value="admin">admin
        <input type="submit" value="Create">
    </form><br>

    <b>Delete user:</b><br>
    <form action="/deleteUser" method="get">
        id = <input type="text" name="id">
        <input type="submit" value="Delete">
    </form><br>

    <b>Update user:</b><br>
    <form action="/updateUser" method="get">
        id = <input type="text" name="id">
        name = <input type="text" name="username">
        enabled = <input type="text" name="enabled" list="enabled">
                  <datalist id="enabled">
                      <option value="true" selected>true</option>
                      <option value="false">false</option>
                  </datalist>
        password = <input type="password" name="password">
        <input type="submit" value="Update">
    </form>

</body>
</html>