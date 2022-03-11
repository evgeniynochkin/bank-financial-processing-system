<%--Author Sergey Vasiliev--%>
<html>
<head>
	<title>User panel</title>
</head>
<body>
<h1>Account information</h1>

Enter the amount of cash withdrawn.

<form action="/withdrawCash" method="get">
    	Balance:${newBalance}
	${errorBalance}
</form>
<form action="/withdrawCash" method="post">
	Input number account:<br>
	<input name="numberAccount"><br>
	Input withdraw cash:<br>
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