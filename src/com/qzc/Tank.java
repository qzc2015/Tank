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
	public static int WIDTH=ResourceMgr.goodTankU.getWidth();
	public static int HEIGHT=ResourceMgr.goodTankU.getHeight();
	private GameModel gm;
	private boolean living = true;
	private Group group;
	Random random=new Random();
	Rectangle react=new Rectangle();
	private FireStrategy fs;

	public Tank(int x, int y, Dir dir,Group group,GameModel gm) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.gm = gm;
		this.group = group;

		react.x=x;
		react.y=y;
		react.width=WIDTH;
		react.height=HEIGHT;
		if (group==Group.GOOD){
			String goodFs =(String) PropertyMgr.get("goodFS");
			try {
				try {
					fs=(FireStrategy) Class.forName(goodFs).newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}else{
			fs=new DefaultFireStrategy();
		}

	}

	public Group getGroup() {
		return group;
	}

	public GameModel getGm() {
		return gm;
	}

	public void setGm(GameModel gm) {
		this.gm = gm;
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
		if (!living) gm.tanks.remove(this);
		switch (dir){
			case LEFT:
				g.drawImage(this.group==Group.GOOD ? ResourceMgr.goodTankL:ResourceMgr.badTankL,x,y,null);
				break;
			case RIGHT:
				g.drawImage(this.group==Group.GOOD ? ResourceMgr.goodTankR:ResourceMgr.badTankR,x,y,null);
				break;
			case UP:
				g.drawImage(this.group==Group.GOOD ? ResourceMgr.goodTankU:ResourceMgr.badTankU,x,y,null);
				break;
			case DOWN:
				g.drawImage(this.group==Group.GOOD ? ResourceMgr.goodTankD:ResourceMgr.badTankD,x,y,null);
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

		if (this.group == Group.BAD && random.nextInt(100)>95) this.fire();
		if (this.group == Group.BAD && random.nextInt(100)>95)
			randomDir();

		boundsCheck();
		//更新react中坦克的位置
		react.x=x;
		react.y=y;
	}

	private void boundsCheck() {
		if (x<2) x=2;
		if (y<28) y=28;
		if (x>TankFrame.GAME_WIDTH-Tank.WIDTH-2) x=TankFrame.GAME_WIDTH-Tank.WIDTH-2;
		if (y>TankFrame.GAME_HEIGHT-Tank.HEIGHT-2) y=TankFrame.GAME_HEIGHT-Tank.HEIGHT-2;
	}

	private void randomDir() {
		this.dir=Dir.values()[random.nextInt(4)];

	}

	public void fire() {
		fs.fire(this);
	}

	public void die() {
		this.living = false;
	}
}
