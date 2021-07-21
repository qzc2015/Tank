package com.qzc.observer;

import com.qzc.Tank;

/**
 * @author qzc
 * @create 2021-07-21 21:47
 */
public class TankFireEvent {
	Tank tank;
	public Tank getSource(){
		return tank;
	}
	public TankFireEvent(Tank tank){
		this.tank=tank;
	}
}
