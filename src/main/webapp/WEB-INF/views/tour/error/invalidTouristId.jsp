<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <title>Tourist error</title>
  </head>
  <body>
    <p align="center"><a href="/tour">Tour menu</a></p>
    There is no tourist with id:

    ${notFound}

  </body>
</html>