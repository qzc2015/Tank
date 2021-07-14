package com.qzc;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author qzc
 * @create 2021-07-14 17:30
 */
public class GameModel {
	Tank myTank=new Tank(200,400,Dir.DOWN,Group.GOOD,this);
	List<Bullet> bullets=new ArrayList<>();
	List<Tank> tanks=new ArrayList<>();
	List<Explode> explodes=new ArrayList<>();
	public GameModel(){
		int initTankCount=Integer.parseInt((String) Objects.requireNonNull(PropertyMgr.get("initTankCount")));
		for (int i = 0; i < initTankCount; i++) {
			tanks.add(new Tank(200+i*60,200,Dir.DOWN,Group.BAD,this));
		}
	}
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.drawString("子弹的数量:"+bullets.size(),10,60);
		g.drawString("敌人的数量:"+tanks.size(),10,80);
		g.drawString("爆炸的数量:"+explodes.size(),10,100);
		g.setColor(c);
		myTank.paint(g);
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).paint(g);
		}
		for (int i = 0; i < tanks.size(); i++) {
			tanks.get(i).paint(g);
		}
		for (int i = 0; i < explodes.size(); i++) {
			explodes.get(i).paint(g);
		}

		//碰撞检查
		for (int i = 0; i < bullets.size(); i++) {
			for (int j = 0; j < tanks.size(); j++) {
				bullets.get(i).collideWith(tanks.get(j));
			}
		}
	}

	public Tank getMainTank() {
		return myTank;
	}
}
