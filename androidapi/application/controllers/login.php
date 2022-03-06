<?php
class login extends MY_Controller{
	function __construct(){
		parent:: __construct();
		$this->load->model('User_Model');
	}
	function index(){
		if(isset($_POST['password'])&&isset($_POST['phoneNumber'])){
		$password = $_POST['password'];
		$phone = $_POST['phoneNumber'];
		
		$user = array(
			'password'=> $password,
			'phoneNumber'=>$phone,
			'idRole' =>0
		);

		if($this->User_Model->check_exists($user)){
			$input = array();
			$list = $this->User_Model->get_list($input);
			echo json_encode($list[0]);
		}else{
			echo null;
		}
	}else{
		echo "No thing";
	}
	}
	
}
?>
