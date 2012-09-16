<?php
/**
 * User: manchitgupta
 * Date: 22/8/12
 * Time: 10:24 AM
 */
class User_feedback extends CI_Model
{
	function __construct(){
		parent::__construct();
		$this->db_master = $this->load->database('default', TRUE);
		$this->db_slave  = $this->load->database('readonly', TRUE);
	}

	function insert($qid, $uid, $feedback){
		$value = array(
			'question_id' => $qid,
			'uid'   => $uid,
			'feedback'   => $feedback
		);
		$this->db_master->set('created_at', 'NOW()', FALSE);
		$this->db_master->insert('help_page_user_feedback', $value);
	}

	function getPriority($qid){
		$this->db_slave->where('question_id',$qid);
		$query = $this->db_slave->get('help_page_user_feedback');
		return $query;
	}

}
