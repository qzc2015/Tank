package com.qzc;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author qzc
 * @create 2021-04-30 9:13
 */
public class TankFrame extends Frame {
	int x=200,y=200;
	private Dir dir=Dir.DOWN;
	private static final int SPEED = 10;
	public TankFrame(){
		setSize(800,600);
		setResizable(false);
		setVisible(true);
		setTitle("tank war");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		addKeyListener(new MyKeyListener());
	}

	@Override
	public void paint(Graphics g) {
		g.fillRect(x,y,50,50);
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
	}
	class MyKeyListener extends KeyAdapter{
		boolean bL = false;
		boolean bR = false;
		boolean bU = false;
		boolean bD = false;
		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch (keyCode){
				case KeyEvent.VK_LEFT:
					bL=true;
					System.out.println("left");
					break;
				case KeyEvent.VK_RIGHT:
					bR=true;
					System.out.println("right");
					break;
				case KeyEvent.VK_UP:
					bU=true;
					System.out.println("up");
					break;
				case KeyEvent.VK_DOWN:
					System.out.println("down");
					bD=true;
					break;
			}
			setMainTankDir();

		}

		@Override
		public void keyReleased(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch (keyCode){
				case KeyEvent.VK_LEFT:
					bL=false;
					break;
				case KeyEvent.VK_RIGHT:
					bR=false;
					break;
				case KeyEvent.VK_UP:
					bU=false;
					break;
				case KeyEvent.VK_DOWN:
					bD=false;
					break;
			}
			setMainTankDir();
		}
		private void setMainTankDir() {
			if (bL) dir=Dir.LEFT;
			if (bD) dir=Dir.DOWN;
			if (bU) dir=Dir.UP;
			if (bR) dir=Dir.RIGHT;
		}
	}
}
