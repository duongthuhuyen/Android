<?php

include('../DataBase.php');

$stmt = $conn->prepare("SELECT thumbnail, foodName, vote, price, sale, address FROM foodnews WHERE Category = 'Drink'");
$stmt ->execute();
$stmt -> bind_result($thumbail, $foodname, $foodrating, $price, $sales, $address);

$FoodListPHP = array();

while($stmt ->fetch()){

    $temp = array();
	
	$temp['img'] = $thumbail;
	$temp['foodName'] = $foodname;
	$temp['foodRating'] = $foodrating;
	$temp['price'] = $price;
	$temp['sales'] = $sales;
	$temp['address'] = $address;

	array_push($FoodListPHP,$temp);
	}

	echo json_encode($FoodListPHP);

?>