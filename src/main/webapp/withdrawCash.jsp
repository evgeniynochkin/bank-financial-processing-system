<%--Author Sergey Vasiliev--%>
<html>
<head>
	<title>User panel</title>
</head>
<body>
<h1>Account information</h1>

Enter the amount of cash withdrawn.

<form action="/account/info/withdrawCash" method="get">
    	Balance:${newBalance} ${currency}
	${errorBalance}
</form>
<form action="/account/info/withdrawCash" method="post">
	Input withdraw cash:<br>
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