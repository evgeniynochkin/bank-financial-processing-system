<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>List transaction</title>
</head>
<body>
<h1>All transaction list:</h1>
        <form action="/account/info/accountStatement" method="get">
        Login: ${login} <br>
        Account number: ${accountNumber} <br>
        Balance: ${balance} ${currency}<br>
            <br>
<c:forEach items="${transactionList}" var="item">
    <hr>
    Terminal id: ${item.terminalId} <br>
    Date transaction: ${item.dateTransaction} <br>
    Type operation: ${item.operationType} <br>
    Sum transaction: ${item.sumTransaction} ${item.currencyType}<br>
    <hr>
</c:forEach>
        </form>
<br>
<br>
<form action="/account/info" method="get">
    <input type="submit" value="Back">
</form>
</body>
</html>