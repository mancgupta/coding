<!--
/**
 * User: manchitgupta
 * Date: 19/8/12
 * Time: 10:07 AM
 */
 -->
<title>
	<?=$title ?>
</title>

<style type="text/css">
	.group
	{
		color: blue;
	}
	.answer
	{
		display: none;
		padding-left: 35px;
	}
	.red{ background-color: red; display: inline; border: none; color: #ffffff;}
	.green{background-color: #008000; display: inline; border: none; color: #ffffff;}
</style>
<script type="text/javascript" src = "//ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		//script for shows child
//		for(var i=1;i<5;i++)
//			$("."+i).hide();
//		$(".group").click(function(){
//			var id = $(this).attr('id');
//			var cc = $(this).attr('name');
//			var x = parseInt(cc) + 1;
//			$("."+x).toggle();
//			$(".answer#"+id).toggle("fast");
//		});
		//script for show child
//		$(".group#"+0).show();
//		$(".group").click(function(){
//			var id = $(this).attr('id');
//			var name = $(this).attr('name');
//			$(".group#"+name).toggle("fast");
//			$(".answer#"+id).toggle("fast");
//		});

		// script to hide all childs in show child
		$(".group:not(#0)").hide();
		$(".group").click(function(){
			var id = $(this).attr('id');
			var name = $(this).attr('name');
			if($(".group#"+name).is(":visible") == false){
				if($(".group#"+name).css("display") == 'none'){
					$(".group#"+name).show();
					$(".answer#"+id).show();
				}
				else{
					$(".group#"+name).toggle();
					$(".answer#"+id).toggle();
				}
			}
			else if($(".group#"+name).is(":visible") == true){
				$(".answer#"+id).hide();
				$(".help#"+name).find(".group").hide();
				$(".help#"+name).find(".answer").hide();
				//$(".group#"+name).hide();
			}
			else{
				$(".answer#"+id).toggle();
			}
		});



		// script for display child
//		$(".group").click(function(){
//			var id = $(this).attr('id');
//			$(".answer#"+id).toggle("fast");
//			$.get("/tradusnew/ci/index.php/help_page/getGroups",{"id":id},function(data){
//				$(".child#"+id).html(data);
//			});
//		});
//		$.get("/tradusnew/ci/index.php/help_page/submit_form",{"question":que,"answer":ans,"parent":par},function(){
//			$.get("/tradusnew/ci/index.php/help_page/getGroups", function(data){
//				$(".groups").html(data);
//			});
//		});

		$("input").click(function(){
			$("input").hide();
		});

	});
</script>

<body>
	<div class="main">
		<?php showchild(0,$groups,0) ?>
	</div>

	<p>was this helpful</p>
	<?php $attributes = array('id' => 'form'); ?>
	<?php echo form_open('',$attributes) ?>
		<input type = 'button' class='green' value = 'YES'>
		<input type = 'button' class='red' value = 'NO'>
	</form>
	<?php
//		function showchild($id, $groups,$shift){
//			echo "<div class='help' id = ".$id.">";
//			echo "<ul class = 'help'>";
//			foreach($groups->result() as $group){
//				if($group->parent == $id){
//					echo "<li class = 'group'><div class = 'group' id = ".$group->id." style = 'padding-left:".$shift."px'>
//						<h3>".$group->question."</h3>
//						</div></li>";
//					echo "<div class = 'answer' id = ".$group->id." style = 'padding-left:".$shift."px'>
//						<h3>".$group->answer."</h3>
//						</div>";
////					echo "<div class = 'child' id = ".$group->id." style = 'padding-left:".$shift."px'>".
////						showchild($group->id,$groups,$shift+70)
////						."</div>";
//					showchild($group->id, $groups, $shift + 70);
//				}
//			}
//			echo "</ul></div>";
//		}

		// Second version
		function showchild($id, $groups, $shift){
			echo "<div class='help' id = ".$id.">";
			echo "<ul>";
			foreach($groups->result() as $group){
				if($group->parent == $id){
					echo "<li class='group' id = ".$id." name = ".$group->id."><h3>".$group->question."</h3></li>";
					echo "<h3 class = 'answer' id = ".$id." name = ".$group->id.">".$group->answer."</h3>";
					showchild($group->id, $groups,$shift);
				}
			}
			echo "</ul></div>";
		}
	?>
	<?php
	function showchilds($id, $groups,$shift,$level){
		echo "<div class='help' id = ".$id.">";
		echo '<ul>';
		foreach($groups->result() as $group){
			if($group->parent == $id){
				echo "<li class = '".$level."'><div class = 'group' name = '".$level."'id = ".$group->id." style = 'padding-left:".$shift."px'>
						<h3>".$group->question."</h3>
						</div></li>";
				echo "<div class = 'answer' id = ".$group->id." style = 'padding-left:".($shift+70)."px'>
						<h3>".$group->answer."</h3>
						</div>";
//					echo "<div class = 'child' id = ".$group->id." style = 'padding-left:".$shift."px'>".
//						showchild($group->id,$groups,$shift+70)
//						."</div>";
				showchilds($group->id, $groups, $shift + 70,$level + 1);
			}
		}
		echo "</ul></div>";
	}
	?>
	<?php
		function displaychild($id, $groups,$shift){
			foreach($groups->result() as $group){
				echo "<div class='help' id = ".$group->id.">";
				echo '<ul>';
				if($group->parent == $id){
					echo "<li><div class = 'group' id = ".$group->id." style = 'padding-left:".$shift."px'>
						<h3>".$group->question."</h3>
						</div></li>";
					echo "<div class = 'answer' id = ".$group->id." style = 'padding-left:".$shift."px'>
						<h3>".$group->answer."</h3>
						</div>";
					echo "<div class = 'child' id = ".$group->id." style = 'padding-left:".$shift."px'>
						</div>";
				}
				echo "</ul></div>";
			}
		}
	?>
</body>


