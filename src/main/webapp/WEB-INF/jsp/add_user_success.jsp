<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Info</title>
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
<h1>Клиент добавлен в БД</h1>
<br><br>
<a href="/afterlogin" class="button24">Вернуться</a>
</body>
</html>
