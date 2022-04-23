<?php
require "DataBaseConfig.php";

$conn = mysqli_connect("localhost","root","","beanikaa");

class DataBase
{
    public $connect;
    public $data;
    private $sql;

    protected $servername;
    protected $username;
    protected $password;
    protected $databasename;

    public $dpId;

    public function __construct()
    {
        $this->connect = null;
        $this->data = null;
        $this->sql = null;
        $dbc = new DataBaseConfig();
        $this->servername = $dbc->servername;
        $this->username = $dbc->username;
        $this->password = $dbc->password;
        $this->databasename = $dbc->databasename;
    }

    function dbConnect()
    {
        $this->connect = mysqli_connect($this->servername, $this->username, $this->password, $this->databasename);
        return $this->connect;
    }

    function prepareData($data)
    {
        return mysqli_real_escape_string($this->connect, stripslashes(htmlspecialchars($data)));
    }

    function logIn($table, $email, $password)
    {
        $account_info = array();


        $email = $this->prepareData($email);
        $password = $this->prepareData($password);

        $this->sql = "select * from " . $table . " where email = '" . $email . "'";

        $result = mysqli_query($this->connect, $this->sql);
        $row = mysqli_fetch_assoc($result);
        

        if (mysqli_num_rows($result) != 0) {
            $dbemail = $row['email'];
            $dbpassword = $row['password'];
            if ($email == $dbemail && password_verify($password, $dbpassword)) {
    
                $account_info['id'] = $row['id'];
                $account_info['email'] = $row['email'];
                $account_info['phonenumber'] = $row['phoneNumber'];
                
            }
        }
        return $account_info;
    }

    function signUp($table, $password, $email, $phonenumber )
    {
        $table = $this->prepareData($table);
        // $username = $this->prepareData($username);
        $phonenumber = $this->prepareData($phonenumber);
        $email = $this->prepareData($email);
        $password = password_hash($password, PASSWORD_DEFAULT);
        $this->sql =
            "INSERT INTO " . $table . " (password, email, phoneNumber) VALUES ('" . $password . "','" . $email . "','" . $phonenumber . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }

    function addCart($foodID,$number,$customerID){
      //  $email = $this->prepareData($email);
        $foodID = $this->prepareData($foodID);
        $number = $this->prepareData($number);
        //$note = $this->prepareData($note);
        $customerID = $this->prepareData($customerID);
        //$telephone = $this->prepareData($telephone);
        //$address = $this->prepareData($address);

        $this->sql = "INSERT INTO orders(`idUserName`, `idfoodNew`, `soluong`, `address`, `phoneNumber`, `Note`, `status`) VALUES ('".$customerID."','".$foodID."','".$number."','','','',0)";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }

    function order($idOrder,$telephone,$address,$note){
        $this->sql = "UPDATE orders set address ='".$address."', phoneNumber = '".$telephone."',Note = '".$note."',status = 1 where idOrder =".(int) $idOrder;
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }

    function search($key){
        $this->sql = "SELECT * FROM `foodnews` WHERE foodName='".$key."'";
        
    }


}

?>
