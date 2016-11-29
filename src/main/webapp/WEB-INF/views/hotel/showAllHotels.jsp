<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="project.model.hotel.Hotel" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
  <head>
    <title>Hotel info</title>
  </head>
  <body>
  <p align="center"><a href="/hotel">Hotel menu</a></p>

  <%
    List<Hotel> allHotels = (List<Hotel>)request.getAttribute("allHotels");
    for(Hotel hotel : allHotels){
            out.println(hotel + "<br>");
        }
  %>


  </body>
</html>