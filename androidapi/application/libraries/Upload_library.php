<?php
// trong library vaf helpers muon load phai thong qua bien CI (bien sieu doi tuong)
class Upload_library{
	var $CI = '';// bien sieu doi tuong
	function __construct(){
		$this->CI = & get_instance();
	}
	// upload_path: ten duong dan
	// filename: ten the input(name)
	function upload($upload_path='',$filename){
		$config = $this->config($upload_path);
		$this->CI->load->library('upload',$config);
		$data = '';
		
		//echo var_dump($filename);
		if($this->CI->upload->do_upload($filename)){
			$data = $this->CI->upload->data();
		}else{
			$data =$this->CI->upload->display_errors();
		}
		return $data;
	}
	// cau hinh upload file
	function config($upload_path =''){
		$config = array();
		$config['upload_path']=$upload_path;
		$config['allowed_types']        = 'gif|jpg|png';
		$config['max_size']             = 10000;
		$config['max_width']            = 1028;
		$config['max_height']           = 1028;
		return $config;
	}
// ham upload nhieu file cung luc 
	function uploads($upload_path='',$filename){
		$config = $this->config($upload_path);
		$file = $_FILES[$filename];
		$count = count($file['name']);
		$image_list = array(); // luu cac file anh upload thanh cong
		for($i = 0;$i<$count;$i++){
			$_FILES['userfile']['name']= $file['name'][$i];
			$_FILES['userfile']['type']= $file['type'][$i];
			$_FILES['userfile']['tmp_name']= $file['tmp_name'][$i];
			$_FILES['userfile']['error']= $file['error'][$i];
			$_FILES['userfile']['size']= $file['size'][$i];
			
			$this->CI->load->library('upload',$config);
			if($this->CI->upload->do_upload()){
				$data = $this->CI->upload->data();
				$image_list[] =  $data['file_name'];
			}
		}
	
	return $image_list;
}
}  
?>
