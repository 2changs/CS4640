<?php
header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");
include('db.php');

$id = $_GET['id'];

$result = $connection->query("SELECT id, recipe_name, recipe_hours, recipe_minutes, recipe_image, recipe_cost, prep, ingredients FROM Recipes where id=".$id);

$output = "";
while($rs = $result->fetch_array(MYSQLI_ASSOC)) {
    if ($output != "") {$output .= ",";}
    $output .= '{"recipe_name":"'  . $rs["recipe_name"] . '",';
    $output .= '"recipe_hours":"'   . $rs["recipe_hours"]        . '",';
    $output .= '"recipe_minutes":"'. $rs["recipe_minutes"]     . '",';
    $output .= '"recipe_image":"'. $rs["recipe_image"]     . '",';
    $output .= '"recipe_prep":"'. $rs["prep"]     . '",';
    $output .= '"recipe_ingredients":"'. $rs["ingredients"]     . '",';
    $output .= '"recipe_cost":"'. $rs["recipe_cost"]     . '"}';
}
$output ='{"recipe":['.$output.']}';
$connection->close();

echo($output);
?>
