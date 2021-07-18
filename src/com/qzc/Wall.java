package com.qzc;

import java.awt.*;

/**
 * @author qzc
 * @create 2021-07-17 11:01
 */
public class Wall extends GameObject{
	int w,h;
	public Rectangle react;
	public Wall(int x,int y,int w,int h){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		react=new Rectangle(x,y,w,h);
	}

	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x,y,w,h);
		g.setColor(c);
	}

	@Override
	public int getWidth() {
		return w;
	}

	@Override
	public int getHeight() {
		return h;
	}
}
