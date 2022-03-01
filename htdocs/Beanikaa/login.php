<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['phoneNumber']) && isset($_POST['password'])) {
    if ($db->dbConnect()) {
        if ($db->logIn("user", $_POST['phoneNumber'], $_POST['password'])) {
            echo "Dang nhap thanh cong!";
        } else echo "Tên đăng nhập hoặc mật khẩu sai, vui lòng xem lại";
    } else echo "Error: Database connection";
} else echo "Vui long dien day du thong tin";
?>
