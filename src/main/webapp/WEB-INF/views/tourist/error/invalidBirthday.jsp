<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <title>Tourist error</title>
  </head>
  <body>
    <p align="center"><a href="/tourist">Tourist menu</a></p>
    Birthday is in wrong format (should be yyyy-mm-dd):

    ${birthday}

  </body>
</html>