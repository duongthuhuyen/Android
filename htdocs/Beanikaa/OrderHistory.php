<?php

include('DataBase.php');

$stmt01 = $conn->prepare("SELECT idfoodNew, soluong FROM orders WHERE idUserName = 1");
$stmt01 ->execute();
$stmt01 -> bind_result($idfood, $amount);


$temp = array();
$products = array();
$listIDfood = array();
$listAmount = array();

while($stmt01 ->fetch()){
	array_push($listAmount,$amount);
	array_push($listIDfood,$idfood);
	}


for ($i = 0; $i<count($listIDfood); $i++) {
$stmt02 = $conn->prepare("SELECT thumbnail, foodname, vote, price FROM foodnews WHERE id = ".$listIDfood[$i]."");
$stmt02 ->execute();
$stmt02 -> bind_result($thumbnail, $foodname, $rating, $price);
  
while($stmt02 ->fetch()){

	
	$temp['img'] = $thumbnail;
	$temp['amount'] = $listAmount[$i];
	$temp['name'] = $foodname;
	$temp['price'] = $price;
	$temp['rating'] = $rating;

	array_push($products,$temp);
	}

	
}

echo json_encode($products);
?>