package com.qzc;

import java.awt.*;

/**
 * @author qzc
 * @create 2021-05-13 14:12
 */
public class Bullet extends GameObject{
	private final Dir dir;
	private static final int SPEED=25;
	public static int WIDTH = ResourceMgr.bulletD.getWidth();
	public static int HEIGHT = ResourceMgr.bulletD.getHeight();
	private boolean living = true;
	public Group group;
	public Rectangle rect=new Rectangle();
	public Bullet(int x,int y,Dir dir,Group group){
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;

		rect.x=x;
		rect.y=y;
		rect.width=WIDTH;
		rect.height=HEIGHT;
		//GameModel.getInstance().add(this);
	}
	public void paint(Graphics g){
		if (!living) {
			GameModel.getInstance().remove(this);
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

	@Override
	public int getWidth() {
		return WIDTH;
	}

	@Override
	public int getHeight() {
		return HEIGHT;
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


	public void die() {
		this.living=false;
	}
}
