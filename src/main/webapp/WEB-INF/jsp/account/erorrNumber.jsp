<%--Author Sergey Vasiliev--%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored = "false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Erorr</title>
</head>
<body>
<h1>Ошибка!!!</h1>
Вы вводите неверный номер счета или такого счета не существует.<br>
Пожалуйста, проверьте свой номер или создайте новый номер счета.
<form action="/account/info" method="get">
    <input type="submit" value="Информация по счету">
</form>
</body>
</html>