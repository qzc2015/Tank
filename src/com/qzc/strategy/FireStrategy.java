package com.qzc.strategy;

import com.qzc.Tank;

import java.io.Serializable;

/**
 * @author qzc
 * @create 2021-06-13 20:58
 */
public interface FireStrategy extends Serializable {
	void fire(Tank tank);
}
