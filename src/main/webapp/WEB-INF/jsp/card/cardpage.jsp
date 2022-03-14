<!DOCTYPE html>
<html lang="ru" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.w3.org/1999/xhtml">
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<head>
    <meta charset="UTF-8">
    <title>Card info</title>
</head>
<body>
    <h1>Card information</h1>
    <form action="/showall" method="get">
        User: ${accpunt.userLogin}<br>
        Account number: ${accpunt.numberAccount} <br>
        Card number: ${card.cardNumber} <br>
        Payment system: ${card.paymentSystem}<br>
        Data open: ${card.expirationDate} <br>
        Holder name: ${card.cardHolderName} <br>
        Activity status: ${card.cardStatus} <br>
        Balance: ${accpunt.balance} ${accpunt.currency} <br>
        <input type="submit" value="Список пользователей">
    </form>
</body>
</html>