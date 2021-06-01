package com.qzc;

import java.util.Objects;

/**
 * @author qzc
 * @create 2021-04-30 9:13
 */
public class Main {
	public static void main(String[] args) throws InterruptedException {
		TankFrame tankFrame=new TankFrame();
		int initTankCount=Integer.parseInt((String) Objects.requireNonNull(PropertyMgr.get("initTankCount")));
		for (int i = 0; i < initTankCount; i++) {
			tankFrame.tanks.add(new Tank(200+i*60,200,Dir.DOWN,Group.BAD,tankFrame));
		}
		while (true){
			Thread.sleep(50);
			tankFrame.repaint();
		}
	}
}
