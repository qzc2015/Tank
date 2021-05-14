package com.qzc;

import java.awt.*;

/**
 * @author qzc
 * @create 2021-05-13 14:12
 */
public class Bullet {
	private int x,y;
	private final Dir dir;
	private static final int SPEED=10,WIDTH = 30,HEIGHT = 30;
	private boolean live = true;
	private final TankFrame tf;
	public Bullet(int x,int y,Dir dir,TankFrame tf){
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf=tf;
	}
	public void paint(Graphics g){
		if (!live) {
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
		if (x<0 || y<0 || x> TankFrame.GAME_WIDTH || y> TankFrame.GAME_HEIGHT) live=false;
	}

}
