<%--Author Sergey Vasiliev--%>
<html>
<head>
    <title>User panel</title>
</head>
<body>
<h1>Creates an account</h1>

<form action="/account/info/createAnAccount" method="get">
    User: ${userLogin}<br>
    Number account: ${accountNumber}<br>
</form>

<form action="/account/info/createAnAccount" method="post">
    Input the account type:<br>
    (1 = CARD)<br>
    <input name="accountType"><br>
    Input currency:<br>
    ( 1 = RUB)<br>
    <input name="currency"><br>
    <input type="submit"><br>
</form>
<br>
<br>
<form>
    <input input name="userLogin" formaction="/clientinfo/${userLogin}" formmethod="get" type="submit" value="Client info">
</form>
</body>
</html>