package com.qzc;

/**
 * @author qzc
 * @create 2021-04-30 9:13
 */
public class Main {
	public static void main(String[] args) throws InterruptedException {
		TankFrame tankFrame=new TankFrame();

		while (true){
			Thread.sleep(25);
			tankFrame.repaint();
		}
	}
}
