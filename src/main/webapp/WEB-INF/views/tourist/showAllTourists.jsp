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
    for(Tourist tourist : allTourists){
            out.println(tourist + "<br>");
        }
  %>


  </body>
</html>