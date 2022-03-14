<!DOCTYPE html>
<html lang="ru" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.w3.org/1999/xhtml">
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<head>
    <meta charset="UTF-8">
    <title>Create card page</title>
</head>
<body>
    <div class="block">
        <div class="header">
            <form>
                User: ${account.userLogin} <br>
                Account number: ${account.numberAccount} <br>
            </form>
        </div>
        <div>
            <form action="/card/add" method="post" th:object="${card}">
                <div>
                    Input holder name: <input type="text"name="holderName" value="${card.cardHolderName}"/>
                </div>
                <div class="form-group">
                    Input the card type:<br>
                    (1 = VISA | 2 = MC | 3 = МИР)<br>
                    <input name="cardType"><br>
                </div>
                <button class="btn btn-primary" type="submit">Submit form</button>
            </form>
        </div>
    </div>
</body>
</html>