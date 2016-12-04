<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="project.model.tour.Tour" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
  <head>
    <title>Tour info</title>
  </head>
  <body>
    <p align="center"><a href="/tour">Tourist menu</a></p>

  <%
    List<Tour> allTours = (List<Tour>)request.getAttribute("allTours");
    for(Tour tour : allTours){
            out.println(tour + "<br>");
        }
  %>


  </body>
</html>