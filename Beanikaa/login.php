<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['email']) && isset($_POST['password'])) {
    if ($db->dbConnect()) {
        if ($db->logIn("user", $_POST['email'], $_POST['password'])) {
            echo "Login Success!";
        } else echo "Sai thong tin dang nhap";
    } else echo "Error: Database connection";
} else echo "All fields are required";
?>
