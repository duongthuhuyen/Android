<?php
require_once('DataBase.php');
$db = new DataBase();

if(isset($_POST['number'])){
    $number = (int) $_POST['number'];
    $IDArray = array();
    for($i = 0;$i<$number;$i++){
        $IDArray[$i]= $_POST['id_'.$i];
    }
    if(isset($_POST['note'])&& isset($_POST['telephone']) && isset($_POST['address'])){
       //$email = $_POST['email'];
      // $foodID =$_POST['foodID'];
      // $idOrder = $_POST['idOrder'];
       $note = $_POST['note'];
      // $customerID = $_POST['userID'];
      $telephone = $_POST['telephone'];
      $address = $_POST['address'];
      if ($db->dbConnect()) {
        $check = true;
        for($i = 0 ;$i<$number;$i++){
        if ($db->order($IDArray[$i],$telephone,$address,$note)) {

            //echo "Order Success";
        } else{
            $check = false;
        }}
        if($check == true){
            echo "Order Success";
        }else{
            echo "Order False";
        }
    } else echo "Error: Database connection";
    }else {echo "All fields are required";}
}else{
    echo "All fields are required";
}
