<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <title>User info</title>
  </head>
  <body>
    <p align="center"><a href="/user">User menu</a></p>
    <table border="1">
        <tr>
            <th bgcolor="#01DF3A"><b>ID</b></th>
            <th bgcolor="#01DF3A"><b>USERNAME</b></th>
            <th bgcolor="#01DF3A"><b>ENABLED</b></th>
            <th bgcolor="#01DF3A"><b>ROLES</b></th>
        </tr>
        <tr>
            <td bgcolor="#E6E6E6">${user.id}</td>
            <td bgcolor="#E6E6E6">${user.username}</td>
            <td bgcolor="#E6E6E6">${user.enabled}</td>
            <td bgcolor="#E6E6E6">${user.roles}</td>
        </tr>
    </table>
  </body>
</html>