package com.qzc;

/**
 * @author qzc
 * @create 2021-06-13 21:04
 */
public class FourFireStrategy implements FireStrategy{
	@Override
	public void fire(Tank tank) {
		Dir[] dirs=Dir.values();
		for (Dir dir : dirs) {
			int bX=tank.getX()+Tank.WIDTH/2-Bullet.WIDTH/2;
			int bY=tank.getY()+Tank.HEIGHT/2-Bullet.HEIGHT/2;
			new Bullet(bX,bY,dir,tank.getGroup());
		}
	}
}
