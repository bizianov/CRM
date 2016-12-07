<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="project.model.user.User" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
  <head>
    <title>User info</title>
  </head>
  <body>
    <p align="center"><a href="/user">User menu</a></p>
  <%
    List<User> allUsers = (List<User>)request.getAttribute("allUsers");
    out.print("<table border=\"1\">");
    out.print("<tr><th bgcolor=\"#00FF00\">ID</th><th bgcolor=\"#00FF00\">USERNAME</th><th bgcolor=\"#00FF00\">ENABLED</th><th bgcolor=\"#00FF00\">ROLES</th></tr><br>");
    for(User user : allUsers){
            out.print("<tr><td>"+ user.getId() +"</td><td>" + user.getUsername()+ "</td><td>" + user.isEnabled() + "</td><td>" + user.getRoles()+"</td></tr><br>");
        }
    out.print("</table>");
  %>


  </body>
</html>