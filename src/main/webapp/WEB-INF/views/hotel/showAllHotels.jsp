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
    out.print("<table border=\"1\">");
    out.print("<tr><th bgcolor=\"#01DF3A\">ID</th>" +
              "<th bgcolor=\"#01DF3A\">NAME</th>" +
              "<th bgcolor=\"#01DF3A\">RATE</th>" +
              "<th bgcolor=\"#01DF3A\">COUNTRY</th>" +
              "<th bgcolor=\"#01DF3A\">REGION</th></tr><br>");
    for(Hotel hotel : allHotels){
            out.print("<tr><td bgcolor=\"#E6E6E6\">"+ hotel.getId() +
                      "</td><td bgcolor=\"#E6E6E6\">" + hotel.getName()+
                      "</td><td bgcolor=\"#E6E6E6\">" + hotel.getRate() +
                      "</td><td bgcolor=\"#E6E6E6\">" + hotel.getCountry()+
                      "</td><td bgcolor=\"#E6E6E6\">" + hotel.getRegion()+"</td></tr><br>");
        }
  %>


  </body>
</html>