package com.qzc;

import java.awt.*;

/**
 * @author qzc
 * @create 2021-05-13 14:12
 */
public class Bullet {
	private int x,y;
	private Dir dir;
	private static final int SPEED=5,WIDTH = 30,HEGHT = 30;

	public Bullet(int x,int y,Dir dir){
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	public void paint(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.red);
		g.fillOval(x,y,WIDTH,HEGHT);
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
	}

}
