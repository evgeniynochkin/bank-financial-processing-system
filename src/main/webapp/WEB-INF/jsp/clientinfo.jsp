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
    <h1>Client information</h1>
    <form>
        Login: ${client.userLogin}<br>
        First name: ${client.firstName}<br>
        Middle name: ${client.middleName}<br>
        Last name: ${client.lastName}<br>
        Birthday: ${client.birthday}<br>
        Passport: ${client.passport}<br>
        Passport organisation: ${client.passportOrg}<br>
        Passport date: ${client.passportDate}<br>
        Email: ${client.email}<br>
        Phone: ${client.phone}<br>
        <br>
        <table border="1" width="1500">
            <tr bgcolor="Gainsboro">
                <td>Account</td>
                <td>Currency</td>
                <td>Type account</td>
                <td>Card</td>
                <td>Type card</td>
                <td>Balance</td>
            </tr>
            <c:forEach items="${accounts}" var="acc">
                <tr>
                    <td>${acc.key.numberAccount}</td>
                    <td>${acc.key.currency}</td>
                    <td>${acc.key.accountType}</td>
                    <td>${acc.value.cardNumber}</td>
                    <td>${acc.value.paymentSystem}</td>
                    <td>${acc.key.balance}</td>
                    <td><input name="accountNumber" formaction="/account/info/${acc.key.numberAccount}" formmethod="get" type="submit" value="Info Account"></td>
                </tr>
            </c:forEach>
        </table>
        <a href="/showall" class="button24">Go back</a> <a href="/logout" class="button24">Logout</a>
        <td><input name="userLogin" formaction="/account/add/${client.userLogin}" formmethod="get" type="submit" value="Create New Account"></td>
    </form>

</body>
</html>