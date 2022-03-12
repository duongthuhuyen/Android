<?php
class MY_Controller extends CI_Controller{
	public $data= array();
	public function __contruct(){
		parent:: __contruct();
		$controller = $this->uri->segment(1);
	/*	switch($controller){
			case "admin":
			{	
				$this->load->helper('admin');
				$this->check_login();
				break;
			}
			default :
			{
				break;
			}
		}*/
	}
/*	private function check_login(){
		$controller = $this->uri->rsegment(1);
		$controller = strtolower($controller);
		$check = $this->session->userdata('login');
		if($controller!='login'&&!$check){
			redirect(admin_url('login'));
		}
		if($controller == 'login'&& $check){
			redirect(admin_url('home'));
		}
	}*/
}
?>
