package com.qzc;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * @author qzc
 * @create 2021-05-14 11:41
 */
public class ResourceMgr {
	public static BufferedImage tankL,tankD,tankR,tankU;
	public static BufferedImage bulletL,bulletR,bulletU,bulletD;
	public static BufferedImage[] explodes=new BufferedImage[16];
	static {
		try {
			tankL= ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif")));
			tankD= ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif")));
			tankR= ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif")));
			tankU= ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif")));

			bulletL= ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif")));
			bulletR= ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif")));
			bulletU= ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif")));
			bulletD= ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif")));
			for (int i = 0; i < explodes.length; i++) {
				explodes[i]=ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif")));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
