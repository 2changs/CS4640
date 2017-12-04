<html>
	<head>
		<meta charset="UTF-8">
		<title>Appetize</title>
		<link rel="stylesheet" type="text/css" href="./css/style.css">
		<link rel="stylesheet" type="text/css" href="./css/recipes.css">

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

		<div class="recipes">
			<!-- search box -->
			<input type="text" class="search-bar" src="./images/icon-search.svg" placeholder="Search for recipes" />

			<div class="row">
				<div class="col-md-12">
					<h1><strong>Recipes</strong></h1>
				</div>
			</div>


			<?php
				include('db.php');
				$query = "SELECT * FROM recipes";
				$result = mysqli_query($connection, $query);

				if ($result->num_rows > 0) {
				    while($row = $result->fetch_assoc()) {

				        $cell = '<div class="col-sm-4">';
						$cell.= '<a class="recipe-tile" href="recipe.html?id='.$row["id"].'">
							<div class="tile" style="background:url(';
						$cell.=	"'".$row["recipe_image"]."'";
						$cell.= ') no-repeat center">
					    		<h3 class="title">'.$row["recipe_name"] ."</h3>
					    		<p>Time: ".$row["recipe_minutes"]." min | Cost: ~$".$row["recipe_cost"]."
					    			Enter short description here!
					    		</p>
							</div>
						</a> </div>";
						echo($cell);
				    }
				} else {
				    echo "0 results";
				}
			?>

		<footer>
			CS4753 | Diana Chang | Amanda Nguyen
		</footer>
	</body>
</html>
