<%--Author Sergey Vasiliev--%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored = "false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User panel</title>
</head>
<body>
<h1>Создание номера счета</h1>

<form action="/account/info/createAnAccount" method="get">
    Логин: ${userLogin}<br>
    Номер счета: ${accountNumber}<br>
</form>

<form action="/account/info/createAnAccount" method="post">
    Введите тип счета:<br>
    (1 = CARD)<br>
    <input name="accountType"><br>
    Введите валюту:<br>
    ( 1 = RUB)<br>
    <input name="currency"><br>
    <input type="submit"><br>
</form>
<br>
<br>
<form>
    <input input name="userLogin" formaction="/clientinfo/${userLogin}" formmethod="get" type="submit" value="Назад">
</form>
</body>
</html>