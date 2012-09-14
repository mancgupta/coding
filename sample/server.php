<?php
	$db_connection = mysql_connect("localhost","tradus_user","tradus_user");
	mysql_select_db("TradusConfig", $db_connection);
	$query = "select * from groups";
	$groups = mysql_query($query);
	$query = "select * from configs";
	$configs = mysql_query($query);


while($group = mysql_fetch_array($groups))
{
echo "<h3>".$group['name']."</h3>";
echo "<table border='1'>
<tr>
<th>Key</th>
<th>Value</th>
</tr>";

while($config = mysql_fetch_array($configs))
{
if($config['group_id'] == $group['id'])
{
	echo "<tr><th>".$config['config_key']."</th><th>".json_decode($config['value'],true)."</th></tr>";
}	
}
echo "</table>";
}

mysql_close($db_connection);

?>
