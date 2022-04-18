<?php
require_once('DataBase.php');
$db = new DataBase();
$email = $this->input->post('email');
		$foodID = $this->input->post('foodID');
		$number = $this->input->post('number');
		$note = $this->input->post('note');
		$customerID = $this->input->post('customerID');
		$telephone = $this->input->post('telephone');
		$address = $this->input->post('address');
if(isset($_POST['email'])&& isset($_POST['foodID'])&& isset($_POST['number'])&& isset($_POST['note'])&& isset($_POST['customerID'])
 && isset($_POST['telephone'])&& isset($_POST['address'])){
    $email = $_POST['email'];
    $foodID =$_POST['foodID'];
    $number = $_POST['number'];
    $note = $_POST['note'];
    $customerID = $_POST['customerID'];
    $telephone = $_POST['telephone'];
    $address = $_POST['address'];
    if ($db->dbConnect()) {
        if ($db->order($email,$foodID,$number,$note,$customerID,$telephone,$address)) {

            echo "Order Success";
        } else echo "Order Failed";
    } else echo "Error: Database connection";
}else {echo "All fields are required";}
 