package com.qzc.observer;

import com.qzc.Tank;

/**
 * @author qzc
 * @create 2021-07-21 21:47
 */
public class TankFireHandler implements TankFireObserver {
	@Override
	public void actionOnFire(TankFireEvent event) {
		Tank tank = event.getSource();
		tank.fire();
	}
}
