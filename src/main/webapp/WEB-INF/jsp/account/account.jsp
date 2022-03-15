<%--Author Sergey Vasiliev--%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored = "false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css">
	<title>User panel</title>
</head>
<body>
	<h1>Информация по счету</h1>
	<form action="/account/info" method="get">
			Логин: ${login}<br>
			Номер счета: ${accountNumber} <br>
			Номер карты: ${card}<br>
			Дата открытия: ${dateOpen} <br>
			Статус открытия: ${activityStatus}<br>
			Баланс: ${balance} ${currency}<br>
	</form>
	<br>
	<form action="/account/info" method="post">
		Введите номер счета:<br>
		<input name="numberAccount"><br>
		<input type="submit"><br>
	</form>
	<br>
	<form action= "/account/info/createAnAccount" method="get" >
		<input type="submit" value="Создать новый номер счета">
	</form>
	<form action="/account/info/updateDeposit" method="get" >
		<input type="submit" value="Положить деньги на счет">
	</form>
	 <form action="/account/info/withdrawCash" method="get">
		 <input type="submit" value="Снять деньги со счета">
	 </form>
	<form action="/account/info/accountStatement" method="get">
		   <button>Выписка по транзакциям</button>
	</form>
	<form action="/card/info" method="get">
		<td><input name="accountNumber" formaction="/card/add/${accountNumber}" formmethod="get" type="submit" value="Создать карту"></td>
	</form>
	<br>
	<form>
		<input input name="userLogin" formaction="/clientinfo/${login}" formmethod="get" type="submit" value="Информация о клиенте">
	</form>
	<br>
	<a href="/showall" class="button24">К списку клиентов</a>
</body>
</html>