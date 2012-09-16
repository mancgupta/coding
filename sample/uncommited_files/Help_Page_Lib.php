<?php
/**
 * User: manchitgupta
 * Date: 22/8/12
 * Time: 4:39 PM
 */
class Help_Page_Lib
{
	public function __construct(){
		$this->QA = $this->load->model('help_page_model');
		$this->user = $this->load->model('User_feedback');
	}

	function insert(){

	}

	function getPriority(){
		$query = $this->user->getPriority();

	}
}
