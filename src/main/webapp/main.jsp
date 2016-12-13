<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>
<head>
    <title>CRM</title>
    <p align="center"><b>TPG AGENCY</b></p>
</head>
<body>
<hr>
<b>Manager menu</b>
<hr>
<c:import url="/WEB-INF/jsp/manager.jsp"/>

<br>
<sec:authorize access="hasRole('ROLE_ADMIN')">
    <hr>
    <b>Admin menu</b>
    <hr>
    <c:import url="/WEB-INF/jsp/admin.jsp"/><br>
    <hr>
</sec:authorize>

</body>
</html>