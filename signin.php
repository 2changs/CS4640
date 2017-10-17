<html>
	<head>
		<meta charset="UTF-8">
		<title>Appetize</title>
		<link rel="stylesheet" type="text/css" href="./css/style.css">
		<link rel="stylesheet" type="text/css" href="./css/signin.css">

		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
		<nav class="navbar navbar-default">
		    <div class="navbar-header">
		        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
		      <a class="navbar-brand" href="index.html"><img class="logo" src="./images/logo1.png"/ alt="logo"></a>
		    </div>
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			    <ul class="nav navbar-nav navbar-right">
			      <li><a href="recipes.php">Recipes</a></li>
			      <li><a href="submitRecipe.php">Submit</a></li>
			      <li><a href="contact.html">Contact Us</a></li>
			      <li><a href="signin.php">Sign In</a></li>
			    </ul>
			</div>
		</nav>

		<div class="form">
			<form name="form-signin">
				<form method="post" action="">
					<div class="user_name">
						<label for="user_name">User Name: </label>
						<input type="text" name="user_name" class="form-control" id="user_name" required />
					</div><br/>
					<div class="password">
						<label for="password"> Password: </label>
						<input type="password" name="password" class="form-control" id="password" required />
					</div><br/>
					<div class="submit">
						<input name="action" type="hidden" value="sign_in">
						<input type="submit" class="btn btn-submit" value="Sign In"/>
					</div>
				</form>
			</form>
		</div>


		<?php
			include('db.php');
			if(isset($_POST['action']) && $_POST['action'] == 'sign_in') {
				$user_name = mysqli_real_escape_string($connection, $_POST['user_name']);
				$password = mysqli_real_escape_string($connection, $_POST['password']);
				$query = mysqli_query($connection, "select first_name from users where user_name = '".$user_name."'and password ='".md5($password)."'");
				$results = mysqli_fetch_array($query);
				if(count($results) >= 1) {
					$message = $results['first_name']." Login successfull.";
					session_start();
					$_SESSION['user'] = $user_name;  
				} else {
					$message = "Invalid user.";
				}
				echo("<p class='form_message'>".$message."</p>");
			}

		?>


		<footer>
			CS4753 | Diana Chang | Amanda Nguyen
		</footer>
	</body>
</html>
