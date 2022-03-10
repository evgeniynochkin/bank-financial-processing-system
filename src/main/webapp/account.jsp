<%--Author Sergey Vasiliev--%>
<html>
<head>
	<title>User panel</title>
</head>
<body>
<h1>Account information</h1>
<form action="infoAccount" method="get">
    	User: ${login}<br>
    	Account number: ${accountNumber} <br>
    	Data open: ${dateOpen} <br>
        Activity status: ${activityStatus}<br>
        Balance: ${balance} ${currency}<br>
    	</form>
<form action="/createAnAccount" method="get" >
	<input type="submit" value="Create account number">
</form>
<form action="/updateDeposit" method="get" >
	<input type="submit" value="Deposit money">
</form>
 <form action="/withdrawCash" method="get">
	 <input type="submit" value="Withdraw cash">
 </form>
<form action="depositMoney.jsp" target="_blank">
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