<?php
class Help_page_model extends CI_Model {
	function __construct(){
		parent::__construct();
        $this->db_master = $this->load->database('default', TRUE);
        $this->db_slave  = $this->load->database('readonly', TRUE);
    }
	
	function insert($question, $answer, $parent){
		$value = array(
				'question' => $question,
				'answer'   => $answer,
				'parent'   => $parent
		);
        $this->db_master->set('created_at', 'NOW()', FALSE);
        $this->db_master->insert('QA', $value);
	}
	
	function getAllQuestions() {
		$questions = $this->db_slave->get('QA');
		return $questions;
	}
	
	function getQuestions($parent) {
		$this->db_slave->where('parent',$parent);
		$questions = $this->db_slave->get('QA');
		return $questions;
	}
	
	function update($id, $question, $answer, $parent){
		$value = array(
				'question' => $question,
				'answer'   => $answer,
				'parent'   => $parent,
		);
		$this->db_master->where('id',$id);
        $this->db_master->set('updated_at', 'NOW()', FALSE);
        $this->db_master->update('QA',$value);
	}

    function delete($id){
        $this->db_master->where('id', $id);
        $this->db_master->delete('QA');
        $this->deleteChild($id);
    }

    function deleteChild($id){
        $this->db_master->where('parent',$id);
        $query = $this->db_master->get('QA');

        foreach($query->result() as $row){
            $this->delete($row->id);
        }
    }
}