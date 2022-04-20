<?php
require "DataBase.php";
$db = new DataBase();
$email = "Huyen@email.com";
$pass = "Aa123456@";
if ($db->dbConnect()) {
	echo json_encode($db->logIn("user", $email, $pass));
}
?>