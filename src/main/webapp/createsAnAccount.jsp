<%--Author Sergey Vasiliev--%>
<html>
<head>
    <title>User panel</title>
</head>
<body>
<h1>Creates an account</h1>

<form action="/createAnAccount" method="get">
${login}<br>
${accountNumber}<br>
</form>

<form action="/createAnAccount" method="post">
    Input the account type:<br>
    <input name="accountType"><br>
    Input currency:<br>
    <input name="currency"><br>
    Input cash:<br>
    <input name="balance"><br>
    <input type="submit"><br>
</form>
<br>
<br>
<form action="/infoAccount" method="get">
    <input type="submit" value="Back">
</form>
</body>
</html>