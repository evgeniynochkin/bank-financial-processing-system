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
    <form>
        User: ${account.userLogin}<br>
        Account number: ${account.numberAccount} <br>
        Card number: ${card.cardNumber} <br>
        Payment system: ${card.paymentSystem}<br>
        Data open: ${card.expirationDate} <br>
        Holder name: ${card.cardHolderName} <br>
        Activity status: ${card.cardStatus} <br>
        Balance: ${account.balance} ${account.currency} <br>
        <input input name="userLogin" formaction="/clientinfo/${account.userLogin}" formmethod="get" type="submit" value="Список пользователей">
    </form>
</body>
</html>