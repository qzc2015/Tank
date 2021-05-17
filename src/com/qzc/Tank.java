package com.qzc;

import java.awt.*;
import java.util.Random;

/**
 * @author qzc
 * @create 2021-05-13 11:49
 */
public class Tank {
	private int x,y;
	private Dir dir;
	private static final int SPEED = 10;
	private boolean moving = true;
	public static int WIDTH=ResourceMgr.tankU.getWidth();
	public static int HEIGHT=ResourceMgr.tankU.getHeight();
	private TankFrame tf;
	private boolean living = true;
	private Group group;
	Random random=new Random();

	public Tank(int x, int y, Dir dir,Group group,TankFrame tf) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
		this.group = group;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public boolean getLiving() {
		return living;
	}

	public void setLiving(boolean living) {
		this.living = living;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public void paint(Graphics g) {
		if (!living) tf.tanks.remove(this);
		switch (dir){
			case LEFT:
				g.drawImage(ResourceMgr.tankL,x,y,null);
				break;
			case RIGHT:
				g.drawImage(ResourceMgr.tankR,x,y,null);
				break;
			case UP:
				g.drawImage(ResourceMgr.tankU,x,y,null);
				break;
			case DOWN:
				g.drawImage(ResourceMgr.tankD,x,y,null);
				break;
		}

		move();
	}

	private void move() {
		if (!moving) return;
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
		if (random.nextInt(10)>8) this.fire();
	}

	public void fire() {
		int bX=x+Tank.WIDTH/2-Bullet.WIDTH/2;
		int bY=y+Tank.HEIGHT/2-Bullet.HEIGHT/2;
		tf.bullets.add(new Bullet(bX,bY,dir,this.group,tf));
	}

	public void die() {
		this.living = false;
	}
}
