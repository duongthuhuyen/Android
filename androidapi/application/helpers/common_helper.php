<?php
function public_url($url = ''){
	return base_url('public/'.$url);
}
function pre($data,$exit = true){
	echo "<pre>";
	print_r($data);
	if($exit){
		die();
	}
}
function countFile($path =''){
	$directory = getcwd().$path;
 
	// Initialize filecount variable
	$filecount = 0;
	 
	$files2 = glob( $directory ."*" );
	 
	if( $files2 ) {
		$filecount = count($files2);
	}
	return $filecount;
}
?>
