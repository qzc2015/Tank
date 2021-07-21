package com.qzc.strategy;

import com.qzc.Bullet;
import com.qzc.Tank;

/**
 * @author qzc
 * @create 2021-06-13 20:57
 */
public class DefaultFireStrategy implements FireStrategy{
	@Override
	public void fire(Tank tank) {
		int bX=tank.getX()+Tank.WIDTH/2- Bullet.WIDTH/2;
		int bY=tank.getY()+Tank.HEIGHT/2-Bullet.HEIGHT/2;
		/*GameModel.getInstance().add(new ReactDecorator(
				new TailDecorator(
				new Bullet(bX,bY,tank.getDir(),tank.getGroup()))));*/

		new Bullet(bX,bY,tank.getDir(),tank.getGroup());
	}
}
