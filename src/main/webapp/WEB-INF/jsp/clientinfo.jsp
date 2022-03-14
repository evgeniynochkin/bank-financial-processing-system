<!DOCTYPE html>
<html lang="ru" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.w3.org/1999/xhtml">
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css">
    <meta charset="UTF-8">
    <title>Card info</title>
</head>
<body>
    <h1 class="utitle">Client information</h1>
    <form class="formusers">
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
        <table border="1" width="1500" class="usertable">
            <caption>Open account and cards</caption>
            <tr bgcolor="Gainsboro">
                <td class="zag">Account</td>
                <td class="zag">Currency</td>
                <td class="zag">Type account</td>
                <td class="zag">Card</td>
                <td class="zag">Type card</td>
                <td class="zag">Balance</td>
                <td class="zag"></td>
            </tr>
            <c:forEach items="${accounts}" var="acc">
                <tr>
                    <td>${acc.key.numberAccount}</td>
                    <td>${acc.key.currency}</td>
                    <td>${acc.key.accountType}</td>
                    <td>${acc.value.cardNumber}</td>
                    <td>${acc.value.paymentSystem}</td>
                    <td>${acc.key.balance}</td>
                    <td><input class="ulink" name="accountNumber" formaction="/account/info/${acc.key.numberAccount}" formmethod="get" type="submit" value="Info Account"></td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <td><input class="ulink" name="userLogin" formaction="/account/add/${client.userLogin}" formmethod="get" type="submit" value="Create New Account"></td>
        <br><br>
        <a href="/showall" class="button24">Go back</a> <a href="/logout" class="button24">Logout</a>
    </form>
</body>
</html>