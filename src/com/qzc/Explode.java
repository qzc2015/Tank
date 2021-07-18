package com.qzc;

import java.awt.*;

/**
 * @author qzc
 * @create 2021-05-13 11:49
 */
public class Explode extends GameObject{
	public static int WIDTH=ResourceMgr.explodes[0].getWidth();
	public static int HEIGHT=ResourceMgr.explodes[0].getHeight();
	private boolean living = true;
	private int step=0;


	public Explode(int x, int y) {
		this.x = x;
		this.y = y;

		new Thread(()->new Audio("audio/explode.wav").play()).start();
	}

	public void paint(Graphics g) {
		g.drawImage(ResourceMgr.explodes[step++],x,y,null);
		if (step>=ResourceMgr.explodes.length)
			GameModel.getInstance().remove(this);
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
	@Override
	public int getWidth() {
		return WIDTH;
	}

	@Override
	public int getHeight() {
		return HEIGHT;
	}
}
