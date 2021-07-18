package com.qzc.decorator;

import com.qzc.GameObject;

import java.awt.*;

/**
 * @author qzc
 * @create 2021-07-18 11:48
 */
public abstract class GODecorator extends GameObject {
	@Override
	public abstract void paint(Graphics g);
}
