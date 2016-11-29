<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="project.model.passport.Passport" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
  <head>
    <title>User info</title>
  </head>
  <body>
    <p align="center"><a href="/passport">Passport menu</a></p>

  <%
    List<Passport> expirePassports = (List<Passport>)request.getAttribute("passportsDueToExpire");
    for(Passport passport : expirePassports){
            out.println(passport + "<br>");
        }
  %>


  </body>
</html>