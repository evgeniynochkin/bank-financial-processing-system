<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <meta charset="UTF-8">
    <title>Clients</title>
</head>
<body>
${message}
<h3>Clients</h3>
    <c:forEach items="${clientsList}" var="clients">
        login: ${clients.userLogin} <br>
        Firstname: ${clients.firstName} <br>
        MiddleName: ${clients.middleName} <br>
        LastName: ${clients.lastName} <br>
        Birthday: ${clients.birthday} <br>
        Passport: ${clients.passport} <br>
        PassportOrg: ${clients.passportOrg} <br>
        PassportDate: ${clients.passportDate} <br>
        Email: ${clients.email} <br>
        Phone: ${clients.phone} <br>
        <hr>
    </c:forEach>
</body>