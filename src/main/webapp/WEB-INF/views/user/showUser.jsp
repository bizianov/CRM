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
            <th bgcolor="#00FF00"><b>ID</b></th>
            <th bgcolor="#00FF00"><b>USERNAME</b></th>
            <th bgcolor="#00FF00"><b>ENABLED</b></th>
            <th bgcolor="#00FF00"><b>ROLES</b></th>
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