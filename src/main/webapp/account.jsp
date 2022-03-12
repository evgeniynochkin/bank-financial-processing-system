<%--Author Sergey Vasiliev--%>
<html>
<head>
	<title>User panel</title>
</head>
<body>
<h1>Account information</h1>
<form action="/account/info" method="get">
    	User: ${login}<br>
    	Account number: ${accountNumber} <br>
    	Data open: ${dateOpen} <br>
        Activity status: ${activityStatus}<br>
        Balance: ${balance} ${currency}<br>
    	</form>
<br>
<form action="/account/info" method="post">
	Input the number account:<br>
	<input name="numberAccount"><br>
	<input type="submit"><br>
</form>
<br>
<form action= "/account/info/createAnAccount" method="get" >
	<input type="submit" value="Create account number">
</form>
<form action="/account/info/updateDeposit" method="get" >
	<input type="submit" value="Deposit money">
</form>
 <form action="/account/info/withdrawCash" method="get">
	 <input type="submit" value="Withdraw cash">
 </form>
<form action="/accountStatement" method="get">
       <button>Account statement</button>
</form>

	<br>
	<br>
	<br>
	<br>
	<form action="/logout" method="get">
	<input type="submit" value="Back">
	</form>
</body>
</html>