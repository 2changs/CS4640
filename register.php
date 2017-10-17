<html>
	<head>
		<meta charset="UTF-8">
		<title>Appetize</title>
		<link rel="stylesheet" type="text/css" href="./css/style.css">
		<link rel="stylesheet" type="text/css" href="./css/register.css">
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
			      <li><a href="recipes.html">Recipes</a></li>
			      <li><a href="submitRecipe.php">Submit</a></li>
			      <li><a href="contact.html">Contact Us</a></li>
			      <li><a href="signin.php">Sign In</a></li>
			    </ul>
			</div>
		</nav>

		<div class="register">
			<form method="post" action="">
				<div class="user_name">
					<label for="user_name">User Name: </label>
					<input type="text" name="user_name" class="form-control" id="user_name" required />
				</div><br/>
				<div class="password">
					<label for="password"> Password: </label>
					<input type="password" name="password" class="form-control" id="password" required />
				</div><br/>
				<div class="first_name">
					<label for="first_name"> First Name: </label>
					<input type="text" name="first_name" class="form-control" id="first_name" />
				</div><br/>
				<div class="last_name">
					<label for="last_name"> Last Name: </label>
					<input type="text" name="last_name" class="form-control" id="first_name" />
				</div><br/>
				<div class="submit">
					<input name="action" type="hidden" value="register">
					<input type="submit" class="btn btn-submit" value="Register"/>
				</div>
			</form>
		</div>


		<?php
			//Password validation function
			function validate_password($pword) {
				if(strlen($pword) < 5) {
					return "The password must be more than 5 characters.";
				}
				if(preg_match('/\\d/', $pword) < 0) {
					return "The password must contain a number.";
				}
			}

			include('db.php');
			if(isset($_POST['action']) && $_POST['action'] == 'register') {
				$user_name = mysqli_real_escape_string($connection, $_POST['user_name']);
				$query = "select user_name from users where user_name='".$user_name."'";
				$result = mysqli_query($connection, $query);
				$num_results = mysqli_num_rows($result);
				$password = mysqli_real_escape_string($connection, $_POST['password']);

				if($num_results >= 1) {
					$message = "This username is already taken! Please choose another username.";

					echo("<p class='form_message'>".$message."</p>");
				} else if(strlen(validate_password($password)) > 0){
					echo("<p class='form_message'>".validate_password($password)."</p>");
				} else {
					$first_name = mysqli_real_escape_string($connection, $_POST['first_name']);
					$last_name = mysqli_real_escape_string($connection, $_POST['last_name']);

					echo($first_name);

					mysqli_query($connection, "insert into users(user_name, password, first_name, last_name) values ('".$user_name."','".md5($password)."','".$first_name."','".$last_name."')");

					$message = "Account has been created. Please log in.";
					echo("<p class='form_message'>".$message."</p>");
				}
			}


		?>


		<footer>
			CS4753 | Diana Chang | Amanda Nguyen
		</footer>
	</body>
</html>
