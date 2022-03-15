<%--Author Sergey Vasiliev--%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored = "false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>User panel</title>
</head>
<body>
<h1>Снятие суммы</h1>

Введите сумму, которую желаете снять со счета.


<form action="/account/info/withdrawCash" method="get">
    	Баланс:${newBalance} ${currency}
	${errorBalance}
</form>
<form action="/account/info/withdrawCash" method="post">
	Введите сумму:<br>
	<input name="money"><br>
	<input type="submit"><br>
</form>
	<br>
	<br>
	<form action="/account/info" method="get">
	<input type="submit" value="Назад">
	</form>
</body>
</html>