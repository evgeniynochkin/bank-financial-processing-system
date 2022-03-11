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
    		top: 0px;
    		left: 0px;
    		width: 100%;
    		height: 100%;
    		padding: 250px 600px;
    		cursor: move;
    		box-sizing: border-box;
    	}


	.h-form-item {
		position: relative;
		z-index: 100;
		font-size: 30px;
		margin-bottom: 5px; /* Отступ снизу */
	}

	.field {
		clear:both;
		text-align:right;
		line-height:25px;
	}
	.main {float:left}

	input{
		z-index: 100;
		font-family: "Roboto Slab", serif;
		font-size: 30px;
		width: 280px; /* Ширина блока с текстом */
		margin-left: 10px; /* Расстояние между полем и текстом */
		border: 1px solid #abadb3; /* Рамка вокруг текстового поля */
		border-radius: 4px;
		margin-bottom: 5px; /* Отступ снизу */
	}
	.field_signup{
		font-family: "Roboto Slab", serif;
		font-size: 30px;
		width: auto; /* Ширина блока с текстом */
		margin-left: 10px; /* Расстояние между полем и текстом */
		margin-top: 50px; /* Отступ снизу */
		text-align:right;
	}

    </style>
</head>
<body>
<div class = "box">
    <form action="" method="POST" NAME="registerForm">
        <div class="h-form-item">
            <div class="main">
                <div class="field">
                    <p>Admin Menu :</p>
                </div>
               <div class="field_signup">
                     <input type="button" value="View all user" onclick="window.location.href='/showall';"/>
               </div>
               <div class="field_signup">
                    <input type="button" value="Registration" onclick="window.location.href='/add';"/>
               </div>
                <div class="field_signup">
                    <input type="button" value="Delete user" onclick="window.location.href='/delete';"/>
                </div>
                <div class="field_signup">
                     <a href="/logout">Logout</a>
                </div>
            </div>
        </div>
    </form>


</body>
</html>
