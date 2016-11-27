<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>
  <head>
    
  </head>
  <body>
   ---------<b>Manager</b>-----------<br>
   <c:import url="/WEB-INF/jsp/manager.jsp" />

   <br>
   <sec:authorize access="hasRole('ROLE_ADMIN')">
   -----------<b>Admin</b>-----------<br>
   <c:import url="/WEB-INF/jsp/admin.jsp" />
   </sec:authorize>

  </body>
</html>