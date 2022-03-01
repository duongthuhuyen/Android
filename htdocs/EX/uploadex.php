<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Upload a file</title>
</head>
<body>

<form enctype="multipart/form-data" method="POST">
    <input type="file" name="myfile" />
    <input type="file" name="myfile" />
    <input type="file" name="myfile" />
    <input type="submit" value="Upload" name="submit">
</form>

<?php
	// $dir = "data/";
	// if ($_FILES['myfile']['name'] != "") 
	// {
	// 	$fileupload = $dir . $_FILES['myfile']['name'];

	// 	if (move_uploaded_file($_FILES['myfile']['tmp_name'], $fileupload)) 
	// 		{echo "Upload thành công!";}
	// 		else {echo "Upload ko thành công";}
	// }

	// else {echo "Vui lòng chọn file để upload";}

	foreach ($_FILES['myfile']['error'] as $key => $error) {
		if($error == 0)
		{
			$tmp_name = $_FILES['myfile']['tmp_name'][$key];
			$name = $_FILES['myfile']['name'][$key];
			move_uploaded_file($tmp_name, "data/$name");
		}
	}
?>
</body>
</html>