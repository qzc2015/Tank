package com.qzc.cor;

import com.qzc.GameObject;

/**
 * @author qzc
 * @create 2021-07-17 9:54
 */
public interface Collider {
	boolean collide(GameObject o1,GameObject o2);
}
