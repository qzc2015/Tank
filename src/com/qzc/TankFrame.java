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
	Tank myTank=new Tank(200,200,Dir.DOWN);
	Bullet b=new Bullet(300,300,Dir.DOWN);
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
		myTank.paint(g);
		b.paint(g);
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
					break;
				case KeyEvent.VK_RIGHT:
					bR=true;
					break;
				case KeyEvent.VK_UP:
					bU=true;
					break;
				case KeyEvent.VK_DOWN:
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
			myTank.setMoving(true);
			if (bL) myTank.setDir(Dir.LEFT);
			if (bD) myTank.setDir(Dir.DOWN);;
			if (bU) myTank.setDir(Dir.UP);
			if (bR) myTank.setDir(Dir.RIGHT);

			if (!bL && !bR && !bU && !bD) myTank.setMoving(false);
		}
	}
}
