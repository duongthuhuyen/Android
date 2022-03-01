<?php
session_start();
?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Log out</title>
</head>
<body>
	<h1>HELLO USER:</h1>
	<?php
	echo '<div style="color:red; font-size: 300%;">'.$_SESSION['username'].'</div>';
	?>
</body>
</html>