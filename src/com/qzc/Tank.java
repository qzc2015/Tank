package com.qzc;

import java.awt.*;

/**
 * @author qzc
 * @create 2021-05-13 11:49
 */
public class Tank {
	private int x,y;
	private Dir dir=Dir.DOWN;
	private static final int SPEED = 10;
	private boolean moving = false;
	public static int WIDTH=ResourceMgr.tankD.getWidth();
	public static int HEIGHT=ResourceMgr.tankD.getHeight();
	private TankFrame tf;

	public Tank(int x, int y, Dir dir,TankFrame tf) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
	}

	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public void paint(Graphics g) {
		switch (dir){
			case LEFT:
				g.drawImage(ResourceMgr.tankL,x,y,null);
				break;
			case RIGHT:
				g.drawImage(ResourceMgr.tankR,x,y,null);
				break;
			case UP:
				g.drawImage(ResourceMgr.tankU,x,y,null);
				break;
			case DOWN:
				g.drawImage(ResourceMgr.tankD,x,y,null);
				break;
		}

		move();
	}

	private void move() {
		if (!moving) return;
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
	}

	public void fire() {
		int bX=x+Tank.WIDTH/2-Bullet.WIDTH/2;
		int bY=y+Tank.HEIGHT/2-Bullet.HEIGHT/2;
		tf.bullets.add(new Bullet(bX,bY,dir,tf));
	}
}
