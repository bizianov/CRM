<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <title>Passport error</title>
  </head>
  <body>
    <p align="center"><a href="/passport">Passport menu</a></p>
    One of the following date is in wrong format (should be yyyy-mm-dd):

    ${inputDates}

  </body>
</html>