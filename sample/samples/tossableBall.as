package {
	import flash.display.Sprite;
	import flash.events.Event;
	import flash.geom.Point;
	import flash.geom.Rectangle;
	import flash.utils.Proxy;
	import flash.utils.flash_proxy;
	import flash.display.Stage;
	import flash.display.StageAlign;
	import flash.display.StageScaleMode;

	public class tossableBall extends Sprite {
		
		private var vector:Point = new Point();
		private var friction:Number = .95;
		private var stageRef:Stage;

		public function tossableBall(size:Number, stageRef : Stage) {
			this.stageRef = stageRef;
			graphics.lineStyle(1);
			graphics.beginFill(0xFF80F0);
			graphics.drawCircle(0, 0, size/2);
			
		}
		
		public function toss(tossVector:Point):void {
			vector = tossVector;
		}
	}
}
