package com.qzc.cor;

import com.qzc.GameObject;
import com.qzc.Tank;
import com.qzc.Wall;

/**
 * @author qzc
 * @create 2021-07-17 14:03
 */
public class TankWallCollider implements Collider{
	@Override
	public boolean collide(GameObject o1, GameObject o2) {
		if (o1 instanceof Tank && o2 instanceof Wall){
			Tank t=(Tank)o1;
			Wall w=(Wall)o2;
			if (t.react.intersects(w.react)){
				t.back();
			}
		}else if (o1 instanceof Wall && o2 instanceof Tank){
			return collide(o2,o1);
		}
		return true;
	}
}
