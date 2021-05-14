package com.qzc;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @author qzc
 * @create 2021-04-30 9:13
 */
public class TankFrame extends Frame {
	Tank myTank=new Tank(200,400,Dir.DOWN,this);
	List<Bullet> bullets=new ArrayList<>();
	List<Tank> tanks=new ArrayList<>();
	public static final int GAME_WIDTH=800;
	public static final int GAME_HEIGHT=600;
	Image offScreenImage = null;
	public TankFrame(){
		setSize(GAME_WIDTH,GAME_HEIGHT);
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
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.drawString("子弹的数量:"+bullets.size(),10,60);
		g.setColor(c);
		myTank.paint(g);
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).paint(g);
		}
		for (int i = 0; i < tanks.size(); i++) {
			tanks.get(i).paint(g);
		}
	}
	@Override
	public void update(Graphics g){
		if (offScreenImage == null){
			offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.black);
		gOffScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage,0,0,null);

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
				case KeyEvent.VK_CONTROL:
					myTank.fire();
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
