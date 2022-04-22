<?php

include('DataBase.php');
if(isset($_POST['userID'])){
    $userid = (int) $_POST['userID'];
$stmt = $conn->prepare("SELECT idOrder,idfoodNewsoluong,foodname FROM order inner join foodnews on idfoodNew = foodnews.id and idUserName =".$userid." and status = 0");
$stmt ->execute();
$stmt -> bind_result($idOrder,$idFoodNews,$soluong,$foodname);

$FoodListPHP = array();

while($stmt ->fetch()){

    $temp = array();
	$temp['idOrder'] = $idOrder;
	$temp['foodName'] = $foodname;
	$temp['idFoodNew'] = $idFoodNews;
	$temp['number'] = $soluong;

	array_push($FoodListPHP,$temp);
	}

	echo json_encode($FoodListPHP);
}
?>