<?php
class register extends MY_Controller{
	function __construct(){
		parent:: __construct();
		$this->load->model('User_Model');
	}
	function index(){
		if(isset($_POST['password'])&&isset($_POST['phoneNumber'])&&isset($_POST['email'])){
		$password = $_POST['password'];
		$phone = $_POST['phoneNumber'];
		$email = $_POST['email'];
		
		$user = array(
			'password'=> $password,
			'phoneNumber'=>$phone,
			'email'=>$email,
			'idRole' =>0
		);

		if($this->User_Model->create($user)){
			//$input = array();
			$list = $this->User_Model->get_list_set_input($user);
			echo json_encode($list[0]);

			//echo "Đăng ký thành công";
		}else{
			echo null;
		}
	}else{
		echo "No thing";
	}
	}
	
}
?>
