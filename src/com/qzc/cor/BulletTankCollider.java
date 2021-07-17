package com.qzc.cor;

import com.qzc.Bullet;
import com.qzc.GameObject;
import com.qzc.Tank;

/**
 * @author qzc
 * @create 2021-07-17 9:55
 */
public class BulletTankCollider implements Collider{

	@Override
	public boolean collide(GameObject o1, GameObject o2) {
		if (o1 instanceof Bullet && o2 instanceof Tank){
			Bullet b=(Bullet)o1;
			Tank t=(Tank)o2;
			return !b.collideWith(t);
		}else if (o1 instanceof Tank && o2 instanceof Bullet){
			collide(o2,o1);
		}
		return true;
	}
}
