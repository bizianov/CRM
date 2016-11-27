<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>
  <head>
    
  </head>
  <body>
   ---------Manager-----------<br>
   <c:import url="/WEB-INF/jsp/manager.jsp" />

   <sec:authorize access="hasRole('ROLE_ADMIN')">
   -----------Admin-----------<br>
   <c:import url="/WEB-INF/jsp/admin.jsp" />
   </sec:authorize>

  </body>
</html>