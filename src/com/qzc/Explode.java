package com.qzc;

import java.awt.*;

/**
 * @author qzc
 * @create 2021-05-13 11:49
 */
public class Explode extends GameObject{
	private int x,y;
	public static int WIDTH=ResourceMgr.explodes[0].getWidth();
	public static int HEIGHT=ResourceMgr.explodes[0].getHeight();
	private GameModel gm;
	private boolean living = true;
	private int step=0;


	public Explode(int x, int y, GameModel gm) {
		this.x = x;
		this.y = y;
		this.gm = gm;

		new Thread(()->new Audio("audio/explode.wav").play()).start();
	}

	public void paint(Graphics g) {
		g.drawImage(ResourceMgr.explodes[step++],x,y,null);
		if (step>=ResourceMgr.explodes.length)
			gm.remove(this);
	}

	public boolean getLiving() {
		return living;
	}

	public void setLiving(boolean living) {
		this.living = living;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
