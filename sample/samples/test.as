package {
	import flash.display.Sprite;
	import flash.events.Event;
	import flash.events.MouseEvent;
	import flash.geom.Point;
	import flash.geom.Rectangle;
	import flash.events.KeyboardEvent;
	import flash.ui.Keyboard;
	import flash.utils.Proxy;
	import flash.utils.flash_proxy;
	import flash.display.Stage;
	import flash.display.StageAlign;
	import flash.display.StageScaleMode;


	public class test extends Sprite{
		private var player:Player;
		private var ball : tossableBall;
		private var xx:Number = 1;
		private var yy:Number = 1;
		public function test(){
			stage.align = StageAlign.TOP_LEFT;
			player = new Player(stage);
			player.x = stage.stageWidth / 2;
			player.y = stage.stageHeight / 2;

			ball = new tossableBall (8, stage);
			ball.x = stage.stageWidth / 2;
			ball.y = stage.stageHeight / 2;
			addEventListener(Event.ENTER_FRAME, soar, false, 0, true);
			stage.addChild(player);
			stage.addChild(ball);
		}
		
		private function keyReleased(evt:KeyboardEvent):void {
			//delete keysDown[evt.keyCode];
		}
		
		private function soar (evt:Event):void {
			ball.x += xx;
			ball.y += yy;
			if(player.imageLoader.x - ball.x > -3 && player.imageLoader.x - ball.x < 3)
				yy = -yy;
			if(ball.x > stage.stageWidth || ball.x >stage.stageHeight)
				xx = -xx;
		}
		
	}
}

import flash.display.Sprite;
import flash.events.Event;
import flash.geom.Point;
import flash.geom.Rectangle;
import flash.display.Loader;
import flash.net.URLRequest;
import flash.events.KeyboardEvent;
import flash.ui.Keyboard;
import flash.utils.Proxy;
import flash.utils.flash_proxy;
import flash.display.Stage;
import flash.display.StageAlign;
import flash.display.StageScaleMode;


class Player extends Sprite{
	public var imageLoader:Loader;
	private var court:Loader;
	private var stageRef:Stage;
	private var key:KeyObject;
	private var speed:Number = 5;
	private var vx:Number = 0;
	private var vy:Number = 0;
	private var friction:Number = 0.93;
	
	public function Player(stageRef : Stage){
		
		this.stageRef = stageRef;
		key = new KeyObject(stageRef);

		imageLoader = new Loader();
		court = new Loader();
		court.load(new URLRequest("tennis_court.png"));
		imageLoader.load(new URLRequest("tennis.png"));

		//imageLoader.x = -150;
		//imageLoader.y = -150;
		addEventListener(Event.ENTER_FRAME, loop, false, 0, true);
		stageRef.addChild(court);
		stageRef.addChild(imageLoader);
	}

	public function loop(e:Event) : void
	{
		vx = 0;
		vy = 0;
		if (key.isDown(Keyboard.LEFT)) 
			vx -= speed;
		else if (key.isDown(Keyboard.RIGHT))
			vx += speed;
		else
			vx *= friction;
		
		if (key.isDown(Keyboard.UP))
			vy -= speed;
		else if (key.isDown(Keyboard.DOWN))
			vy += speed;
		else
			vy *= friction;
			
		imageLoader.x += vx;
		imageLoader.y += vy;
		imageLoader.width = 100;
		imageLoader.height = 100;
	}		
}
