<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Delete by login</title>
</head>
<style>
body {
    		height: 100%;
            background: radial-gradient(circle farthest-corner at 100px 50px, #FBF2EB, #76ab81); //aqua, darkblue #FBF2EB, #352A3B
    		background-repeat: no-repeat;
    		background-size: cover;
    		background-attachment: fixed;
}

.button24{
  display: inline-block;
  color: white;
  text-decoration: none;
  padding: .5em 2em;
  outline: none;
  border-width: 2px 0;
  border-style: solid none;
  border-color: #FDBE33 #000 #D77206;
  border-radius: 6px;
  background: linear-gradient(#F3AE0F, #E38916) #E38916;
  transition: 0.2s;
}
.button24:hover { background: linear-gradient(#f5ae00, #f59500) #f5ae00; }
.button24:active { background: linear-gradient(#f59500, #f5ae00) #f59500; }

.delete{

    	position: absolute;
   		top: 80px;
   		left: 800px;
   		width: 500px;
   		height: 500px;
   		padding: 0px 0px;
   		cursor: move;
   		box-sizing: border-box;
}
</style>
<body>
<div class="delete">
  <form method="POST" action="">
    <h2>Delete user by login</h2>
    <div>
      <input name="login" type="text" placeholder="Userlogin" autofocus="true"/>
      <button type="submit">Delete</button>
    </div>
  </form>
      <a href="/logout" class="button24">Logout</a>
      <a href="/afterlogin" class="button24">Go back</a>
</div>
</body>
</html>