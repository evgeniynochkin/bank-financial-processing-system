<%@ page isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <meta charset="UTF-8"
</head>
<body>
<style>
.button24{
  display: inline-block;
  color: white;
  text-decoration: none;
  padding: .5em 2em;
  outline: none;
  border-width: 2px 0;
  border-style: solid none;
  border-color: #FDBE33 #000 #D77206;
  border-radius: 6px;
  background: linear-gradient(#F3AE0F, #E38916) #E38916;
  transition: 0.2s;
}
.button24:hover { background: linear-gradient(#f5ae00, #f59500) #f5ae00; }
.button24:active { background: linear-gradient(#f59500, #f5ae00) #f59500; }
</style>
    <form>
        <h1>All users: ${todaydata}</h1>
        <table border="1" width="1500"> <!-- Задаём границу в 1 пиксель и ширину в 300 пикселей -->
           <tr bgcolor="Gainsboro">  <!-- Задаём цвет ячеек для всей первой строки -->
                            <td>Login</td>
                            <td>Name</td>
                            <td>middleName<br>
                            <td>lastName</td>
                            <td>birthday</td>
                            <td>passport</td>
                            <td>passportOrg</td>
                            <td>passportDate</td>
                            <td>email</td>
                            <td>phone</td>
                            <td>operation</td>
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
                       <td><input name="userLogin" formaction="/clientinfo/${user.userLogin}" formmethod="get" type="submit" value="Accounts"></td>
           </tr>
           </c:forEach>

        </table>
            <a href="/afterlogin" class="button24">Admin menu</a> <a href="/logout" class="button24">Logout</a>
    </form>
</body>
</html>
