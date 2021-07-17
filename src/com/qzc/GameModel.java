package com.qzc;

import com.qzc.cor.ColliderChain;

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

	List<GameObject> gos=new ArrayList<>();

	ColliderChain collide=new ColliderChain();
	public GameModel(){
		int initTankCount=Integer.parseInt((String) Objects.requireNonNull(PropertyMgr.get("initTankCount")));
		for (int i = 0; i < initTankCount; i++) {
			add(new Tank(200+i*60,200,Dir.DOWN,Group.BAD,this));
		}
	}
	public void add(GameObject go){
		gos.add(go);
	}
	public void remove(GameObject go){
		gos.remove(go);
	}
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		/*g.drawString("子弹的数量:"+bullets.size(),10,60);
		g.drawString("敌人的数量:"+tanks.size(),10,80);
		g.drawString("爆炸的数量:"+explodes.size(),10,100);*/
		g.setColor(c);
		myTank.paint(g);
		for (int i = 0; i < gos.size(); i++) {
			gos.get(i).paint(g);
		}


		//碰撞检查
		for (int i = 0; i < gos.size(); i++) {
			for (int j = i+1; j < gos.size()-1; j++) {
				GameObject o1 = gos.get(i);
				GameObject o2 = gos.get(j);
				collide.collide(o1,o2);
			}
		}
	}

	public Tank getMainTank() {
		return myTank;
	}
}
