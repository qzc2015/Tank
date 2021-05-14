package com.qzc;

import java.awt.*;

/**
 * @author qzc
 * @create 2021-05-13 14:12
 */
public class Bullet {
	private int x,y;
	private final Dir dir;
	private static final int SPEED=10;
	public static int WIDTH = ResourceMgr.bulletD.getWidth();
	public static int HEIGHT = ResourceMgr.bulletD.getHeight();
	private boolean living = true;
	private final TankFrame tf;
	private Group group;
	public Bullet(int x,int y,Dir dir,Group group,TankFrame tf){
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
		this.group = group;
	}
	public void paint(Graphics g){
		if (!living) {
			tf.bullets.remove(this);
		}
		switch (dir){
			case LEFT:
				g.drawImage(ResourceMgr.bulletL,x,y,null);
				break;
			case RIGHT:
				g.drawImage(ResourceMgr.bulletR,x,y,null);
				break;
			case UP:
				g.drawImage(ResourceMgr.bulletU,x,y,null);
				break;
			case DOWN:
				g.drawImage(ResourceMgr.bulletD,x,y,null);
				break;
		}
		move();
	}
	public void move(){
		switch (dir){
			case LEFT:
				x-=SPEED;
				break;
			case RIGHT:
				x+=SPEED;
				break;
			case UP:
				y-=SPEED;
				break;
			case DOWN:
				y+=SPEED;
				break;
		}
		if (x<0 || y<0 || x> TankFrame.GAME_WIDTH || y> TankFrame.GAME_HEIGHT) living =false;
	}

	public void collideWith(Tank tank) {
		if (group == tank.getGroup())return;
		Rectangle rectangle1=new Rectangle(this.x,this.y,WIDTH,HEIGHT);
		Rectangle rectangle2=new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
		if (rectangle1.intersects(rectangle2)){
			die();
			tank.die();
		}
	}

	private void die() {
		this.living=false;
	}
}
