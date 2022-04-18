<?php

include('../DataBase.php');

$stmt = $conn->prepare("SELECT thumbnail, foodName, vote, status FROM foodnews WHERE Category = 'Noodles'");
$stmt ->execute();
$stmt -> bind_result($thumbail, $foodname, $foodrating, $sales);

$FoodListPHP = array();

while($stmt ->fetch()){

    $temp = array();
	
	$temp['img'] = $thumbail;
	$temp['foodName'] = $foodname;
	$temp['foodRating'] = $foodrating;
	$temp['sales'] = $sales;

	array_push($FoodListPHP,$temp);
	}

	echo json_encode($FoodListPHP);

?>