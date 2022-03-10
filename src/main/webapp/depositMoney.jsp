<%--Author Sergey Vasiliev--%>
<html>
<head>
	<title>User panel</title>
</head>
<body>
<h1>Account information</h1>
Enter the amount of money.


<form action="/updateDeposit" method="get">
    	Balance:${newBalance}
</form>
<form action="/updateDeposit" method="post">
	Input the number account:<br>
	<input name="numberAccount"><br>
	Input cash:<br>
	<input name="money"><br>
	<input type="submit"><br>
</form>
	<br>
	<br>
	<form action="/infoAccount" method="get">
	<input type="submit" value="Back">
	</form>
</body>
</html>