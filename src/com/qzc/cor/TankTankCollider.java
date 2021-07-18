package com.qzc.cor;

import com.qzc.GameObject;
import com.qzc.Tank;

/**
 * @author qzc
 * @create 2021-07-17 10:00
 */
public class TankTankCollider implements Collider{
	@Override
	public boolean collide(GameObject o1, GameObject o2) {
		if (o1 instanceof Tank && o2 instanceof Tank){
			Tank t1=(Tank)o1;
			Tank t2=(Tank)o2;
			if (t1.react.intersects(t2.react)){
				t1.back();
				t2.back();
			}
		}
		return true;
	}
}
