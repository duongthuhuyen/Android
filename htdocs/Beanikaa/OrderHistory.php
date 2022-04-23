<?php

include('DataBase.php');

$user_id = $_POST['id'];
$id = (int)$user_id;

$stmt01 = $conn->prepare("SELECT idfoodNew, soluong FROM orders WHERE idUserName = ".$id." AND status = 1");
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
$stmt02 = $conn->prepare("SELECT thumbnail, foodname, vote, price, status FROM foodnews WHERE id = ".$listIDfood[$i]."");
$stmt02 ->execute();
$stmt02 -> bind_result($thumbnail, $foodname, $rating, $price, $status);
  
while($stmt02 ->fetch()){

	$temp['img'] = $thumbnail;
	$temp['amount'] = $listAmount[$i];
	$temp['name'] = $foodname;
	$temp['price'] = $price;
	$temp['rating'] = $rating;
	$temp['status'] = $status;

	array_push($products,$temp);
	}

	
}

echo json_encode($products);
?>