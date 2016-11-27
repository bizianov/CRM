<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="project.model.User" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
  <head>
    <title>User info</title>
  </head>
  <body>

  <sec:authorize access="isAuthenticated()">
     YES, you are logged in!<br><br>
     <c:import url="/WEB-INF/views/test.jsp"></c:import>
  </sec:authorize>

  <%
    List<User> allUsers = (List<User>)request.getAttribute("allUsers");
    for(User user : allUsers){
            out.println(user + "<br>");
        }
  %>


  </body>
</html>