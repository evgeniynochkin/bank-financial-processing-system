<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Delete by login</title>
</head>
<body>
<div>
  <form method="POST" action="">
    <h2>Delete user by login</h2>
    <div>
      <input name="login" type="text" placeholder="Userlogin" autofocus="true"/>
      <button type="submit">Delete</button>
    </div>
  </form>
</div>
        <input type="button" value="Go back" onclick="window.location.href='/afterlogin';"/>
        <h4><a href="/logout">Logout</a></h4>
</body>
</html>