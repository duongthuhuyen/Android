<?php

include('DataBase.php');

$stmt = $conn->prepare("SELECT id, thumbnail, foodName, vote, price, sale, address FROM foodnews");
$stmt ->execute();
$stmt -> bind_result($id, $thumbnail, $foodname, $foodrating, $price, $sales, $address);

$FoodListPHP = array();

while($stmt ->fetch()){

    $temp = array();
	
	$temp['id'] = $id;
	$temp['img'] = $thumbnail;
	$temp['foodName'] = $foodname;
	$temp['foodRating'] = $foodrating;
	$temp['price'] = $price;
	$temp['sales'] = $sales;
	$temp['address'] = $address;

	array_push($FoodListPHP,$temp);
	}

	echo json_encode($FoodListPHP);

?>