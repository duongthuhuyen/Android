<?php
require_once('DataBase.php');
$db = new DataBase();
if(isset($_POST['foodID'])&&isset($_POST['customerID'])
 && isset($_POST['number'])){
   // $email = $_POST['email'];
    $foodID =$_POST['foodID'];
    $number = $_POST['number'];
   // $note = $_POST['note'];
    $customerID = $_POST['customerID'];
   // $telephone = $_POST['telephone'];
   // $address = $_POST['address'];
    if ($db->dbConnect()) {
        if ($db->addCart($foodID,$number,$customerID)) {

            echo "Add to cart Success";
        } else echo "Add to cart Failed";
    } else echo "Error: Database connection";
}else {echo "All fields are required";}
 