<?php

include('DataBase.php');
if(isset($_POST['userID'])){
$userid = (int) $_POST['userID'];
$stmt = $conn->prepare("SELECT o.idOrder,f.foodName,f.price,o.idfoodNew,o.soluong FROM orders as o INNER JOIN `foodnews` as f ON o.idfoodNew = f.id WHERE o.idUserName =".$userid." AND o.status = 0;");
$stmt ->execute();
$stmt -> bind_result($idOrder,$foodName,$price,$idFoodNew,$number);

$FoodListPHP = array();

while($stmt ->fetch()){

    $temp = array();
	$temp['price'] = $price;
	$temp['idOrder'] = $idOrder;
	$temp['foodName'] = $foodName;
	$temp['idFoodNew'] = $idFoodNew;
	$temp['number'] = $number;

	array_push($FoodListPHP,$temp);
	}

	echo json_encode($FoodListPHP);
}
?>