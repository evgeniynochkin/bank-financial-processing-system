<%@ page isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <meta charset="UTF-8"
</head>
<body>
<h1>All users: ${todaydata}</h1>
<br>
<c:forEach items="${userList}" var="user">
        login:${user.userLogin}<br>
        firstname:${user.firstName}<br>
        middlename:${user.middleName}<br>
        lastname:${user.lastName}<br>
        birthday:${user.birthday}<br>
        passport: ${user.passport}  passportOrg: ${user.passportOrg} passportDate: ${user.passportDate}<br>
        email   : ${user.email}<br>
        phone: ${user.phone}<br>
    <hr>
</c:forEach>
    <input type="button" value="Go back" onclick="window.location.href='/afterlogin';"/>
    <h4><a href="/logout">Logout</a></h4>
</body>
</html>