package com.qzc.observer;

import java.io.Serializable;

/**
 * @author qzc
 * @create 2021-07-21 21:48
 */
public interface TankFireObserver extends Serializable {

	void actionOnFire(TankFireEvent event);
}
