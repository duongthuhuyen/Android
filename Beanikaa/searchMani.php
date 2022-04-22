<?php

include('DataBase.php');
if(isset[$_POST['key']]){
$key = $_POST['key'];
$stmt = $conn->prepare("SELECT * FROM `foodnews` WHERE foodName ='".$key."'");
$stmt ->execute();
$stmt -> bind_result($id,$thumbnal, $foodname,$idRestaurant,$vote,$status,$price,$sale,$dateFrom,$dateTo,$Category,$idCategory,$priority);

$FoodListPHP = array();

while($stmt ->fetch()){

    $temp = array();
	$temp['id'] = $id;
	$temp['thumbnal'] = $thumbnal;
	$temp['foodName'] = $foodname;
    $temp['idRestaurant'] = $idRestaurant;
    $temp['status'] = $status;
    $temp['price']= $price;
    $temp['dateFrom']=$dateFrom;
    $temp['dateTo']=$dateTo;
    $temp['Category']=$Category;
    $temp['idCategory']= $idCategory;
    $temp['priority'] = $priority;
	$temp['vote'] = $vote;
	$temp['sales'] = $sales;

	array_push($FoodListPHP,$temp);
	}

	echo json_encode($FoodListPHP);
}

?>
