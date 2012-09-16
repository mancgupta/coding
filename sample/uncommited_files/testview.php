<!--/**-->
<!-- * User: manchitgupta-->
<!-- * Date: 22/8/12-->
<!-- * Time: 11:59 AM-->
<!-- */-->
<title>test Page</title>
<body>
<script type="text/javascript" src= "<?=$cdn_url;?>sites/all/themes/basic/jquery-1.6.1.min.js"></script>
<script type="text/javascript" src= "<?=$cdn_url;?>sites/all/themes/basic/ci_js/jquery.js"></script>
<script type="text/javascript" src= "<?=$cdn_url;?>sites/all/themes/basic/ci_js/jquery.treeview.async.js"></script>
<script type="text/javascript" src= "<?=$cdn_url;?>sites/all/themes/basic/ci_js/jquery.treeview.edit.js"></script>
<script type="text/javascript" src= "<?=$cdn_url;?>sites/all/themes/basic/ci_js/jquery.treeview.js"></script>
<script type="text/javascript" src= "<?=$cdn_url;?>sites/all/themes/basic/ci_js/jquery.treeview.sortable.js"></script>
<script type="text/javascript">
	function initTrees() {

		$("#black").treeview({
			url: "<?=$cdn_url; ?>tradusnew/ci/application/views/source.php"
		})

		$("#mixed").treeview({
			url: "<?=$cdn_url; ?>tradusnew/ci/application/views/source.php",
			// add some additional, dynamic data and request with POST
			ajax: {
				data: {
					"additional": function() {
						return "yeah: " + new Date;
					}
				},
				type: "post"
			}
		});
	}

	$(document).ready(function(){
		initTrees();
		$("#refresh").click(function() {
			$("#black").empty();
			$("#mixed").empty();
			initTrees();
		});
	});
</script>

<h1 id="banner"><a href="http://bassistance.de/jquery-plugins/jquery-plugin-treeview/">jQuery Treeview Plugin</a> Demo</h1>
<div id="main">

	<ul>
		<li><a href=".">Main Demo</a></li>
		<li><a href="<?=$cdn_url; ?>tradusnew/ci/application/views/source.phps">Server component used</a></li>
	</ul>

	<h4>Lazy-loading tree</h4>

	<ul id="black">
	</ul>

	<h4>Mixed pre and lazy-loading</h4>

	<ul id="mixed">
		<li><span>Item 1</span>
			<ul>
				<li><span>Item 1.0</span>
					<ul>
						<li><span>Item 1.0.0</span></li>
					</ul>
				</li>
				<li><span>Item 1.1</span></li>
			</ul>
		</li>
		<li id="36" class="hasChildren">
			<span>Item 2</span>
			<ul>
				<li><span class="placeholder">&nbsp;</span></li>
			</ul>
		</li>
		<li>
			<span>Item 3</span>
		</li>
	</ul>

	<button id="refresh">Refresh both Trees</button>

</div>
</body>