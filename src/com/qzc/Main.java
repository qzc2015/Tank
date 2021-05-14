package com.qzc;

/**
 * @author qzc
 * @create 2021-04-30 9:13
 */
public class Main {
	public static void main(String[] args) throws InterruptedException {
		TankFrame tankFrame=new TankFrame();
		for (int i = 0; i < 5; i++) {
			tankFrame.tanks.add(new Tank(200+i*60,200,Dir.DOWN,tankFrame));
		}
		while (true){
			Thread.sleep(50);
			tankFrame.repaint();
		}
	}
}
