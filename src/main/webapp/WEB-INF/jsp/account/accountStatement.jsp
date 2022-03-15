<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored = "false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List transaction</title>
</head>
<body>
<h1>Список транзакций по счету:</h1>
        <form action="/account/info/accountStatement" method="get">
        Логин: ${login} <br>
        Номер счета: ${accountNumber} <br>
        Баланс: ${balance} ${currency}<br>
            <br>
<c:forEach items="${transactionList}" var="item">
    <hr>
    Id терминала: ${item.terminalId} <br>
    Дата транзакции: ${item.dateTransaction} <br>
    Тип операции: ${item.operationType} <br>
    Сумма транзакции : ${item.sumTransaction} ${item.currencyType}<br>
    <hr>
</c:forEach>
        </form>
<br>
<br>
<form action="/account/info" method="get">
    <input type="submit" value="Назад">
</form>
</body>
</html>