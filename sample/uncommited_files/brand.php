<?php
/**
 * User: Manchit Gupta
 * Date: 4/9/12
 * Time: 3:21 PM
 */
class brand extends CI_Controller
{
	function __construct(){
		parent::__construct();
		$this->load->helper('url');
		$this->load->helper('form');
		$this->load->helper(array('search_api','common','block'));
		$this->load->library('ArrayToXml');

		$this->load->model("seller_model");
		$this->load->model("user_model");
		$this->load->model("productcmsmodel");
	}

	function index(){
		@session_start();
		$aPrepFinalData = array();
		//$this->load->helper(array('block','common'));
		$this->load->driver('cache', array('adapter' => 'memcached', 'backup' => 'memcached'));
		$this->config->load('settings');
		$conf	= $this->config->config;
		$base_url = $conf['base_url'];
		if(empty($base_url))
			$base_url = 'http://www.tradus.com/';
		$base_path = $base_url;
		$aPrepFinalData['base_path']	= $base_path;
		$aPrepFinalData['baseURL']	= $base_path;
		$aPrepFinalData['conf']	= $conf;
		$aPrepFinalData['asset_version'] = $asset_version = asset_version();
		$aPrepFinalData['isLoggedIn'] = $_SESSION['isLoggedin'];
		$aPrepFinalData['loginFailed'] = $loginFailed;
		$_SESSION['cartCount']=isset($_SESSION['cartCount'])?$_SESSION['cartCount']:0;
		$aPrepFinalData['cartCount'] = $_SESSION['cartCount'];
		$aPrepFinalData['user']	= $_SESSION['user'];
		if(isset($_SESSION['user_name']) && !empty($_SESSION['user_name']))
			$aPrepFinalData['user_name']  = $_SESSION['user_name'];
		else
			$aPrepFinalData['user_name']  = 'Guest';
		$iUID	= '';
		if(isset($_SESSION['uid']) && !empty($_SESSION['uid']))
			$iUID	= $_SESSION['uid'];
		$aPrepFinalData['chkuid'] = $iUID;
		$structure = $this->cache->memcached->get('structure');
		if(empty($structure))
		{
			$structure = getSearchDropdownNew();
			$this->cache->memcached->save('structure', $structure, 86400);
		}
		$aPrepFinalData['structure'] = $structure;
		//for fb login
		$user_profile = 'fail';
		//Facebook Call Starts here
		$iFetchedUser = fetchFBUser();
		$aPrepFinalData['iFetchedUser']=$iFetchedUser;
		if ($iFetchedUser)
		{
			$user_profile = fetchFBUserProfile($iFetchedUser);
		}
		// Login or logout url will be needed depending on current user state.
		if ($user_profile == 'fail')
		{
			$url=$loginUrl = facebookLoginUrl();
			$aPrepFinalData['loginUrl']= $loginUrl;
		}
		//fb login ends here
		$list = get_block('sitedropdown');
		$aPrepFinalData['list'] = $list;
		$sReqPage	= '';

		if(isset($_GET['q']) && !empty($_GET['q']))
		{
			$sReqPage	= trim(strip_tags($_GET['q']));
			$sBlock	= 'static_'.trim(strip_tags($_GET['q']));
			if(isset($_GET["deleteCache"])){
				delete_block($sBlock);}
			else{
				$sFetchBlock = get_block($sBlock);
				$aToRemove = array('<?=$conf[\'cdn_url\']?>', '<?=$conf[\'base_url\']?>', '<?=$asset_version?>');
				$aWithRemove   = array($conf['cdn_url'], $conf['base_url'], $asset_version);
				$sFetchBlock = str_replace($aToRemove, $aWithRemove, $sFetchBlock);
				$aPrepFinalData['staticBlock']	= $sFetchBlock;
			}
			$sBlockSEO	= 'static_seo_'.trim(strip_tags($_GET['q']));
			if(isset($_GET["deleteCache"])){
				delete_block($sBlockSEO);}
			else{
				$sFetchBlockSEO = get_block($sBlockSEO);
				$aPrepFinalData['staticBlockSEO'] = $sFetchBlockSEO;}

			$sBlockScript	= 'static_script_'.trim(strip_tags($_GET['q']));
			if(isset($_GET["deleteCache"])){
				delete_block($sBlockScript);}
			else {
				$sFetchBlockScript = get_block($sBlockScript);
				$aPrepFinalData['staticBlockScript'] = $sFetchBlockScript;
			}
		}


		if(isset($_GET["deleteCache"]))
			return;


		$featured_product_strip_1 = getProductStripHtml_brand('test_brand_strip', FALSE);
		$data['featured_product_strip_1']=$featured_product_strip_1;

		$featured_product_strip_2 = getProductStripHtml_brand('test_brand_strip_1', TRUE);
		$data['featured_product_strip_2']=$featured_product_strip_2;

		$data['block'] = get_block('brandpage_samsung');
		$this->load->view('header1.phtml',$aPrepFinalData,$_SESSION);
		$this->load->view('brand/brandpage.phtml',$data);
		$this->load->view('footer.phtml',$aPrepFinalData,$_SESSION);

	}
}
