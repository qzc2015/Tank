package com.qzc.decorator;

import com.qzc.GameObject;

import java.awt.*;

/**
 * @author qzc
 * @create 2021-07-18 11:49
 */
public class ReactDecorator extends GODecorator{
	GameObject go;
	public ReactDecorator(GameObject go){
		this.go=go;
	}
	@Override
	public void paint(Graphics g) {
		this.x=go.x;
		this.y=go.y;
		go.paint(g);

		Color c = g.getColor();
		g.setColor(Color.yellow);
		g.drawRect(go.x, go.y,go.getWidth(),go.getHeight());
		g.setColor(c);
	}

	@Override
	public int getWidth() {
		return go.getWidth();
	}

	@Override
	public int getHeight() {
		return go.getHeight();
	}
}
