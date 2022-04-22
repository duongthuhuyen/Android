<?php
require_once('DataBase.php');
if(isset($_POST['idOrder']) && isset($_POST['note'])
&& isset($_POST['telephone']) && isset($_POST['address'])){
       //$email = $_POST['email'];
      // $foodID =$_POST['foodID'];
       $idOrder = $_POST['idOrder'];
       $note = $_POST['note'];
      // $customerID = $_POST['userID'];
      $telephone = $_POST['telephone'];
      $address = $_POST['address'];
      if ($db->dbConnect()) {
        if ($db->addCart($foodID,$number,$customerID)) {

            echo "Order Success";
        } else echo "Order Failed";
    } else echo "Error: Database connection";
}else {echo "All fields are required";}