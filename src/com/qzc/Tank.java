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
		Color c = g.getColor();
		g.setColor(Color.yellow);
		g.fillRect(x,y,50,50);
		g.setColor(c);
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
		tf.bullets.add(new Bullet(x,y,dir,tf));
	}
}
