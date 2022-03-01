<?php
session_start();
?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Ví đụ</title>
</head>
<body>
	<form method="GET">
		<input type="text" name="name">
		<input type="text" name="pass">
		<input type="submit" name="btn">
	</form>

	<?php
		error_reporting(0);
		$con = mysqli_connect('localhost', 'root', '', 'accounts');
		$tendangnhap = $_GET['name'];
		$matkhau = $_GET['pass'];

		$query = "SELECT * FROM account WHERE tentaikhoan = '".$tendangnhap."'";

		$result = mysqli_query($con, $query);

		$row = mysqli_fetch_array($result);

		if ($matkhau == $row['matkhau'] && $matkhau != null) {
			
			$_SESSION['isLogin'] = true;
			$_SESSION['username'] = $tendangnhap;
			header('Location:logout.php');
			echo '<div style="color:red">Dang nhap ok!</div>';


		} else {
			$_SESSION['isLogin'] = false;
		}
		
		
	?>
</body>
</html>