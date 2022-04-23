<?php

include('DataBase.php');
	$stmt = $conn->prepare("SELECT * FROM `foodnews` WHERE foodName like'"."Mi"."'");
	$stmt ->execute();
	$stmt -> bind_result($id,$thumbnail, $foodname,$idRestaurant,$vote,$status,$price,$sales,$dateFrom,$dateTo,$Category,$idCategory,$address,$priority, $imagelist);

	$FoodListPHP = array();

	while($stmt ->fetch()){

	    $temp = array();
		$temp['id'] = $id;
		$temp['img'] = $thumbnail;
		$temp['foodName'] = $foodname;
	    $temp['idRestaurant'] = $idRestaurant;
	    $temp['status'] = $status;
	    $temp['price']= $price;
	    $temp['dateFrom']=$dateFrom;
	    $temp['dateTo']=$dateTo;
	    $temp['Category']=$Category;
	    $temp['idCategory']= $idCategory;
	    $temp['priority'] = $priority;
	    $temp['address'] = $address;
		$temp['foodRating'] = $vote;
		$temp['sales'] = $sales;

		array_push($FoodListPHP,$temp);
		}

		echo json_encode($FoodListPHP);

?>
