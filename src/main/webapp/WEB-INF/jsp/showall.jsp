<%@ page isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css">
    <meta charset="UTF-8"
</head>
<body>
    <form>
        <h1>All users: ${todaydata}</h1>
        <table border="1" width="1500"> <!-- Задаём границу в 1 пиксель и ширину в 300 пикселей -->
           <tr bgcolor="Gainsboro">  <!-- Задаём цвет ячеек для всей первой строки -->
                            <td class="zag">Login</td>
                            <td class="zag">Name</td>
                            <td class="zag">Middle name<br>
                            <td class="zag">Last name</td>
                            <td class="zag">Birthday</td>
                            <td class="zag">Passport</td>
                            <td class="zag">Passport org.</td>
                            <td class="zag">Passport date</td>
                            <td class="zag">E-mail</td>
                            <td class="zag">Phone</td>
                            <td class="zag"></td>
           </tr>
           <c:forEach items="${userList}" var="user">
           <tr>
                       <td>${user.userLogin}</td>
                       <td>${user.firstName}</td>
                       <td>${user.middleName}<br>
                       <td>${user.lastName}</td>
                       <td>${user.birthday}</td>
                       <td>${user.passport}</td>
                       <td>${user.passportOrg}</td>
                       <td>${user.passportDate}</td>
                       <td>${user.email}</td>
                       <td>${user.phone}</td>
                       <td><input class="ulink" name="userLogin" formaction="/clientinfo/${user.userLogin}" formmethod="get" type="submit" value="Accounts"></td>
           </tr>
           </c:forEach>

        </table>
        <br>
        <a href="/afterlogin" class="button24">Admin menu</a> <a href="/logout" class="button24">Logout</a>
    </form>
</body>
</html>
