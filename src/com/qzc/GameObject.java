package com.qzc;

import java.awt.*;
import java.io.Serializable;

/**
 * @author qzc
 * @create 2021-07-14 18:09
 */
public abstract class GameObject implements Serializable {
	public int x,y;
	public abstract void paint(Graphics g);

	public abstract int getWidth();
	public abstract int getHeight();


}
