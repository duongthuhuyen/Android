<?php
class user extends MY_Controller{
	function __construct(){
		parent:: __construct();
		$this->load->model('User_Model');
	}
	function add(){
		$password = $_POST['password'];
		$email = $_POST['email'];
		$phone = $_POST['phoneNumber'];
		
		$user = array(
			
			'password'=> $password,
			'email'=>$email,
			'phoneNumber'=>$phone,
			'created_date'=>  date("Y-m-d h:i:sa")
			'idRole'=>0
		)

		if($this->User_Model->create($user)){
			echo "true";
		}else{
			echo "false";
		}
	}
	
}
?>
