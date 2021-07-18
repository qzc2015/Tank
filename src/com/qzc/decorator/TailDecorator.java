package com.qzc.decorator;

import com.qzc.GameObject;

import java.awt.*;

/**
 * @author qzc
 * @create 2021-07-18 11:56
 */
public class TailDecorator extends GODecorator{
	GameObject go;
	public TailDecorator(GameObject go){
		this.go=go;
	}

	@Override
	public int getWidth() {
		return go.getWidth();
	}

	@Override
	public int getHeight() {
		return go.getHeight();
	}

	@Override
	public void paint(Graphics g) {
		this.x=go.x;
		this.y=go.y;

		go.paint(g);
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.drawLine(go.x,go.y,go.x+go.getWidth(),go.y+go.getHeight());
		g.setColor(c);
	}
}
