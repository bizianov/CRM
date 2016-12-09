<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="project.model.tourist.Tourist" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
  <head>
    <title>Tourist info</title>
  </head>
  <body>
    <p align="center"><a href="/tourist">Tourist menu</a></p>

  <%
    List<Tourist> allTourists = (List<Tourist>)request.getAttribute("allTourists");
    out.print("<table border=\"1\">");
        out.print("<tr><th bgcolor=\"#01DF3A\">ID</th>" +
                  "<th bgcolor=\"#01DF3A\">FIRST NAME</th>" +
                  "<th bgcolor=\"#01DF3A\">LAST NAME</th>" +
                  "<th bgcolor=\"#01DF3A\">PHONE</th>" +
                  "<th bgcolor=\"#01DF3A\">EMAIL</th>" +
                  "<th bgcolor=\"#01DF3A\">BIRTHDAY</th>" +
                  "<th bgcolor=\"#01DF3A\">SOURCE</th></tr><br>");
    out.print("</table>");
    for(Tourist tourist : allTourists){ %>
                ${tourist}
            <%
        }

  %>


  </body>
</html>