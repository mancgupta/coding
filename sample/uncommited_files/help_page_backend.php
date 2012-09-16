<!--
 * User: manchitgupta
 * Date: 18/8/12
 * Time: 8:00 PM
-->
<head>
    <title>
        <?=$title ?>
    </title>
</head>
<style type="text/css">
    .text{
        width: 100%;
    }
</style>
<body>
<!--    <script type="text/javascript" src = "//ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>-->
<script type="text/javascript" src= "<?=$cdn_url;?>sites/all/themes/basic/jquery-1.6.1.min.js"></script>

    <?php $attributes = array('id' => 'group_form'); ?>
    <?php echo form_open($base_url.'help_page', $attributes)?>
        <?php echo form_hidden("function","insert") ?>
            <div>
                <input type="text" class="text" id="question" name="question" placeholder = "Enter Question" /><br>
                <input type="text" class="text" id="answer" name="answer" placeholder = "Enter Answer"/><br>
                <input type="text" class="text" id="parent" name="parent" placeholder = "Enter Parent ID"/><br>
                <input type="button" value="submit" class = "submit">
            </div>
    </form>
	<div class="main">
		<ul>
			<?php
				foreach($main_groups->result() as $group){
					echo "<li><h3 class='group' id = '0'name = ".$group->id.">".$group->question."</h3></li>";
					echo "<h3 class = 'answer' id = '0' name = ".$group->id.">".$group->answer."</h3>";
					echo "<div class = 'child' id = '0 ' name = ".$group->id."></div>";
				}
			?>
		</ul>
    </div>
<script type="text/javascript" src= "<?=$cdn_url;?>sites/all/themes/basic/ci_js/help_page.js"></script>
</body>
