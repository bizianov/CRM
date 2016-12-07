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
    out.print("<tr><th bgcolor=\"#01DF3A\">ID</th>" +
              "<th bgcolor=\"#01DF3A\">USERNAME</th>" +
              "<th bgcolor=\"#01DF3A\">ENABLED</th>" +
              "<th bgcolor=\"#01DF3A\">ROLES</th></tr><br>");
    for(User user : allUsers){
            out.print("<tr><td bgcolor=\"#E6E6E6\">"+ user.getId() +
                      "</td><td bgcolor=\"#E6E6E6\">" + user.getUsername()+
                      "</td><td bgcolor=\"#E6E6E6\">" + user.isEnabled() +
                      "</td><td bgcolor=\"#E6E6E6\">" + user.getRoles()+"</td></tr><br>");
        }
    out.print("</table>");
  %>

  </body>
</html>