<html>
	<head>
		<meta charset="UTF-8">
		<title>Appetize</title>
		<link rel="stylesheet" type="text/css" href="./css/style.css">
		<link rel="stylesheet" type="text/css" href="./css/submit.css">

		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="./js/index.js"></script>

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

		<div class="submit-recipe">
			<h1> Submit a recipe! </h1>
			<form name="form-recipe" method="get">
		    	<label for="recipe-name"> Recipe Name: </label>
				<input name="recipe-name" class="form-control" type = "text" id="recipe-name"/>
				<span class="error" id="error-name"> </span> </br>

		    	<label for="recipe-form-hours"> Hours: </label>
				<input name="recipe-form-hours" class="form-control recipe-time" type="number" name="quantity" min="0" max="12"  id="recipe-form-hours"/>

				<label for="recipe-form-minutes"> Minutes: </label>
				<span class="error" id="error-name"> </span> </br>

				<input name="recipe-form-minutes" class="form-control recipe-time" type="number" name="quantity" min="0" max="60"  id="recipe-form-minutes"/>
				<span class="error" id="error-name"> </span> </br>

		    	<label for="recipe-form-cost"> Cost: </label>
				<input name="recipe-form-cost" class="form-control" type="number" name="quantity" min="0" max="100" id="recipe-form-cost"/>
				<span class="error" id="error-name"> </span> </br>

		    	<label for="recipe-form-difficulty"> Difficulty: </label>
				<input name="recipe-form-difficulty" class="form-control" type="number" name="quantity" min="1" max="5" id="recipe-form-difficulty" />
				<span class="error" id="error-name"> </span> </br>


				<label for="message"> Ingredients: </label>
				<div class="submit-ingredients">
					<div class="add-ingredient">
						<input type='text' id='ingredient' />
						<input type='button' value='Add ingredient' id='add' onclick="addIngredient()" />
					</div>
					<div class="added-ingredients">
						<ul id='ingredient-list'>
						</ul>
					</div>
				</div>

				<label for="message"> Directions: </label>
				<textarea name="message" class="form-control" rows="5" id="contact-message" placeholder="Please enter your message here"></textarea>
				<span class="error" id="error-message"> </span> 
				<br/>

				<label for="recipe-image"> Image: </label>
				<input name="recipe-image" class="form-control" type = "text" id="recipe-image"/>
				<span class="error" id="error-message"> </span> 

				<input name="action" type="hidden" value="submitRecipe">
				<input type="submit" value="Submit" class="btn btn-submit" onclick="validate()"/>
	  		</form>


	  		<?php
	  			include('db.php');
	  			if(isset($_GET['action']) && $_GET['action'] == 'submitRecipe') {
	  				$recipe_name = mysqli_real_escape_string($connection, $_GET['recipe-name']);
	  				$recipe_form_hours = mysqli_real_escape_string($connection, $_GET['recipe-form-hours']);
	  				$recipe_form_minutes = mysqli_real_escape_string($connection, $_GET['recipe-form-minutes']);
	  				$recipe_form_cost = mysqli_real_escape_string($connection, $_GET['recipe-form-cost']);
	  				$recipe_form_difficulty = mysqli_real_escape_string($connection, $_GET['recipe-form-difficulty']);
	  				$recipe_image = mysqli_real_escape_string($connection, $_GET['recipe-image']);

	  				echo($recipe_form_difficulty);
	  				$query = "insert into recipes(recipe_name, recipe_hours, recipe_minutes, recipe_cost, recipe_difficulty, recipe_image) values ('".$recipe_name."',".$recipe_form_hours.",".$recipe_form_minutes.",".$recipe_form_cost.",".$recipe_form_difficulty.",'".$recipe_image."')";
	  				mysqli_query($connection, $query);
	  			}

	  		?>



	  	</div>
		<footer>
			CS4753 | Diana Chang | Amanda Nguyen
		</footer>	
	</body>
</html>