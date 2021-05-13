package com.qzc;

import java.awt.*;

/**
 * @author qzc
 * @create 2021-05-13 14:12
 */
public class Bullet {
	private int x,y;
	private Dir dir;
	private static final int SPEED=5,WIDTH = 30,HEIGHT = 30;
	private boolean live = true;
	private TankFrame tf;
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
		Color c = g.getColor();
		g.setColor(Color.red);
		g.fillOval(x,y,WIDTH,HEIGHT);
		g.setColor(c);
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
