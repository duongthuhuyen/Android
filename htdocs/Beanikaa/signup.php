<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['fullname']) && isset($_POST['email']) && isset($_POST['username']) && isset($_POST['password'])) {
    if ($db->dbConnect()) {
        if ($db->signUp("user", $_POST['fullname'], $_POST['email'], $_POST['username'], $_POST['password'])) {
            echo "Đăng ký thành công!";
        } else echo "Đăng ký không thành công, xin thử lại sau";
    } else echo "Error: Database connection";
} else echo "Vui lòng điền đủ thông tin";
?>
