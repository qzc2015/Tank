package com.qzc;

import java.awt.*;

/**
 * @author qzc
 * @create 2021-05-13 14:12
 */
public class Bullet {
	private int x,y;
	private final Dir dir;
	private static final int SPEED=25;
	public static int WIDTH = ResourceMgr.bulletD.getWidth();
	public static int HEIGHT = ResourceMgr.bulletD.getHeight();
	private boolean living = true;
	private final TankFrame tf;
	private Group group;
	Rectangle rect=new Rectangle();
	public Bullet(int x,int y,Dir dir,Group group,TankFrame tf){
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
		this.group = group;

		rect.x=x;
		rect.y=y;
		rect.width=WIDTH;
		rect.height=HEIGHT;
	}
	public void paint(Graphics g){
		if (!living) {
			tf.bullets.remove(this);
		}
		switch (dir){
			case LEFT:
				g.drawImage(ResourceMgr.bulletL,x,y,null);
				break;
			case RIGHT:
				g.drawImage(ResourceMgr.bulletR,x,y,null);
				break;
			case UP:
				g.drawImage(ResourceMgr.bulletU,x,y,null);
				break;
			case DOWN:
				g.drawImage(ResourceMgr.bulletD,x,y,null);
				break;
		}
		move();
	}
	public void move(){
		switch (dir){
			case LEFT:
				x-=SPEED;
				break;
			case RIGHT:
				x+=SPEED;
				break;
			case UP:
				y-=SPEED;
				break;
			case DOWN:
				y+=SPEED;
				break;
		}
		rect.x=x;
		rect.y=y;
		if (x<0 || y<0 || x> TankFrame.GAME_WIDTH || y> TankFrame.GAME_HEIGHT) living =false;
	}

	public void collideWith(Tank tank) {
		if (group == tank.getGroup())return;
		if (rect.intersects(tank.react)){
			tank.die();
			this.die();
			int eX = tank.getX()+Tank.WIDTH/2-Explode.WIDTH/2;
			int eY = tank.getY()+Tank.HEIGHT/2-Explode.HEIGHT/2;
			tf.explodes.add(new Explode(x,y,tf));

		}
	}

	private void die() {
		this.living=false;
	}
}
