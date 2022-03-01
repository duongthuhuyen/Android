<?php
session_start();
if (isset($_SESSION['count']))
	$_SESSION['count'] = $_SESSION['count'] + 1;
else 
	$_SESSION['count'] = 1;

echo 'Bạn đã truy cập '.$_SESSION['count'].' lần'
?>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Hehe</title>
</head>
<body>
	<button value = "Reset" type="button" onclick="resetsession()">Reset</button>

	<?php
	function resetsession(){
		$_SESSION['count'] = 0;
	}
	?>
</body>
</html>