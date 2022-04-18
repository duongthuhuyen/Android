<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['email']) && isset($_POST['phoneNumber']) && isset($_POST['password'])) {
    if ($db->dbConnect()) {
        if ($db->signUp("user", $_POST['password'], $_POST['email'], $_POST['phoneNumber'])) {
            echo "Sign Up Success";
        } else echo "Sign up Failed";
    } else echo "Error: Database connection";
} else echo "All fields are required";
?>
