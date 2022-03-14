<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Manager Menu</title>
   	</script>
    <style type="text/css">
	body {
    		height: 100%;
    		background: radial-gradient(circle farthest-corner at 100px 50px, #FBF2EB, #352A3B ); //aqua, darkblue #FBF2EB, #352A3B
    		background-repeat: no-repeat;
    		background-size: cover;
    		background-attachment: fixed;
   }
   .box {
    		overflow: hidden;
    		position: absolute;
    		top: 80px;
    		left: 800px;
    		width: 500px;
    		height: 500px;
    		padding: 0px 0px;
    		cursor: move;
    		box-sizing: border-box;
   }
	.field {
		clear:both;
		text-align:center;
		font-size: 250%;
		color: white;
	}
	.field_signup{
		font-family: "Roboto Slab", serif;
		font-size: 30px;
		width: 500px; /* Ширина блока с текстом */
		margin-left: 10px; /* Расстояние между полем и текстом */
		margin-top: 10px; /* Отступ снизу */
		text-align:center;
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

	.button2{
      display: inline-block;
      color: white;
      text-decoration: none;
      padding: .5em 2em;
      outline: none;
      border-width: 2px 0;
      border-style: solid none;
      border-color: #FDBE33 #000 #D77206;
      border-radius: 6px;
      background: linear-gradient(#4169E1, #0000FF) #0000FF;
      transition: 0.2s;
    }
    </style>
</head>
<body>
<div class = "box">
    <form action="" method="POST" NAME="registerForm">
                <div class="field">
                    <p>Admin Menu</p>
                </div>
               <div class="field_signup">
                    <a href="/showall" class="button2">View all user</a>
               </div>
               <div class="field_signup">
                    <a href="/add" class="button2">Registration</a>
               </div>
                <div class="field_signup">
                    <a href="/delete" class="button2">Delete user</a>
                </div>
                <div class="field_signup">
                    <a href="/clients/main" class="button2">Users menu</a>
                </div>
                <div class="field_signup">
                     <a href="/logout" class="button24">Logout</a>
                </div>
    </form>
</body>
</html>
