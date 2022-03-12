<%--Author Sergey Vasiliev--%>
<html>
<head>
	<title>User panel</title>
</head>
<body>
<h1>Account information</h1>
Enter the amount of money.


<form action="/account/info/updateDeposit" method="get">
    	Balance:${newBalance} ${currency}
</form>
<form action="/account/info/updateDeposit" method="post">
	Input cash:<br>
	<input name="money"><br>
	<input type="submit"><br>
</form>
	<br>
	<br>
	<form action="/account/info" method="get">
	<input type="submit" value="Back">
	</form>
</body>
</html>