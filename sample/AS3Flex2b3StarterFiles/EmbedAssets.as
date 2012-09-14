package {
	import flash.display.Sprite;
	public class EmbedAssets extends Sprite {
		
		[Embed(source="images/trophy.png")]
		private var TrophyImage:Class;
			
		[Embed(source="swfs/satdish.swf")]
		private var SatelliteAnimation:Class;

		public function EmbedAssets() {
			addChild(new SatelliteAnimation());
			addChild(new TrophyImage());
		}
		
	}
}