<?php
	function convert_value($value) {
		if($value == '' || $value == null)
			return $value;

		$elements = explode(",",$value);

		$pairs = null;
	
		$temp = explode(":",$elements[0]);

		if(count($temp) == 1){
			if(count($elements) == 1)
				return $value;
			for($i=0;$i<count($elements);$i++){
				$pairs[$i] = $elements[$i];
			}
		}
		else{
			for($i=0;$i<count($elements);$i++){
				$temp = explode(":",$elements[$i]);
				$pairs[$temp[0]] = $temp[1];
			}
		}
	
		return $pairs;
	}
	
	$p = convert_value(10800);
	$t = json_encode($p);
	$x = json_decode($t,true);
	$y = serialize($p);
	$z = unserialize($y);
	print_r($p);
	echo "\n";
	print_r($t);
	echo "\n";
	print_r($x);
	echo "\n";
	print_r($y);
	echo "\n";
	print_r($z);
	echo "\n";
	

?>

